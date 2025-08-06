package com.atguigu.bean;

import java.math.BigDecimal;
import java.util.*;

/**
 * 购物车  (存储在session内)
 *  加入购物车的需求
 *      第一次点击加入购物车(无论是哪本书)
 *          新建一个Cart对象，新建一个CartItem对象，将CartItem对象添加到Cart对象的集合内
 *      第二次点击加入购物车(和第一次不是同一本书)
 *          获取到上次新建的Cart对象，新建一个CartItem对象，将CartItem对象添加到Cart对象的集合内
 *       第二次点击加入购物车(和第一次是同一本书)
 *          获取到上次新建的Cart对象，获取到上次新建的CartItem对象，将CartItem对象的count自增1
 *  如何获取上次新建的Cart对象？
 *      根据key值，从session会话域内获取即可！
 *  如何获取上次新建的CartItem对象？
 *      从Cart对象内获取到存储CartItem的集合，判断是否有重复的
 *
 */
public class Cart {
    private Integer totalCount;//总数量
    private Double totalAmount;//总金额
    //将书的id值设置Map集合的key
    private Map<Integer,CartItem> cartItemMap=new HashMap<>();//存储很多个购物项 ★

    //加入购物车
    public void addCart(Book book){
        //1. 判断这本书是否是第一次添加？(判断cartItemMap中是否有这本书)
        CartItem cartItem = cartItemMap.get(book.getBookId());
        if(cartItem==null){
            //说明这本书之前没有添加过购物车
            CartItem cartItem1=new CartItem(book,1);
            cartItemMap.put(book.getBookId(),cartItem1);
        }else{
            //说明这本书之前添加过
            cartItem.setCount(cartItem.getCount()+1);
        }
        System.out.println(cartItemMap);//纯粹是为了看Map集合内的东西
    }

    public Integer getTotalCount(){
        //计算总数量
        Collection<CartItem> values =  getCartItems();
        Integer totalCount=0;
        for (CartItem value : values) {
            totalCount += value.getCount();
        }
        this.totalCount=totalCount;
        return this.totalCount;
    }

    public Double getTotalAmount(){
        Collection<CartItem> values = getCartItems();
        BigDecimal b1=new BigDecimal("0");
        for (CartItem value : values) {
            BigDecimal b2=new BigDecimal(value.getAmount()+"");
            b1=b1.add(b2);
        }
        this.totalAmount=b1.doubleValue();
        return this.totalAmount;
    }

    public Collection<CartItem> getCartItems(){
        return cartItemMap.values();
    }

    //删除购物项
    public void deleteCartItem(Integer id){
        cartItemMap.remove(id);
    }

    //数量加1
    public void addCount(Integer id){
        CartItem cartItem = cartItemMap.get(id);
        cartItem.setCount(cartItem.getCount()+1);
    }

    public void subCount(Integer id){
        CartItem cartItem = cartItemMap.get(id);
        if(cartItem.getCount()==1){
            cartItemMap.remove(id);
        }else{
            cartItem.setCount(cartItem.getCount()-1);
        }
    }

    public void changeCount(Integer id,Integer count){
        CartItem cartItem = cartItemMap.get(id);
        cartItem.setCount(count);
    }

}
