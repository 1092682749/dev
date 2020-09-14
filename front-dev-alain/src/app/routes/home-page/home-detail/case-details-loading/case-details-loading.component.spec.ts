import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { CaseDetailsLoadingComponent } from './case-details-loading.component';

describe('CaseDetailsLoadingComponent', () => {
  let component: CaseDetailsLoadingComponent;
  let fixture: ComponentFixture<CaseDetailsLoadingComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ CaseDetailsLoadingComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(CaseDetailsLoadingComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
