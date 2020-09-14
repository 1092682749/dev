import {Component, OnInit, ViewChild, ViewChildren, ViewContainerRef} from '@angular/core';
import {HomeCaseListComponent} from "../home-case-list/home-case-list.component";
import {CollectComponent} from "../../personal-center/collect/collect.component";
import {MyCollectsComponent} from "../my-collects/my-collects.component";
import {_HttpClient} from "@delon/theme";
import {ROOT_URL} from "@shared";

@Component({
  selector: 'app-home-index',
  templateUrl: './home-index.component.html',
  styles: [
      `
          #home-box .box-module {
              vertical-align: middle;
              display: inline-block;
          }

          .left-box {
              position: absolute;
          }

          .right-box {
              position: absolute;
          }
    `,

  ],
  styleUrls: [
     './mycss/articleList/css/bootstrap5152.css',
    './mycss/articleList/css/main5152.css',
    './mycss/articleList/css/responsive5152.css'
  ]
})
export class HomeIndexComponent implements OnInit {
// './css/prettyPhotoaeb9.css',
  searchValue: string;
  constructor(private http: _HttpClient) {
  }

  ngOnInit(): void {
  }
  @ViewChild('caseListComponent') caseListComponent: HomeCaseListComponent;
  @ViewChild('collectsComponent') collectsComponent: MyCollectsComponent;
  search() {
    console.log(this.searchValue);
    if (this.searchValue != undefined) {
      this.caseListComponent.setCondition(this.searchValue);
      this.caseListComponent.getData();
    }
  }
  appSearchChange(value) {
    console.log(value);
    this.searchValue = value;
  }
  inputValue?: string;
  options: string[] = [];

  onInput(event: Event): void {
    const value = (event.target as HTMLInputElement).value;
    this.options = value ? ['<span>' + value + '</span>', value + value, value + value + value] : [];
  }

  sanall() {
    this.http.get(ROOT_URL + '/caseForm/putNoSaveDoc').subscribe(
      res=> {

      }
    );
  }
  onCollect(e) {
    console.log('i get a event, notify flush my collects list' + e);
    this.collectsComponent.getData();
  }

}
