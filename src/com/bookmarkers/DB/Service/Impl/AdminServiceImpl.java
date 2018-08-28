package com.bookmarkers.DB.Service.Impl;

import com.bookmarkers.DB.Service.SearchService;
import com.bookmarkers.DB.DatabaseConnection.DataBaseConnection;
import com.bookmarkers.DB.Factory.DAOFactory.DAOFactory;
import com.bookmarkers.DB.Service.AdminService;

import java.sql.Connection;
import java.sql.SQLException;

/**
 * @Author : Yutong Jin
 * @date : 8/20/18
 * @Description :
 */
public class AdminServiceImpl implements AdminService {
    SearchService searchService;
    private Connection dbc = DataBaseConnection.getInstance().getDBConnection();



    @Override
    public boolean login(String username, String password) {

        try {
            boolean result = DAOFactory.getAdminDAOInstance(dbc).login(username,password);
            return result;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return false;
    }

    @Override
    public String getName(String username, String password) {

        try {
            return DAOFactory.getAdminDAOInstance(dbc).getName(username,password);
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return "error";
    }


}
