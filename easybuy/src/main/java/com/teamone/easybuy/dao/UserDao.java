package com.teamone.easybuy.dao;

import com.teamone.easybuy.entities.User;
import com.teamone.easybuy.util.C3p0Util;
import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanListHandler;

import java.sql.SQLException;
import java.util.List;

public class UserDao {
    QueryRunner queryRunner = new QueryRunner(C3p0Util.dataSource);
    public List<User> userList() throws SQLException {
        String sql = "select * from user";
        List<User> userlist = queryRunner.query(sql,new BeanListHandler<>(User.class));
        return userlist;
    }
}
