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
        String email = request.getParameter("phone");
        UserService userService=new UserServiceImpl();
        User user = userService.checkUsername(email);
        if(user==null){
            response.getWriter().write("ok");
        }else{
            response.getWriter().write("no");
        }
    }
}
