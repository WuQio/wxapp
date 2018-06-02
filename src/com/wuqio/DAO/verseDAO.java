package com.wuqio.DAO;


import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.sql.DataSource;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class verseDAO {
    public static String queryVerse() throws SQLException, ClassNotFoundException, NamingException {
//        Connection conn = MysqlConnFactory.getConn();
        Context ctx = new InitialContext();
        DataSource ds = (DataSource) ctx.lookup("java:comp/env/jdbc/lamp");
        Connection conn = ds.getConnection();
        String querySql = "SELECT verse from verse WHERE date=if((SELECT date from verse WHERE date=curdate())=NULL, subdate(curdate(), INTERVAL 1 DAY), curdate());";
        Statement statement = conn.createStatement();
        ResultSet rs = statement.executeQuery(querySql);
        rs.next();
        String verse = "";
        try{
            verse = rs.getString("verse");
        }catch (Exception e){
            e.printStackTrace();
            System.out.println("查询今天verse失败！！！");
        }
        rs.close();
        statement.close();
        return verse;
    }
}
