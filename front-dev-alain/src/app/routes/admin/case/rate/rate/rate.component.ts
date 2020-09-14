import { Component, OnInit } from '@angular/core';

@Component({
  selector: 'app-rate',
  templateUrl: './rate.component.html',
  styles: [
  ]
})
export class RateComponent implements OnInit {
  rate;
  record: any = {};
  constructor() { }

  ngOnInit(): void {
  }

}
