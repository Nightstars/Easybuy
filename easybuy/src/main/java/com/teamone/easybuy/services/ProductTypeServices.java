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
    public boolean updateProductType(Type type) throws SQLException {
        if(type.getPid()==0){
            if(productTypeDao.updateProductParType(type)>0){
                return true;
            }else {
                return false;
            }
        }else {
            if(productTypeDao.updateProductChildType(type)>0){
                return true;
            }else {
                return false;
            }
        }
    }
    public boolean deleteProductType(int id,boolean isPar) throws SQLException {
        if(isPar){
                productTypeDao.deleteProductParChildType(id);
                if(productTypeDao.deleteProductParType(id)>0){
                    return true;
                }else {
                    return false;
                }
        }else {
            System.out.println("child");
            if(productTypeDao.deleteProductChildType(id)>0){
                return true;
            }else {
                return false;
            }
        }
    }
}
