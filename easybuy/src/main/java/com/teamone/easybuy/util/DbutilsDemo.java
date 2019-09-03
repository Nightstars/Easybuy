package com.teamone.easybuy.util;

import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanListHandler;

import java.sql.SQLException;
import java.util.List;

public class DbutilsDemo {
    public static void main(String[] args) throws SQLException {
        // QueryRunner
        QueryRunner queryRunner = new QueryRunner(C3p0Util.dataSource);
        //update:  insert update delete
        // String sql = "insert into users(name,age,pwd,birthday) values(?,?,?,?)";
        // queryRunner.update(sql,"jack",20,"123","1999-09-3");

        // 查询：根据id用户对象
        //        String sql = "select * from users where id=?";
        //        User user = queryRunner.query(sql,new BeanHandler<>(User.class),16);
        //        System.out.println(user);

        // 查询所有
        String sql = "select * from user";
        List<User> users = queryRunner.query(sql,new BeanListHandler<User>(User.class));
        System.out.println(users);
        //System.out.println("ok");

        //query:查询

    }
}
