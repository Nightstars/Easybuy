package com.teamone.easybuy.dao;

import com.teamone.easybuy.entities.OrderDetail;
import com.teamone.easybuy.entities.OrderList;
import com.teamone.easybuy.util.C3p0Util;
import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanHandler;

import java.sql.SQLException;
import java.util.Date;

public class OrderDao {
    QueryRunner queryRunner = new QueryRunner(C3p0Util.dataSource);
    public int insertOrderListAndOrderDetail(OrderList orderList, OrderDetail orderDetail) throws SQLException {
        String sql="insert orderList(orderId,userId,orderCreateDate) values(?,?,?)";
        int row1=queryRunner.update(sql,orderList.getOrderId(),orderList.getUserId(),new Date());
        sql="select * from orderList where id=(select max(id) from orderList)";
        OrderList orderList1=queryRunner.query(sql,new BeanHandler<OrderList>(OrderList.class));
        sql="insert orderDetail(goodsId,goodsNum,goodsPrice,orderId) values(?,?,?,?)";
        int row2=queryRunner.update(sql,orderDetail.getGoodsId(),orderDetail.getGoodsNum(),orderDetail.getGoodsPrice(),orderList1.getId());
        if(row1>0&&row2>0){
            return 1;
        }else {
            return 0;
        }
    }
}
