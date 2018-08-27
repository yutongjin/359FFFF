package com.bookmarkers.DB.DAO.Impl.SearchStrategy;

import com.bookmarkers.DB.DAO.SearchService;
import com.bookmarkers.Data.Item.Item;

import java.sql.*;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;

/**
 * @Author : Yutong Jin
 * @date : 8/24/18
 * @Description :
 */
public class SearchByAuthor extends SearchService {
    public SearchByAuthor(Connection conn) {
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
        String sql = "SELECT Id ,name ,ItemType ,Type, Arthur ,ReturnDate FROM Item where Booker = " + id;

        String sql = "SELECT Id ,name ,ItemType ,Type, Arthur ,ReturnDate FROM Item where Arthur like '%" + info + "%'";
        System.out.println("start searching");

        try (ResultSet resultSet = statement.executeQuery(sql)) {
            ResultSetMetaData metaData = resultSet.getMetaData();
            Item item = null;
            while (resultSet.next()) {
                String[] s = new String[6];
                item = new Item();
                for (int i = 1; i <= metaData.getColumnCount(); i++) {
                    String columnName = metaData.getColumnLabel(i);
                    s[i - 1] = resultSet.getString(columnName);
                    System.out.println(s[i - 1]);
                }
                item.setId(s[0]);
                item.setName(s[1]);
                item.setType(s[2]);
                item.setDetailedType(s[3]);
                item.setAuthor(s[4]);
                list.add(item);
                try {
                    item.setReturnDate(new SimpleDateFormat("yyyy-MM-dd").parse(s[5]));
                } catch (ParseException e) {
                    e.printStackTrace();
                }

            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return list;
    }
}
