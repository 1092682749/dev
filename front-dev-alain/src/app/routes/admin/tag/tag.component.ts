import { Component, OnInit, ViewChild } from '@angular/core';
import {_HttpClient, MenuService, ModalHelper} from '@delon/theme';
import {STColumn, STComponent, STReq, STRes} from '@delon/abc/st';
import { SFSchema } from '@delon/form';
import {ROOT_URL} from "@shared";
import {AdminTagEditComponent} from "./edit/edit.component";
import {AdminTagViewComponent} from "./view/view.component";
import {ACLService} from "@delon/acl";
import {NzMessageService} from "ng-zorro-antd";

@Component({
  selector: 'app-admin-tag',
  templateUrl: './tag.component.html',
})
export class AdminTagComponent implements OnInit {
  url = `${ROOT_URL}tag/page/list`;
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
  roleA = '';
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
    { title: {
      text: 'Tags', i18n: 'menu.tags'
      }, index: 'tagName' },
    { title: {i18n: 'menu.module'}, index: 'roleName' },
    { title: {text: 'Employee No', i18n: 'menu.employee'}, index: 'createEmpno' },
    {
      title: '',
      buttons: [
        // { text: '查看', click: (item: any) => this.detail(item) },
        { i18n: 'menu.edit', click: (item: any) => this.edit(item),  acl: {ability: ['admin']}},
        {text: 'delete', type: 'del', click: (item: any) => this.delete(item),  acl: {ability: ['admin']}}
      ]
    }
  ];

  constructor(private http: _HttpClient, private modal: ModalHelper, public aclSrv: ACLService, private menuSrv: MenuService, private msgSrv: NzMessageService,) { }

  ngOnInit() { }

  add() {
    this.modal
      .createStatic(AdminTagEditComponent, { i: { id: 0 } })
      .subscribe(() => this.st.reload());
  }

  detail(item) {
    this.modal
      .createStatic(AdminTagViewComponent, { record: item })
      .subscribe(() => this.st.reload());
  }

  edit(item) {
    this.modal
      .createStatic(AdminTagEditComponent, { record: item })
      .subscribe(() => this.st.reload());
  }

  delete(item){
    console.log(item)
    let params = Object.assign(item,{isDelete: 'Y'})
    this.http.post(`${ROOT_URL}tag/update`, item).subscribe(res => {
      this.msgSrv.success('更新成功');
      this.st.reload()
    });
  }

  toggleRoleA() {
    console.log(this.roleA)
    this.roleA = this.roleA === 'SOLVE_CENTER_ROOT_ADMIN' ? '' : 'SOLVE_CENTER_ROOT_ADMIN';
    this.aclSrv.setRole([this.roleA]);
    this.menuSrv.resume();
  }

}
