import { Component, OnInit } from '@angular/core';
import { _HttpClient } from '@delon/theme';
import {ROOT_URL} from "@shared";
import {G2BarData} from "@delon/chart";

@Component({
  selector: 'app-dashboard',
  templateUrl: './dashboard.component.html',
})
export class DashboardComponent implements OnInit {

  tags = []
  percent = 36;
  color = '#2f9cff';
  salesData: G2BarData[]
  constructor(private http: _HttpClient) { }

  ngOnInit() {
    setInterval(() => {
      this.percent = parseInt((Math.random() * 100).toString(), 10);
      this.color = this.percent > 50 ? '#f50' : '#2f9cff';
    }, 1000);
    this.http.get(`${ROOT_URL}/case/comment/rate/chart`).subscribe(res => {
      console.log(res)
      if (res && res['code'] == 0){
        this.salesData = res['data'].map(item => {
          // console.log({
          //   x: item['employee'],
          //   y: Number.parseInt(item['totalRate']),
          //   color: '#f50'
          // })
          return {
            x: item['employee'],
            y: Number.parseInt(item['totalRate']),
            color: '#f50'
          }
        })
      }
    })
    // Notification.requestPermission().then(function(permission) {
    //   if(permission === 'granted'){
    //     console.log('用户允许通知');
    //   }else if(permission === 'denied'){
    //     console.log('用户拒绝通知');
    //   }
    // });
  }
//   salesData: G2BarData[]
// {employee: "102316", totalRate: "13"}

  handleClick(data): void {
    console.log(data)
    var n = new Notification('状态更新提醒',{
      body: '你的朋友圈有3条新状态，快去查看吧'
    })

    setTimeout(function() {
      n.close();
    }, 3000);
  }

}
