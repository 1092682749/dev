import { Component, OnInit } from '@angular/core';
import Quill from 'quill';
const Link = Quill.import('formats/link')
@Component({
  selector: 'app-href-format',
  templateUrl: './href-format.component.html',
  styles: [
  ]
})
export class HrefFormatComponent extends Link  {

  constructor() {
    super();
    Quill.register(HrefFormatComponent);
  }

static create(value) {
    let node = undefined;
    if (value && !value.href) {
      node = super.create(value)
    } else {
      node = super.create(value.href);
      node.setAttribute("download", true);
      node.innerText = value.innerText;
    }
    return node;
}
  static blotName = 'href'
  static tagName = 'A'

}
