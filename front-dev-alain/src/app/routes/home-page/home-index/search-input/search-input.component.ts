import {Component, EventEmitter, Input, OnInit, Output} from '@angular/core';
import {_HttpClient} from "@delon/theme";
import {ROOT_URL} from "@shared";
import {Router} from "@angular/router";
import {ControlValueAccessor} from "@angular/forms";

@Component({
  selector: 'app-search-input',
  templateUrl: './search-input.component.html',
  styles: [
      `
          .global-search-item {
              display: flex;
          }

          .global-search-item-desc {
              flex: auto;
              text-overflow: ellipsis;
              overflow: hidden;
          }

          .global-search-item-count {
              flex: none;
          }
        .highlight {
          color: red;
        }
    `
  ]
})
export class SearchInputComponent implements OnInit {
  api = '/details?id=';
  @Input() placeholder: string;

  instance = this;
  fun: any;
  inputValue?: string;
  @Output() valueChange = new EventEmitter<string>();
    // var run = true;
  run = true;
  // var timer = -1;
  timer = -1;
  options: Array<{ title: string; brief: string; content: number; caseId: string }> = [];
  constructor(private http: _HttpClient, private router: Router){}
  onChange(e: Event): void {
    console.log(this.inputValue);
    this.getData(e, null);
    this.valueChange.emit(this.inputValue);
    // this.fun(e);
  }

  private getRandomInt(max: number, min: number = 0): number {
    return Math.floor(Math.random() * (max - min + 1)) + min;
  }

  ngOnInit(): void {
     this.fun = this.setDelay(this.getData, 500);
  }
  viewDetail(e, id) {
    console.log(id);
    if (e.isUserInput) {
      this.router.navigate(['/details', {id: id}]);
    }

  }
  getData(e, a) {
    // console.log(e, a);
    // const value = e.data;
    this.http.get(ROOT_URL + '/es/search', {value: this.inputValue}).subscribe(
      res => {
        console.log(res);
        this.options = res['data'];
      },
      error => {

      }
    );
  }
  setDelay(fun, time) {
    var bingo = true, timer = -1;
    return function() {
      if (bingo) {
        var args = Array.prototype.slice.call(arguments, 0);
        var ret = fun.call(this, args);
        bingo = false;
        window.clearTimeout(timer);
        timer = window.setTimeout(function() {
          bingo = true;
        }, time);
        return ret;
      }
    }
  }

  registerOnChange(fn: any): void {
    console.log(fn)
  }

  registerOnTouched(fn: any): void {
    console.log(fn)
  }

  writeValue(obj: any): void {
    console.log("asdasdasd" + obj)
    this.inputValue = obj;
  }
}
