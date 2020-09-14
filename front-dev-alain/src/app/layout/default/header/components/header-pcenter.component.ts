import {Component, OnInit} from '@angular/core';
import {Router} from "@angular/router";

@Component({
  selector: 'header-pcenter',
  template: `<span (click)="toPersonCenter()">
      <i nz-icon nzType="user" nzTheme="outline"></i>
      {{'menu.account.center' | translate}}</span>`,
  styles: []
})
export class HeaderPcenterComponent implements OnInit {

  constructor(
    private router: Router
  ) {
  }

  ngOnInit(): void {
  }

  toPersonCenter() {
    console.log('asd');
    this.router.navigate(['/personalCenter/myCase']);
  }
}
