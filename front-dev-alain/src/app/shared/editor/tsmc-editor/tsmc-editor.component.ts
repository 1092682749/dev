import {
  Component,
  ElementRef,
  EventEmitter,
  forwardRef,
  OnInit,
  Output,
  ViewChild,
  ViewContainerRef
} from '@angular/core';
import {
  EditorChangeContent,
  EditorChangeSelection,
  QuillEditorComponent, QuillService,
  QuillViewComponent,
  SelectionChange
} from "ngx-quill";
import {ROOT_URL} from "@shared";
import {_HttpClient, ModalHelper} from "@delon/theme";
import {ControlValueAccessor, NG_VALUE_ACCESSOR} from "@angular/forms";
import Quill from 'quill';
// import QuillResize, { PlaceholderRegister } from 'quill-resize-module';
import QuillResizeModule from "@ssumo/quill-resize-module";
import {CutImageComponent} from "../../../routes/home-page/create-case/cut-image/cut-image.component";
// import {ImageResize} from "quill-image-resize-module"
Quill.register("modules/resize", QuillResizeModule);
@Component({
  selector: 'app-tsmc-editor',
  templateUrl: './tsmc-editor.component.html',
  styles: [],
  providers: [
    {
      provide: NG_VALUE_ACCESSOR,
      useExisting: forwardRef(() => TsmcEditorComponent),
      multi: true
    }
  ]
})
export class TsmcEditorComponent implements OnInit, ControlValueAccessor {

  constructor(private http: _HttpClient,
              private modal: ModalHelper) {
    // this.readFiles = this.readFiles.bind(this);
  }
  editorComponent: any;
  @Output('onchange') changeEvent = new EventEmitter<any>();
  _content: any;
  // quill: any;
  ngOnInit(): void {
  }

