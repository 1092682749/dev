import { Component, OnInit, ViewChild } from '@angular/core';
import { NzModalRef } from 'ng-zorro-antd/modal';
import { NzMessageService } from 'ng-zorro-antd/message';
import { _HttpClient } from '@delon/theme';
import {SFSchema, SFSelectWidgetSchema, SFUISchema} from '@delon/form';
import {ROOT_URL} from "@shared";
import {map} from "rxjs/operators";

@Component({
  selector: 'app-admin-tag-edit',
  templateUrl: './edit.component.html',
})
export class AdminTagEditComponent implements OnInit {
  record: any = {};
  i: any;
  schema: SFSchema = {
    properties: {
      tagName: { type: 'string', title: 'Tag Name' },
      // 异步数据
      // roleName: {
      //   type: 'string',
      //   title: 'Role Name',
      //   default: '',
      //   ui: {
      //     widget: 'select',
      //     asyncData: () => this.http.get(`${ROOT_URL}role/list`).pipe(map(res => {
      //       console.log(res)
      //       let list = []
      //       if (res['code'] == 0){
      //         list = res['data'] && res['data']['list'] ? res['data']['list'].map(item => {
      //           return {
      //             label: item['rName'],
      //             value: item['rName']
      //           }
      //         }) : []
      //       }
      //       return list
      //     }))
      //   } as SFSelectWidgetSchema,
      // },
      // createEmpno: { type: 'number', title: 'EmpNo' },
    },
    required: ['tagName'],
  };
  ui: SFUISchema = {
    '*': {
      spanLabelFixed: 100,
      grid: { span: 12 },
    },
    $tagName: {
      widget: 'string',
    },
  };

  constructor(
    private modal: NzModalRef,
    private msgSrv: NzMessageService,
    public http: _HttpClient,
  ) {}

  ngOnInit(): void {
    // if (this.record.id > 0)
    console.log(this.record)
    this.http.get(`${ROOT_URL}tag/detail`,{id: this.record.roleName}).subscribe(res => {
      console.log(res)
      this.i = {
        tagName: this.record.tagName,
        // roleName: this.record.roleName,
        // createEmpno: this.record.createEmpno
      };
    });
  }

  save(value: any) {
    if (this.record && this.record.tId){
      let params = Object.assign({tId: this.record.tId},value)
      console.log(params)
      this.http.post(`${ROOT_URL}tag/update`, params).subscribe(res => {
        this.msgSrv.success('更新成功');
        this.modal.close(true);
      });
    }else {
      this.http.post(`${ROOT_URL}tag/add`, value).subscribe(res => {
        this.msgSrv.success('保存成功');
        this.modal.close(true);
      });
    }
  }

  close() {
    this.modal.destroy();
  }
}
