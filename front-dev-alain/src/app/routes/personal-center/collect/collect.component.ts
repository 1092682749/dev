import { Component, OnInit } from '@angular/core';
import {HttpClient} from "@angular/common/http";
import {NzMessageService} from "ng-zorro-antd";
import {ActivatedRoute, Router} from "@angular/router";
import {ROOT_URL} from "@shared";
const count = 5;
const fakeDataUrl = ROOT_URL + '/case/collect/list';
@Component({
  selector: 'app-collect',
  templateUrl: './collect.component.html',
  styles: [
    `  .demo-loadmore-list {
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
      }`
  ]
})
export class CollectComponent implements OnInit {
  avatarSrc = 'https://zos.alipayobjects.com/rmsportal/ODTLcjxAfvqbxHnVXCYX.png';
  initLoading = true; // bug
  loadingMore = false;
  condition: '';
  data: any[] = [];
  list: any[] = [];
  pageNum: number =  1;
  pages: number = 1;
  // list: Array<{ loading: boolean; name: any }> = [];

  constructor(private http: HttpClient, private msg: NzMessageService,
              private router: Router, private route: ActivatedRoute){}

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
        // 分出标签
        res.data.list = res.data.list.map((v, i, arr) => {
          if (v.tags != null) v['tagArr'] = v?.tags.split(",");
          return v;
        });
        this.data = res.data.list;
        this.list = res.data.list;
        if (res.data.code == 302) {
          // console.log('ccccc')
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
        // console.log(res);
        res.data.list = res.data.list.map((v, i, arr) => {
          if (v.tags != null) v['tagArr'] = v?.tags.split(",");
          return v;
        });
        // console.log(res.data.list);
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

  like(index, action){
    let item = this.list[index];
    console.log(action);
    item.likeOrUnlike = action;
    this.http.post(ROOT_URL + '/case/like/likeOrUnlike', {
      action: action,
      caseId: item.caseId,
    }).subscribe(
      (res: any) => {
        console.log(res);
        this.list[index] = res.data;
      }
    )
  }
  unLike(item){

  }

  setCondition(condition) {
    this.condition = condition;
  }

}
