package com.bookmarkers.DB.DAO;

import java.sql.SQLException;

public interface UserDAO {
    public boolean canBook(String itemType,String userId) throws SQLException;
    public void book(String itemType,String userId);
    public void returnItem(String userId,String itemType);
    public boolean login(String username,String password) throws SQLException;
    public String getName(String username) throws SQLException;
}
