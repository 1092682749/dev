import { Component, OnInit, ViewChild } from '@angular/core';
import { _HttpClient, ModalHelper } from '@delon/theme';
import {STColumn, STComponent, STReq, STRes} from '@delon/abc/st';
import { SFSchema } from '@delon/form';
import {AdminUserEditComponent} from "./edit/edit.component";
import {_HttpHeaders} from "@delon/theme/src/services/http/http.client";
import {HttpHeaders} from "@angular/common/http";
import {ES_URL, ROOT_URL} from "@shared";
import {AdminUserViewComponent} from "./view/view.component";

@Component({
  selector: 'app-admin-user',
  templateUrl: './user.component.html',
})
export class AdminUserComponent implements OnInit {
  url = `${ROOT_URL}employee/list`;
  searchSchema: SFSchema = {
    properties: {
      account: {
        type: 'string',
        title: 'NT'
      }
    }
  };

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
  }


  // assignee: "Yes"
  // cnameSh: "吴悲"
  // department: "CN-MFG"
  // deptNo: "C012"
  // eName: "Tough Wu"
  // emailAddr: "BWU@TSMC.COM"
  // empNo: "044112"
  // extension: "7103283/7406898"
  // fulldeptcode: "00C01202"
  // hireDate: "2007-07-01T16:00:00.000+0000"
  // idl: "IDL"
  // lastupdated: "2020-06-19T03:00:04.000+0000"
  // location: "FAB10"
  // mailName: "BWU"
  // manager: "032825"
  // notesid: "BWU/TSMCSH"
  // sectNo: "2-00"
  // section: "TPS Section"
  // sex: "M"
  // shiftCode: "S1"
  // siteCode: "F10"
  // statCode: "W003"
  @ViewChild('st', { static: false }) st: STComponent;
  columns: STColumn[] = [
    { title: '工号', index: 'empNo' },
    { title: '姓名', index: 'cnameSh' },
    { title: '课别', index: 'section' },
    { title: '邮箱', index: 'emailAddr'},
    {
      title: '',
      buttons: [
        { text: '查看', click: (item: any) => this.detail(item) },
        // { text: '编辑', click: (item) => this.edit(item) },
      ]
    }
  ];

  constructor(private http: _HttpClient, private modal: ModalHelper) { }

  ngOnInit() {
    // this.http.get(ES_URL).subscribe(res => {
    //   console.log(res)
    // })
    // this.http.get(`${ROOT_URL}employee/list`).subscribe(res => {
    //   console.log(res)
    // })
  }

  add() {
    this.modal
      .createStatic(AdminUserEditComponent, { i: { id: 0 } })
      .subscribe(() => this.st.reload());
  }
  detail(item) {
    this.modal
      .createStatic(AdminUserViewComponent, { record: item })
      .subscribe(() => this.st.reload());
  }
  edit(item) {
    this.modal
      .createStatic(AdminUserEditComponent, { record: { id: item.id } })
      .subscribe(() => this.st.reload());
  }
  handleSearch(ev){
    console.log(ev)
  }

}
