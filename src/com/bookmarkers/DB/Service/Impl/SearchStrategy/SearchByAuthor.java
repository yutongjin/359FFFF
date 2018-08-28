package com.bookmarkers.DB.Service.Impl.SearchStrategy;

import com.bookmarkers.DB.Factory.DAOFactory.DAOFactory;
import com.bookmarkers.DB.Service.SearchService;
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

    @Override
    public List<Item> search(String info) {
        java.sql.Connection connection = super.dbc;
        Statement statement = null;
        searchResult = new ArrayList<>();
        try {
            statement = connection.createStatement();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        String id = "";
        // look up status
        String sql = "SELECT Id FROM Item where Arthur like '%" + info +"%'";
        System.out.println("start searching");

        try (ResultSet resultSet = statement.executeQuery(sql)) {
            ResultSetMetaData metaData = resultSet.getMetaData();
            while (resultSet.next()) {
                //System.out.println("start searching");
                String columnName = metaData.getColumnLabel(1);
                id = resultSet.getString(columnName);

                searchResult.add(DAOFactory.getItemDAOInstance(dbc).getItemByItemId(id));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return searchResult;
    }
}
