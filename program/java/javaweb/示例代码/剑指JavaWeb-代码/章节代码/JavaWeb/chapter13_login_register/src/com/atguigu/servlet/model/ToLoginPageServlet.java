package com.atguigu.servlet.model;

import com.atguigu.servlet.base.ViewBaseServlet;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;

@WebServlet(name = "ToLoginPageServlet", value = "/login.html")
public class ToLoginPageServlet extends ViewBaseServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doPost(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String username="";
        String password="";
        //记住用户名和密码
        Cookie[] cookies = request.getCookies();
        if(cookies!=null){
            for (Cookie cookie : cookies) {
                if(cookie.getName().equals("atguigu_phone")){
                    username=cookie.getValue();
                }
                if(cookie.getName().equals("atguigu_password")){
                    password=cookie.getValue();
                }
            }
        }
        request.setAttribute("atguigu_phone",username);
        request.setAttribute("atguigu_password",password);
        this.processTemplate("login",request,response);
    }
}
