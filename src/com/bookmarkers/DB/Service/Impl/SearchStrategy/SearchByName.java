package com.bookmarkers.DB.Service.Impl.SearchStrategy;

import com.bookmarkers.DB.Factory.DAOFactory.DAOFactory;
import com.bookmarkers.DB.Service.SearchService;
import com.bookmarkers.Data.Item.Item;

import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

/**
 * @Author : Yutong Jin
 * @date : 8/27/18
 * @Description :
 */
public class SearchByName  extends SearchService {

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
        String sql = "SELECT Id FROM Item where Name like '%" + info +"%'";
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
