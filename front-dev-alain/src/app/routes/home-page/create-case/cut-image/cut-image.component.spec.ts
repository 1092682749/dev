import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { CutImageComponent } from './cut-image.component';

describe('CutImageComponent', () => {
  let component: CutImageComponent;
  let fixture: ComponentFixture<CutImageComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ CutImageComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(CutImageComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
