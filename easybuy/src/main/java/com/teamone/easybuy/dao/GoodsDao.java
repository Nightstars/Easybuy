package com.teamone.easybuy.dao;

import com.teamone.easybuy.entities.Goods;
import com.teamone.easybuy.util.C3p0Util;
import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanListHandler;

import java.sql.SQLException;
import java.util.List;

public class GoodsDao {
    QueryRunner queryRunner = new QueryRunner(C3p0Util.dataSource);
    public int insertGoods(Goods goods) throws SQLException {
        String sql="insert goods(name,detail,price,goodsNum,imgurl,typeId) values(?,?,?,?,?,?)";
        Object[] parms={goods.getName(),goods.getDetail(),goods.getPrice(),goods.getGoodsNum(),goods.getImgurl(),goods.getTypeId()};
        return queryRunner.update(sql,parms);
    }
    public List<Goods> selectAllGoods() throws SQLException {
        String sql="select * from goods";
        return queryRunner.query(sql, new BeanListHandler<Goods>(Goods.class));
    }
    public int deleteGoodsByID(int id) throws SQLException {
        String sql = "delete from goods where id=?";
        return queryRunner.update(sql,id);
    }
}
