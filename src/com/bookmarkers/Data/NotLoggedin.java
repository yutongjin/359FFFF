package com.bookmarkers.Data;

public class NotLoggedin implements UserState{
    @Override
    public boolean isLogdedIn() {
        return false;
    }

    @Override
    public boolean isLoggedOut() {
        return false;
    }
}
