import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { LeftCardSollectsComponent } from './left-card-sollects.component';

describe('LeftCardSollectsComponent', () => {
  let component: LeftCardSollectsComponent;
  let fixture: ComponentFixture<LeftCardSollectsComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ LeftCardSollectsComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(LeftCardSollectsComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
