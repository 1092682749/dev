import { Injectable } from '@angular/core';
import {SettingsService} from "@delon/theme";
import {NzMessageService} from "ng-zorro-antd";
import {WS_URL} from "@shared";

@Injectable({
  providedIn: 'root'
})
export class SocketService {

   socket: WebSocket;
   // eventMap 注册回调事件
   map: Map<String, (e: MessageEvent)=>void> = new Map<String, (e: MessageEvent)=>void>();
  constructor(
    private settingsService: SettingsService,
    private msg: NzMessageService
  ) {

    console.log("初始化socket");
    this.socket = new WebSocket(WS_URL + "/empon=" + this.settingsService.user['empno']);
    this.socket.onopen = () => {
      console.log("socket 已打开")
    };
    this.socket.onclose = () => {
      console.log("socket 已关闭")
    };
    this.socket.onmessage = (messageEvent: MessageEvent) => {
      console.log('messageEvent')
      console.log(messageEvent)
      this.map.forEach((value: (e: MessageEvent) => void, key: string, map1) => {
        value.apply(value, [messageEvent]);
      })
    }
  }

  sendMsg(msg: string) {
    console.log(msg);

    this.socket.send(msg);
  }

  onMessage(callbackName: string, callback: (e: MessageEvent) => void) {
    this.map.set(callbackName, callback);
  }
}
