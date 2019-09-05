package com.teamone.easybuy.services;

import com.teamone.easybuy.dao.ProductTypeDao;
import com.teamone.easybuy.entities.Type;

import java.sql.SQLException;

public class ProductTypeServices {
    ProductTypeDao productTypeDao=new ProductTypeDao();
    public boolean addParProductName(Type type) throws SQLException {
        if(productTypeDao.insertProductParType(type)>0){
            return true;
        }else {
            return false;
        }
    }
    public boolean addChildProductName(Type type) throws SQLException {
        if(productTypeDao.insertProductChildType(type)>0){
            return true;
        }else {
            return false;
        }
    }
}
