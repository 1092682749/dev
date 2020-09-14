import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { HeaederSearchComponent } from './heaeder-search.component';

describe('HeaederSearchComponent', () => {
  let component: HeaederSearchComponent;
  let fixture: ComponentFixture<HeaederSearchComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ HeaederSearchComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(HeaederSearchComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
