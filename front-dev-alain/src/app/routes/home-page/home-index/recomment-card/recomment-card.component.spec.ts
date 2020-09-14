import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { RecommentCardComponent } from './recomment-card.component';

describe('RecommentCardComponent', () => {
  let component: RecommentCardComponent;
  let fixture: ComponentFixture<RecommentCardComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ RecommentCardComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(RecommentCardComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
