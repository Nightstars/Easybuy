package com.teamone.easybuy.dao;

import com.teamone.easybuy.entities.User;
import com.teamone.easybuy.util.C3p0Util;
import org.apache.commons.codec.digest.DigestUtils;
import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanHandler;
import org.apache.commons.dbutils.handlers.BeanListHandler;

import java.sql.SQLException;
import java.util.List;

public class UserDao {
    QueryRunner queryRunner = new QueryRunner(C3p0Util.dataSource);
    public List<User> userList() throws SQLException {
        String sql = "select * from user";
        List<User> userlist = queryRunner.query(sql,new BeanListHandler<User>(User.class));
        return userlist;
    }
    public int deleteUserByID(int id) throws SQLException {
        String sql = "delete from user where id=?";
        return queryRunner.update(sql,id);
    }
    public User getUserByID(int id) throws SQLException {
        String sql = "select * from user where id=?";
        return queryRunner.query(sql,new BeanHandler<User>(User.class),id);
    }
    public int updateUser(User user) throws SQLException {
        String sql = "update user set username=?,realname=?,password=?,sex=?,birthday=?,phone=?,address=?  where id=?";
        Object[] parms={user.getUsername(),user.getRealname(), DigestUtils.sha256Hex(user.getPassword()),user.getSex(),user.getBirthday(),user.getPhone(),user.getAddress(),user.getId()};
        return queryRunner.update(sql,parms);
    }
}
