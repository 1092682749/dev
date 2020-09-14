package com.dyz.dev.configuration.netty;

import org.springframework.beans.factory.annotation.Autowired;

import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;
import javax.servlet.annotation.WebListener;


@WebListener
public class NettyServerListener implements ServletContextListener {
  @Autowired
  NettyServer nettyServer;
  @Override
  public void contextInitialized(ServletContextEvent servletContextEvent) {
//    System.out.println("aaaaaaa");
    nettyServer.start();
  }

  @Override
  public void contextDestroyed(ServletContextEvent servletContextEvent) {

  }
}
