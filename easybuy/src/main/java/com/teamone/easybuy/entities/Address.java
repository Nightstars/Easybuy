package com.teamone.easybuy.entities;

public class Address {
    private int id;
    private String name;
    private int userIId;

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

    public int getUserIId() {
        return userIId;
    }

    public void setUserIId(int userIId) {
        this.userIId = userIId;
    }
    public Address(){

    }
    public Address(int id, String name, int userIId) {
        this.id = id;
        this.name = name;
        this.userIId = userIId;
    }

    @Override
    public String toString() {
        return "Address{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", userIId=" + userIId +
                '}';
    }
}
