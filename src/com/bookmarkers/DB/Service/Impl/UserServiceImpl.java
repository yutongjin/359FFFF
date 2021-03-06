package com.bookmarkers.DB.Service.Impl;

import com.bookmarkers.DB.Service.Impl.SearchStrategy.SearchByAuthor;
import com.bookmarkers.DB.Service.Impl.SearchStrategy.SearchById;
import com.bookmarkers.DB.Service.Impl.SearchStrategy.SearchByKeywords;
import com.bookmarkers.DB.DAO.Impl.UserDAOImpl;
import com.bookmarkers.DB.DatabaseConnection.DataBaseConnection;
import com.bookmarkers.DB.Factory.DAOFactory.DAOFactory;
import com.bookmarkers.DB.Service.SearchService;
import com.bookmarkers.DB.Service.UserService;
import com.bookmarkers.Data.Item.Item;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 * @Author : Yutong Jin
 * @date : 8/20/18
 * @Description :
 */
public class UserServiceImpl implements UserService {
    SearchService searchService;
    private Connection dbc = DataBaseConnection.getInstance().getDBConnection();
    @Override
    public boolean checkOutItem(String userId, String itemId) throws SQLException {
        String type = DAOFactory.getItemDAOInstance(dbc).getType(itemId);
        //System.out.println("c");
         try {
             //1.for item itself ,can be booked
             //2.for user ,that type balance is not 0
            if(DAOFactory.getItemDAOInstance(dbc).active(itemId) && DAOFactory.getUserDAOInstance(dbc).canBook(type,userId)){
                System.out.println("created");
                DAOFactory.getUserDAOInstance(dbc).book(type,userId);
                return DAOFactory.getItemDAOInstance(dbc).checkOutItem(userId,itemId);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        finally {
            //this.dbc.close();
        }
        return false;
    }

    @Override
    public boolean returnItem(String userId, String itemId) {
        try {
            boolean result = false;
            System.out.println("judging");
            String bookerId = DAOFactory.getItemDAOInstance(dbc).getBookerId(itemId);
            String type = DAOFactory.getItemDAOInstance(dbc).getType(itemId);
            System.out.println("bookiD" + bookerId );
            if( bookerId != null &&bookerId.equals(userId)&& !DAOFactory.getItemDAOInstance(dbc).active(itemId)) {
                result = DAOFactory.getItemDAOInstance(dbc).returnItem(userId, itemId);

                DAOFactory.getUserDAOInstance(dbc).returnItem(userId,type);
                return DAOFactory.getItemDAOInstance(dbc).returnItem(userId, itemId);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return false;
    }

    //这个函数待删除
   // public void searchByKeyWord(String key) {
       // DAOFactory.getItemDAOInstance(dbc).searchByKey(key);
    //}

    @Override
    public void searchByAuthor(String author) {
        searchService = new SearchByAuthor();
        searchService.search(author);
    }

    @Override
    public void searchById(String Id) {
       searchService= new SearchById();
       searchService.search(Id);
    }

    @Override
    public void searchByKeyWord(String KeyWord) {
        searchService= new SearchByKeywords();
        searchService.search(KeyWord);
    }

    @Override
    public boolean login(String username, String password) {
        if (username.isEmpty() || password.isEmpty()){
            return false;
        }
        try {
            boolean result = DAOFactory.getUserDAOInstance(dbc).login(username,password);
            return result;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return false;
    }

    @Override
    public String getName(String username)  {

        try {
            return DAOFactory.getUserDAOInstance(dbc).getName(username);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return "Error";
    }

    @Override
    public String getId(String username) throws SQLException {
        return DAOFactory.getUserDAOInstance(dbc).getId(username);
    }

    @Override
    public String getBookBalance(String username) throws SQLException {
        return DAOFactory.getUserDAOInstance(dbc).getBookBalance(username);
    }

    @Override
    public String getMagazineBalance(String username) throws SQLException {
        return DAOFactory.getUserDAOInstance(dbc).getMagazineBalance(username);
    }

    @Override
    public String getVideoBalance(String username) throws SQLException {
        return DAOFactory.getUserDAOInstance(dbc).getVideoBalance(username);
    }

    @Override
    public List<Item> getCheckOutInfo(String Id) {
        List<Item> list = new ArrayList<>();
        list =  DAOFactory.getItemDAOInstance(dbc).getItemListById(Id);
        for(Item item : list) {
            System.out.println(item.toString());

        }
        return list;
    }
}
