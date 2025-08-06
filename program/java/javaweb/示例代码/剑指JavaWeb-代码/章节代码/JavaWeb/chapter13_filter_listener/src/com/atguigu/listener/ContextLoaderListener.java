package com.atguigu.listener;

import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;

public class ContextLoaderListener implements ServletContextListener {

    @Override
    public void contextInitialized(ServletContextEvent servletContextEvent) {

        System.out.println("在服务器启动的时候，模拟创建SpringMVC的核心容器...");
    }

    @Override
    public void contextDestroyed(ServletContextEvent servletContextEvent) {

        System.out.println("在服务器关闭的时候，模拟销毁SpringMVC的核心容器...");
    }
}
