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
    String Id;
    String name;
    String email;
    String phone;
    List<Item> itemList;
    String username;
    String password;
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

    }

    public void setId(String id) {
        this.Id = id;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public void setItemList(List<Item> itemList) {
        this.itemList = itemList;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getId() {
        return super.getId();
    }
}
