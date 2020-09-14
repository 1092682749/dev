import { Component, OnInit, ViewChild } from '@angular/core';
import { _HttpClient, ModalHelper } from '@delon/theme';
import {STColumn, STComponent, STReq, STRes} from '@delon/abc/st';
import { SFSchema } from '@delon/form';
import {AdminPermissionEditComponent} from "./edit/edit.component";
import {ROOT_URL} from "@shared";
import {AdminPermissionViewComponent} from "./view/view.component";

@Component({
  selector: 'app-admin-permission',
  templateUrl: './permission.component.html',
})
export class AdminPermissionComponent implements OnInit {
  url = ROOT_URL + `/permission/list`;
  res: STRes = {
    reName: {
      total: 'data.total',
      list: 'data.list'
    }
  }
  req: STReq = {
    reName: {
      pi: 'pageNum',
      ps: 'pageSize'
    }
  };

  extReq: any;
  searchSchema: SFSchema = {
    properties: {
      no: {
        type: 'string',
        title: '编号'
      }
    }
  };
  @ViewChild('st', { static: false }) st: STComponent;
  columns: STColumn[] = [
    { title: 'Id', index: 'id' },
    { title: 'Title',  index: 'pName' },
    { title: 'Description', index: 'pDesc' },
    { title: 'Update Time', type: 'date', index: 'updatedAt' },
    {
      title: '',
      buttons: [
        // { text: '查看', click: (item: any) => this.detail(item) },
        { i18n: 'menu.edit', click: (item: any) => this.edit(item) },
      ]
    }
  ];

  constructor(private http: _HttpClient, private modal: ModalHelper) { }

  ngOnInit() {
    Object.assign(this.req,this.extReq)
  }

  add() {
    this.modal
      .createStatic(AdminPermissionEditComponent, { i: { id: 0 } })
      .subscribe(() => this.st.reload());
  }

  edit(item) {
    this.modal
      .createStatic(AdminPermissionEditComponent, { record: item })
      .subscribe(() => this.st.reload());
  }

  detail(item) {
    this.modal
      .createStatic(AdminPermissionViewComponent, { record: { id: item.id } })
      .subscribe(() => this.st.reload());
  }

}
