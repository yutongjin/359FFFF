
package com.bookmarkers.DB.DatabaseConnection;
import java.sql.*;
//Return connection with database
//Singleton
public class DataBaseConnection {
    private static DataBaseConnection ourInstance = new DataBaseConnection();
    public static DataBaseConnection getInstance() {
        return ourInstance;
    }

    private DataBaseConnection() {
    }
    public Connection getDBConnection() {
        try {
            Class.forName("com.mysql.jdbc.Driver");//加载数据库驱动
            Connection connection = getConnection();
            if(connection != null) {
                System.out.println("DataBase loaded successfully!");
            }
            return connection;
        } catch (SQLException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();

        }
        System.out.println("DataBase load failed!");
        return null;
    }
    private static Connection getConnection() throws ClassNotFoundException, SQLException {
        String serverName = "localhost";
        String database = "cooper1";
        String url = "jdbc:mysql://localhost:3306/cooper1" ;

        // 数据配置用户和密码
        String user = "root";
        String password = "Jyt6554056!";

        return DriverManager.getConnection(url, user, password);
    }
}

