package com.teamone.easybuy.entities;

public class Goods {
    private int id;
    private String name;
    private String detail;
    private  double price;
    private  int goodsNum;
    private  String imgurl;
    private  int typeId;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDetail() {
        return detail;
    }

    public void setDetail(String detail) {
        this.detail = detail;
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

    public int getTypeId() {
        return typeId;
    }

    public void setTypeId(int typeId) {
        this.typeId = typeId;
    }
    public Goods(){

    }

    public Goods(String name, String detail, double price, int goodsNum, String imgurl, int typeId) {
        this.name = name;
        this.detail = detail;
        this.price = price;
        this.goodsNum = goodsNum;
        this.imgurl = imgurl;
        this.typeId = typeId;
    }

    public Goods(int id, String name, String detail, double price, int goodsNum, String imgurl, int typeId) {
        this.id = id;
        this.name = name;
        this.detail = detail;
        this.price = price;
        this.goodsNum = goodsNum;
        this.imgurl = imgurl;
        this.typeId = typeId;
    }

    @Override
    public String toString() {
        return "Goods{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", detail='" + detail + '\'' +
                ", price=" + price +
                ", goodsNum=" + goodsNum +
                ", imgurl='" + imgurl + '\'' +
                ", typeId=" + typeId +
                '}';
    }
}
