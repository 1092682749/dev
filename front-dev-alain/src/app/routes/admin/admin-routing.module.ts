import { NgModule } from '@angular/core';
import { Routes, RouterModule } from '@angular/router';
import { AdminRoleComponent } from './role/role.component';
import { AdminPermissionComponent } from './permission/permission.component';
import { AdminCaseComponent } from './case/case.component';
import { AdminSolutionComponent } from './solution/solution.component';
import { AdminUserComponent } from './user/user.component';
import { AdminTagComponent } from './tag/tag.component';

const routes: Routes = [
  { path: '', redirectTo: 'case', pathMatch: 'full' },
  { path: 'role', component: AdminRoleComponent },
  { path: 'permission', component: AdminPermissionComponent },
  { path: 'case', component: AdminCaseComponent },
  { path: 'solution', component: AdminSolutionComponent },
  { path: 'user', component: AdminUserComponent },
  { path: 'tag', component: AdminTagComponent }];

@NgModule({
  imports: [RouterModule.forChild(routes)],
  exports: [RouterModule]
})
export class AdminRoutingModule { }
