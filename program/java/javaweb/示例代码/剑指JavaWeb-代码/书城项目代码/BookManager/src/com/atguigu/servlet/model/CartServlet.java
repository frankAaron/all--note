package com.atguigu.servlet.model;

import com.atguigu.bean.Book;
import com.atguigu.bean.Cart;
import com.atguigu.bean.CartItem;
import com.atguigu.bean.CommonResult;
import com.atguigu.service.BookService;
import com.atguigu.service.impl.BookServiceImpl;
import com.atguigu.servlet.base.ViewBaseServlet;
import com.google.gson.Gson;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

@WebServlet("/cart")
public class CartServlet extends ViewBaseServlet {
    private BookService bookService=new BookServiceImpl();

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        this.doPost(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String method = request.getParameter("method");
        if(method.equals("addCart")){
            addCart(request,response);
        }else if(method.equals("toCartPage")){
            toCartPage(request,response);
        }else if(method.equals("showCart")){
            showCart(request,response);
        }else if(method.equals("addCount")){
            addCount(request,response);
        }else if(method.equals("subCount")){
            subCount(request,response);
        }else if(method.equals("changeCount")){
            changeCount(request,response);
        }else if(method.equals("clearCart")){
            clearCart(request,response);
        }else if(method.equals("deleteCartItem")){
            deleteCartItem(request,response);
        }
    }


    protected void addCart(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        //1. 获取到书的id值
        String id = request.getParameter("id");
        System.out.println("id = " + id);//知道用户点的是哪本书了
        //2. 调用业务层根据id查到书的信息(book就是我们要添加到购物车内的书)
        Book book = bookService.getById(Integer.parseInt(id));
        //3. 判断此次加入购物车是第几次点的？(从session域内判断是否存在Cart对象)

        HttpSession session = request.getSession();
        Cart cart=(Cart)session.getAttribute("cart");//key暂时写cart
        if(cart==null){
            //说明第一次点击加入购物车
            cart=new Cart();
            session.setAttribute("cart",cart);
        }

        //4. 将书的信息，添加到购物车
        cart.addCart(book);
        //5. 给响应
        //除了ok之外，还需要将购物车的总数量响应回去
        Integer totalCount = cart.getTotalCount();
        CommonResult commonResult = CommonResult.ok().setResultData(totalCount);
        String s = new Gson().toJson(commonResult);
        System.out.println("s = " + s);//{flag:true,resultData:num}
        response.getWriter().write(s);
    }


    protected void toCartPage(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        processTemplate("cart/cart",request,response);
    }


    protected void showCart(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        //1. 将购物车所需要的数据获取到
        HttpSession session = request.getSession();
        Cart cart = (Cart)session.getAttribute("cart");

        responseData(cart,request,response);
    }


    protected void clearCart(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.getSession().removeAttribute("cart");
        CommonResult ok = CommonResult.ok();
        String s = new Gson().toJson(ok);
        response.getWriter().write(s);
    }


    protected void deleteCartItem(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        //获得到请求参数
        String id = request.getParameter("id");
        HttpSession session = request.getSession();
        //获得到购物车对象
        Cart cart = (Cart) session.getAttribute("cart");
        //删除购物项
        cart.deleteCartItem(Integer.parseInt(id));

        if(cart.getTotalCount()==0){
            session.removeAttribute("cart");
        }
        //删完之后，该怎么办？
        responseData(cart,request,response);

    }

    protected void responseData(Cart cart,HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        Integer totalCount=0;
        Double totalAmount=0D;
        Collection<CartItem> cartItems=new ArrayList<>();
        if(cart!=null){
            totalCount=cart.getTotalCount();
            totalAmount=cart.getTotalAmount();
            cartItems=cart.getCartItems();
        }
        //2. 将数据响应给js

        List cartAll=new ArrayList();//[totalCount,totalAmount,[{},{},{}...]]
        cartAll.add(totalCount);
        cartAll.add(totalAmount);
        cartAll.add(cartItems);

        CommonResult commonResult = CommonResult.ok().setResultData(cartAll);
        //{flag:true,resultData:[totalCount,totalAmount,[{},{},{}...]]}

        String s = new Gson().toJson(commonResult);

        response.getWriter().write(s);
    }


    protected void addCount(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String id = request.getParameter("id");

        HttpSession session = request.getSession();
        Cart cart = (Cart)session.getAttribute("cart");

        cart.addCount(Integer.parseInt(id));

        responseData(cart,request,response);
    }

    protected void subCount(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String id = request.getParameter("id");

        HttpSession session = request.getSession();
        Cart cart = (Cart)session.getAttribute("cart");
        cart.subCount(Integer.parseInt(id));
        responseData(cart,request,response);
    }


    protected void changeCount(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String id = request.getParameter("id");
        String count = request.getParameter("count");

        HttpSession session = request.getSession();
        Cart cart = (Cart)session.getAttribute("cart");

        cart.changeCount(Integer.parseInt(id),Integer.parseInt(count));

        responseData(cart,request,response);
    }

}
