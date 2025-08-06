package com.atguigu.filter;

import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import java.io.IOException;

//注意不要导错包
//@WebFilter(filterName="FirstFilter",urlPatterns={"/first"})
public class FirstFilter implements Filter {

    //1.创建对象
    public FirstFilter() {
        //System.out.println("FirstFilter对象被创建了...");
    }

    //2.对象初始化
    @Override
    public void init(FilterConfig filterConfig) throws ServletException {
        //System.out.println("FirstFilter对象被初始化了...");
    }

    //3.执行拦截过滤
    //过滤器核心方法，用于检查过滤
    /*
    * 参数
    * servletRequest请求
    * servletResponse响应
    * filterChain用于放行
    * */
    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {
        System.out.println("访问到了FirstFilter...");
        //放行（看检查结果）
        //原理：依次去寻找下一个过滤器，下一个没有过滤器了，就直接到目标Servlet
        filterChain.doFilter(servletRequest,servletResponse);

        //放行后的代码
        System.out.println("这是FirstFilter放行后的代码");
    }

    //4.销毁对象
    @Override
    public void destroy() {
        //System.out.println("FirstFilter对象被销毁了...");
    }
}
 