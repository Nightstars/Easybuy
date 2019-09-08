package com.teamone.easybuy.util;

import com.teamone.easybuy.dao.UserDao;
import com.teamone.easybuy.entities.User;
import com.teamone.easybuy.services.UserService;

import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class Test {
    public static void main(String[] args) throws SQLException {
        System.out.println(new SimpleDateFormat("yyyyMMddHHmmss").format(new Date())+System.currentTimeMillis());
        UserDao userDao=new UserDao();
        User user=userDao.getIdByNameAndPassword("test","test");
        System.out.println(user);
        UserService userService=new UserService();
        int id=userService.getUserId("test","test");
        System.out.println(id);
    }
}
