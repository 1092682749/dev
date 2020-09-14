import { Component, OnInit } from '@angular/core';
import {EditorChangeContent, EditorChangeSelection, QuillService} from "ngx-quill";
import {NzMessageService, NzModalRef} from "ng-zorro-antd";
import {SFSchema, SFUISchema} from "@delon/form";
import {_HttpClient} from "@delon/theme";
import {ROOT_URL} from "@shared";

@Component({
  selector: 'app-details-comment',
  templateUrl: './details-comment.component.html',
  styles: [
  ]
})
export class DetailsCommentComponent implements OnInit {
  review: any;

  content = ''

  comment: any;
  parentId: number;
  i: any;
  schema: SFSchema = {
    properties: {
      // no: { type: 'string', title: '编号' },
      // owner: { type: 'string', title: '姓名', maxLength: 15 },
      // callNo: { type: 'number', title: '调用次数' },
      // href: { type: 'string', title: '链接', format: 'uri' },
      // description: { type: 'string', title: '描述', maxLength: 140 },
    },
    //'owner', 'callNo', 'href', 'description'
    required: [],
  };
  ui: SFUISchema = {
    // '*': {
    //   spanLabelFixed: 100,
    //   grid: { span: 12 },
    // },
    // $no: {
    //   widget: 'text'
    // },
    // $href: {
    //   widget: 'string',
    // },
    // $description: {
    //   widget: 'textarea',
    //   grid: { span: 24 },
    // },
  };
  constructor(
    private modal: NzModalRef,
    private msgSrv: NzMessageService,
    public http: _HttpClient,
  ) { }

  ngOnInit(): void {

  }
  blured = false
  focused = false




  save(value: any) {
    console.log(this.content)
    this.comment = {
      caseId: this.review.caseId,
      parentId: this.parentId,
      content: this.content,
      commentLevel: 2,
      toEmpno: this.review.commentEmpno,
    }
    this.close();
  }

  close() {
    this.modal.destroy(this.comment);
  }
}
