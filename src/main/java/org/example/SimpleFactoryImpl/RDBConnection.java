package org.example.SimpleFactoryImpl;

import java.sql.Connection;

public interface RDBConnection {
    Connection getConnection(String url,String username,String pwd) throws Exception;
}
