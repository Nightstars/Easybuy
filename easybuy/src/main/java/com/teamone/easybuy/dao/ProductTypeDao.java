package com.teamone.easybuy.dao;

import com.teamone.easybuy.entities.Type;
import com.teamone.easybuy.util.C3p0Util;
import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanHandler;

import java.sql.SQLException;

public class ProductTypeDao {
    QueryRunner queryRunner=new QueryRunner(C3p0Util.dataSource);
    public int insertProductParType(Type type) throws SQLException {
        String sql="insert type(name) values(?)";
        int row=queryRunner.update(sql,type.getName());
        return row;
    }
    public int insertProductChildType(Type type) throws SQLException {
        String sql="insert type(name,pid) values(?,?)";
        Object[] parms={type.getName(),type.getPid()};
        int row=queryRunner.update(sql,parms);
        return row;
    }
    public int updateProductParType(Type type) throws SQLException {
        String sql="update type set name=?,pid=? where id=?";
        Object[] parms={type.getName(),null,type.getId()};
        int row=queryRunner.update(sql,parms);
        return row;
    }
    public int updateProductChildType(Type type) throws SQLException {
        String sql="update type set name=?,pid=? where id=?";
        Object[] parms={type.getName(),type.getPid(),type.getId()};
        int row=queryRunner.update(sql,parms);
        return row;
    }
    public int deleteProductChildType(int id) throws SQLException {
        String sql="delete from type where id=?";
        int row=queryRunner.update(sql,id);
        return row;
    }
    public Type selectParentTyep(int id) throws SQLException {
        String sql = "select * from type where id=?";
        Type parentType=queryRunner.query(sql,new BeanHandler<Type>(Type.class),id);
        return parentType;
    }
    public int deleteProductParType(int id) throws SQLException {
        String sql="delete from type where id=?";
        int row=queryRunner.update(sql,id);
        return row;
    }
    public int deleteProductParChildType(int id) throws SQLException {
        String sql="delete from type where pid=?";
        int row=queryRunner.update(sql,id);
        return row;
    }
}
