import { CollectionViewer, DataSource } from '@angular/cdk/collections';
import { HttpClient } from '@angular/common/http';
import {ChangeDetectionStrategy, Component, EventEmitter, OnInit, Output} from '@angular/core';
import {ActivatedRoute, Route, Router} from '@angular/router';
import {NzMessageService, NzNotificationModule, NzNotificationService} from 'ng-zorro-antd';
import { BehaviorSubject, Observable, Subscription } from 'rxjs';
import {ROOT_URL} from "@shared";
const count = 5;
const fakeDataUrl = ROOT_URL + '/caseForm/list';

@Component({
  selector: 'app-case-list',
  templateUrl: './home-case-list.component.html',
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
          zoom: 1.2;
          /*width: 20px;*/
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
  ],
  changeDetection: ChangeDetectionStrategy.Default,
  // exportAs:
})
export class HomeCaseListComponent implements OnInit {
  @Output("onCollect")
  myCollectId: EventEmitter<string> = new EventEmitter<string>();
  avatarSrc = 'https://zos.alipayobjects.com/rmsportal/ODTLcjxAfvqbxHnVXCYX.png';
  initLoading = true; // bug
  loadingMore = false;
  condition: '';
  data: any[] = [];
  list: any[] = [];
  pageNum: number =  1;
  pages: number = 1;
  // list: Array<{ loading: boolean; name: any }> = [];

  constructor(private http: HttpClient, private msg: NzMessageService,private notify: NzNotificationService,
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
        if (res.data.list == null) {
          this.msg.info('似乎什么都没有搜索到');
          res.data.list = [];
        }
        res.data.list = res.data.list.map((v, i, arr) => {
          if (v.tags != null) v['tagArr'] = v?.tags.split(",");
          v.adminRate = parseInt(v['adminRate']);
          return v;
        });
        this.data = res.data.list;
        this.list = res.data.list;
        if (res.data.code === 302) {
          // console.log('aaaaaaaaa')
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
      // window.open("/#/details;id="+item.caseId)
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
        /**
         * downNum: "1"
         likeOrUnlike: "unlike"
         moduleName: "SOLVE_CENTER_MODULE_FTS"
         status: "accept"
         tags: "EDW"
         title: "保存测试"
         upNum: "0"
         */
        this.list[index]['likeOrUnlike'] = res.data['likeOrUnlike'];
        this.list[index]['downNum'] = res.data['downNum'];
        this.list[index]['upNum'] = res.data['upNum'];
      }
    )
  }
  unLike(item){

  }

  setCondition(condition) {
    this.condition = condition;
  }

  collectCase(item) {
    // 收藏

    this.http.get(ROOT_URL + '/case/collect/collectCase', {params: {caseId: item.caseId}})
      .subscribe(res => {
          console.log(res);
          if (res['code'] == 0) {
          this.msg.success('收藏' + res['message']);
          console.log("emit it............1");
          this.myCollectId.emit(item.caseId);
        } else {
          this.msg.success('收藏' + res['message']);
          console.log("emit it............2");
          this.myCollectId.emit(item.caseId);
        }
      },
        error => {
          this.notify.error('Error', error['message'])
        })
  }

  confirmDeleteCase(caseId, index) {
    this.http.post(ROOT_URL + '/caseForm/delete', {caseId: caseId}).subscribe(
      res => {
        if (res['code'] == 0) {
          this.msg.success('删除' + res['message'])
          this.list.splice(index, 1);
          // this.getData();
        } else {
          this.msg.warning('删除' + res['message'])
        }
      }
    )
  }

  adminRate(e, item, i) {
    let body = {
      caseId: item.caseId,
      adminRate: e
    };
    this.http.post(ROOT_URL + '/caseForm/Rating', body).subscribe(res => {

    })
  }
  startCount = "5";
}
