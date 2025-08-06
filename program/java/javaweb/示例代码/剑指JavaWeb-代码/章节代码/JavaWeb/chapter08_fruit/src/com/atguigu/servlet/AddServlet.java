package com.atguigu.servlet;

import com.atguigu.dao.FruitDAO;
import com.atguigu.dao.impl.FruitDAOImpl;
import com.atguigu.bean.Fruit;
import com.atguigu.common.servlet.ViewBaseServlet;
import com.atguigu.service.FruitService;
import com.atguigu.service.impl.FruitServiceImpl;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/add")
public class AddServlet extends ViewBaseServlet {

    private FruitService fruitService=new FruitServiceImpl();

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("UTF-8");

        String fname = request.getParameter("fname");
        Integer price = Integer.parseInt(request.getParameter("price")) ;
        Integer fcount = Integer.parseInt(request.getParameter("fcount"));
        String remark = request.getParameter("remark");

        Fruit fruit = new Fruit(0,fname , price , fcount , remark ) ;

        fruitService.addFruit(fruit);

        response.sendRedirect("index.html");

    }
}
