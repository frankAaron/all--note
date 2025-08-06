package com.atguigu.servlet;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

@WebServlet("/chartSetTest")
public class CharSetTestServlet extends HttpServlet {

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String username = request.getParameter("username");
        System.out.println("username = " + username);

        //如果昵称输入的是中文，控制台输出就会有乱码现象
        String nickname = request.getParameter("nickname");
        System.out.println("nickname = " + nickname);

        response.setContentType("text/html;charset=UTF-8");

        //通过输出流将中文数据响应给浏览器
        PrintWriter writer = response.getWriter();
        writer.write("做经得起时间检验的事情！");

    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        this.doPost(request,response);
    }

}
