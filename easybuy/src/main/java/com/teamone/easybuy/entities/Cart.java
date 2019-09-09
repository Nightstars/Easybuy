package com.teamone.easybuy.entities;

public class Cart {
    private int id;
    private int goodsId;
    private int goodsNum;
    private int UserId;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getGoodsId() {
        return goodsId;
    }

    public void setGoodsId(int goodsId) {
        this.goodsId = goodsId;
    }

    public int getGoodsNum() {
        return goodsNum;
    }

    public void setGoodsNum(int goodsNum) {
        this.goodsNum = goodsNum;
    }

    public int getUserId() {
        return UserId;
    }

    public void setUserId(int userId) {
        UserId = userId;
    }
    public Cart(){

    }

    public Cart(int id, int goodsId, int goodsNum, int userId) {
        this.id = id;
        this.goodsId = goodsId;
        this.goodsNum = goodsNum;
        UserId = userId;
    }
}
