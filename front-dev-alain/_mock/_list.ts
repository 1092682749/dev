const list = [
  {
    email: 'maurice.smith@example.com',
    gender: 'male',
    description: '如何存档邮件到本地',
    content:
      `<div class="tab-pane active" id="commonQuestions">
                                            <div id="">
                                                <div class="row">
                                                    
                                                    <!-- modfiy by yywangw -->
                                                    <div class="tim-typo">
                                                        <h4 style="color: Red;font-weight:900;">
                                                            一、如何存档邮件到本地:<br>
                                                           <small>①手动存档<br /><br /></small>
                                                        </h4>
                                                        <img class="img" src="../imgs/notauto.jpg" style="width:60%;height: auto;"/>
                                                        <h4 style="color: Red;font-weight:900;">
                                    
                                                           <small>②自动存档<br /><br /></small>
                                                        </h4>
                                                        <img class="img" src="../imgs/auto.jpg" style="width:60%;height: auto;"/>
                                                    </div>
\t\t\t\t\t\t\t\t\t\t\t\t\t<div class="tim-typo">
                                                        <h4 style="color: Red;font-weight:900;">
                                                            二、邮件重发发送，把下列的选项不要打勾<br />
                                                        </h4>
                                                        <img class="img" src="../imgs/quetion6.jpg" style="width:60%;height: auto;"/>
                                                    </div>
                                                    <div class="tim-typo">
                                                        <h4 style="color: Red;font-weight:900;">
                                                            二、如何打开本地outlook文件:
                                                        </h4>
                                                        <img class="img" src="../imgs/openfile.jpg" style="width:60%;height: auto;"/>
                                                    </div>

                                                    <div class="tim-typo">
                                                        <h4 style="color: Red;font-weight:900;">
                                                            三、收到 B mail，没有提示输入密码，只有乱码；发送mail的时候，没有B、C mail的按钮，解决方法：<br>
                                                            <small>①点击outlook"文件"->"文件"->"速度慢且已禁用的COM加载项"<br /><br />②找到“PGP Mail Encryption”，点击“始终启用此加载项”</small>
                                                        </h4>
                                                        <img class="img" src="../imgs/quetion2.jpg" style="width:60%;height: auto;"/>
                                                        <br />
                                                        <br />
                                                        <h4 style="color: Red;font-weight:900;">
                                                            <small>③如还是没有B、C mail的按钮，请按以下方法解决：<br /><br />
                                                            “文件”-〉“选项”-〉“加载项”-〉“转到”-〉勾选“PGP Mail Encryption”-〉确定-〉即可。
                                                            <br /></small>
                                                        </h4>
                                                        
                                                        <img class="img" src="../imgs/3_1.jpg" style="width:60%;height: auto;"/>
                                                        <img class="img" src="../imgs/3_2.jpg" style="width:60%;height: auto;"/>
                                                        <img class="img" src="../imgs/3_3.jpg" style="width:60%;height: auto;"/>
                                                    </div>
\t\t\t\t\t\t\t\t\t\t\t\t\t<!-- end -->

                                                    <div class="tim-typo">
                                                        <h4 style="color: Red;font-weight:900;">
                                                            四、进入outlook webmail的方法：<br>
                                                            <small>①chrome中输入"f10outlook/"<br /><br />
                                                                ②点击：“进入WebMail"<br /><br />
                                                                ③输入账号：tsmcsh\\+NT账号，例如：tsmcsh\\qqshia，密码是NT密码
                                                            </small>
                                                        </h4>
                                                        <img class="img" src="../imgs/quetion3.jpg" style="width:60%;height: auto;"/>
                                                    </div>
                                                    <div class="tim-typo">
                                                        <h4 style="color: Red;font-weight:900;">
                                                            五、收件人收到的mail格式与编辑的格式不一致<br>
                                                            <small>①新建邮件默认格式设置为RTF："文件"->"选项"->"邮件"->"使用此格式撰写邮件"改为RTF格式<br />
                                                            
                                                            <br />
                                                                ②回复邮件，注意邮件上方会显示格式，改为RTF<br /><br />
                                                                
                                                            </small>
                                                            <img class="img" src="../imgs/quetion4.jpg" style="width:40%;height: auto;"/>
                                                            <img class="img" src="../imgs/quetion5.jpg" style="width:40%;height: auto;"/>
                                                        </h4>
                                                    </div>
                                                    <div class="tim-typo">
                                                        <h4 style="color:Red;font-weight:900;">
                                                            六、outlook无法启动问题尝试修复方法<br />
                                                            <small>
                                                            一、尝试修改配置文件<br /><br />
                                                                ①尝试删除邮件配置文件<br /><br />
                                                            
                                                            <img class="img" src="../imgs/0.jpg" style="width:40%;height: auto;"/><br />
                                                            <br />
                                                             ②尝试重新加载个人配置文件：开始->运行（或者按"Win+R"）-〉输入命令"outlook /importprf.\\.prf"->点击回车键<br /><br />
                                                                ③尝试安全模式下启动：开始->运行（或者按"Win+R"）-〉输入命令"outlook /safe"->点击回车键<br /><br />
                                                            </small>
                                                           <small>
                                                           二、尝试修复inbox文件<br /><br />
                                                           工具：D\\Program Files(x86)\\Microsoft Office\\Office16\\SCANPST.EXE<br /><br />
                                                           </small>
                                                           <img class="img" src="../imgs/1.jpg" style="width:40%;height: auto;" />
                                                           <img class="img" src="../imgs/2.jpg" style="width:40%;height: auto;" />
                                                           <img class="img" src="../imgs/3.jpg" style="width:40%;height: auto;" /><br /><br />
                                                           <small>
                                                           三、所有尝试都无法修复User问题，重置个人电脑profile解决问题（请helpdesk同事处理）:<br /><br />
                                                           ①先备份D盘用户帐号下的（桌面，收藏夹和我的文档）3个文件夹<br /><br />
                                                           ②再备份C盘用户帐号下的chrome收藏夹，然后切换管理员帐号，计算机属性中删除用户配置文件，然后确认C:\\user下没有用户帐号（如有就删除），D:\\user下把用户帐号改为NT_BAK<br /><br />
                                                           ③注销请用户再次登陆获取新的配置文件，把刚才备份的资料还原到原路径
                                                           </small>
                                                        </h4>
                                                    </div>
\t\t\t\t\t\t\t\t\t\t\t\t\t<div class="tim-typo">
                                                        <h4 style="color: Red;font-weight:900;">
                                                            七、Outlook无法连接服务器：如下图Outlook图标出现黄色感叹号<br />
                                                            <img class="img" src="../imgs/quetion7.jpg" style="width:60%;height: auto;"/>
                                                            <small><br /><br />①检查网络正常，确认其他网站，例如mycn和lycn都可以正常使用；<br /><br />点击电脑的"开始"->"运行"<br /><br />②输入"outlook /importprf .\\.prf"</small>
                                                        </h4>
                                                        <img class="img" src="../imgs/quetion1.jpg" style="width:60%;height: auto;"/>
                                                    </div>
                                                </div>
                                            </div>
                                        </div>`,
    name: {title: 'Mr', first: 'Maurice', last: 'Smith'},
    nat: 'IE',
  },
  {
    email: 'maurice.smith@example.com',
    gender: 'male',

    name: {title: 'Mr', first: 'Maurice', last: 'Smith'},
    nat: 'IE',
  }
];
let res = {
  results: [{
    id: '2',
    title: '如何存档邮件到本地',
    brief: '这是一篇Outlook教程，教你如何玩转存档',
    name: {title: 'Mrs', first: 'Brooke', last: 'Ferguson'},
    email: 'brooke.ferguson@example.com',
    nat: 'GB'
  }, {
    id: '1',
    title: '如何Debug IDEA',
    brief: '这是一篇IDEA教程，教你如何玩转IDEA',
    name: {title: 'Mr', first: 'Kurt', last: 'Simpson'},
    email: 'kurt.simpson@example.com',
    nat: 'AU'
  }, {
    id: '3',
    title: '【求助】怎样才能快速完成工作',
    brief: '各位有没有时间管理的好办法？？？？？',
    name: {title: 'Ms', first: 'Sofia', last: 'Christensen'},
    email: 'sofia.christensen@example.com',
    nat: 'DK'
  }
  ]
};
export const LIST = {
  '/caseList': res
};
