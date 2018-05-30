package com.wuqio.Factory;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class MysqlConnFactory {
    private static final String JDBC_DRIVER = "com.mysql.jdbc.Driver";
    private static final String DB_URL = "jdbc:mysql://wuqio.mixue.ink:3306/lamp";
    private static Connection conn;

    public static Connection getConn() throws ClassNotFoundException, SQLException {
        Class.forName(JDBC_DRIVER);
        if (conn==null){
            conn = DriverManager.getConnection(DB_URL, "mixue", "mixue");
        }
        return conn;
    }
}
