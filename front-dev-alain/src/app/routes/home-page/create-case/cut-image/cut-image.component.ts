import {Component, ElementRef, OnInit, ViewChild} from '@angular/core';
import {CropperComponent} from "angular-cropperjs";
import {NzModalRef} from "ng-zorro-antd";

@Component({
  selector: 'app-cut-image',
  templateUrl: './cut-image.component.html',
  styles: [
  ]
})
export class CutImageComponent implements OnInit {

  ev: ProgressEvent;
  @ViewChild('fileUploadInput', {static: true})
  upLoadInput: ElementRef;
  config = {
    viewMode: 0,
    zoomOnWheel: true,
    zoomable: true
  }
// Get with @ViewChild
  @ViewChild('angularCropper', {static: true}) public angularCropper: CropperComponent;
  constructor(private modal: NzModalRef,) { }

  ngOnInit(): void {

    console.log(this.ev.target['result']);
    console.log(
    this.angularCropper.imageElement)

    this.modal.destroy(this.angularCropper.cropper.getCroppedCanvas().toDataURL());
  }


  zoom = 0.1;
  resizeZoom() {
    this.zoom += 0.1;
    this.modal.destroy(this.angularCropper.cropper.getCroppedCanvas().toDataURL())
  }


  nocut() {
    this.modal.destroy(this.ev.target['result'])

  }

}
