package com.atguigu.servlet;

import javax.servlet.*;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/setMsg")
public class SetMsgServlet extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        this.doGet(req, resp);
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        System.out.println("访问到SetMsgServlet的doGet方法...");
        //往应用域设置共享数据
        //1.获取ServletContext应用域对象
        ServletContext servletContext = req.getServletContext();
        //2.设置共享数据
        servletContext.setAttribute("servletContextKey","servletContextValue");
    }


}
