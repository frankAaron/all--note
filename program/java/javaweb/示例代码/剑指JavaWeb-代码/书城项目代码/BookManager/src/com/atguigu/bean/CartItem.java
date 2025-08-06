package com.atguigu.bean;

import java.math.BigDecimal;

/**
 * 购物项
 *  购物车中一种商品的具体信息
 *  注意：对setBook/setCount/有参构造，添加了amount的计算代码
 */
public class CartItem {
    private Book book;//书的信息
    private Integer count;//数量
    private Double amount;//价格(书的单价和数量计算得到的结果)

    public CartItem() {
    }
    //计算金额(书的单价*数量)
    public void setAmount(){
        if(this.book!=null){
            BigDecimal b1=new BigDecimal(this.book.getPrice()+"");
            BigDecimal b2=new BigDecimal(this.count+"");
            this.amount= b1.multiply(b2).doubleValue();
        }

    }

    public CartItem(Book book, Integer count) {
        this.book = book;
        this.count = count;
        setAmount();
    }

    public Book getBook() {
        return book;
    }

    public void setBook(Book book) {
        this.book = book;
        setAmount();
    }

    public Integer getCount() {
        return count;
    }

    public void setCount(Integer count) {
        this.count = count;
        setAmount();
    }

    public Double getAmount() {
        return amount;
    }


    @Override
    public String toString() {
        return "CartItem{" +
                "book=" + book +
                ", count=" + count +
                ", amount=" + amount +
                '}';
    }
}
