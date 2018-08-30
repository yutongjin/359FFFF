package com.bookmarkers.DB.Service;

import com.bookmarkers.Data.Item.Item;

import java.sql.SQLException;
import java.util.List;

public interface UserService extends Service{

    public abstract boolean checkOutItem(String userId,String itemId) throws SQLException;
    public abstract boolean returnItem(String userId,String itemId);
    public abstract void searchByAuthor(String Author) ;
    public abstract void searchById(String Id) ;
    public abstract void searchByKeyWord(String KeyWord) ;
    public abstract boolean login(String username,String password);
    public abstract String getName(String username) throws SQLException;
    public abstract String getId(String username) throws SQLException;
    public abstract String getBookBalance(String username) throws SQLException;
    public abstract String getMagazineBalance(String username) throws SQLException;
    public abstract String getVideoBalance(String username) throws SQLException;
    public List<Item> getCheckOutInfo(String userId);
}
