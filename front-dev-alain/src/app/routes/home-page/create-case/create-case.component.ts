import {Component, ElementRef, OnInit, ViewChild, ViewChildren, ViewContainerRef} from '@angular/core';
import {EditorChangeContent, EditorChangeSelection} from "ngx-quill";
import {HttpClient} from "@angular/common/http";
import {NzMessageService, NzNotificationService, NzSelectSizeType} from "ng-zorro-antd";
import {_HttpClient, ModalHelper} from "@delon/theme";
import {CaseForm} from "../pojo/CaseForm";
import {ROOT_URL} from "@shared";

import {ActivatedRoute, Router} from "@angular/router";

import {CutImageComponent} from "./cut-image/cut-image.component";

import Quill from 'quill';

import QuillResizeModule from "@ssumo/quill-resize-module";
import {DomSanitizer} from "@angular/platform-browser";
import {ACLService} from "@delon/acl";
Quill.register("modules/resize", QuillResizeModule);
// import {ROOT_URL} from "@shared";

@Component({
  selector: 'app-create-case',
  templateUrl: './create-case.component.html',
  styles: [
      `
          .inner-box {
              /*text-align: center;*/
          }

          .inputs, .label {
              vertical-align: top;
          }

          .inputs {

              width: 80%;
          }

          .label {

              display: inline-block;
              width: 16%;
          }

          #image {
              display: block;

              /* This rule is very important, please don't ignore this */
              max-width: 500px;
          }
          .redFont {
              color: red;
          }

    `
  ]
  // styleUrls: ['/node_modules/cropperjs/dist/cropper.css']
})
export class CreateCaseComponent implements OnInit {
  size: NzSelectSizeType = 'default';
  @ViewChild('toolbar', {read: ViewContainerRef, static: true})
  private toolbar: ViewContainerRef;

  // cropper: Cropper;
  constructor(private msgSrv: NzMessageService,
              public http: _HttpClient,
              private notify: NzNotificationService,
              private route: ActivatedRoute,
              private modal: ModalHelper,
              protected sanitizer: DomSanitizer,
              private  router: Router,
              private aclService: ACLService) {
  }

  title: string;
  brief: string;
  multipleTagsValue = [];
  multipleModuleName = [];
  listOfTagsOption: Array<{ label: string; value: string }> = [];
  newCase = new CaseForm();
  moduleNames = [];
  ngOnInit(): void {
    // this.initCropper();
    this.moduleNames = this.aclService.data.roles
      .filter(roleName => {
        return roleName.indexOf("SOLVE_CENTER_MODULE") >= 0;
      }
    ).map(roleName => {
      let artifacts = roleName.split("_");
      return {
        value: roleName,
        label: artifacts[artifacts.length - 1]
      };
    });
    console.log(this.aclService.data.roles);
    this.runStep();
    this.route.queryParams.subscribe(
      res => {
        console.log(res);
        let caseId = res['caseId'];
        if (caseId !== undefined) {
          this.getCase(caseId);
        }
      }
    );
    this.getTags();
  }

  getCase(id) {
    this.http.get(ROOT_URL + '/caseForm/detail', {id: id}).subscribe(res => {
      console.log(res);
      this.newCase = res.data;
    })
  }

  content: any;
  modules = {

    'emoji-shortname': true,
    'emoji-textarea': true,
    'emoji-toolbar': true,
    'toolbar': [

      [{'header': [1, 2, 3, 4, 5, 6, false]}],

      [{'color': []}, {'background': []}],          // dropdown with defaults from theme
      [{'font': []}],
      [{'align': []}],

      ['clean'],                                 // remove formatting button

      ['link', 'image', 'video'],                         // link and image, video
      ['emoji'],
    ],
    resize: {
      locale: {
        altTip: "按住alt键比例缩放",
        floatLeft: "靠左",
        floatRight: "靠右",
        center: "居中",
        restore: "还原"
      }
    }
  };


  blured = false;
  focused = false;
  quill: any;

  created(event) {
    // tslint:disable-next-line:no-console
    this.quill = event;
    // console.log(this.quill.root.getEvents());;
    // console.log('editor-created', event)
    this.quill.root.onpaste = this.handlePaste(this);
    // ('paste', this.handlePaste(this), false);

  }

  changedEditor(event: EditorChangeContent | EditorChangeSelection) {
    // tslint:disable-next-line:no-console
    console.log('editor-change', event)
  }

  readFiles(e, files, callback) {
    // check each file for an image
    [].forEach.call(files, file => {
      if (!file.type.match(/^image\/(gif|jpe?g|a?png|svg|webp|bmp|vnd\.microsoft\.icon)/i)) {
        // file is not an image
        // Note that some file formats such as psd start with image/* but are not readable
        return;
      }
      e.preventDefault();
      // set up file reader
      const reader = new FileReader();
      reader.onload = (evt) => {
        callback(evt.target.result);
      };
      // read the clipboard item or file
      const blob = file.getAsFile ? file.getAsFile() : file;
      if (blob instanceof Blob) {
        reader.readAsDataURL(blob);
      }
    });
  }