  modules = {
    'emoji-shortname': true,
    'emoji-textarea': true,
    'emoji-toolbar': true,
    'toolbar': [

      [{'header': [1, 2, 3, 4, 5, 6, false]}],

      [{'color': []}, {'background': []}],          // dropdown with defaults from theme
      [{'font': []}],
      [{'align': []}],

      ['clean'],                                         // remove formatting button

      ['link',  'image', 'video', 'href'],                         // link and image, video 'image',
      ['emoji'],
    ],
    // clipboard: {
    //   matchers: [[Node.TEXT_NODE, this.handlePaste(this)]],
    //
    // },
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
  blured = false
  focused = false

  created(event) {
    // tslint:disable-next-line:no-console
    console.log('editor-created', event)
    // const toolbar = event.getModule('toolbar');
    // toolbar.addHandler('image', this.imageHandler.bind(this));
    this.editorComponent = event;
    console.log(this.editorComponent.root);;
    this.editorComponent.root.onpaste = this.handlePaste(this);
    // ('paste', this.handlePaste(this), false);

  }

  changedEditor(event: EditorChangeContent | EditorChangeSelection) {
    if (event.event == 'text-change') {
      this.changeEvent.emit(this.content)
    }
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
        console.log(this);
        _this.readFiles(evt, evt.clipboardData.items, dataUrl => {
          _this.upload('fileName', dataUrl).subscribe(res => {
            let url = ROOT_URL + 'file/downloadFile?fid=' + res.data.fileFid;
            _this.insert(url)
          });

        });
      }
    }

  }


  insert(dataUrl) {
    const index = (this.editorComponent.getSelection() || {}).index || this.editorComponent.getLength();
    this.editorComponent.insertEmbed(index, 'image', dataUrl, 'user');
  }



  upload(fileName, str) {
    return this.http.post(ROOT_URL + "/file/uploadFileByBase64", {
      fileName: fileName,
      baseStr: str
    });
  }
  focus($event) {
    // tslint:disable-next-line:no-console
    // console.log('focus', $event)
    this.focused = true
    this.blured = false
  }

  blur($event) {
    // tslint:disable-next-line:no-console
    // console.log('blur', $event)
    this.focused = false
    this.blured = true
  }

  @ViewChild('fileUploadInput', {static: true})
  upLoadInput: ElementRef;


  uploadFile(type) {
    // this.newCase.content += '<div style="width: 100px;">123</div>';
    let base64 = "";
    let el = this.upLoadInput.nativeElement;
    el.click();
    const range = this.editorComponent.getSelection(true);
    // const index = range.index + range.length;
    el.onchange = (e) => {
      var reader = new FileReader();
      reader.readAsDataURL(el.files[0]);
      let fileName = el.files[0].name;
      reader.onload = (ev) => {
        if (type == 'pic') {
          this.initCropper(ev).subscribe(
            res => {
              console.log('modal 回调');
              this.upload(fileName, res).subscribe(res => {
                this.editorComponent.insertEmbed(range.index, 'image', ROOT_URL + 'file/downloadFile?fid=' + res.data.fileFid);
                el.value = '';
              });
            }
          );
        } else {
          this.upload(fileName, ev.target.result).subscribe(
            res => {
              // this.editorComponent.insertEmbed(range.index,
              //   'link',
              //   {
              //     href: ROOT_URL + 'file/downloadFile?fid=' + res.data.fileFid,
              //     innerText: fileName
              //   },
              //   "api");
                          this.content += '<a href="' + ROOT_URL + 'file/downloadFile?fid=' + res.data.fileFid + '">' + res.data.fileName + '</a>'

              // this.editorComponent.insertEmbed(range.index, 'href', ROOT_URL + 'file/downloadFile?fid=' + res.data.fileFid);
              el.value = '';
            }
          );
        }
      }
    };
  }
  // uploadFile(type) {
  //   let el = this.upLoadInput.nativeElement;
  //   el.click();
  //   el.onchange = (e) => {
  //     var reader = new FileReader();
  //     reader.readAsDataURL(el.files[0]);
  //     let fileName = el.files[0].name;
  //     reader.onload = (ev) => {
  //
  //       let url = "http://localhost:8080/servletTest_war_exploded/ajax"; // ROOT_URL + "/file/uploadFileByBase64"
  //       this.http.post(ROOT_URL + "/file/uploadFileByBase64", {
  //         fileName: fileName,
  //         baseStr: ev.target.result
  //       }).subscribe(
  //         res => {
  //           const range = this.editorComponent.getSelection(true);
  //           const index = range.index + range.length;
  //           let appendTag;
  //           if (type == 'pic') {
  //             console.log(appendTag+ "aaaaaaaaaaaaaaaaaaaaaaa")
  //             // appendTag = '<img style="max-width: 500px" src="' + ROOT_URL + 'file/downloadFile?fid=' + res.data.fileFid + '" />';
  //             this.editorComponent.insertEmbed(range.index, 'image', ROOT_URL + 'file/downloadFile?fid=' + res.data.fileFid);
  //           } else {
  //             this.content += '<a href="' + ROOT_URL + 'file/downloadFile?fid=' + res.data.fileFid + '">' + res.data.fileName + '</a>'
  //             // this.content = appendTag;
  //
  //             // this.editorComponent.insertEmbed(range.index, 'link', ROOT_URL + 'file/downloadFile?fid=' + res.data.fileFid);
  //           }
  //           el.value = '';
  //         }
  //       )
  //     }
  //   };
  // }

  //return this.modal.create(CutImageComponent, {ev: ev}, {modalOptions: {nzClosable: false}});
  initCropper(ev: ProgressEvent) {
    return this.modal.create(CutImageComponent, {ev: ev}, {modalOptions: {nzClosable: false, nzMaskClosable: false}})
  }
  get content() {
    return this._content;
  }

  set content(val) {
    this._content = val;
    this.propagateChange(val);
  }

  registerOnChange(fn: any): void {
    this.propagateChange = fn;
  }

  registerOnTouched(fn: any): void {
  }

  writeValue(obj: any): void {
    this._content = obj;
  }

  propagateChange(val) {
    console.log('propagateChange')
  }
  onSelectionChanged(e: SelectionChange) {
    // console.log(e.range.index);
  }
}
























