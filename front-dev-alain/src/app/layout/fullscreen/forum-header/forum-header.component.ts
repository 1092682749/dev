import {ChangeDetectionStrategy, Component, OnInit} from '@angular/core';
import {SettingsService} from '@delon/theme';
import {ACLService} from "@delon/acl";

@Component({
  selector: 'app-forum-header',
  templateUrl: './forum-header.component.html',
  styles: [
    `.item  {
          display: block;
          min-width: 50px;
          padding: 8px 2px;
          line-height: 100%;
          text-align: center;
          border-radius: 2px;
          outline: none;
          cursor: pointer;
          transition: background-color 300ms;
      }
      .goWrite {
          display: block;
          min-width: 50px;
          padding: 8px 2px;
          line-height: 100%;
          text-align: center;
          border-radius: 2px;
          outline: none;
          cursor: pointer;
          transition: background-color 300ms;
          background-color: #1890ff;
      }
      .goWrite a {
          color: white;
      }
      .home {
        width: 19px
    }
    `
  ],
  changeDetection: ChangeDetectionStrategy.OnPush,
})
export class ForumHeaderComponent implements OnInit {

  searchToggleStatus: boolean;

  constructor(public settings: SettingsService, private aclService: ACLService) {}

  toggleCollapsedSidebar() {
    this.settings.setLayout('collapsed', !this.settings.layout.collapsed);
  }

  searchToggleChange() {
    this.searchToggleStatus = !this.searchToggleStatus;
  }

  ngOnInit(): void {
    console.log(this.aclService);
  }

}
