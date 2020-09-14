import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { ForumNotificationComponent } from './forum-notification.component';

describe('ForumNotificationComponent', () => {
  let component: ForumNotificationComponent;
  let fixture: ComponentFixture<ForumNotificationComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ ForumNotificationComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(ForumNotificationComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
