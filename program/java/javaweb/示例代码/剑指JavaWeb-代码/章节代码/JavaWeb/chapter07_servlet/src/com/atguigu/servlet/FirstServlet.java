package com.atguigu.servlet;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/first")
public class FirstServlet extends HttpServlet {


    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        System.out.println("访问到了FirstServlet...");

        //1.获取请求转发对象
        //RequestDispatcher dispatcher = request.getRequestDispatcher("second");
        //2.发起转发
        //dispatcher.forward(request, response);
        //或者以上两步合为一步
        /*
         * 转发到SecondServlet,getRequestDispatcher方法的实参,
         * 填写SecondServlet的映射路径
         */
        request.getRequestDispatcher("second").forward(request, response);



    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doGet(request,response);
    }
}
