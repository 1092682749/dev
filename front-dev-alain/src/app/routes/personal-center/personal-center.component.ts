import { Component, OnInit } from '@angular/core';
import { HttpClient } from '@angular/common/http';
// import { Component, OnInit } from '@angular/core';
import { NzMessageService } from 'ng-zorro-antd/message';
import {ROOT_URL} from "@shared";
import {ActivatedRoute, Router} from "@angular/router";



@Component({
  selector: 'app-personal-center',
  templateUrl: './personal-center.component.html',
  styles: [
    `
    `
  ]
})



export class PersonalCenterComponent implements OnInit {


  constructor(private http: HttpClient, private msg: NzMessageService,
              private router: Router, private route: ActivatedRoute) {}

  ngOnInit(): void {

  }




}