  handlePaste(_this) {
    return (evt) => {
      if (evt.clipboardData && evt.clipboardData.items && evt.clipboardData.items.length) {
        // this.readFiles()
        // console.log(this);
        _this.readFiles(evt, evt.clipboardData.items, dataUrl => {
          _this.upload('fileName', dataUrl).subscribe(res => {
            const selection = _this.quill.getSelection();
            console.log("????")
            let url = ROOT_URL + 'file/downloadFile?fid=' + res.data.fileFid;
            _this.insert(url)
            if (selection) {
              // so it has already been placed into the editor
            }
            else {
              // otherwise we wait until after the paste when this.quill.getSelection()
              // will return a valid index
              // setTimeout(() => _this.insert(url), 0);
            }
            // this.editorComponent.insertEmbed(range.index, 'image', ROOT_URL + 'file/downloadFile?fid=' + res.data.fileFid);
          });

        });
      }
    }

  }


  insert(dataUrl) {
    const index = (this.quill.getSelection() || {}).index || this.quill.getLength();
    this.quill.insertEmbed(index, 'image', dataUrl, 'user');
  }

  focus($event) {
    console.log('focus', $event)
    this.focused = true
    this.blured = false
  }

  blur($event) {
    // tslint:disable-next-line:no-console
    console.log('blur', $event)
    this.focused = false
    this.blured = true
  }


  save(value: any) {
    this.http.post(`/user/`, value).subscribe(res => {
      this.msgSrv.success('评论成功');
      // this.modal.close(this.content);
    });
  }


  // listOfTagsOption: Array<{ label: string; value: string }> = [];

  singleValue = '';

  tagValue = [];

  // ngOnInit(): void {

  // }


  saveAndPublish(type) {
    // var hxr = new XMLHttpRequest();
    // hxr.open('post','http://localhost:8080/caseForm/save');
    // hxr.send();
    if (type == 'publish') {
      this.newCase.status = 'published'
    } else {
      this.newCase.status = 'draft'
    }
    this.newCase.tags = this.multipleTagsValue.join(',');
    this.newCase.moduleName = this.multipleModuleName.join(',');
    var body = {};
    body = Object.assign(body, this.newCase);
    body['token'] = 'asd';
    this.http.post(ROOT_URL + '/caseForm/save', this.newCase)
      .subscribe(res => {
        if (res['code'] == 0) {
          this.msgSrv.success("上传成功!");
          this.router.navigateByUrl('/');
          // this.newCase = new CaseForm();
        } else {
          this.notify.error("Error", res['message']);
        }
      })
  }


  getTags() {
    this.http.get(ROOT_URL + '/tag/list')
      .subscribe(
        res => {
          console.log(res);
          const children: Array<{ label: string; value: string }> = [];
          for (let i = 0; i < res.data.length; i++) {
            children.push({label: res.data[i]['tagName'], value: res.data[i]['tagName']});
          }
          console.log(children);
          this.listOfTagsOption = children;
        }
      )
  }
  // @ViewChild('fileUploadInput', {static: true})
  // upLoadInput: ElementRef;

  @ViewChild('fileUploadInput', {static: true})
  upLoadInput: ElementRef;

  uploadFile(type) {
    // this.newCase.content += '<div style="width: 100px;">123</div>';
    let base64 = "";
    let el = this.upLoadInput.nativeElement;
    el.click();
    const range = this.quill.getSelection(true);
    // const index = range.index + range.length;
    el.onchange = (e) => {
      var reader = new FileReader();
      reader.readAsDataURL(el.files[0]);
      let fileName = el.files[0].name;
      reader.onload = (ev) => {
        if (type == 'pic') {
          console.log('上传图片');
          this.initCropper(ev).subscribe(
            res => {
              this.upload(fileName, res).subscribe(res => {
                this.quill.insertEmbed(range.index, 'image', ROOT_URL + 'file/downloadFile?fid=' + res.data.fileFid);
                el.value = '';
              });
            }
          );
        } else {
          console.log('上传附件');
          this.upload(fileName, ev.target.result).subscribe(
            res => {
              console.log('插入a');
              // this.quill.insertEmbed(range.index, 'image', ROOT_URL + 'file/downloadFile?fid=' + res.data.fileFid);
              this.newCase.content += '<a href="' + ROOT_URL + 'file/downloadFile?fid=' + res.data.fileFid + '">' + res.data.fileName + '</a>'
              // this.quill.insertEmbed(range.index,
              //   'link',
              //   {
              //     href: ROOT_URL + 'file/downloadFile?fid=' + res.data.fileFid,
              //     innerHTML: fileName
              //   },
              //   "api");
              el.value = '';
            }
          );
        }
      }
    };
  }

  upload(fileName, str) {
    return this.http.post(ROOT_URL + "/file/uploadFileByBase64", {
      fileName: fileName,
      baseStr: str
    });
  }

  showImg() {
    alert("aaa");
  }


// cropper
  zoom = 0.1;
  cropper;

  addSize() {
    console.log('add size')
    this.zoom += 0.1;
    // this.angularCropper.cropper.zoom(this.zoom);
    // this.initCropper();
  }

  initCropper(ev: ProgressEvent) {
    return this.modal.create(CutImageComponent, {ev: ev}, {modalOptions: {nzClosable: false, nzMaskClosable: false}})
  }

  // stepIndex
  stepIndex = 0;
  stepTimer;
  lastTimer;
  runStep() {
    this.stepTimer = setInterval(() => {
      this.stepIndex = (this.stepIndex + 1) % 5;
     }, 1000)
  }
  clearTimer() {
    if (this.lastTimer == this.stepTimer) {
      this.runStep();
    } else {
      clearInterval(this.stepTimer);
      this.lastTimer = this.stepTimer;
    }
    ;
  }
}
