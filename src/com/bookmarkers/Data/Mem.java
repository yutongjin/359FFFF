package com.bookmarkers.Data;

import com.bookmarkers.DB.DatabaseConnection.DataBaseConnection;
import com.bookmarkers.Data.Item.Item;
import com.bookmarkers.Data.User;
import java.sql.*;
import java.text.ParseException;
import java.util.List;

/**
 * @Author : Yutong Jin
 * @date : 8/15/18
 * @Description :
 */
public class Mem extends User {
    public Mem(){
        this.isAdmin = false;
    }
    public Mem(String id, String name, String email, String phone, String username, String password, boolean isAdmin) {
        super(id, name, email, phone, username, password, false);
    }
    public Mem(String name,boolean b){
        super(name,b);
    }

    public Mem(String id) {
super(id);

        this.Id = id;

    }

   // public void setId(String id) {
    //    this.Id = id;
   // }


}
