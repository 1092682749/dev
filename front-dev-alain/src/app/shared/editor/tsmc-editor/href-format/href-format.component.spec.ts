import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { HrefFormatComponent } from './href-format.component';

describe('HrefFormatComponent', () => {
  let component: HrefFormatComponent;
  let fixture: ComponentFixture<HrefFormatComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ HrefFormatComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(HrefFormatComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
