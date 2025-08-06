package com.atguigu.servlet.model;

import com.atguigu.bean.Cart;
import com.atguigu.bean.Order;
import com.atguigu.bean.User;
import com.atguigu.service.OrderService;
import com.atguigu.service.impl.OrderServiceImpl;
import com.atguigu.servlet.base.ViewBaseServlet;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.util.List;

@WebServlet("/order")
public class OrderServlet extends ViewBaseServlet {
    private OrderService orderService=new OrderServiceImpl();

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        this.doPost(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String method = request.getParameter("method");
        if(method.equals("checkout")){
            checkout(request, response);
        }else if(method.equals("showOrder")){
            showOrder(request,response);
        }
    }


    protected void checkout(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        //处理结账的请求
        //1. 获取处理请求需要的相关数据
        //1.1 需要购物车的数据
        HttpSession session = request.getSession();
        Cart cart = (Cart) session.getAttribute("cart");
        //1.2 当前登录人的User对象
        User user=(User)session.getAttribute("user");
        //2. 调用业务层处理业务
        String sequence = orderService.checkout(cart, user);
        //2.1 清空购物车
        request.getSession().removeAttribute("cart");
        //3. 给响应
        request.setAttribute("sequence",sequence);
        processTemplate("cart/checkout",request,response);
    }

    protected void showOrder(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        //1. 获取到当前登录人的User对象
        HttpSession session = request.getSession();
        User user=(User)session.getAttribute("user");
        //2. 调用业务层处理业务
        List<Order> orders = orderService.showOrder(user.getId());
        //3. 给响应
        request.setAttribute("orders",orders);
        processTemplate("order/order",request,response);
    }

    }
