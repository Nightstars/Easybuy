package com.teamone.easybuy.dao;

import com.teamone.easybuy.entities.Type;
import com.teamone.easybuy.entities.User;
import com.teamone.easybuy.util.C3p0Util;
import org.apache.commons.codec.digest.DigestUtils;
import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanHandler;
import org.apache.commons.dbutils.handlers.BeanListHandler;

import java.sql.SQLException;
import java.util.List;

public class EasybuyDao {
    QueryRunner queryRunner = new QueryRunner(C3p0Util.dataSource);
    public User selectUserByNameAndPwd(String name, String password) throws SQLException {
        String sql = "select * from user where username=? and password=?";
       User user=queryRunner.query(sql,new BeanHandler<User>(User.class),name,password);
        //String sql = "select * from user";
        //List<User> users = queryRunner.query(sql,new BeanListHandler<>(User.class));
        //System.out.println(users);
        return user;
    }

    public int insertUser(User user) throws SQLException {
        String sql = "insert user(username,realname,password,sex,birthday,personId,email,phone,address) values(?,?,?,?,?,?,?,?,?)";
        Object[] parms={user.getUsername(),user.getRealname(),DigestUtils.sha256Hex(user.getPassword()),user.getSex(),user.getBirthday(),user.getPsersonId(),user.getEmail(),user.getPhone(),user.getAddress()};
        int row=queryRunner.update(sql,parms);
        return row;
    }

    public List<Type> selectParentType() throws SQLException {
        String sql = "select * from type where pid is null";
        List<Type> parTypeList=queryRunner.query(sql,new BeanListHandler<Type>(Type.class));
        return parTypeList;
    }

    public List<Type> selectChildType(int id) throws SQLException {
        String sql = "select * from type where pid=?";
        List<Type> childTypeList=queryRunner.query(sql,new BeanListHandler<Type>(Type.class),id);
        return childTypeList;
    }

}
