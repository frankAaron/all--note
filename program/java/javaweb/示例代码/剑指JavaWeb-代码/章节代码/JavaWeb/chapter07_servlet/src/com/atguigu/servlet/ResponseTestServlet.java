package com.atguigu.servlet;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

public class ResponseTestServlet extends HttpServlet {


    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        System.out.println("访问到了ResponseTestServlet...");
        //设置响应头信息
        response.setHeader("Content-Type", "text/html;charset=UTF-8");

        //通过PrintWriter对象向浏览器端发送响应信息
        PrintWriter writer = response.getWriter();
        writer.write("Servlet response");
        //关闭输出流
        writer.close();


        //简写
       // response.setContentType("text/html;charset=UTF-8");


    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doGet(request, response);
    }
}
