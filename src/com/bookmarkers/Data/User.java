package com.bookmarkers.Data;

/**
 * @Author : Yutong Jin
 * @date : 8/26/18
 * @Description :
 */
public abstract class User {
    String Id;
    String name;
    String email;
    String phone;
    String username;
    String password;
    boolean isAdmin;
    public User(){

    }

    public String getId() {
        //System.out.println("this id "+ getId());
        return Id;
    }

    public String getName() {
        return name;
    }

    public boolean isAdmin() {
        return isAdmin;

    }
    public User(String id) {

        this.Id = id;
        System.out.println(id +" id!!!");

    }
    public User(String name, boolean b) {

        this.name = name;

        this.isAdmin = b;
    }

    public void setId(String id) {
        Id = id;
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

    public void setUsername(String username) {
        this.username = username;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public void setAdmin(boolean admin) {
        isAdmin = admin;
    }

    public User(String id, String name, String email, String phone, String username, String password, boolean isAdmin) {
        Id = id;

        this.name = name;
        this.email = email;
        this.phone = phone;
        this.username = username;
        this.password = password;
        this.isAdmin = isAdmin;
    }
}
