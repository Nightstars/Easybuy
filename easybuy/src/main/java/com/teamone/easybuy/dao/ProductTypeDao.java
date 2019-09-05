package com.teamone.easybuy.dao;

import com.teamone.easybuy.entities.Type;
import com.teamone.easybuy.util.C3p0Util;
import org.apache.commons.dbutils.QueryRunner;

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
}
