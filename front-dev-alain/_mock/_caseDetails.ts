import {MockRequest} from "@delon/mock";

const CASEList = [
  {
  id: '2',
  title: '如何存档邮件到本地',
  brief: '这是一篇Outlook教程，教你如何玩转存档',
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
},
  {
    id: '1',
    title: '如何Debug IDEA',
    brief: '如何Debug IDEA',
    content:
      ` <div id="cnblogs_post_description" style="display: none">
        一、Debug开篇 二、基本用法&快捷键 三、变量查看 四、计算表达式  五、智能步入  六、断点条件设置  七、多线程调试  八、回退断点  九、中断Debug  十、附：JRebel激活
    </div>
<div id="cnblogs_post_body" class="blogpost-body ">
    <p>　　Debug用来追踪代码的运行流程，通常在程序运行过程中出现异常，启用Debug模式可以分析定位异常发生的位置，以及在运行过程中参数的变化。通常我们也可以启用Debug模式来跟踪代码的运行流程去学习三方框架的源码。</p>
<p>　　所以学习下如何在Intellij IDEA中使用好Debug，主要包括如下内容：</p>
<p>　　　　一、Debug开篇</p>
<p>　　　　二、基本用法&amp;快捷键</p>
<p>　　　　三、变量查看</p>
<p>　　　　四、计算表达式</p>
<p>　　　　五、智能步入</p>
<p>　　　　六、断点条件设置</p>
<p>　　　　七、多线程调试</p>
<p>　　　　八、回退断点</p>
<p>　　　　九、中断Debug</p>
<p>　　　　十、附：JRebel激活</p>
<p>&nbsp;</p>
<h2>一、Debug开篇</h2>
<p>　　首先看下IDEA中Debug模式下的界面。</p>
<p>　　如下是在IDEA中启动Debug模式，进入断点后的界面，我这里是Windows，可能和Mac的图标等会有些不一样。就简单说下图中标注的8个地方：</p>
<p>　　① 以Debug模式启动服务，左边的一个按钮则是以Run模式启动。在开发中，我一般会直接启动Debug模式，方便随时调试代码。</p>
<p>　　② 断点：在左边行号栏单击左键，或者快捷键Ctrl+F8 打上/取消断点，断点行的颜色可自己去设置。</p>
<p>　　③ Debug窗口：访问请求到达第一个断点后，会自动激活Debug窗口。如果没有自动激活，可以去设置里设置，如图1.2。</p>
<p>　　④ 调试按钮：一共有8个按钮，调试的主要功能就对应着这几个按钮，鼠标悬停在按钮上可以查看对应的快捷键。在菜单栏Run里可以找到同样的对应的功能，如图1.4。</p>
<p>　　⑤ 服务按钮：可以在这里关闭/启动服务，设置断点等。</p>
<p>　　⑥ 方法调用栈：这里显示了该线程调试所经过的所有方法，勾选右上角的[Show All Frames]按钮，就不会显示其它类库的方法了，否则这里会有一大堆的方法。</p>
<p>　　⑦ Variables：在变量区可以查看当前断点之前的当前方法内的变量。</p>
<p>　　⑧ Watches：查看变量，可以将Variables区中的变量拖到Watches中查看&nbsp;</p>
<p>　　[图1.1]</p>
<p>　　<img src="https://images2017.cnblogs.com/blog/856154/201709/856154-20170905221418147-1205043020.png" alt="" width="1001" height="542" /></p>
<p>&nbsp;　　[图1.2]：在设置里勾选Show debug window on breakpoint，则请求进入到断点后自动激活Debug窗口</p>
<p>　　<img src="https://images2017.cnblogs.com/blog/856154/201709/856154-20170905111655647-1134637623.png" alt="" width="1031" height="601" /></p>
<p>　　[图1.3]：如果你的IDEA底部没有显示工具栏或状态栏，可以在View里打开，显示出工具栏会方便我们使用。可以自己去尝试下这四个选项。</p>
<p>　　<img src="https://images2017.cnblogs.com/blog/856154/201709/856154-20170905112617351-1554043487.png" alt="" width="613" height="606" /></p>
<p>　　[图1.4]：在菜单栏Run里有调试对应的功能，同时可以查看对应的快捷键。</p>
<p>　　<img src="https://images2017.cnblogs.com/blog/856154/201709/856154-20170905124338444-556465721.png" alt="" width="1070" height="607" /></p>
<p>&nbsp;</p>
<h2>二、基本用法&amp;快捷键</h2>
<p>Debug调试的功能主要对应着图一中4和5两组按钮：</p>
<p>　　1、首先说第一组按钮，共8个按钮，从左到右依次如下：</p>
<p>　　　　<img src="https://images2017.cnblogs.com/blog/856154/201709/856154-20170905134837851-1615718043.png" alt="" />&nbsp;[图2.1]</p>
<p>　　　　&gt; Show Execution Point (Alt + F10)：如果你的光标在其它行或其它页面，点击这个按钮可跳转到当前代码执行的行。</p>
<p>　　　　&gt; Step Over (F8)：步过，一行一行地往下走，如果这一行上有方法不会进入方法。</p>
<p>　　　　&gt; Step Into (F7)：步入，如果当前行有方法，可以进入方法内部，一般用于进入自定义方法内，不会进入官方类库的方法，如第25行的put方法。</p>
<p>　　　　&gt; Force Step Into (Alt + Shift + F7)：强制步入，能进入任何方法，查看底层源码的时候可以用这个进入官方类库的方法。</p>
<p>　　　　&gt; Step Out (Shift + F8)：步出，从步入的方法内退出到方法调用处，此时方法已执行完毕，只是还没有完成赋值。</p>
<p>　　　　&gt; Drop Frame (默认无)：回退断点，后面章节详细说明。</p>
<p>　　　　&gt; Run to Cursor (Alt + F9)：运行到光标处，你可以将光标定位到你需要查看的那一行，然后使用这个功能，代码会运行至光标行，而不需要打断点。</p>
<p>　　　　&gt; Evaluate Expression (Alt + F8)：计算表达式，后面章节详细说明。</p>
<p>　　2、第二组按钮，共7个按钮，从上到下依次如下：</p>
<p>&nbsp;　　　　<img src="https://images2017.cnblogs.com/blog/856154/201709/856154-20170905134011101-1824595229.png" alt="" />&nbsp;[图2.2]</p>
<p>　　　　&gt; Rerun 'xxxx'：重新运行程序，会关闭服务后重新启动程序。</p>
<p>　　　　&gt; Update 'tech' application (Ctrl + F5)：更新程序，一般在你的代码有改动后可执行这个功能。而这个功能对应的操作则是在服务配置里，如图2.3。</p>
<p>　　　　&gt; Resume Program (F9)：恢复程序，比如，你在第20行和25行有两个断点，当前运行至第20行，按F9，则运行到下一个断点(即第25行)，再按F9，则运行完整个流程，因为后面已经没有断点了。</p>
<p>　　　　&gt; Pause Program：暂停程序，启用Debug。目前没发现具体用法。</p>
<p>　　　　&gt; Stop 'xxx' (Ctrl + F2)：连续按两下，关闭程序。有时候你会发现关闭服务再启动时，报端口被占用，这是因为没完全关闭服务的原因，你就需要查杀所有JVM进程了。</p>
<p>　　　　&gt; View Breakpoints (Ctrl + Shift + F8)：查看所有断点，后面章节会涉及到。</p>
<p>　　　　&gt; Mute Breakpoints：哑的断点，选择这个后，所有断点变为灰色，断点失效，按F9则可以直接运行完程序。再次点击，断点变为红色，有效。如果只想使某一个断点失效，可以在断点上右键取消Enabled，如图2.4，则该行断点失效。</p>
<p>　　　　 [图2.3]：更新程序，On 'Update' actions，执行更新操作时所做的事情，一般选择'Update classes and resources'，即更新类和资源文件。</p>
<p>　　　　　　　一般配合热部署插件会更好用，如JRebel，这样就不用每次更改代码后还要去重新启动服务。如何激活JRebel，在最后章节附上。</p>
<p>　　　　　　　下面的On frame deactivation，在IDEA窗口失去焦点时触发，即一般你从idea切换到浏览器的时候，idea会自动帮你做的事情，一般可以设置Do nothing，频繁切换会比较消耗资源的。</p>
<p>&nbsp;　　 　&nbsp;&nbsp;<img src="https://images2017.cnblogs.com/blog/856154/201709/856154-20170905143932694-500925087.png" alt="" width="1051" height="620" /></p>
<p>　　　　[图2.4]</p>
<p>　　　　<img src="https://images2017.cnblogs.com/blog/856154/201709/856154-20170905193821194-225518192.png" alt="" /></p>
<p>&nbsp;</p>
<h2>三、变量查看</h2>
<p>在Debug过程中，跟踪查看变量的变化是非常必要的，这里就简单说下IDEA中可以查看变量的几个地方，相信大部分人都了解。</p>
<p>　　1、如下，在IDEA中，参数所在行后面会显示当前变量的值。</p>
<p>　　<img src="https://images2017.cnblogs.com/blog/856154/201709/856154-20170905154209179-9123997.png" alt="" width="797" height="416" />&nbsp;[图3.1]</p>
<p>　　2、光标悬停到参数上，显示当前变量信息。点击打开详情如图3.3。我一般会使用这种方式，快捷方便。</p>
<p>　　<img src="https://images2017.cnblogs.com/blog/856154/201709/856154-20170905154425772-770303651.png" alt="" width="578" height="172" />&nbsp;[图3.2]</p>
<p>　　<img src="https://images2017.cnblogs.com/blog/856154/201709/856154-20170905154724866-160919363.png" alt="" width="750" height="260" />&nbsp;[图3.3]</p>
<p>　　3、在Variables里查看，这里显示当前方法里的所有变量。</p>
<p>&nbsp;　　<img src="https://images2017.cnblogs.com/blog/856154/201709/856154-20170905155339491-1166069157.png" alt="" />&nbsp;[图3.4]</p>
<p>　　4、在Watches里，点击New Watch，输入需要查看的变量。或者可以从Variables里拖到Watche里查看。</p>
<p>　　<img src="https://images2017.cnblogs.com/blog/856154/201709/856154-20170905160057038-750351531.png" alt="" />&nbsp;[图3.5]</p>
<p>　　如果你发现你没有Watches，可能在下图所在的地方。</p>
<p>　　<img src="https://images2017.cnblogs.com/blog/856154/201709/856154-20170905160433710-2004658473.png" alt="" width="389" height="215" />&nbsp;[图3.6]&nbsp;&nbsp;</p>
<p>　&nbsp;&nbsp;&nbsp;<img src="https://images2017.cnblogs.com/blog/856154/201709/856154-20170905160515538-1647769062.png" alt="" width="844" height="213" />&nbsp;[图3.7]</p>
<p>&nbsp;</p>
<h2>四、计算表达式</h2>
<p>　　在前面提到的计算表达式如图4.1的按钮，Evaluate Expression (Alt + F8) 。可以使用这个操作在调试过程中计算某个表达式的值，而不用再去打印信息。</p>
<p>　　<img src="https://images2017.cnblogs.com/blog/856154/201709/856154-20170905160826444-1625048711.png" alt="" />&nbsp;[图4.1]</p>
<p>　　1、按Alt + F8或按钮，或者，你可以选中某个表达式再Alt + F8，弹出计算表达式的窗口，如下，回车或点击Evaluate计算表达式的值。</p>
<p>　　　&nbsp; 这个表达式不仅可以是一般变量或参数，也可以是方法，当你的一行代码中调用了几个方法时，就可以通过这种方式查看查看某个方法的返回值。</p>
<p>　　<img src="https://images2017.cnblogs.com/blog/856154/201709/856154-20170905161614694-93470669.png" alt="" width="972" height="512" />&nbsp;[图4.2]</p>
<p>　　2、设置变量，在计算表达式的框里，可以改变变量的值，这样有时候就能很方便我们去调试各种值的情况了不是。</p>
<p>　　<img src="https://images2017.cnblogs.com/blog/856154/201709/856154-20170905162404288-824548249.png" alt="" width="994" height="439" />&nbsp;[图4.3]</p>
<p>&nbsp;</p>
<h2>五、智能步入</h2>
<p>　　想想，一行代码里有好几个方法，怎么只选择某一个方法进入。之前提到过使用Step Into (Alt + F7) 或者 Force Step Into (Alt + Shift + F7)进入到方法内部，但这两个操作会根据方法调用顺序依次进入，这比较麻烦。</p>
<p>　　那么智能步入就很方便了，智能步入，这个功能在Run里可以看到，Smart Step Into (Shift + F7)，如图5.1</p>
<p>　　<img src="https://images2017.cnblogs.com/blog/856154/201709/856154-20170905152523304-803289488.png" alt="" />&nbsp;[图5.1]</p>
<p>　　按Shift + F7，会自动定位到当前断点行，并列出需要进入的方法，如图5.2，点击方法进入方法内部。</p>
<p>　　如果只有一个方法，则直接进入，类似Force Step Into。</p>
<p>　　<img src="https://images2017.cnblogs.com/blog/856154/201709/856154-20170905163730929-1374653206.png" alt="" width="735" height="206" />&nbsp;[图5.2]</p>
<p>&nbsp;</p>
<h2>六、断点条件设置</h2>
<p>　　通过设置断点条件，在满足条件时，才停在断点处，否则直接运行。</p>
<p>　　通常，当我们在遍历一个比较大的集合或数组时，在循环内设置了一个断点，难道我们要一个一个去看变量的值？那肯定很累，说不定你还错过这个值得重新来一次。</p>
<p>　　1、在断点上右键直接设置当前断点的条件，如图6.1，我设置exist为true时断点才生效。</p>
<p>　　<img src="https://images2017.cnblogs.com/blog/856154/201709/856154-20170905165253944-1162138475.png" alt="" />&nbsp;&nbsp;[图6.1]</p>
<p>　　2、点击View Breakpoints (Ctrl + Shift + F8)，查看所有断点。</p>
<p>　　　　Java Line Breakpoints 显示了所有的断点，在右边勾选Condition，设置断点的条件。</p>
<p>　　　　勾选Log message to console，则会将当前断点行输出到控制台，如图6.3</p>
<p>　　　　勾选Evaluate and log，可以在执行这行代码是计算表达式的值，并将结果输出到控制台。</p>
<p>　　&nbsp;[图6.2]</p>
<p>　　<img src="https://images2017.cnblogs.com/blog/856154/201709/856154-20170905170655163-1805982960.png" alt="" width="1068" height="579" /></p>
<p>　　 [图6.3]</p>
<p>　　<img src="https://images2017.cnblogs.com/blog/856154/201709/856154-20170905170947257-1667065155.png" alt="" /></p>
<p>　　3、再说说右边的Filters过滤，这些一般情况下不常用，简单说下意思。</p>
<p>　　　　Instance filters：实例过滤，输入实例ID(如图6.5中的实例ID)，但是我这里没有成功，不知道什么原因，知道的朋友留个言。</p>
<p>　　　　Class filters：类过滤，根据类名过滤，同样没有成功....</p>
<p>　　　　Pass count：用于循环中，如果断点在循环中，可以设置该值，循环多少次后停在断点处，之后的循环都会停在断点处。</p>
<p>　　[图6.4]</p>
<p>　　<img src="https://images2017.cnblogs.com/blog/856154/201709/856154-20170905185247132-1922055922.png" alt="" />&nbsp;</p>
<p>　　 [图6.5]</p>
<p>　　<img src="https://images2017.cnblogs.com/blog/856154/201709/856154-20170905190253304-1057381593.png" alt="" /></p>
<p>　　4、异常断点，通过设置异常断点，在程序中出现需要拦截的异常时，会自动定位到异常行。</p>
<p>　　如图6.6，点击+号添加Java Exception Breakpoints，添加异常断点。然后输入需要断点的异常类，如图6.7，之后可以在Java Exception Breakpoints里看到添加的异常断点。</p>
<p>　　我这里添加了一个NullPointerException异常断点，如图6.8，出现空指针异常后，自动定位在空指针异常行。</p>
<p>&nbsp;　　[图6.6]</p>
<p>　　<img src="https://images2017.cnblogs.com/blog/856154/201709/856154-20170905200131851-150143203.png" alt="" /></p>
<p>　　[图6.7]</p>
<p>　　<img src="https://images2017.cnblogs.com/blog/856154/201709/856154-20170905200305147-527881101.png" alt="" width="912" height="557" />&nbsp;</p>
<p>　　[图6.8]</p>
<p>　　<img src="https://images2017.cnblogs.com/blog/856154/201709/856154-20170905200726069-688175303.png" alt="" width="937" height="358" />&nbsp;</p>
<p>&nbsp;</p>
<h2>七、多线程调试</h2>
<p>　　一般情况下我们调试的时候是在一个线程中的，一步一步往下走。但有时候你会发现在Debug的时候，想发起另外一个请求都无法进行了？</p>
<p>　　那是因为IDEA在Debug时默认阻塞级别是ALL，会阻塞其它线程，只有在当前调试线程走完时才会走其它线程。可以在View Breakpoints里选择Thread，如图7.1，然后点击Make Default设置为默认选项。</p>
<p>　　[图7.1]</p>
<p>　　<img src="https://images2017.cnblogs.com/blog/856154/201709/856154-20170905204329757-1196950664.png" alt="" width="1062" height="313" />&nbsp;</p>
<p>　　切换线程，在图7.2中Frames的下拉列表里，可以切换当前的线程，如下我这里有两个Debug的线程，切换另外一个则进入另一个Debug的线程。</p>
<p>　　[图7.2]</p>
<p>　　<img src="https://images2017.cnblogs.com/blog/856154/201709/856154-20170905205012663-56609868.png" alt="" width="1051" height="568" />&nbsp;</p>
<p>&nbsp;</p>
<h2>八、回退断点</h2>
<p>　　在调试的时候，想要重新走一下流程而不用再次发起一个请求？</p>
<p>　　1、首先认识下这个方法调用栈，如图8.1，首先请求进入DemoController的insertDemo方法，然后调用insert方法，其它的invoke我们且先不管，最上面的方法是当前断点所在的方法。</p>
<p>　　[图8.1]</p>
<p>　　<img src="https://images2017.cnblogs.com/blog/856154/201709/856154-20170905210917741-1095775464.png" alt="" width="1056" height="526" />&nbsp;</p>
<p>　　2、断点回退</p>
<p>　　所谓的断点回退，其实就是回退到上一个方法调用的开始处，在IDEA里测试无法一行一行地回退或回到到上一个断点处，而是回到上一个方法。</p>
<p>　　回退的方式有两种，一种是Drop Frame按钮(图8.2)，按调用的方法逐步回退，包括三方类库的其它方法(取消Show All Frames按钮会显示三方类库的方法，如图8.3)。</p>
<p>　　第二种方式，在调用栈方法上选择要回退的方法，右键选择Drop Frame(图8.4)，回退到该方法的上一个方法调用处，此时再按F9(Resume Program)，可以看到程序进入到该方法的断点处了。</p>
<p>　　但有一点需要注意，断点回退只能重新走一下流程，之前的某些参数/数据的状态已经改变了的是无法回退到之前的状态的，如对象、集合、更新了数据库数据等等。</p>
<p>　　图[8.2]</p>
<p>　　<img src="https://images2017.cnblogs.com/blog/856154/201709/856154-20170905211428554-1617570377.png" alt="" /></p>
<p>　　图[8.3]</p>
<p>　　<img src="https://images2017.cnblogs.com/blog/856154/201709/856154-20170905211723304-1223322879.png" alt="" /></p>
<p>　　图[8.4]</p>
<p>　　<img src="https://images2017.cnblogs.com/blog/856154/201709/856154-20170905212138101-113776159.png" alt="" /></p>
<p>&nbsp;</p>
<h2>九、中断Debug</h2>
<p>　　想要在Debug的时候，中断请求，不要再走剩余的流程了？</p>
<p>　　有些时候，我们看到传入的参数有误后，不想走后面的流程了，怎么中断这次请求呢(后面的流程要删除数据库数据呢....)，难道要关闭服务重新启动程序？嗯，我以前也是这么干的。</p>
<p>　　确切的说，我也没发现可以直接中断请求的方式(除了关闭服务)，但可以通过Force Return，即强制返回来避免后续的流程，如图9.1。</p>
<p>　　点击Force Return，弹出Return Value的窗口，我这个方法的返回类型为Map，所以，我这里直接返回 results，来强制返回，从而不再进行后续的流程。或者你可以new HashMap&lt;&gt;()。</p>
<p>　　[图9.1]</p>
<p>　　<img src="https://images2017.cnblogs.com/blog/856154/201709/856154-20170905213656241-1998475384.png" alt="" /></p>
<p>　　[图9.2]</p>
<p>　　<img src="https://images2017.cnblogs.com/blog/856154/201709/856154-20170905214031397-1943297392.png" alt="" width="911" height="517" /></p>
<p>&nbsp;</p>
<h2>十、附：JRebel激活</h2>
<p>　　目前本人一直使用JRebel做热部署工具，效果还算理想，修改Java代码或者xml等配置文件都能热更新。偶尔服务开久了，或更改的文件较多时，热更新没有生效，需要重新启动服务。</p>
<p>　　这里只是简单说下我在网上看到的一种免费获得永久使用权的方式(非破解)，不确定这种方式什么时候不能用。</p>
<p>　　① 首先你需要一个Facebook或Twitter的账号(最好Twitter)</p>
<p>　　② 进入这个网址：https://my.jrebel.com/，并登录，如图10.1</p>
<p>　　③ 然后在Install and Acticate里可以得到你的永久激活码。</p>
<p>　　④ 在设置里Jrebel里设置激活码，如图10.3，如果没有安装JRebel插件，先在Plugins里安装搜索安装JRebel插件。</p>
<p>　　[图10.1]</p>
<p>&nbsp;　　<img style="border: 1px solid black;" src="https://images2017.cnblogs.com/blog/856154/201709/856154-20170905215607882-171678285.png" alt="" /></p>
<p>　　[图10.2]</p>
<p>　　<img style="border: 1px solid black;" src="https://images2017.cnblogs.com/blog/856154/201709/856154-20170905215814194-779245117.png" alt="" /></p>
<p>　　[图10.3]</p>
<p>　　<img src="https://images2017.cnblogs.com/blog/856154/201709/856154-20170905220123351-598613604.png" alt="" width="1050" height="611" /></p>
<p>&nbsp;</p>
<p>&nbsp;</p>
<p>&nbsp;--------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------</p>
<p>有什么不妥之处或者更好的方式，欢迎留言！&nbsp;</p>
<p>完！！！</p>
<p>--------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------</p>
</div>`,
  }
];

function getDeatils(id) {

  return CASEList.filter(i => {
    console.log(id);
      return i.id == id;
  })[0]
}
export const DETAILS = {
  '/getDetails': (req: MockRequest) => {
    console.log(req)
    return getDeatils(req.queryString.id)}
}
