package com.teamone.easybuy.dao;

import com.teamone.easybuy.entities.Address;
import com.teamone.easybuy.entities.Goods;
import com.teamone.easybuy.util.C3p0Util;
import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanListHandler;

import java.sql.SQLException;
import java.util.List;

public class AddressDao {
    QueryRunner queryRunner = new QueryRunner(C3p0Util.dataSource);
    public int insertAddress(Address address) throws SQLException {
        String sql="insert address(name,userId) values(?,?)";
        Object[] parms={address.getName(),address.getUserIId()};
        return queryRunner.update(sql,parms);
    }
}
