import { NgModule } from '@angular/core';

import { SharedModule } from '@shared';
import { RouteRoutingModule } from './routes-routing.module';
// dashboard pages
import { DashboardComponent } from './dashboard/dashboard.component';
// passport pages
import { UserLoginComponent } from './passport/login/login.component';
import { UserRegisterComponent } from './passport/register/register.component';
import { UserRegisterResultComponent } from './passport/register-result/register-result.component';
// single pages
import { CallbackComponent } from './callback/callback.component';
import { UserLockComponent } from './passport/lock/lock.component';
import {DelonChartModule} from "@delon/chart";
import { PersonalCenterComponent } from './personal-center/personal-center.component';
import { NzListModule, NzSkeletonModule, NzTagModule} from "ng-zorro-antd";
import { CollectComponent } from './personal-center/collect/collect.component';
import { MyCaseComponent } from './personal-center/my-case/my-case.component';

const COMPONENTS = [
  DashboardComponent,
  // passport pages
  UserLoginComponent,
  UserRegisterComponent,
  UserRegisterResultComponent,
  // single pages
  CallbackComponent,
  UserLockComponent,
];
const COMPONENTS_NOROUNT = [];

@NgModule({
  imports: [SharedModule, RouteRoutingModule, DelonChartModule, NzListModule, NzSkeletonModule, NzTagModule],
  declarations: [
    ...COMPONENTS,
    ...COMPONENTS_NOROUNT,
    PersonalCenterComponent,
    CollectComponent,
    MyCaseComponent
  ],
})
export class RoutesModule {}
