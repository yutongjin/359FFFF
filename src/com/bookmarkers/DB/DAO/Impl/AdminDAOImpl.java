package com.bookmarkers.DB.DAO.Impl;

import com.bookmarkers.DB.DAO.AbstractDAO;
import com.bookmarkers.DB.DAO.AdminDAO;

import java.sql.*;

/**
 * @Author : Yutong Jin
 * @date : 8/26/18
 * @Description :
 */
public class AdminDAOImpl extends AbstractDAO implements AdminDAO {
    public AdminDAOImpl(Connection conn) {
        super(conn);
    }

    @Override
    public boolean login(String userName, String passWord) throws SQLException {
        String sql = "SELECT password FROM Admin where adminName ='" + userName+ "'";
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
    public String getName(String userName, String password) throws SQLException {
        String sql = "SELECT name FROM Admin where adminName ='" + userName + "'";
        System.out.println("准备找");
        java.sql.Connection connection = this.conn;
        Statement statement = connection.createStatement();
        String name = "";
        try (ResultSet resultSet = statement.executeQuery(sql)) {
            ResultSetMetaData metaData = resultSet.getMetaData();
            while (resultSet.next()) {
                System.out.println("找到了");
                String columnName = metaData.getColumnLabel(1);
                name = resultSet.getString(columnName);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        //end : look up status

        return name;
    }
}
