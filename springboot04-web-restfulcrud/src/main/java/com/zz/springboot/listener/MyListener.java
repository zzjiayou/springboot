package com.zz.springboot.listener;

import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;

public class MyListener implements ServletContextListener {
    @Override
    public void contextInitialized(ServletContextEvent sce) {
        System.out.println("servletContext初始化...");
    }

    @Override
    public void contextDestroyed(ServletContextEvent sce) {

    }
}
