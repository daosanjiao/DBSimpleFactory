package org.example.SimpleFactoryImpl;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class OracleConnection implements RDBConnection{
    @Override
    public Connection getConnection(String url,String username,String pwd) throws ClassNotFoundException, SQLException {
        Class.forName("oracle.jdbc.driver.OracleDriver");
        Connection conn = DriverManager.getConnection(url,username,pwd);
        System.out.println("成功获取Oracle连接！");
        return conn;
    }
}
