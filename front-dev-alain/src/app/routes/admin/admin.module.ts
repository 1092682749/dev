import { NgModule } from '@angular/core';
import { SharedModule } from '@shared';
import { AdminRoutingModule } from './admin-routing.module';
import { AdminRoleComponent } from './role/role.component';
import { AdminRoleEditComponent } from './role/edit/edit.component';
import { AdminRoleViewComponent } from './role/view/view.component';
import { AdminPermissionComponent } from './permission/permission.component';
import { AdminPermissionEditComponent } from './permission/edit/edit.component';
import { AdminPermissionViewComponent } from './permission/view/view.component';
import {NzCommentModule, NzListModule, NzRateModule, NzTransferModule} from "ng-zorro-antd";
import { AdminCaseComponent } from './case/case.component';
import { AdminCaseEditComponent } from './case/edit/edit.component';
import { AdminCaseViewComponent } from './case/view/view.component';
import { AdminSolutionComponent } from './solution/solution.component';
import { AdminSolutionEditComponent } from './solution/edit/edit.component';
import { AdminSolutionViewComponent } from './solution/view/view.component';
import {EditorModule} from "../../shared/editor/editor.module";
import { AdminUserComponent } from './user/user.component';
import { AdminUserEditComponent } from './user/edit/edit.component';
import { AdminUserViewComponent } from './user/view/view.component';
import { AdminTagComponent } from './tag/tag.component';
import { AdminTagEditComponent } from './tag/edit/edit.component';
import { AdminTagViewComponent } from './tag/view/view.component';
import { RateComponent } from './case/rate/rate/rate.component';
import {HomePageModule} from "../home-page/home-page.module";

const COMPONENTS = [
  AdminRoleComponent,
  AdminPermissionComponent,
  AdminCaseComponent,
  AdminSolutionComponent,
  AdminUserComponent,
  AdminTagComponent];
const COMPONENTS_NOROUNT = [
  AdminRoleEditComponent,
  AdminRoleViewComponent,
  AdminPermissionEditComponent,
  AdminPermissionViewComponent,
  AdminCaseEditComponent,
  AdminCaseViewComponent,
  AdminSolutionEditComponent,
  AdminSolutionViewComponent,
  AdminUserEditComponent,
  AdminUserViewComponent,
  AdminTagEditComponent,
  AdminTagViewComponent];

@NgModule({
  imports: [
    SharedModule,
    AdminRoutingModule,
    NzTransferModule,
    EditorModule,
    NzListModule,
    NzCommentModule,
    NzRateModule,
    HomePageModule
  ],
  declarations: [
    ...COMPONENTS,
    ...COMPONENTS_NOROUNT,
    RateComponent
  ],
})
export class AdminModule { }
