package com.teamone.easybuy.util;

import com.mchange.v2.c3p0.ComboPooledDataSource;

import javax.sql.DataSource;
import java.sql.Connection;
import java.sql.SQLException;

public class C3p0Util {
    public static DataSource dataSource = new ComboPooledDataSource();

    public static Connection getDBConnection() throws SQLException {
        return dataSource.getConnection();
    }
}
