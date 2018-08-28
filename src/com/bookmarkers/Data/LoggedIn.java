package com.bookmarkers.Data;

public class LoggedIn implements UserState{
    @Override
    public boolean isLogdedIn() {
        return true;
    }

    @Override
    public boolean isLoggedOut() {
        return false;
    }
}
