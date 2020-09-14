import {Component, Input, OnInit} from '@angular/core';
import {_HttpClient} from "@delon/theme";
import {ROOT_URL} from "@shared";
import {Router} from "@angular/router";

@Component({
  selector: 'app-my-collects',
  templateUrl: './my-collects.component.html',
  styles: [
      `
          p {
              margin: 0;
          }
    `
  ]
})
export class MyCollectsComponent implements OnInit {
  list = [];
  // @Input
  constructor(private http: _HttpClient,
              private router: Router) {
  }

  ngOnInit(): void {
    this.getData();
  }
  viewDetail(item: any) {
    console.log(item);
    this.router.navigate(['/details', {id: item.caseId}], );
    // this.router.navigateByUrl('/details?id=' + item['email'])
  }
  getData() {
    this.list = [];
    this.http.get(ROOT_URL + '/case/collect/list').subscribe(res => {
      console.log(res);
      let retList = res['data']['list'];
      if (retList.length > 3) {
        this.list.push(retList[0]);
        this.list.push(retList[1]);
        this.list.push(retList[2]);
      } else {
        this.list = [...res['data']['list']];
      }
      // this.list.
      // this.list = [...res['data']['list']];
    })
  }
}
