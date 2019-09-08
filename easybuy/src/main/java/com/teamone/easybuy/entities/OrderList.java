package com.teamone.easybuy.entities;

import java.util.Date;

public class OrderList {
    private  int id;
    private String orderId;
    private int userId;
    private Date orderCreateDate;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getOrderId() {
        return orderId;
    }

    public void setOrderId(String orderId) {
        this.orderId = orderId;
    }

    public int getUserId() {
        return userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }

    public Date getOrderCreateDate() {
        return orderCreateDate;
    }

    public void setOrderCreateDate(Date orderCreateDate) {
        this.orderCreateDate = orderCreateDate;
    }
    public OrderList(){

    }

    public OrderList(int id, String orderId, int userId, Date orderCreateDate) {
        this.id = id;
        this.orderId = orderId;
        this.userId = userId;
        this.orderCreateDate = orderCreateDate;
    }
}
