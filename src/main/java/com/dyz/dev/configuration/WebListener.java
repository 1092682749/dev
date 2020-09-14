package com.dyz.dev.configuration;

import org.springframework.scheduling.annotation.Async;

import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;

@Async
@javax.servlet.annotation.WebListener
public class WebListener implements ServletContextListener {
    @Override
    public void contextInitialized(ServletContextEvent servletContextEvent) {
        System.out.println("asd");

    }

    @Override
    public void contextDestroyed(ServletContextEvent servletContextEvent) {

    }
}
