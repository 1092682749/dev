import { NgModule } from '@angular/core';
import { RouterModule, Routes } from '@angular/router';
import {HomeDetailComponent} from './home-detail/home-detail.component';
import {HomeIndexComponent} from './home-index/home-index.component';
import { HomePageTestComComponent } from './test-com/test-com.component';
import {CreateCaseComponent} from "./create-case/create-case.component";
import {CaseDetailsLoadingComponent} from "./home-detail/case-details-loading/case-details-loading.component";


const routes: Routes = [
  { path: '', redirectTo: 'index', pathMatch: 'full' },
  {
    path: 'index',
    component: HomeIndexComponent,
    data: {title: 'Home'},
    children: [
      // {
      //   path: 'details',
      //   component: HomeDetailComponent,
      //   data: {title: 'Details'}
      // }
    ]
  },
  {
    path: 'details',
    component: HomeDetailComponent,
    data: {title: 'Details'},

  },
  {
    path: 'loading',
    component: CaseDetailsLoadingComponent,
    data: {title: 'loading'},
  }
,
  { path: 'testCom', component: HomePageTestComComponent },
  {
    path: 'createCase',
    component: CreateCaseComponent,
    data: {title: 'Create Case'}
  }
];

@NgModule({
  imports: [RouterModule.forChild(routes)],
  exports: [RouterModule]
})
export class HomePageRoutingModule { }
