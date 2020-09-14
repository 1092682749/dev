import { Component, OnInit, ViewChild } from '@angular/core';
import { NzModalRef } from 'ng-zorro-antd/modal';
import { NzMessageService } from 'ng-zorro-antd/message';
import { _HttpClient } from '@delon/theme';
import { SFSchema, SFUISchema } from '@delon/form';

@Component({
  selector: 'app-admin-case-edit',
  templateUrl: './edit.component.html',
})
export class AdminCaseEditComponent implements OnInit {
  content: any;
  record: any = {};
  i: any;
  schema: SFSchema = {
    properties: {
      title: { type: 'string', title: 'title'},
    },
    required: ['title'],
  };
  ui: SFUISchema = {
    '*': {
      spanLabelFixed: 100,
      grid: { span: 12 },
    },
    $title: {
      widget: 'string',
    }
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

  changeText(ev){
    console.log(ev)
    this.content = ev
  }

  save(value: any) {
    let params = Object.assign(value,{description: this.content})
    this.http.put(`/case`, params).subscribe(res => {
      this.msgSrv.success('保存成功');
      this.modal.close(true);
    });
  }

  close() {
    this.modal.destroy();
  }
}
