package com.bookmarkers.Data;

import com.bookmarkers.Data.User;

/**
 * @Author : Yutong Jin
 * @date : 8/16/18
 * @Description :
 */
public class Admin extends User {
    public Admin(){

        this.isAdmin =true;
    }

    public Admin(String id, String name, String email, String phone, String username, String password, boolean isAdmin) {
        super(id, name, email, phone, username, password, true);
    }
    public Admin(String name,boolean isAdmin){
        super(name,true);
    }
    public void setAdmin(boolean admin) {
        super.isAdmin = admin;
    }}
