package com.bookmarkers.DB.Factory.DAOFactory;

import com.bookmarkers.DB.Service.Impl.ItemServiceImpl;
import com.bookmarkers.DB.Service.Impl.UserServiceImpl;
import com.bookmarkers.DB.Service.SearchService;

/**
 * @Author : Yutong Jin
 * @date : 8/20/18
 * @Description :
 */
public class ServiceFactory {
    public static ItemServiceImpl getItemServiceInstance(){return new ItemServiceImpl(); }
    public static UserServiceImpl getUserServiceInstance(){return new UserServiceImpl(); }

}
