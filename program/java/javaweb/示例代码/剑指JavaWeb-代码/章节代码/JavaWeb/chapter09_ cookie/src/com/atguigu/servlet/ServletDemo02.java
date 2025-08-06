package com.atguigu.servlet;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/servletDemo02")
public class ServletDemo02 extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doGet(request, response);
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        //1. 从请求中取出cookie
        //底层是由名为"Cookie"的请求头携带的
        Cookie[] cookies = request.getCookies();

        //2. 遍历出每一个cookie
        if (cookies != null) {
            for (Cookie cookie : cookies) {
                //匹配cookie的name
                if (cookie.getName().equals("cookie-message")) {
                    //它就是我们想要的那个cookie
                    //我们就获取它的value
                    String value = cookie.getValue();
                    System.out.println("在ServletDemo02中获取str的值为：" + value);
                }
            }
        }
       /* if (cookies != null) {
            for (Cookie cookie : cookies) {
                //匹配cookie的name
                if (cookie.getPath().equals("/web/ServletDemo")) {
                    //它就是我们想要的那个cookie
                    //我们就获取它的value
                    String value = cookie.getValue();
                    System.out.println("在ServletDemo02中获取str的值为：" + value);
                }
            }
        }*/
    }
}