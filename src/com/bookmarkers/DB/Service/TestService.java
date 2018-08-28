package com.bookmarkers.DB.Service;

import com.bookmarkers.DB.Factory.DAOFactory.ServiceFactory;
import com.bookmarkers.DB.Service.Impl.SearchStrategy.SearchByKeywords;
import com.bookmarkers.DB.Service.Impl.UserServiceImpl;
import com.bookmarkers.Data.Item.Item;
import com.bookmarkers.Data.Mem;
import com.bookmarkers.Data.User;

import java.sql.SQLException;
import java.util.List;

/**
 * @Author : Yutong Jin
 * @date : 8/20/18
 * @Description :
 */
public class TestService {
    public static void main(String[] args) {
        //checkOut("001");
        //returnItem("Yuin");
       // returnItem("001");
        //SearchService searchService = new SearchByAuthor().search("cooper");
        //new UserServiceImpl().searchByKeyWord("mag");
        //List<Item> list = new UserServiceImpl().getCheckOutInfo("001");
        SearchService searchService = new SearchByKeywords();
        List<Item> list = searchService.search("magic");
        for (Item item :list
             ) {
            System.out.println(item.getId() + "???");
        }
    }
    public static void checkOut(String id){
        User user  =new Mem(id);
        UserService userService = ServiceFactory.getUserServiceInstance();
        for (int i = 1; i < 8; i++) {
            String itemId = "00" + i;

            try {
                if(userService.checkOutItem(user.getId(),itemId)){
                    System.out.println("Check out Success");
                }
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }

    public static void returnItem(String id){
        User user  =new Mem(id);
        UserService userService = ServiceFactory.getUserServiceInstance();
        for (int i = 1; i < 8; i++) {
            String itemId = "00" + i;
            System.out.println(user.getId() + "iddddd");
            if(userService.returnItem(user.getId(),itemId)){
                System.out.println("return Success");
            }
        }
    }
}
