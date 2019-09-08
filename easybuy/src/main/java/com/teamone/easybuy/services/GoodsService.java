package com.teamone.easybuy.services;

import com.teamone.easybuy.dao.GoodsDao;
import com.teamone.easybuy.entities.Goods;

import java.sql.SQLException;
import java.util.List;

public class GoodsService {
    GoodsDao goodsDao=new GoodsDao();
    public boolean addGoods(Goods goods) throws SQLException {
        if(goodsDao.insertGoods(goods)>0){
            return true;
        }else {
            return false;
        }
    }
    public List<Goods> selectGoods() throws SQLException {
       return goodsDao.selectAllGoods();
    }
    public boolean deleteGoods(int id) throws SQLException {
        if(goodsDao.deleteGoodsByID(id)>0){
            return true;
        }else{
            return false;
        }
    }
}
