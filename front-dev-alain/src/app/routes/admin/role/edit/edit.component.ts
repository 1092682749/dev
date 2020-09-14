import { Component, OnInit, ViewChild } from '@angular/core';
import { NzModalRef } from 'ng-zorro-antd/modal';
import { NzMessageService } from 'ng-zorro-antd/message';
import { _HttpClient } from '@delon/theme';
import { SFSchema, SFUISchema } from '@delon/form';
import {ROOT_URL} from "@shared";
import {TransferItem} from "ng-zorro-antd";

@Component({
  selector: 'app-admin-role-edit',
  templateUrl: './edit.component.html',
})
export class AdminRoleEditComponent implements OnInit {
  record: any = {};
  i: any;
  list: TransferItem[] = [];

  constructor(
    private modal: NzModalRef,
    public msgSrv: NzMessageService,
    public http: _HttpClient
  ) { }

  ngOnInit(): void {
    this.getpermissionData().then()
    console.log("========");
  }

  save(value: any) {
    this.http.post(`/user/${this.record.id}`, value).subscribe(res => {
      this.msgSrv.success('保存成功');
      this.modal.close(true);
    });
  }

  change(ret: {}): void {
    console.log('nzChange', ret);
  }

  select(ret: {}): void {
    console.log('nzSelectChange', ret);
  }

  async getpermissionData(){
    await  this.http.get(`${ROOT_URL}permission/list`).subscribe(res => {
      console.log(res)
      if (res['code'] == 0){
        if (res.data && res.data.list) {
          for (let i = 0; i < res.data.list.length; i++) {
            this.list.push({
              key: res.data.list[i].id.toString(),
              title: res.data.list[i].pName,
              direction: "left"
            });
          }
        }
      }
    })

    await this.http.get(`${ROOT_URL}permission/list/${this.record.rName}`).subscribe(res => {
      console.log(res)
      if (res.code == 0){
        this.i = res['data']
        res['data'] && res['data']['permissions'].forEach(item => {
          this.list.map(i => {
            console.log(i,item)
            if(i.key == item.id){
              i.direction = 'right'
            }
            return i
          })
        });
        this.list = [...this.list]
        console.log(this.list)
      }
    });
  }


  submit(){
    let params = {
      permissions: this.list.filter(i => i.direction == 'right').map(item => {
        item.id = item.key
        return item
      }),
      id: this.record.id,
      rName: this.record.rName
    }
    console.log(params)
    this.http.post(`${ROOT_URL}/role/grant`, params).subscribe(res => {
      console.log(res)
      if (res['code'] == 0){
        this.msgSrv.success('授权成功!')
      }else {
        this.msgSrv.warning(res['message'])
      }
    })
  }

  close() {
    this.modal.destroy();
  }
}
