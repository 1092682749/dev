import { Component, OnInit, ViewChild } from '@angular/core';
import { NzModalRef } from 'ng-zorro-antd/modal';
import { NzMessageService } from 'ng-zorro-antd/message';
import { _HttpClient } from '@delon/theme';
import {TransferItem} from "ng-zorro-antd";

@Component({
  selector: 'app-admin-user-edit',
  templateUrl: './edit.component.html',
})
export class AdminUserEditComponent implements OnInit {
  record: any = {};
  i: any;
  list: TransferItem[] = [];

  constructor(
    private modal: NzModalRef,
    public msgSrv: NzMessageService,
    public http: _HttpClient
  ) { }

  ngOnInit(): void {
    this.http.get(`/role/${this.record.id}`).subscribe(res => this.i = res);
    this.http.get(`/permission`).subscribe(res => {
      console.log(res)
      if (res.list){
        for (let i = 0; i < res.list.length; i++) {
          this.list.push({
            key: res.list[i].id.toString(),
            title: res.list[i].title,
            direction: "left"
          });
        }
        this.http.get(`/role/${this.record.id}/permissions`).subscribe(res => {
          console.log(res)
          res && res.forEach(item => {
            this.list.map(i => {
              if(i.key == item.key){
                i.direction = 'right'
              }
              return i
            })
          });
          this.list = [...this.list]
        });
      }
    });
  }

  select(ret: {}): void {
    console.log('nzSelectChange', ret);
  }

  change(ret: {}): void {
    console.log('nzChange', ret);
  }

  close() {
    this.modal.destroy();
  }

  submit(){
    this.http.post(`/role/${this.record.id}/permissions`,this.list.filter(i => i.direction == 'right')).subscribe(res => {
      console.log(res)
    })
    this.http.post('http://localhost/es/tsmc-user/zhxuf',{
      empNo: '108509',
      eName: 'E108509',
      eNameSh: '徐志行',
      mailName: 'xuzhf',
      mailAddr: 'xuzhf@tsmc.com',
      department: '',
      deptNo: '',
      fulldeptcode: ''
    }).subscribe(res => {
      console.log(res)
    })
  }
}
