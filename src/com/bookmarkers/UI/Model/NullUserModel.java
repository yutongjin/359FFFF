package com.bookmarkers.UI.Model;

import javafx.beans.property.SimpleStringProperty;

public class NullUserModel extends UserModel {

    public NullUserModel() {
        this.SpId = new SimpleStringProperty("0000");
        this.SpName = new SimpleStringProperty("null");
        this.SpEmail = new SimpleStringProperty("null@bookmarks.com");
        this.SpPhone = new SimpleStringProperty("null");
        this.SpIsAdmin = false;
    }
}
