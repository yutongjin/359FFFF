
package com.bookmarkers.DB.DatabaseConnection;
import java.sql.*;
import org.sqlite.JDBC;

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
            Class.forName("org.sqlite.JDBC");//加载数据库驱动
            Connection connection = getConnection();
            System.out.println("zhe");
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
        String database = "main";
        String url = "jdbc:sqlite:identifier.sqlite" ;

        // 数据配置用户和密码
        String user = "root";
        String password = "jyt6554056!";


        Connection c = DriverManager.getConnection(url);
        System.out.println("sqlite 链接成功");

        return DriverManager.getConnection(url);

    }
}

