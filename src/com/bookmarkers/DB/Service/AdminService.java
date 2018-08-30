package com.bookmarkers.DB.Service;

import java.sql.SQLException;

public interface AdminService extends Service{
    public  boolean login(String username,String password);
    public  String getName(String username,String password);
    public  int getBookNumber() throws SQLException;
    public  int getMagNumber();
    public  int getVideoNumber();
    public  int getBookedBookNumber();
    public  int getBookedMagNumber();
    public  int getBookedVideoNumber();


}
