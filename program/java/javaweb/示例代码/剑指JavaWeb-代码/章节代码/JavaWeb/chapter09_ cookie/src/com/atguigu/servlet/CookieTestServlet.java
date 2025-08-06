package com.atguigu.servlet;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/cookieTestServlet")
public class CookieTestServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        //1. 新建Cookie对象
        Cookie cookie=new Cookie("username","xiaoShang");
        //2. 设置cookie对象的有效期
        cookie.setMaxAge(60);//单位是秒
        //3. 将cookie对象添加到response内
        response.addCookie(cookie);
        //4. 给出响应内容
        response.getWriter().write("success");
    }
}
