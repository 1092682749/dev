import {ChangeDetectionStrategy, ChangeDetectorRef, Component, Inject, OnInit} from '@angular/core';
import {NzMessageService} from "ng-zorro-antd";
import {_HttpClient, SettingsService} from "@delon/theme";
import {DA_SERVICE_TOKEN, ITokenService, TokenService} from "@delon/auth";
import {SocketService} from "../../../core/net/socket.service";
import {CALLBACK_NOTIFY, ROOT_URL} from "@shared";
import {Router} from "@angular/router";
import {Observable} from "rxjs";
const msgTemplate = '易答 发来一条通知, 请打开' + ROOT_URL + '查看';
@Component({
  selector: 'header-notification',
  templateUrl: './forum-notification.component.html',
  changeDetection: ChangeDetectionStrategy.OnPush,
  styles: [
      `
          .wid {
              width: 390px;
              max-height: 700px;
              overflow: auto;
          }
    `
  ]
})
export class ForumNotificationComponent implements OnInit {

  _unReadMessage: Array<any>;

  set unReadMessage(v) {
    // 数据更新的时候要做的事情放在这里
    console.log("unReadMessage 更新");
    this.setDot(this._unReadMessage, v);
    this._unReadMessage = v;
  }

  get unReadMessage() {
    return this._unReadMessage;
  }

  // obs = new Observable(o => {
  //     o.next(1);
  // });
  // arr: Observable<Array<any>>;
  loading = true;

  constructor(private cdr: ChangeDetectorRef,
              private  settingService: SettingsService,
              @Inject(DA_SERVICE_TOKEN) private tokenService: ITokenService,
              private msg: NzMessageService,
              private http: _HttpClient,
              private socketService: SocketService,
              private router: Router) {
  }

  change() {

    setTimeout(() => {

    }, 500);
  }

  ngOnInit(): void {
    Notification.requestPermission().then(res => {
      console.log(res);
    })
    // this.arr.subscribe(
    //   next=>{
    //     console.log(next);
    //   }
    // )
    // this.unReadMessage.
    this.getData();
    console.log(this.settingService.user);
    this.socketService.onMessage(CALLBACK_NOTIFY, (ev: MessageEvent) => {
      console.log((ev.data));
      // console.log(JSON.parse(ev.data));
      this.msg.info("您有一条新消息!");
      if (!ev.data) return;
      this.getData();
      let notification = new Notification('EASY ANSWER Notify', {body: msgTemplate});
      notification.onclick = (ne): any => {
        // return "";
        // window.top
        window.focus();
      };
      console.log("未读消息");
      console.log(this.unReadMessage)
    })
    // this.socket = new WebSocket("ws://127.0.0.1:8088/empon=" + this.settingService.user['empno']);
    // this.socket.onmessage = (ev: MessageEvent) => {
    //   console.log(ev);
    //   this.msg.info("您有一条新消息!");
    //   this.unReadMessage.push({
    //     name: 'unknown',
    //     msg: ev['data'].toString()
    //   })
    // }

  }

  getData() {
    console.log("getData");
    this.http.get(ROOT_URL + '/unread/message/list').subscribe(res => {
      console.log(res);
      this.unReadMessage = res['data'];
      this.loading = false;
      this.cdr.detectChanges();
    })

  }

  viewDetails(item) {
    this.router.navigateByUrl('/loading').then(() => {
      this.router.navigate(['/details', {id: item.caseId}],);
      this.deleteUnread(item.unreadId);
    });
  }

  deleteUnread(unreadId) {
    console.log('delete unread')
    this.http.post(ROOT_URL + '/unread/message/delete', unreadId).subscribe(res => {
      this.getData();
    })
  }

  sendMsg() {
    this.socketService.sendMsg("消息");
  }

  nzDot: boolean = false;

  setDot(oldValue, newValue) {
    console.log('setDot');
    console.log(newValue);
    if (newValue.length > 0) {
      this.nzDot = true;
    } else {
      this.nzDot = false;
    }
  }

}
