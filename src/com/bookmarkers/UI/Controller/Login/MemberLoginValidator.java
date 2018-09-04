package com.bookmarkers.UI.Controller.Login;

import com.bookmarkers.DB.Service.Impl.UserServiceImpl;

public class MemberLoginValidator implements LoginValidator {

    @Override
    public boolean validateLogin(String username, String password) {
        boolean result =  new UserServiceImpl().login(username,password);
        return result;
    }
}
