package com.dyz.dev.configuration.netty;

import io.netty.channel.Channel;
import io.netty.handler.codec.http.websocketx.TextWebSocketFrame;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Component;


import java.util.Set;
import java.util.concurrent.ConcurrentHashMap;

public class ChannelMap {
  public static final Logger logger = LoggerFactory.getLogger(ChannelMap.class.getName());
  public static final ConcurrentHashMap<String, Channel> channelMap = new ConcurrentHashMap<>();
  public static final ConcurrentHashMap<String, StringBuilder> longFrameMap = new ConcurrentHashMap<>();

  public static void registerChannel(String registerUser, Channel channel) {

    Set<String> users = ChannelMap.channelMap.keySet();
    // 遍历所有已注册的channel
    for (String item : users) {
//            判断是否合一注册相同
      if (item.equals(registerUser)) {
        Channel removeChannel = channelMap.get(item);
        if (removeChannel.remoteAddress().equals(channel.remoteAddress())) {
          logger.info("equal对比" + removeChannel.equals(channel));

          logger.info("==对比：" + (removeChannel == channel));

          logger.info("hash对比：" + removeChannel + "###########" + channel);

          logger.info("id对比：" + removeChannel.id() + "############" + channel.id());

          logger.info("同一地址不执行移出" + removeChannel.remoteAddress() + "####" + channel.remoteAddress());
          return;
        }
//        removeChannel.writeAndFlush(new TextWebSocketFrame("移除channel"));
      }
    }
    channelMap.put(registerUser, channel);
  }
}
