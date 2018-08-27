package com.bookmarkers.DB.DAO.Impl.SearchStrategy;

import com.bookmarkers.DB.DAO.SearchService;
import com.bookmarkers.Data.Item.Item;

import java.sql.*;
import java.util.List;

/**
 * @Author : Yutong Jin
 * @date : 8/24/18
 * @Description :
 */
public class SearchByKeywords extends SearchService  {
    public SearchByKeywords(Connection conn) {
        super(conn);
    }

    @Override
    public List<Item> search(String info) {
        java.sql.Connection connection = super.conn;
        Statement statement = null;
        try {
            statement = connection.createStatement();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        String id = "";
        // look up status
        String sql = "SELECT Id FROM Item where KeyWords like '%" + info +"%'";
        System.out.println("start searching");

        try (ResultSet resultSet = statement.executeQuery(sql)) {
            ResultSetMetaData metaData = resultSet.getMetaData();
            while (resultSet.next()) {
                //System.out.println("start searching");
                String columnName = metaData.getColumnLabel(1);
                id = resultSet.getString(columnName);
                System.out.println(id);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}

