import {ChangeDetectionStrategy, Component, HostListener} from '@angular/core';
import * as screenfull from 'screenfull';
import {Router} from "@angular/router";

@Component({
  selector: 'header-write',
  template: `
      <span (click)="toCreateCase()">
      <i nz-icon nzType="edit" ></i>

      新建Case</span>
      
  `,
  // tslint:disable-next-line: no-host-metadata-property <i nz-icon nzType="edit" nzTheme="outline"></i>
  host: {
    '[class.d-block]': 'true',
  },
  changeDetection: ChangeDetectionStrategy.OnPush,
})
export class HeaderWriteComponent {
  constructor(private router: Router){}
  toCreateCase() {
    this.router.navigate(['/createCase']);
  }
}
