import { Component, OnInit, ViewChild } from '@angular/core';
import { NzModalRef } from 'ng-zorro-antd/modal';
import { NzMessageService } from 'ng-zorro-antd/message';
import { _HttpClient } from '@delon/theme';
import { SFSchema, SFUISchema } from '@delon/form';
import {ROOT_URL} from "@shared";

@Component({
  selector: 'app-admin-permission-edit',
  templateUrl: './edit.component.html',
})
export class AdminPermissionEditComponent implements OnInit {
  record: any = {};
  i: any;
  schema: SFSchema = {
    properties: {
      pName: { type: 'string', title: '权限名' },
      pDesc: { type: 'string', title: '描述', maxLength: 140 },
    },
    required: ['pName', 'pDesc'],
  };
  ui: SFUISchema = {
    '*': {
      spanLabelFixed: 100,
      grid: { span: 12 },
    },
    $title: {
      widget: 'string',
    },
    $description: {
      widget: 'textarea',
      grid: { span: 24 },
    },
  };

  constructor(
    private modal: NzModalRef,
    private msgSrv: NzMessageService,
    public http: _HttpClient,
  ) {}

  ngOnInit(): void {
    if (this.record.id > 0)
    this.http.get(`/user/${this.record.id}`).subscribe(res => (this.i = res));
  }

  save(value: any) {
    if (this.record && this.record.id){
      let params = Object.assign({id: this.record.id},value)
      this.http.post(`${ROOT_URL}/permission/update`, params).subscribe(res => {
        if (res['code'] == 0){
          this.msgSrv.success('保存成功');
          this.modal.close(true);
        }else {
          this.msgSrv.error(res['message'])
        }
      });
    }else {
      this.http.post(`${ROOT_URL}/permission/add`, value).subscribe(res => {
        if (res['code'] == 0){
          this.msgSrv.success('保存成功');
          this.modal.close(true);
        }else {
          this.msgSrv.error(res['message'])
        }
      });
    }
  }

  close() {
    this.modal.destroy();
  }
}
