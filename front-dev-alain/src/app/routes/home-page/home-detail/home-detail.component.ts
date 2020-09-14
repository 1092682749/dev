import {Component, Inject, OnInit} from '@angular/core';
import {ActivatedRoute, NavigationEnd, Router} from '@angular/router';
import {Observable} from 'rxjs';
import {switchMap} from 'rxjs/operators';
import {EditorChangeContent, EditorChangeSelection} from "ngx-quill";
import 'quill-emoji/dist/quill-emoji.js'
import {HttpClient, HttpHeaders, HttpParams} from "@angular/common/http";
import {ModalHelper} from "@delon/theme";
import {DetailsCommentComponent} from "./details-comment/details-comment.component";
import {ROOT_URL} from "@shared";
import {DA_SERVICE_TOKEN, ITokenService} from "@delon/auth";
import {NzMessageService, NzNotificationService} from "ng-zorro-antd";
import {ACLService} from "@delon/acl";
import {CaseForm} from "../pojo/CaseForm";
import Quill from 'quill';
// import QuillResize, { PlaceholderRegister } from 'quill-resize-module';
import QuillResizeModule from "@ssumo/quill-resize-module";
import {DomSanitizer} from "@angular/platform-browser";
Quill.register("modules/resize", QuillResizeModule);
@Component({
  selector: 'app-home-detail',
  templateUrl: './home-detail.component.html',
  // styleUrls: ['./css/quill.core.css', './css/quill.snow.css'],
  styles: [
      `
      .zoom {
          zoom: 1.2;
      }
          .fill {
              color: #1890ff;
          }

          .outline {
              color: gray;
          }

          .commentHeader {
              display: inline-block;
              margin-right: 20px;
              vertical-align: top;
              /*font-size: 17px;*/
              color: black;
              /*font-family: "Droid Serif", serif;*/
          }

          .commentContent {
              display: inline-block;
              word-break: break-all;
              vertical-align: top;
          }

          .imgAccept {
              width: 25px;
          }
    `
  ]

})
export class HomeDetailComponent implements OnInit {
  currentId: string;
  // modules = {}
  content = ''
  arr: ['asd', 'asd'];
  reviews: any[];
  caseDetails:any;
  loginUser: any;
  allExpansionComments: Array<number> = new Array<number>();
  navigationSubscription: any;
  // p = {
  //   [param: string]: string | string[]
  // };
  constructor(private router: Router, private route: ActivatedRoute,
              private http: HttpClient, private modal: ModalHelper,
              @Inject(DA_SERVICE_TOKEN) private tokenService: ITokenService,
              private nzMessageService: NzMessageService,
              private aclService: ACLService,
              private notification: NzNotificationService,
              protected sanitizer: DomSanitizer) {
    // this.navigationSubscription = this.router.events.subscribe((event: any) => {
    //   if (event instanceof NavigationEnd) {
    //     console.log("event 刷新页面");
    //     this.ngOnInit();
    //   }
    // });
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

  ngOnInit(): void {

    this.route.paramMap.subscribe(res => {
      console.log(res);
      this.currentId = res.get('id');
      this.getCaseDetails(this.currentId);
    });
    this.loginUser = this.tokenService.get();

    // console.log(t);
  }

  blured = false
  focused = false

  created(event) {
    // tslint:disable-next-line:no-console
    console.log('editor-created', event)
  }

  changedEditor(event: EditorChangeContent | EditorChangeSelection) {
    // tslint:disable-next-line:no-console
    console.log('editor-change', event)
  }

  focus($event) {
    // tslint:disable-next-line:no-console
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

  showValue() {
  }

  like(action, i) {

    let item = this.reviews[i];
    let body = {
      action: action,
      commentId: item.commentId,
      actionId: item['actionId']
    };
    this.likeRequest(body);
    console.log('like')
  }

  likeChildren(action, i, j) {
    let item = this.reviews[i]['children'][j];
    let body = {
      action: action,
      commentId: item.commentId,
      actionId: item['actionId']
    };
    console.log('like')
    this.likeRequest(body);
  }

  likeRequest(body) {
    console.log(body)
    this.http.post(ROOT_URL + '/case/like/likeOrUnlike', body).subscribe(
      res => {
        this.getCaseDetails(this.currentId);
      }
    )
  }

  getCaseDetails(id: any) {
    // console.log(this.aclService)
    // this.aclService.setRole(['SOLVE_CENTER_MODULE_FTS']);
    this.http.get(ROOT_URL + 'caseForm/detail', {params: {id: this.currentId}}).subscribe(res => {
      console.log(res);
      if (res['code'] == 302) {
        this.notification.error("提示", "该帖子已被管理员删除禁止查看!");
        return;
      }
      // 变成数组
      res['data']['moduleName'] = {
        role: res['data']['moduleName'].split(",").filter(i => i != ""),
        mode: 'oneOf'
      };
      // res['data']['content'] = this.sanitizer.bypassSecurityTrustHtml(res['data']['content']);
      this.caseDetails = res['data'];
    });
    this.http.get(ROOT_URL + '/case/comment/list', {
      params: {
        caseId: this.currentId,
      }
    }).subscribe((res: any) => {
      console.log(res);
      this.reviews = res.data as [];
      // string to int
      this.reviews = this.reviews.map( review => {
        review['adminRate'] = parseInt(review['adminRate']);
        if (review['children'].length > 0) {
          review['children'] = review['children'].map( child=> {
            child['adminRate'] = parseInt(child['adminRate']);
            return  child;
          })
        }

        return review;
      });
      this.allExpansionComments.forEach(value => {
        this.reviews[value]['show'] = true;
      });
      console.log(this.reviews);

    })
  }

  gert(options: {
    params?: {
      [param: string]: string | string[];
    };
  }) {
  }

  adminRate(e, review, i) {
    console.log("对第" + i + "个评论进行了评分！");
    console.log(e);
    let body = {
      commentId: review.commentId,
      adminRate: e
    };
    this.http.post(ROOT_URL + '/case/comment/Rating', body).subscribe(res => {

    })
  }

  replyTo(review, i) {
    console.log(this.reviews[i])
    console.log('click reply')

    this.modal.createStatic(DetailsCommentComponent, {
      review: review,
      modules: this.modules,
      parentId: this.reviews[i]['commentId']
    })
      .subscribe(res => {
        console.log(res);
        this.postComment(res)
        if (this.allExpansionComments.indexOf(i) < 0) {
          this.allExpansionComments.push(i);
        }
        console.log(this.reviews);
      })
  }

  showAllSubReview(index) {
    console.log(this.reviews)
    this.reviews[index].show = true;
    this.allExpansionComments.push(index);
  }

  hiddenAllSubReview(index) {
    console.log(this.reviews)
    this.reviews[index].show = false;
    let at = this.allExpansionComments.indexOf(index);
    this.allExpansionComments.splice(at, 1);
  }

  commentCase() {
    console.log(this.content)
    let comment = {
      caseId: this.currentId,
      content: this.content,
      commentLevel: 1,
      toEmpno: this.caseDetails.createEmplid,
    };
    this.postComment(comment)
  }

  postComment(comment) {
    this.http.post(ROOT_URL + '/case/comment/add', comment).subscribe(
      res => {
        // console.log
        this.getCaseDetails(this.currentId);
        if (res['code'] == 0) {
          this.content = "";
        }
      }
    )
  }

  accept(review) {

    let body = {
      commentId: review.commentId,
      caseId: review.caseId
    };
    this.http.post(ROOT_URL + '/caseForm/accept', body)
      .subscribe(
        res => {
          console.log('accept');
          this.nzMessageService.info(res['message']);
          this.getCaseDetails(this.currentId);
        }
      )
  }

  deleteComment(review) {

  }

  cancelDeleteComment(review): void {
    // this.nzMessageService.info('click cancel');
  }

  confirmDeleteComment(review): void {
    // this.nzMessageService.info('click confirm');
    let body = {
      commentId: review.commentId
    };
    this.http.post(ROOT_URL + '/case/comment/delete', body).subscribe(res => {
      if (res['code'] == 0) {
        this.nzMessageService.success('删除' + res['message'])
      } else {
        this.notification.error('提示', 'error:' + res['message'])
      }
      this.getCaseDetails(this.currentId);
    })
  }

  showAcceptButton(): boolean {
    if (!this.caseDetails) return  false;
    if (this.caseDetails.createEmplid != this.loginUser.empno) return false;
    if (this.caseDetails.status == 'accept') return false;
    return true;
  }

  showAcceptFlag(review): Boolean {
    if (review['accept'] == 'Y') return true;
    return false;
  }
}
