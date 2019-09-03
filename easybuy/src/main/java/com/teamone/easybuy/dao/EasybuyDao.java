package com.teamone.easybuy.dao;

import com.teamone.easybuy.entities.User;
import com.teamone.easybuy.services.EasybuyServices;
import com.teamone.easybuy.util.C3p0Util;
import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanHandler;

import java.sql.SQLException;

public class EasybuyDao {
    QueryRunner queryRunner = new QueryRunner(C3p0Util.dataSource);
    public User selectUserByNameAndPwd(String name, String password) throws SQLException {
        String sql = "select * from user where username=? and password=?";
       User user=queryRunner.query(sql,new BeanHandler<>(User.class),name,password);
        //String sql = "select * from user";
        //List<User> users = queryRunner.query(sql,new BeanListHandler<>(User.class));
        //System.out.println(users);
        return user;
    }

    public int insertUser(User user) throws SQLException {
        String sql = "insert user(username,realname,password,sex,birthday,personId,email,phone,address) values(?,?,?,?,?,?,?,?,?)";
        Object[] parms={user.getUsername(),user.getRealname(),user.getPassword(),user.getSex(),user.getBirthday(),user.getPsersonId(),user.getEmail(),user.getPhone(),user.getAddress()};
        int row=queryRunner.update(sql,parms);
        return row;
    }

    public static void main(String[] args) throws SQLException {
        //EasybuyDao easybuyDao=new EasybuyDao();
        EasybuyServices easybuyServices=new EasybuyServices();
        //User user=easybuyDao.selectUserByNameAndPwd("Jack","123456");
        boolean islogin=easybuyServices.login("Jack","123456");
        System.out.println(islogin);
    }
}
