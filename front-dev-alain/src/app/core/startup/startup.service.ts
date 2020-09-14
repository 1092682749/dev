import {HttpClient} from '@angular/common/http';
import {Inject, Injectable, Injector} from '@angular/core';
import {Router} from '@angular/router';
import {ACLService} from '@delon/acl';
import {DA_SERVICE_TOKEN, ITokenModel, ITokenService} from '@delon/auth';
import {ALAIN_I18N_TOKEN, MenuService, SettingsService, TitleService} from '@delon/theme';
import {TranslateService} from '@ngx-translate/core';
import {zip} from 'rxjs';
import {catchError} from 'rxjs/operators';
import {I18NService} from '../i18n/i18n.service';

import {NzIconService} from 'ng-zorro-antd/icon';
import {ICONS} from '../../../style-icons';
import {ICONS_AUTO} from '../../../style-icons-auto';
import {ROOT_URL} from "@shared";

/**
 * Used for application startup
 * Generally used to get the basic data of the application, like: Menu Data, User Data, etc.
 */
@Injectable()
export class StartupService {
  constructor(
    iconSrv: NzIconService,
    private menuService: MenuService,
    private translate: TranslateService,
    @Inject(ALAIN_I18N_TOKEN) private i18n: I18NService,
    private settingService: SettingsService,
    private aclService: ACLService,
    private titleService: TitleService,
    @Inject(DA_SERVICE_TOKEN) private tokenService: ITokenService,
    private httpClient: HttpClient,
    private injector: Injector
  ) {
    iconSrv.addIcon(...ICONS_AUTO, ...ICONS);
  }

  private viaHttp(resolve: any, reject: any) {
    // let token = new ITokenModel();
    // this.tokenService.set({'token': 'asd'});
    zip(
      this.httpClient.get(`assets/tmp/i18n/${this.i18n.defaultLang}.json`),
      this.httpClient.get('assets/tmp/app-data.json')
    ).pipe(
      catchError((res) => {
        console.warn(`StartupService.load: Network request failed`, res);
        resolve(null);
        return [];
      })
    ).subscribe(([langData, appData]) => {
        // Setting language data
        this.translate.setTranslation(this.i18n.defaultLang, langData);
        this.translate.setDefaultLang(this.i18n.defaultLang);
        // const user = this.tokenService.get("user");
        // this.tokenService
        console.log(this.tokenService);
        // Application data
        const res: any = appData;
        // Application information: including site name, description, year
        this.settingService.setApp(res.app);
        // User information: including name, avatar, email address
        // this.settingService.setUser(res.user);
        // ACL: Set the permissions to full, https://ng-alain.com/acl/getting-started
        this.aclService.setFull(false);
        const user = this.settingService.user;
        console.log('return json', user);
        // acl 尽量在 menu 前设置
        if (user && user['roles']) {
          this.aclService.setRole(user['roles'].split(',').filter(i => i != ''))
        }

        if (user && user['permissions']) {
          // set 会清除所有权限此次用 attach 追加
          console.log('zui jia' + user['permissions'].split(',').filter(i => i != ''))
          this.aclService.attachAbility(user['permissions'].split(',').filter(i => i != ''))
        }

        // Menu data, https://ng-alain.com/theme/menu
        this.menuService.add(res.menu);
        // Can be set page suffix title, https://ng-alain.com/theme/title
        this.titleService.suffix = res.app.name;

        this.httpClient.get(`${ROOT_URL}/user/auth`).subscribe(res => {
          console.log(res)
          if (res['code'] == 0){
            const data = res['data']
            if (data && data['roles']) {
              console.log('set role...........' );
              console.log(data['roles'].split(',').filter(i => i != ''));
              this.aclService.setRole(data['roles'].split(',').filter(i => i != ''))
            }

            if (data && data['permissions']) {
              // set 会清除所有权限此次用 attach 追加
              console.log('set permissions...........' );
              console.log(data['permissions'].split(',').filter(i => i != ''));
              this.aclService.attachAbility(data['permissions'].split(',').filter(i => i != ''))
            }
          }
        })
      },
      () => {
      },
      () => {
        resolve(null);
      });
  }

  private viaMockI18n(resolve: any, reject: any) {
    this.httpClient
      .get(`assets/tmp/i18n/${this.i18n.defaultLang}.json`)
      .subscribe(langData => {
        this.translate.setTranslation(this.i18n.defaultLang, langData);
        this.translate.setDefaultLang(this.i18n.defaultLang);

        this.viaMock(resolve, reject);
      });
  }

  private viaMock(resolve: any, reject: any) {
    console.log('viaMock............')
    // const tokenData = this.tokenService.get();
    // if (!tokenData.token) {
    //   this.injector.get(Router).navigateByUrl('/passport/login');
    //   resolve({});
    //   return;
    // }
    // mock
    const app: any = {
      name: `ng-alain`,
      description: `Ng-zorro admin panel front-end framework`
    };
    // const user: any = {
    //   name: 'Admin',
    //   avatar: './assets/tmp/img/avatar.jpg',
    //   email: 'cipchk@qq.com',
    //   token: '123456789'
    // };
    const user = this.tokenService.get("user");
    console.log('return json' + user);
    // Application information: including site name, description, year
    this.settingService.setApp(app);
    // User information: including name, avatar, email address
    this.settingService.setUser(user);
    this.aclService.setRole(user['roles'])
    // set 会清除所有权限此次用 attach 追加
    this.aclService.attachAbility(user['permissions'])
    // ACL: Set the permissions to full, https://ng-alain.com/acl/getting-started
    this.aclService.setFull(true);
    // Menu data, https://ng-alain.com/theme/menu
    this.menuService.add([
      {
        text: 'Main',
        group: true,
        children: [
          {
            text: 'Home',
            link: '/business',
            icon: {type: 'icon', value: 'appstore'}
          },
          {
            text: 'Admin',
            icon: {type: 'icon', value: 'rocket'},
            shortcutRoot: true
          }
        ]
      }
    ]);
    // Can be set page suffix title, https://ng-alain.com/theme/title
    this.titleService.suffix = app.name;

    resolve({});
  }

  load(): Promise<any> {
    // only works with promises
    // https://github.com/angular/angular/issues/15088
    return new Promise((resolve, reject) => {
      // http
      this.viaHttp(resolve, reject);
      // mock：请勿在生产环境中这么使用，viaMock 单纯只是为了模拟一些数据使脚手架一开始能正常运行
      // this.viaMockI18n(resolve, reject);
      // this.viaHttp();
    });
  }
}
