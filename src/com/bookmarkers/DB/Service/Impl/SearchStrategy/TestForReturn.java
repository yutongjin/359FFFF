package com.bookmarkers.DB.Service.Impl.SearchStrategy;

import com.bookmarkers.DB.Factory.DAOFactory.ServiceFactory;

/**
 * @Author : Yutong Jin
 * @date : 8/28/18
 * @Description :
 */
public class TestForReturn {
    public static void main(String[] args) {
        ServiceFactory.getUserServiceInstance().returnItem("004","004");

    }
}
