package com.atguigu.servlet;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

@WebServlet("/xmlHttpRequestTest")
public class XMLHttpRequestTestServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        System.out.println("访问到了AjaxTestServlet");
        String message = req.getParameter("message");
        System.out.println("message = "+ message);

        //响应数据：不能用重定向和转发（属于同步请求），采用输出流的方式
        PrintWriter writer = resp.getWriter();
        //谁发请求，数据就响应给谁（JS）
        writer.write("success");
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        doGet(req, resp);
    }
}
