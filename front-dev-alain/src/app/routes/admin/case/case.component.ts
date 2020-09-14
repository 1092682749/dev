import { Component, OnInit, ViewChild } from '@angular/core';
import { _HttpClient, ModalHelper } from '@delon/theme';
import {STColumn, STComponent, STReq, STRes} from '@delon/abc/st';
import { SFSchema } from '@delon/form';
import {AdminCaseViewComponent} from "./view/view.component";
import {AdminCaseEditComponent} from "./edit/edit.component";
import {ROOT_URL} from "@shared";
import {Router} from "@angular/router";
import {RateComponent} from "./rate/rate/rate.component";
import {NzMessageService} from "ng-zorro-antd";

@Component({
  selector: 'app-admin-case',
  templateUrl: './case.component.html',
})
export class AdminCaseComponent implements OnInit {
  url = `${ROOT_URL}/caseForm/list`;

  res: STRes = {
    reName: {
      total: 'data.total',
      list: 'data.list'
    },
    process: (data, rawData) => {
      data = data.map(i => {
        if (i['adminRate'] == null) {
          i['adminRate'] = 0;
        }
        if (i['brief']) {
          if (i['brief'].length > 20) {
            i['brief'] = i['brief'].substring(0, 20) + '...';
          }
        }
        return i;
      });
      return data;
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
      condition: {
        type: 'string',
        title: ''
      }
    }
  };
  @ViewChild('st', { static: false }) st: STComponent;
  columns: STColumn[] = [
    { title: 'Title', index: 'title', width: '200px' },
    { title: 'Brief', index: 'brief', className: 'text-truncate', width: '200px' },
    // { title: 'content', index: 'content' },
    { title: 'Tags', index: 'tags' },
    { title: 'Type', index: 'categoryId' },
    {
      title: 'Rate',
      render: 'custom',
      sort: {
        key: 'orderBy',
        reName: { ascend: 'ADMIN_RATE asc', descend: 'ADMIN_RATE desc' }
      },
    },
    { title: 'Time', type: 'date', index: 'createDate' },
    {
      title: '',
      buttons: [
        { text: 'detail', click: (item: any) => this.detail(item) },
        { text: 'delete',type: 'del', click: (item: any) => this.delete(item), acl: {ability: ['admin']} },
        // { text: '编辑', click: (item: any) => this.edit(item) },
      ]
    }
  ];

  constructor(private http: _HttpClient, private modal: ModalHelper, private router: Router,private msg: NzMessageService) { }

  ngOnInit() { }

  add() {
    this.modal
      .createStatic(AdminCaseEditComponent, { i: { id: 0 } })
      .subscribe(() => this.st.reload());
  }
  delete(item) {
    this.http.post(ROOT_URL + '/caseForm/delete', {caseId: item.caseId}).subscribe(
      res => {
        if (res['code'] == 0) {
          this.msg.success('删除' + res['message'])
          // this.getData();
        } else {
          this.msg.warning('删除' + res['message'])
        }
      }
    )
  }
  adminRate(ev, item){
    let body = {
      caseId: item.caseId,
      adminRate: ev
    };
    this.http.post(ROOT_URL + '/caseForm/Rating', body).subscribe(res => {

    })
  }
  edit(item) {
    this.modal
      .createStatic(AdminCaseEditComponent, { i: { id: item.id } })
      .subscribe(() => this.st.reload());
  }
  detail(item) {
    // this.modal
    //   .createStatic(AdminCaseViewComponent, { record: { id: item.caseId } })
    //   .subscribe(() => this.st.reload());
    this.router.navigate(['/details', {id: item.caseId}], );
  }

}
