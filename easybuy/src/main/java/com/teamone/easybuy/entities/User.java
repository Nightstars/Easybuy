package com.teamone.easybuy.entities;

import java.util.Date;

public class User {
    private  int id;
    private String username;
    private String realname;
    private String password;
    private String sex;
    private Date birthday;
    private String psersonId;
    private String email;
    private String phone;
    private String address;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getRealname() {
        return realname;
    }

    public void setRealname(String realname) {
        this.realname = realname;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getSex() {
        return sex;
    }

    public void setSex(String sex) {
        this.sex = sex;
    }

    public Date getBirthday() {
        return birthday;
    }

    public void setBirthday(Date birthday) {
        this.birthday = birthday;
    }

    public String getPsersonId() {
        return psersonId;
    }

    public void setPsersonId(String psersonId) {
        this.psersonId = psersonId;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }
    public User(){

    }
    public User(String username, String realname, String password, String sex, Date birthday, String psersonId, String email, String phone, String address){
        this.username=username;
        this.realname=realname;
        this.password=password;
        this.sex=sex;
        this.birthday=birthday;
        this.psersonId=psersonId;
        this.email=email;
        this.phone=phone;
        this.address=address;
    }
    public User(int id, String username, String realname, String password, String sex, Date birthday, String psersonId, String email, String phone, String address){
        this.id=id;
        this.username=username;
        this.realname=realname;
        this.password=password;
        this.sex=sex;
        this.birthday=birthday;
        this.psersonId=psersonId;
        this.email=email;
        this.phone=phone;
        this.address=address;
    }

    @Override
    public String toString() {
        return "User{" +
                "id=" + id +
                ", username='" + username + '\'' +
                ", realname='" + realname + '\'' +
                ", password='" + password + '\'' +
                ", sex='" + sex + '\'' +
                ", birthday=" + birthday +
                ", psersonId='" + psersonId + '\'' +
                ", email='" + email + '\'' +
                ", phone='" + phone + '\'' +
                ", address='" + address + '\'' +
                '}'+"\n";
    }
}
