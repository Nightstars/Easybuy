package com.teamone.easybuy.services;

import com.teamone.easybuy.dao.CartDao;
import com.teamone.easybuy.entities.Cart;
import com.teamone.easybuy.entities.Cart_Goods;

import java.sql.SQLException;
import java.util.List;

public class CartService {
    CartDao cartDao=new CartDao();
    public boolean addCart(Cart cart) throws SQLException {
        if(cartDao.insertCart(cart)>0){
            return true;
        }else{
            return false;
        }
    }
    public List<Cart_Goods> CartGoodsInfo(int id) throws SQLException {
        return  cartDao.selectAllCartByUserId(id);
    }
}
