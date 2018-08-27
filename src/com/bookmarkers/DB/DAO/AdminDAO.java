package com.bookmarkers.DB.DAO;

import java.sql.SQLException;

public interface AdminDAO {
    public boolean login(String username,String password) throws SQLException;
    public String getName(String username,String password) throws SQLException;
}
