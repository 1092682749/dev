import { Component, OnInit } from '@angular/core';
import { NzModalRef } from 'ng-zorro-antd/modal';
import { NzMessageService } from 'ng-zorro-antd/message';
import {_HttpClient, ModalHelper} from '@delon/theme';
import {ROOT_URL} from "@shared";
import {TransferItem} from "ng-zorro-antd";
import {iterator} from "rxjs/internal-compatibility";
import {Observable} from "rxjs";
import {Router} from "@angular/router";
import {AdminPermissionComponent} from "../../permission/permission.component";
import {STReq} from "@delon/abc";

@Component({
  selector: 'app-admin-user-view',
  templateUrl: './view.component.html',
})
export class AdminUserViewComponent implements OnInit {
  record: any = {};
  roles = [];
  list: TransferItem[] = [];
  extReq: STReq;
  constructor(
    private modal: NzModalRef,
    private modalHelper: ModalHelper,
    public msgSrv: NzMessageService,
    public http: _HttpClient,
    public router: Router
  ) { }

  ngOnInit(): void {
    console.log(this.record)
    this.http.get(`${ROOT_URL}/employee/role/${this.record.mailName}`).subscribe(res => {
      for ( let key in res.data){
        if (key.startsWith('SOLVE_CENTER')){
          this.roles.push(key)
        }
      }
    });
    // this.getRolesData().then()
  }

  async getRolesData(){
    await  this.http.get(`${ROOT_URL}role/list`).subscribe(res => {
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

  close() {
    this.modal.destroy();
  }

  select(ret: {}): void {
    console.log('nzSelectChange', ret);
  }

  change(ret: {}): void {
    console.log('nzChange', ret);
  }

  roleDetail(item) {
    // this.router.navigateByUrl('admin/admin/permission')
    this.extReq = {
      params: {
        roleName: item
      }
    }
    this.modalHelper.create(AdminPermissionComponent,{extReq: this.extReq}).subscribe(res => {
      console.log(res)
    })
  }

  edit(){
    window.location.href = 'https://a4.tsmc.com.tw/'
  }
}
