package com.dyz.dev.configuration.netty;

import io.netty.bootstrap.ServerBootstrap;
import io.netty.channel.Channel;
import io.netty.channel.ChannelFuture;
import io.netty.channel.ChannelOption;
import io.netty.channel.EventLoopGroup;
import io.netty.channel.nio.NioEventLoopGroup;
import io.netty.channel.socket.nio.NioServerSocketChannel;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.scheduling.annotation.Async;
import org.springframework.scheduling.annotation.EnableAsync;
import org.springframework.stereotype.Component;

import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;


@Component
@Async
//public class NettyServer extends Thread implements CommandLineRunner  {
public class NettyServer extends Thread {
  public static Logger logger = LoggerFactory.getLogger(NettyServer.class.getName());

  @Autowired
  ServerChannelInitializer serverChannelInitializer;

  private void initNettyConfig() {
    EventLoopGroup bossGroup = new NioEventLoopGroup(); // (1)
    EventLoopGroup workerGroup = new NioEventLoopGroup();
    try {
      ServerBootstrap b = new ServerBootstrap(); // (2)
      b.group(bossGroup, workerGroup)
        .channel(NioServerSocketChannel.class) // (3)
        .childHandler(serverChannelInitializer)
        .option(ChannelOption.SO_BACKLOG, 128)          // (5)
        .childOption(ChannelOption.SO_KEEPALIVE, true); // (6)
      logger.info("==============netty start............=========================");
      // Bind and start to accept incoming connections.
      ChannelFuture f = b.bind(8088).sync(); // (7)

      // Wait until the service socket is closed.
      // In this example, this does not happen, but you can do that to gracefully
      // shut down your service.
      f.channel().closeFuture().sync();
    } catch (InterruptedException e) {
      e.printStackTrace();
    } finally {
      workerGroup.shutdownGracefully();
      bossGroup.shutdownGracefully();
    }
  }

  @Override
  public void run() {
    initNettyConfig();
  }

  public NettyServer() {

  }

  public void sendMessageToUser(String empno, String message) {
    Channel channel = ChannelMap.channelMap.get(empno);
    channel.writeAndFlush(message);
  }



  public void run(String... args) throws Exception {
    initNettyConfig();
//    Proxy
  }
  /**
   * 不能搜评论吗
   *
   * =========================================
   *
   * 你这个新消息提醒能不能直接定位到收到的新消息
   *
   * 现在还要找
   *
   * =========================================
   *
   * 把所有数据放到一个索引里！
   *
   *
   */
}
