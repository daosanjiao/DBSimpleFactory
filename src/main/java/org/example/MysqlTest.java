package org.example;

import java.sql.Connection;

public class MysqlTest {

    public static Connection getMysqlConnection() throws ClassNotFoundException {
        Class.forName("com.mysql.jdbc.Driver");

        return null;
    }
}
