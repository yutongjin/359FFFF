package com.bookmarkers.DB.DAO;

import com.bookmarkers.DB.DAO.AbstractDAO;
import com.bookmarkers.Data.Item.Item;

import java.sql.Connection;
import java.util.List;

public abstract class SearchService extends AbstractDAO {
    public SearchService(Connection conn) {
        super(conn);
    }
    public abstract List<Item> search(String info);
}
