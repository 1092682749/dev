import { Component, OnInit } from '@angular/core';
import { NzModalRef } from 'ng-zorro-antd/modal';
import { NzMessageService } from 'ng-zorro-antd/message';
import { _HttpClient } from '@delon/theme';
import { addDays, formatDistance } from 'date-fns';
import {ROOT_URL} from "@shared";

@Component({
  selector: 'app-admin-case-view',
  templateUrl: './view.component.html',
})
export class AdminCaseViewComponent implements OnInit {
  record: any = {};
  i: any;

  data = [
    {
      author: 'Han Solo',
      avatar: 'https://zos.alipayobjects.com/rmsportal/ODTLcjxAfvqbxHnVXCYX.png',
      description:
        'ok, I am sure, TSMC here is',
      datetime: formatDistance(new Date(), addDays(new Date(), 1))
    }
  ];

  constructor(
    private modal: NzModalRef,
    public msgSrv: NzMessageService,
    public http: _HttpClient
  ) { }

  ngOnInit(): void {
    this.http.get(`${ROOT_URL}/caseForm/detail`,{id: this.record.id}).subscribe(res => {
      console.log(res)
      if (res.code == 0){
        this.i = res.data
      }else {
        this.msgSrv.warning(res.message)
      }
    });
    this.http.get(`/solution/${this.record.id}/case`).subscribe(res => {
      res.map(item => {
        this.data.push(Object.assign({
          author: 'Han Solo',
          avatar: 'https://zos.alipayobjects.com/rmsportal/ODTLcjxAfvqbxHnVXCYX.png',
          datetime: formatDistance(new Date(), addDays(new Date(), 2))
        },item))
      })
      this.data = [...this.data]
    });
  }

  close() {
    this.modal.destroy();
  }
}
