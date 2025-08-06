package com.atguigu.servlet.model;

import com.atguigu.bean.User;
import com.atguigu.service.UserService;
import com.atguigu.service.impl.UserServiceImpl;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;

@WebServlet("/checkPhone")
public class ServletCheckPhone extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doPost(request,response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        //获取手机号
        String phone = request.getParameter("phone");
        //校验手机号是否存在
        UserService userService=new UserServiceImpl();
        User user = userService.checkUsername(phone);
        //给响应
        if(user==null){
            response.getWriter().write("ok");
        }else{
            response.getWriter().write("no");
        }
    }
}
