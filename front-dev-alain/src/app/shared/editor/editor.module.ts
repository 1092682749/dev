import { NgModule } from '@angular/core';
import { CommonModule } from '@angular/common';

import {QuillModule} from "ngx-quill";
import { TsmcEditorComponent } from './tsmc-editor/tsmc-editor.component';
import {FormsModule} from "@angular/forms";
import { HrefFormatComponent } from './tsmc-editor/href-format/href-format.component';


@NgModule({
  declarations: [TsmcEditorComponent, HrefFormatComponent],
  exports: [
    TsmcEditorComponent
  ],
  imports: [
    CommonModule,
    QuillModule.forRoot(),
    FormsModule
  ]
})
export class EditorModule { }
