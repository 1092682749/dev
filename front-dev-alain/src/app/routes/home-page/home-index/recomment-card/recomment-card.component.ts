import { Component, OnInit } from '@angular/core';
import {_HttpClient} from "@delon/theme";
import {ROOT_URL} from "@shared";
import {Router} from "@angular/router";

@Component({
  selector: 'app-recomment-card',
  templateUrl: './recomment-card.component.html',
  styles: [
  ]
})
export class RecommentCardComponent implements OnInit {
  list: Array<any>;
  constructor(private http: _HttpClient, private router: Router) { }

  ngOnInit(): void {
    this.getData();
  }
  getData() {
    this.http.get(ROOT_URL + '/caseForm/Oldest').subscribe(
      res => {
        this.list = [...res['data']['list']];
      },

    )
  }

  viewDetail(item: any) {
    console.log(item);
    this.router.navigate(['/details', {id: item.caseId}], );
    // this.router.navigateByUrl('/details?id=' + item['email'])
  }
}
