package com.dyz.dev.configuration.netty;


import com.dyz.dev.model.Employee;
import com.dyz.dev.service.EmployeeService;
import io.netty.buffer.ByteBuf;
import io.netty.buffer.Unpooled;
import io.netty.channel.*;
import io.netty.handler.codec.http.DefaultFullHttpResponse;
import io.netty.handler.codec.http.FullHttpRequest;
import io.netty.handler.codec.http.FullHttpResponse;
import io.netty.handler.codec.http.websocketx.*;
import io.netty.util.CharsetUtil;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import java.util.Map;
import java.util.Set;
import java.util.concurrent.ConcurrentHashMap;

import static io.netty.handler.codec.http.HttpHeaderNames.CONTENT_TYPE;
import static io.netty.handler.codec.http.HttpResponseStatus.OK;
import static io.netty.handler.codec.http.HttpVersion.HTTP_1_1;


@Component
@ChannelHandler.Sharable
public class NotifyHandler extends ChannelInboundHandlerAdapter {
  public static Logger logger = LoggerFactory.getLogger(NotifyHandler.class.getName());
  @Value("${ws.url}")
  String webSocketUrl;
  @Autowired
  EmployeeService employeeService;

  WebSocketServerHandshaker handshaker = null;

  @Override
  public void channelRegistered(ChannelHandlerContext ctx) throws Exception {
    logger.info("===================================一个链接注册进来: " + ctx.channel().remoteAddress());
    // ChannelMap.registerChannel("yzding", ctx.channel());
  }

  @Override
  public void channelRead(ChannelHandlerContext ctx, Object msg) throws Exception {

    if (msg instanceof FullHttpRequest) {
      // 处理http请求

      handleHttp(ctx, msg);
      return;
    } else if (msg instanceof WebSocketFrame) {
      // 处理websocket帧

      if (msg instanceof CloseWebSocketFrame) {
        handshaker.close(ctx.channel(), ((CloseWebSocketFrame) msg).retain());
        return;
      } else if (msg instanceof PingWebSocketFrame) {
        ctx.channel().write(new PongWebSocketFrame(((PingWebSocketFrame) msg).content().retain()));
      }
      WebSocketFrame webSocketFrameMsg = (WebSocketFrame) msg;
      System.out.println(webSocketFrameMsg.content());
      ctx.channel().writeAndFlush(new TextWebSocketFrame("收到了！"));
      // 从ChannelMap 里获取channel 并发送对应消息

    } else {
      ChannelFuture f = ctx.channel().writeAndFlush("该端口目前仅支持websocket协议\r\n");
      f.addListener(new ChannelFutureListener() {
        @Override
        public void operationComplete(ChannelFuture channelFuture) throws Exception {
          ctx.close();
        }
      });
    }
//    super.channelRead(ctx, msg);
  }


  @SuppressWarnings("Duplicates")
  public void handleHttp(ChannelHandlerContext ctx, Object msg) {
    FullHttpRequest request = (FullHttpRequest) msg;

    if (request.headers().get("Upgrade") != null) {
      if (request.headers().get("Upgrade").equals("websocket")) {
        String uri = request.retain().uri();
        String[] args = uri.split("=");
        WebSocketServerHandshakerFactory handshakerFactory = new WebSocketServerHandshakerFactory(webSocketUrl, null, true);
        handshaker = handshakerFactory.newHandshaker(request);
        handshaker.handshake(ctx.channel(), request);
        ChannelMap.registerChannel(args[1], ctx.channel());
      }
    } else {

      // 处理普通http请求
      FullHttpResponse response = new DefaultFullHttpResponse(HTTP_1_1, OK);
      response.headers().set(CONTENT_TYPE, "application/json; charset=UTF-8");
      StringBuilder bufRespose = new StringBuilder();
      bufRespose.append("该端口目前仅支持websocket协议\r\n");
      ByteBuf buffer = Unpooled.copiedBuffer(bufRespose, CharsetUtil.UTF_8);
      response.content().writeBytes(buffer);
      ChannelFuture future = ctx.channel().writeAndFlush(response);
      future.addListener(new ChannelFutureListener() {
        @Override
        public void operationComplete(ChannelFuture channelFuture) throws Exception {
          ctx.close();
        }
      });
    }
  }

  @Override
  public void channelInactive(ChannelHandlerContext ctx) throws Exception {
    logger.info("=====================有一个链接被关闭");
    ConcurrentHashMap<String, Channel> channelMap = ChannelMap.channelMap;
    Set<Map.Entry<String, Channel>> set = channelMap.entrySet();
    for (Map.Entry entry : set) {
      Boolean isQ = ((Channel) entry.getValue()).id().asShortText().equals(ctx.channel().id().asShortText());
      System.out.println(isQ);
      if (isQ) {
        logger.info("=====================移除了一个web端channel");
        channelMap.remove(entry.getKey());
      }
    }
  }


}
