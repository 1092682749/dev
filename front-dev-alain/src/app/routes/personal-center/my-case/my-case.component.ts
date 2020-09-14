import { Component, OnInit } from '@angular/core';
import {HttpClient} from "@angular/common/http";
import {NzMessageService} from "ng-zorro-antd";
import {ActivatedRoute, Router} from "@angular/router";
import {ROOT_URL} from "@shared";
const count = 5;
const fakeDataUrl = ROOT_URL + '/caseForm/findMyCase';
@Component({
  selector: 'app-my-case',
  templateUrl: './my-case.component.html',
  styles: [
    `
      .demo-loadmore-list {
          min-height: 350px;
      }
      .loadmore {
          text-align: center;
          margin-top: 12px;
          height: 32px;
          line-height: 32px;
      }
      .zoom {
          zoom: 1.5;
      }
      .close {
          width: 37px;
          height: 37px;
          /*background: url("./assets/closed.svg");*/
      }
      .share {
          width: 33px;
          height: 33px;
      }
      .tagImg {
          position: absolute;
          right: 0px;
      }
    `
  ]
})
export class MyCaseComponent implements OnInit {

  initLoading = true; // bug
  loadingMore = false;
  condition: '';
  data: any[] = [];
  list: any[] = [];
  pageNum: number =  1;
  pages: number = 1;

  constructor(private http: HttpClient, private msg: NzMessageService,
              private router: Router, private route: ActivatedRoute) {}

  ngOnInit(): void {
    this.getData();
  }


  getData(): void {
    console.log(this.condition)
    if (this.condition == undefined) {
      this.condition = '';
    }
    this.pageNum =  1;
    this.http.get(fakeDataUrl, {params: {condition: this.condition}}).subscribe(
      (res: any) => {
        this.data = res.data.list;
        this.list = res.data.list;
        if (res.data.code == 302) {
          // console.log('bbbb')
          this.msg.info(res['data']['message']);
        }

        this.initLoading = false;
        this.pages = res.data.pages;
      }
    );
  }

  onLoadMore(): void {
    this.pageNum++;
    this.loadingMore = true;
    this.list = this.data.concat([...Array(count)].fill({}).map(() => ({ loading: true, name: {} })));
    this.http.get(fakeDataUrl, {params: {
        'pageNum': this.pageNum.toString(),
        'condition': this.condition
      }})
      .subscribe((res: any) => {
        res.data.list = res.data.list.map((v, i, arr) => {
          if (v.tags != null) v['tagArr'] = v?.tags.split(",");
          return v;
        });
        console.log(res.data.list);
        this.data = this.data.concat(res.data.list);
        this.list = [...this.data];
        console.log(this.list);
        // this.list.map()
        this.loadingMore = false;
      });
  }

  edit(item: any): void {
    this.msg.success(item.email);
  }

  viewDetail(item: any) {
    console.log(item);
    this.router.navigate(['/details', {id: item.caseId}], );
    // this.router.navigateByUrl('/details?id=' + item['email'])
  }
  cancel(): void {
    // this.msg.info('click cancel');

  }

  confirm(caseId, index): void {
    this.msg.info('click confirm');
    this.http.post(ROOT_URL + '/caseForm/delete', {caseId: caseId}).subscribe(
      res => {
        if (res['code'] == 0) {
          this.msg.success('删除' + res['message']);
          this.list.splice(index, 1);
        } else {
          this.msg.warning('删除' + res['message'])
        }
      }
    )
  }
}
