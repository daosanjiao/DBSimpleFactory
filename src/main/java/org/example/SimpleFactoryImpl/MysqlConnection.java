package org.example.SimpleFactoryImpl;

import java.sql.*;

public class MysqlConnection implements RDBConnection{

    private static final String URL_SUFFIX = "?characterEncoding=utf8&useSSL=false&serverTimezone=GMT%2B8&allowPublicKeyRetrieval=true";

    @Override
    public Connection getConnection(String url,String username,String pwd) throws ClassNotFoundException, SQLException {
        Class.forName("com.mysql.jdbc.Driver");
        String fullUrl = url+URL_SUFFIX;
        Connection conn = DriverManager.getConnection(fullUrl,username,pwd);
        System.out.println("成功获取Mysql连接！");
        return conn;
    }
}
