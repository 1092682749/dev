import { Component, OnInit } from '@angular/core';
import { NzModalRef } from 'ng-zorro-antd/modal';
import { NzMessageService } from 'ng-zorro-antd/message';
import { _HttpClient } from '@delon/theme';
import {ROOT_URL} from "@shared";

@Component({
  selector: 'app-admin-permission-view',
  templateUrl: './view.component.html',
})
export class AdminPermissionViewComponent implements OnInit {
  record: any = {};
  i: any;

  constructor(
    private modal: NzModalRef,
    public msgSrv: NzMessageService,
    public http: _HttpClient
  ) { }

  ngOnInit(): void {
    this.http.get(`${ROOT_URL}/permission/list/${this.record.id}`).subscribe(res => {
      console.log(res)
      this.i = res
    });
  }

  close() {
    this.modal.destroy();
  }
}
