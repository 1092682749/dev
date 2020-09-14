import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { CaseRankComponent } from './case-rank.component';

describe('CaseRankComponent', () => {
  let component: CaseRankComponent;
  let fixture: ComponentFixture<CaseRankComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ CaseRankComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(CaseRankComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
