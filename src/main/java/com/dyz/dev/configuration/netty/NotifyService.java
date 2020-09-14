package com.dyz.dev.configuration.netty;

import io.netty.channel.Channel;
import io.netty.handler.codec.http.websocketx.TextWebSocketFrame;
import io.netty.handler.codec.http.websocketx.WebSocketFrame;
import org.springframework.stereotype.Component;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

@Component
public class NotifyService {
  public void sendMsgToUser(String empno, String msg) {
    Channel channel = ChannelMap.channelMap.get(empno);
    if (channel == null) {
      return;
    }
    channel.writeAndFlush(new TextWebSocketFrame(msg));
  }

  // 需要{0} {1} 。。。 添加参数例如: template = "{0} 发送消息给{1}"
  public void sendMsgToUser(String empno, String template, String... args) {
    String regex = "\\{([^}]*)\\}";
    System.out.println(args[1]);
    Pattern pattern = Pattern.compile(regex);
    Matcher matcher = pattern.matcher(template);
    while (matcher.find()) {
      String replaceStr = matcher.group();
      int i = Integer.parseInt(matcher.group(1));
      template = template.replace(replaceStr, args[i]);
    }
    sendMsgToUser(empno, template);
  }
}
