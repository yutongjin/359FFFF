package com.bookmarkers.Data;

public class LoggedOut  implements UserState {
    @Override
    public boolean isLogdedIn() {
        return false;
    }

    @Override
    public boolean isLoggedOut() {
        return true;
    }
}
