import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { TsmcEditorComponent } from './tsmc-editor.component';

describe('TsmcEditorComponent', () => {
  let component: TsmcEditorComponent;
  let fixture: ComponentFixture<TsmcEditorComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ TsmcEditorComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(TsmcEditorComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
