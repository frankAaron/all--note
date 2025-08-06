package com.atguigu.servlet;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/servletDemo01")
public class ServletDemo01 extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doGet(request, response);
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        //1. 创建一个cookie对象，用于存放键值对
        Cookie cookie = new Cookie("cookie-message","hello-cookie");

        //2. 将cookie添加到response中
        //底层是通过一个名为"Set-Cookie"的响应头携带到浏览器的
        response.addCookie(cookie);
/*
        //1. 创建一个cookie对象，用于存放键值对
        Cookie cookie1 = new Cookie("cookie-message1","hello-cookie1");
        //2. 设置cookie的有效时间和path属性
        cookie.setMaxAge(100);
        cookie.setPath("/web/ServletDemo");
        //3. 将cookie添加到response中
        response.addCookie(cookie1);
        */
    }
}
