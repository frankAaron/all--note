package com.atguigu.service.impl;

import com.atguigu.bean.*;
import com.atguigu.dao.BookDao;
import com.atguigu.dao.OrderDao;
import com.atguigu.dao.OrderItemDao;
import com.atguigu.dao.impl.BookDaoImpl;
import com.atguigu.dao.impl.OrderDaoImpl;
import com.atguigu.dao.impl.OrderItemDaoImpl;
import com.atguigu.service.OrderService;
import com.sun.org.apache.xpath.internal.operations.Or;

import java.text.SimpleDateFormat;
import java.util.Collection;
import java.util.Date;
import java.util.List;

/**
 * @Author chenxin
 * @date 2022/10/26
 * @Version 1.0
 */
public class OrderServiceImpl implements OrderService {

    private OrderDao orderDao=new OrderDaoImpl();
    private OrderItemDao orderItemDao=new OrderItemDaoImpl();
    private BookDao bookDao=new BookDaoImpl();

    @Override
    public String checkout(Cart cart, User user) {
        //1. 新增订单记录
        //1.1 准备订单数据
        String orderSequence="atguigu"+System.currentTimeMillis();
        SimpleDateFormat sdf=new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        String date = sdf.format(new Date());
        Order order=new Order(null,orderSequence,date,cart.getTotalCount(),cart.getTotalAmount(),0,user.getId());
        //1.2 进行订单的新增操作
        orderDao.insert(order);
        //2. 新增订单项记录
        //2.1 获取到刚刚新增订单的id值
        Integer orderId = orderDao.getId(orderSequence);
        //2.2 获取到所有的购物项
        Collection<CartItem> cartItems = cart.getCartItems();
        for (CartItem cartItem : cartItems) {
            //2.3 准备订单项的数据
            OrderItem orderItem=new OrderItem(
                    null,
                    cartItem.getBook().getBookName(),
                    cartItem.getBook().getPrice(),
                    cartItem.getBook().getImgPath(),
                    cartItem.getCount(),
                    cartItem.getAmount(),
                    orderId);
            //2.4 调用dao层进行数据的新增
            orderItemDao.insert(orderItem);
            //3. 修改图书的库存和销量
            Book book = cartItem.getBook();
            book.setStock(book.getStock()-cartItem.getCount());
            book.setSales(book.getSales()+cartItem.getCount());

            bookDao.update(book);
        }
        return orderSequence;

        /*try{
            开启事务/提交方式设置为手动

            放对数据库的所有操作

            事务的提交
        }catch (Exception e){
            事务的回滚
        }*/
    }

    @Override
    public List<Order> showOrder(Integer userId) {
        return orderDao.findOrderByUserId(userId);
    }
}
