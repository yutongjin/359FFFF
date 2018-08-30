package com.bookmarkers.DB.DAO.Impl;

import com.bookmarkers.DB.DAO.AbstractDAO;
import com.bookmarkers.DB.DAO.UserDAO;

import java.sql.*;

/**
 * @Author : Yutong Jin
 * @date : 8/20/18
 * @Description :
 */
public class UserDAOImpl extends AbstractDAO implements UserDAO {
    public UserDAOImpl(Connection conn) {
        super(conn);

    }

    @Override
    public boolean canBook(String itemType,String userId) throws SQLException {
            String type = "";
        switch (itemType){
            case "Book" : type = "balanceBook";break;
            case "Magazine" : type = "balanceMagazine";break;
            default:type = "balanceVideo";
        }

        java.sql.Connection connection = this.conn;
        System.out.println(type);
        Statement statement = connection.createStatement();
        int balance = -1;
        // look up status
      //  System.out.println("UPDATE Item SET Booker ='" + userId + "' where Id = " );
      //String sql = "SELECT Active FROM Item where Id = " + itemId;
        String sql = "SELECT "+type +" FROM user where uId = '" + userId+"'";
        //System.out.println(sql);
        try (ResultSet resultSet = statement.executeQuery(sql)) {
            ResultSetMetaData metaData = resultSet.getMetaData();
            while (resultSet.next()) {
                String columnName = metaData.getColumnLabel(1);
                balance = resultSet.getInt(columnName);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        //end : look up status
        System.out.println(balance);
        return balance > 0;
    }

    @Override
    public void book(String itemType, String userId) {

        String type = "";
        switch (itemType){
            case "BookSet" : ;
            case "Book" : type = "balanceBook";break;
            case "Magazine" : type = "balanceMagazine";break;
            default:type = "balanceVideo";
        }
        System.out.println("booking");
        String sql2 = "UPDATE user SET " + type+" = " + type + "- 1  where uId = '" + userId+"'";
        try {
            java.sql.Connection connection = this.conn;
            Statement statement = connection.createStatement();
            statement.executeUpdate(sql2);

            //connection.close();
            if (connection.isClosed()) {
                System.out.println("Closed !");
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }

    }

    @Override
    public void returnItem(String userId,String itemType) {
        String type = "";
        switch (itemType){
            case "Book" : type = "balanceBook";break;
            case "Magazine" : type = "balanceMagazine";break;
            default:type = "balanceVideo";
        }
        System.out.println(type);
        String sql2 = "UPDATE user SET " + type+" = " + type + "+ 1  where uId = '" + userId+"'";
        try {
            java.sql.Connection connection = this.conn;
            Statement statement = connection.createStatement();
            System.out.println("added back");

            statement.executeUpdate(sql2);

            //connection.close();
            if (connection.isClosed()) {
                System.out.println("Closed !");
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }

    }

    @Override
    public boolean login(String userName, String passWord) throws SQLException {
        String sql = "SELECT password FROM user where username ='" + userName+"'";
        System.out.println("准备找");
        java.sql.Connection connection = this.conn;
        Statement statement = connection.createStatement();
        String rightPassWord = "";
        try (ResultSet resultSet = statement.executeQuery(sql)) {
            ResultSetMetaData metaData = resultSet.getMetaData();
            while (resultSet.next()) {
                System.out.println("找到了");
                String columnName = metaData.getColumnLabel(1);
                rightPassWord = resultSet.getString(columnName);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        //end : look up status
        System.out.println(rightPassWord + "是真正的密码");
        return passWord.equals(rightPassWord);
    }

    @Override
    public String getName(String userName) throws SQLException {
        String sql = "SELECT Name FROM user where username ='" + userName+"'";
        System.out.println("准备找");
        java.sql.Connection connection = this.conn;
        Statement statement = connection.createStatement();
        String name = "";
        try (ResultSet resultSet = statement.executeQuery(sql)) {
            ResultSetMetaData metaData = resultSet.getMetaData();
            while (resultSet.next()) {

                String columnName = metaData.getColumnLabel(1);
                name = resultSet.getString(columnName);
                System.out.println("找到了" + name);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        //end : look up status
        return name;
    }

    @Override
    public String getId(String userName) throws SQLException {
        String sql = "SELECT uId FROM user where username ='" + userName+"'";
        System.out.println("准备找");
        java.sql.Connection connection = this.conn;
        Statement statement = connection.createStatement();
        String id = "";
        try (ResultSet resultSet = statement.executeQuery(sql)) {
            ResultSetMetaData metaData = resultSet.getMetaData();
            while (resultSet.next()) {
                System.out.println("找到了");
                String columnName = metaData.getColumnLabel(1);
                id = resultSet.getString(columnName);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        //end : look up status

        return id;
    }

    @Override
    public String getBookBalance(String Id) throws SQLException {
        String sql = "SELECT balanceBook FROM user where uId ='" + Id+"'";
        System.out.println("准备找");
        java.sql.Connection connection = this.conn;
        Statement statement = connection.createStatement();
        String id = "";
        try (ResultSet resultSet = statement.executeQuery(sql)) {
            ResultSetMetaData metaData = resultSet.getMetaData();
            while (resultSet.next()) {
                System.out.println("找到了");
                String columnName = metaData.getColumnLabel(1);
                id = resultSet.getString(columnName);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        //end : look up status

        return id;
    }

    @Override
    public String getMagazineBalance(String Id) throws SQLException {
        String sql = "SELECT balanceMagazine FROM user where uId ='" + Id+"'";
        System.out.println("准备找");
        java.sql.Connection connection = this.conn;
        Statement statement = connection.createStatement();
        String id = "";
        try (ResultSet resultSet = statement.executeQuery(sql)) {
            ResultSetMetaData metaData = resultSet.getMetaData();
            while (resultSet.next()) {
                System.out.println("找到了");
                String columnName = metaData.getColumnLabel(1);
                id = resultSet.getString(columnName);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        //end : look up status

        return id;
    }

    @Override
    public String getVideoBalance(String Id) throws SQLException {
        String sql = "SELECT balanceVideo FROM user where uId ='" + Id+"'";
        System.out.println("准备找");
        java.sql.Connection connection = this.conn;
        Statement statement = connection.createStatement();
        String id = "";
        try (ResultSet resultSet = statement.executeQuery(sql)) {
            ResultSetMetaData metaData = resultSet.getMetaData();
            while (resultSet.next()) {
                System.out.println("找到了");
                String columnName = metaData.getColumnLabel(1);
                id = resultSet.getString(columnName);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        //end : look up status

        return id;
    }
}
