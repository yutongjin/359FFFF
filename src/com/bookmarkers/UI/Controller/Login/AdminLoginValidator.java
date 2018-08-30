package com.bookmarkers.UI.Controller.Login;


import com.bookmarkers.DB.Service.Impl.AdminServiceImpl;

public class AdminLoginValidator implements LoginValidator {

    @Override
    public boolean validateLogin(String username, String password) {
        boolean result =  new AdminServiceImpl().login(username,password);
        return result;
    }
}
