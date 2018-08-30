package com.bookmarkers.UI.Controller.Login;

import com.bookmarkers.DB.Service.Impl.UserServiceImpl;

public class UserLoginValidator implements LoginValidator {

    @Override
    public boolean validateLogin(String username, String password) {
        boolean result =  new UserServiceImpl().login(username,password);
        return result;
    }
}
