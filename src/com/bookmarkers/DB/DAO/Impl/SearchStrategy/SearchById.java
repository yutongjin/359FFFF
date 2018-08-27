package com.bookmarkers.DB.DAO.Impl.SearchStrategy;

import com.bookmarkers.DB.DAO.SearchService;
import com.bookmarkers.Data.Item.Item;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

/**
 * @Author : Yutong Jin
 * @date : 8/24/18
 * @Description :
 */
public class SearchById extends SearchService {
    public SearchById(Connection conn) {
        super(conn);
    }

    @Override
    public List<Item> search(String info) {
        java.sql.Connection connection = this.conn;
        Statement statement = null;
        List<Item> list = new ArrayList<>();


        try {
            statement = connection.createStatement();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        String id = "";
        // look up status
        //String sql = "SELECT Id ,name ,ItemType ,Type, Arthur ,ReturnDate FROM Item where Booker = " + id;

        String sql = "SELECT Id FROM Item where Id = '" + info +"'";
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
        return null;
    }
}
