package com.atguigu.servlet;

import com.atguigu.bean.Fruit;
import com.atguigu.common.servlet.ViewBaseServlet;
import com.atguigu.service.FruitService;
import com.atguigu.service.impl.FruitServiceImpl;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/update")
public class UpdateServlet extends ViewBaseServlet {

    private FruitService fruitService=new FruitServiceImpl();

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        //1.设置编码
        request.setCharacterEncoding("utf-8");

        //2.获取参数
        String fidStr = request.getParameter("fid");
        Integer fid = Integer.parseInt(fidStr);
        String fname = request.getParameter("fname");
        String priceStr = request.getParameter("price");
        int price = Integer.parseInt(priceStr);
        String fcountStr = request.getParameter("fcount");
        Integer fcount = Integer.parseInt(fcountStr);
        String remark = request.getParameter("remark");

        //3.执行更新
        fruitService.updateFruit(new Fruit(fid,fname, price ,fcount ,remark ));

        //4.资源跳转
        response.sendRedirect("index.html");
    }
}