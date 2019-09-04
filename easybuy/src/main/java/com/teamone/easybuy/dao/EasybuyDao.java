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

    public static void main(String[] args) throws SQLException {
        EasybuyDao easybuyDao=new EasybuyDao();
        //EasybuyServices easybuyServices=new EasybuyServices();
        //User user=easybuyDao.selectUserByNameAndPwd("Jack","123456");
        //boolean islogin=easybuyServices.login("Jack","123456");
       // System.out.println(islogin);
//        MessageDigest md = MessageDigest.getInstance("SHA");
//        String s = new String(md.digest("i123love".getBytes()));
//        String s1 = new String(md.digest("123love".getBytes()));
//        System.out.println(s.equals(s1));

            /*String str = DigestUtils.md5Hex("123客戶");
            String str1 = DigestUtils.md5Hex("123客户");
            System.out.println(str.length());
            System.out.println("str="+str+","+(str.equals(str1)));
            String str2 = DigestUtils.sha256Hex("123客户");
            String str4 = DigestUtils.sha256Hex("123客户");
            System.out.println("str2="+str2+","+(str2.equals(str4)));
            System.out.println(str2.length()+","+(str.equals(str2)));*/
            List<Type> list=easybuyDao.selectChildType(4);
            System.out.println(list);

    }
}
