package com.bookmarkers.DB.DAO;

import com.bookmarkers.Data.Item.Item;

import java.sql.SQLException;
import java.util.List;

public interface ItemDAO {
    public boolean checkOutItem(String userId, String itemId);

    public boolean returnItem(String userId, String itemId);

    public boolean active(String itemId) throws SQLException;

    public String getBookerId(String itemId) throws SQLException;

    public String getType(String itemId);
    public void searchByInfo(String info);
    public List<Item> getItemListById(String id );
    public Item getItemByItemId(String id);

    public  int getBookNumber() throws SQLException;
    public  int getMagNumber();
    public  int getVideoNumber();
    public  int getBookedBookNumber() throws SQLException;
    public  int getBookedMagNumber();
    public  int getBookedVideoNumber();

}