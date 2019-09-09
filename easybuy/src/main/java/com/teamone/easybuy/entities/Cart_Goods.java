package com.teamone.easybuy.entities;

public class Cart_Goods {
    private String name;
    private  double price;
    private  int goodsNum;
    private  String imgurl;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public int getGoodsNum() {
        return goodsNum;
    }

    public void setGoodsNum(int goodsNum) {
        this.goodsNum = goodsNum;
    }

    public String getImgurl() {
        return imgurl;
    }

    public void setImgurl(String imgurl) {
        this.imgurl = imgurl;
    }
    public Cart_Goods(){

    }
    public Cart_Goods(String name, double price, int goodsNum, String imgurl) {
        this.name = name;
        this.price = price;
        this.goodsNum = goodsNum;
        this.imgurl = imgurl;
    }

    @Override
    public String toString() {
        return "Cart_Goods{" +
                "name='" + name + '\'' +
                ", price=" + price +
                ", goodsNum=" + goodsNum +
                ", imgurl='" + imgurl + '\'' +
                '}';
    }
}
