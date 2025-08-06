package com.atguigu.servlet;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/thymeleafTest")
public class ThymeleafTestServlet extends ViewBaseServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doGet(request,response);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        System.out.println("访问到了ThymeleafTestServlet");
        String msg="用户名或密码错误";
        //1. 设置共享数据(请求域)
        request.setAttribute("msg",msg);
        //2. 进行转发操作(/views/admin.html)
        this.processTemplate("admin",request,response);
    }
}

