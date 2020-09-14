import { Component, OnInit, ViewChild } from '@angular/core';
import { _HttpClient, ModalHelper } from '@delon/theme';
import {STColumn, STComponent, STReq, STRes} from '@delon/abc/st';
import { SFSchema } from '@delon/form';
import {AdminSolutionEditComponent} from "./edit/edit.component";
import {AdminSolutionViewComponent} from "./view/view.component";
import {ROOT_URL} from "@shared";

@Component({
  selector: 'app-admin-solution',
  templateUrl: './solution.component.html',
})
export class AdminSolutionComponent implements OnInit {
  url = `${ROOT_URL}case/comment/list`;
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
  // caseId: "351"
  // commentEmpno: "102316"
  // commentId: "1"
  // commentTime: "2020-07-05T16:00:00.000+0000"
  // content: "啦啦啦
  @ViewChild('st', { static: false }) st: STComponent;
  columns: STColumn[] = [
    // { title: 'id', index: 'id' },
    { title: 'content', index: 'content' },
    { title: 'commentEmpno', index: 'commentEmpno' },
    { title: 'commentTime', type: 'date', index: 'commentTime' },
    {
      title: '',
      buttons: [
        { text: '查看', click: (item: any) => this.detail(item) },
        { text: '编辑', click: (item: any) => this.edit(item) },
      ]
    }
  ];

  constructor(private http: _HttpClient, private modal: ModalHelper) { }

  ngOnInit() { }

  add() {
    this.modal
      .createStatic(AdminSolutionEditComponent, { i: { id: 0 } })
      .subscribe(() => this.st.reload());
  }
  detail(item) {
    this.modal
      .createStatic(AdminSolutionViewComponent, { record: { id: item.id } })
      .subscribe(() => this.st.reload());
  }
  edit(item) {
    this.modal
      .createStatic(AdminSolutionEditComponent, { record: { id: item.id } })
      .subscribe(() => this.st.reload());
  }

}
