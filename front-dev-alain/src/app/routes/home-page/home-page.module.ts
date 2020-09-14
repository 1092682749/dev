import {CommonModule} from '@angular/common';
import {NgModule} from '@angular/core';

import {ScrollingModule} from '@angular/cdk/scrolling';
import {RouterModule} from '@angular/router';
import {
  NgZorroAntdModule,
  NzAutocompleteModule,
  NzAvatarModule,
  NzCommentModule, NzEmptyModule,
  NzGridModule,
  NzIconModule,
  NzListModule, NzRateModule,
  NzSkeletonModule, NzSpinModule,
  NzTagModule, NzToolTipModule
} from 'ng-zorro-antd';
import {CaseRankComponent} from './case-rank/case-rank.component';
import {HomeCaseListComponent} from './home-case-list/home-case-list.component';
import {HomeDetailComponent} from './home-detail/home-detail.component';
import {HomeIndexComponent} from './home-index/home-index.component';
import {HomePageRoutingModule} from './home-page-routing.module';
import {EditorModule} from "../../shared/editor/editor.module";
import {FormsModule} from "@angular/forms";
import {DetailsCommentComponent} from './home-detail/details-comment/details-comment.component';
import { HomePageTestComComponent } from './test-com/test-com.component';
import { HomePageTestComEditComponent } from './testCom/edit/edit.component';
import { HomePageTestComViewComponent } from './testCom/view/view.component';
import {DelonFormModule} from "@delon/form";
import {SharedModule} from "@shared";
import { CreateCaseComponent } from './create-case/create-case.component';
import { SearchInputComponent } from './home-index/search-input/search-input.component';
import { MyCollectsComponent } from './my-collects/my-collects.component';
import { LeftCardSollectsComponent } from './left-card-sollects/left-card-sollects.component';
import { RecommentCardComponent } from './home-index/recomment-card/recomment-card.component';
// import {AngularCropperjsModule} from "angular-cropperjs";
import { CutImageComponent } from './create-case/cut-image/cut-image.component';
import { CaseDetailsLoadingComponent } from './home-detail/case-details-loading/case-details-loading.component';
import { ContentToSafeHtmlPipe } from './home-detail/content-to-safe-html.pipe';
import {QuillModule} from "ngx-quill";
import {AngularCropperjsModule} from "angular-cropperjs";
import { String2NumberPipe } from './string2-number.pipe';
// import {AngularCropperjsModule} from "angular-cropperjs";
// import {ImageCropperModule} from "ngx-image-cropper";

// import {RoutesModule} from "../routes.module";

const COMPONENTS = [
  HomePageTestComComponent];
const COMPONENTS_NOROUNT = [
  HomePageTestComEditComponent,
  HomePageTestComViewComponent];
@NgModule({
  declarations: [
    HomeIndexComponent,
    HomeCaseListComponent,
    CaseRankComponent,
    HomeDetailComponent,
    DetailsCommentComponent,
    ...COMPONENTS,
    ...COMPONENTS_NOROUNT,
    CreateCaseComponent,
    SearchInputComponent,
    MyCollectsComponent,
    LeftCardSollectsComponent,
    RecommentCardComponent,
    CutImageComponent,
    CaseDetailsLoadingComponent,
    ContentToSafeHtmlPipe,
    String2NumberPipe
  ],
  imports: [
    CommonModule,
    HomePageRoutingModule,
    NzListModule,
    ScrollingModule,
    NzSkeletonModule,
    NzGridModule,
    NzTagModule,
    NzIconModule,
    EditorModule,
    FormsModule,
    NzCommentModule,
    NzAvatarModule,
    NzToolTipModule,
    DelonFormModule,
    NzSpinModule,
    SharedModule,
    NzEmptyModule,
    NzAutocompleteModule,
    // NzRateModule,
    NgZorroAntdModule,
    QuillModule,
    AngularCropperjsModule,
    // QuillModule,
    // AngularCropperjsModule,
    // AngularCropperjsModule,
    // ImageCropperModule
    // SharedModule
  ],
  exports: [
    String2NumberPipe
  ],
  providers: [
    // QuillService
  ]
})
export class HomePageModule {
}
