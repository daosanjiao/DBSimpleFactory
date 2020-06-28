package org.example.SimpleFactoryImpl;

import java.sql.Connection;
import java.sql.SQLException;

public class RDBConnectionFactory {

    public static Connection createConnction(String url,String username,String pwd) throws SQLException, ClassNotFoundException {
        String dbName = url.split(":")[1];
        switch (dbName){
            case "oracle":
                return new OracleConnection().getConnection(url, username, pwd);
            case "mysql":
                return new MysqlConnection().getConnection(url, username, pwd);
            default:
                return null;
        }
    }
}
