package com.bookmarkers.DB.Service;

import com.bookmarkers.DB.DAO.AbstractDAO;
import com.bookmarkers.DB.DatabaseConnection.DataBaseConnection;
import com.bookmarkers.Data.Item.Item;

import java.sql.Connection;
import java.util.List;

public abstract class SearchService {

    protected List<Item> searchResult;

    public abstract List<Item> search(String info);

    protected Connection dbc = DataBaseConnection.getInstance().getDBConnection();

}
