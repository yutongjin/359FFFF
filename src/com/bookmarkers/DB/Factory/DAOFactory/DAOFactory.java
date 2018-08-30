package com.bookmarkers.DB.Factory.DAOFactory;

import com.bookmarkers.DB.DAO.AdminDAO;
import com.bookmarkers.DB.DAO.Impl.AdminDAOImpl;
import com.bookmarkers.DB.DAO.Impl.ItemDAOImpl;
import com.bookmarkers.DB.DAO.Impl.UserDAOImpl;
import com.bookmarkers.DB.DAO.ItemDAO;
import com.bookmarkers.DB.DAO.UserDAO;
import com.bookmarkers.DB.DatabaseConnection.DataBaseConnection;
import java.sql.Connection;

/**
 * @Author : Yutong Jin
 * @date : 8/20/18
 * @Description :
 */
public class DAOFactory implements Factory{
    //public static AdminDAO getAdminDAOInstance(Connection conn){
    //    return new AdminDAOImpl(conn);
    //}
    public static UserDAO getUserDAOInstance(Connection conn){
        return new UserDAOImpl(conn);
    }
    public static ItemDAO getItemDAOInstance(Connection conn){
        return new ItemDAOImpl(conn);
    }
    public static AdminDAO getAdminDAOInstance(Connection conn){
        return new AdminDAOImpl(conn);
    }

}
