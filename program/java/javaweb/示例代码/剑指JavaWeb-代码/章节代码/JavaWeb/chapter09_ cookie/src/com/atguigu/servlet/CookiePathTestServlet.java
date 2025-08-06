package com.atguigu.servlet;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/cookiePathTestServlet")
public class CookiePathTestServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        //1. 新建Cookie对象
        Cookie cookie=new Cookie("password","atguigu");
        //2. 设置有效路径
        cookie.setPath(request.getContextPath()+"/cookiePathTestServlet");
        //3. 将cookie对象添加到response
        response.addCookie(cookie);
        //4. 给出响应内容
        response.getWriter().write("success");
    }
}
