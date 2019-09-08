package com.teamone.easybuy.services;

import com.teamone.easybuy.dao.OrderDao;
import com.teamone.easybuy.entities.OrderDetail;
import com.teamone.easybuy.entities.OrderList;

import java.sql.SQLException;

public class OrderService {
    OrderDao orderDao=new OrderDao();
    public boolean createOrder(OrderList orderList, OrderDetail orderDetail) throws SQLException {
        if(orderDao.insertOrderListAndOrderDetail(orderList,orderDetail)>0){
            return true;
        }else{
            return false;
        }
    }
}
