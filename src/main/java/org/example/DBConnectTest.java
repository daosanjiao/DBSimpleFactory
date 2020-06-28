package org.example;

import org.example.SimpleFactoryImpl.RDBConnectionFactory;

import java.sql.*;

public class DBConnectTest {

    public static void main(String args[]){
        try {
            query(RDBConnectionFactory.createConnction("jdbc:mysql://172.0.0.1:3306/test","test","test"));
            //query(RDBConnectionFactory.createConnction("jdbc:oracle:thin:@127.0.0.1:1521:orcl","test","test"));
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
    }
    public static void query(Connection conn) throws SQLException, ClassNotFoundException {
        PreparedStatement pps = conn.prepareStatement("SELECT * FROM TEST_USER");
        ResultSet resultSet = pps.executeQuery();
        ResultSetMetaData resultSetMetaData = resultSet.getMetaData();
        int column = resultSetMetaData.getColumnCount();
        while (resultSet.next()) {
            for (int i = 1; i <= column; i++) {
                System.out.print(resultSet.getObject(i) + "\t");
            }
            System.out.println();
        }
        resultSet.close();
        pps.close();
        conn.close();
    }

    public static Connection getMysqlConnection() throws ClassNotFoundException, SQLException {
        Class.forName("com.mysql.jdbc.Driver");
        String url = "jdbc:mysql://172.0.0.1:3306/test?characterEncoding=utf8&useSSL=false&serverTimezone=GMT%2B8&allowPublicKeyRetrieval=true";
        String user =  "test";
        String pwd = "test";
        Connection conn = DriverManager.getConnection(url,user,pwd);
        System.out.println("成功获取Mysql连接！");
        return conn;
    }

    public static Connection getOracleConnection() throws ClassNotFoundException, SQLException {
        Class.forName("oracle.jdbc.driver.OracleDriver");
        String url ="jdbc:oracle:thin:@127.0.0.1:1521:orcl";
        String user = "test";
        String pwd = "test";
        Connection conn = DriverManager.getConnection(url,user,pwd);
        System.out.println("成功获取Oracle连接！");
        return conn;
    }


    public static void query() throws SQLException, ClassNotFoundException {
        Connection conn = DBConnectTest.getMysqlConnection();
        PreparedStatement pps = conn.prepareStatement("SELECT * FROM TEST_USER");
        ResultSet resultSet = pps.executeQuery();
        ResultSetMetaData resultSetMetaData = resultSet.getMetaData();
        int column = resultSetMetaData.getColumnCount();
        while (resultSet.next()) {
            for (int i = 1; i <= column; i++) {
                System.out.print(resultSet.getObject(i) + "\t");
            }
            System.out.println();
        }
        resultSet.close();
        pps.close();
        conn.close();
    }
}
