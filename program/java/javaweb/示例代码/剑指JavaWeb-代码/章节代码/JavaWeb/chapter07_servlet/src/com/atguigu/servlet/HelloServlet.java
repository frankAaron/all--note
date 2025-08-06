package com.atguigu.servlet;

import javax.servlet.*;
import java.io.IOException;

/**
 * 编写Servlet的步骤:
 * 1. 编写一个类实现Servlet接口,并且实现里面的方法: 主要是要实现service方法
 * 2. 重写service方法,service方法中就是接收、处理请求，并且将信息响应给客户端
 * 3. 配置Servlet的映射路径(供客户端访问的路径):在web/WEB-INF/web.xml中配置
 */
public class HelloServlet implements Servlet {

    //构造器
    public HelloServlet(){
        System.out.println("HelloServlet对象被创建了...");
    }

    //初始化方法
    @Override
    public void init(ServletConfig servletConfig) throws ServletException {
        System.out.println("HelloServlet对象被初始化了...");
    }

    //处理请求以及给出响应
    @Override
    public void service(ServletRequest servletRequest,
                        ServletResponse servletResponse) throws ServletException, IOException {
        System.out.println("访问到了HelloServlet的service方法......");
        //输出响应数据到浏览器
        servletResponse.getWriter().write("Hello,I am Servlet");
    }

    //销毁方法
    @Override
    public void destroy() {
        System.out.println("HelloServlet对象被销毁了...");
    }

    //获得Servlet的配置
    @Override
    public ServletConfig getServletConfig() {
        return null;
    }

    // 获得Servlet的相关信息
    @Override
    public String getServletInfo() {
        return null;
    }


}
