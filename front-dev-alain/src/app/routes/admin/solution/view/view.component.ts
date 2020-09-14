import { Component, OnInit } from '@angular/core';
import { NzModalRef } from 'ng-zorro-antd/modal';
import { NzMessageService } from 'ng-zorro-antd/message';
import { _HttpClient } from '@delon/theme';
import {addDays, formatDistance} from "date-fns";

@Component({
  selector: 'app-admin-solution-view',
  templateUrl: './view.component.html',
})
export class AdminSolutionViewComponent implements OnInit {
  record: any = {};
  i: any;
  solutionCase: any;

  constructor(
    private modal: NzModalRef,
    public msgSrv: NzMessageService,
    public http: _HttpClient
  ) { }

  ngOnInit(): void {
    this.http.get(`/solution/${this.record.id}`).subscribe(res => {
      this.i = Object.assign({
        author: 'Han Solo',
        avatar: 'https://zos.alipayobjects.com/rmsportal/ODTLcjxAfvqbxHnVXCYX.png',
        datetime: formatDistance(new Date(), addDays(new Date(), 2))
      },res)
      this.http.get(`/case/${res.cid}`).subscribe(item => {
        this.solutionCase = item
        console.log(item)
      })
    });
  }

  close() {
    this.modal.destroy();
  }

  save(){
    this.http.post(`/solution/${this.record.id}`,this.i).subscribe(res => {
      console.log(res)
    })
  }
}
