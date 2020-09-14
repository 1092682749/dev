import { Component, OnInit, ViewChild } from '@angular/core';
import { _HttpClient, ModalHelper } from '@delon/theme';
import {STColumn, STComponent, STReq, STRes} from '@delon/abc/st';
import { SFSchema } from '@delon/form';
import {AdminRoleEditComponent} from "./edit/edit.component";
import {AdminRoleViewComponent} from "./view/view.component";
import {ROOT_URL} from "@shared";

@Component({
  selector: 'app-admin-role',
  templateUrl: './role.component.html',
})
export class AdminRoleComponent implements OnInit {
  url = `${ROOT_URL}role/list`;
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
    { title: 'Title',  index: 'rName' },
    { title: 'Description', index: 'rDesc' },
    { title: 'Update Time', type: 'date', index: 'updaeTime' },
    {
      title: '',
      buttons: [
        // { text: '查看', click: (item: any) => this.detail(item) },
        { i18n: 'menu.edit', click: (item: any) => this.edit(item) },
      ]
    }
  ];

  constructor(private http: _HttpClient, private modal: ModalHelper) { }

  ngOnInit() { }

  add() {
    this.modal
      .createStatic(AdminRoleEditComponent, { i: { id: 0 } })
      .subscribe(() => this.st.reload());
  }
  edit(item) {
    this.modal
      .createStatic(AdminRoleEditComponent, { record: item })
      .subscribe(() => this.st.reload());
  }
  detail(item) {
    this.modal
      .createStatic(AdminRoleViewComponent, { record: item })
      .subscribe(() => this.st.reload());
  }

}
