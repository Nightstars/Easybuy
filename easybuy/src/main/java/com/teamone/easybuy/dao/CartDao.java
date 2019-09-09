package com.teamone.easybuy.dao;

import com.teamone.easybuy.entities.Cart;
import com.teamone.easybuy.entities.Cart_Goods;
import com.teamone.easybuy.util.C3p0Util;
import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanHandler;
import org.apache.commons.dbutils.handlers.BeanListHandler;

import java.sql.SQLException;
import java.util.List;

public class CartDao {
    QueryRunner queryRunner = new QueryRunner(C3p0Util.dataSource);
    public int insertCart(Cart cart) throws SQLException {
        String sql="insert cart(goodsId,goodsNum,userId) values(?,?,?)";
        return queryRunner.update(sql,cart.getGoodsId(),cart.getGoodsNum(),cart.getUserId());
    }
    public List<Cart_Goods> selectAllCartByUserId(int id) throws SQLException {
        String sql="select t1.name,t1.price,t2.goodsNum,t1.imgurl from goods t1,cart t2 where t2.goodsId=t1.id and t2.userId=?";
        return queryRunner.query(sql, new BeanListHandler<Cart_Goods>(Cart_Goods.class),id);
    }
}
