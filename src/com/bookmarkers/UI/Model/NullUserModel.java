package com.bookmarkers.UI.Model;

import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;

public class NullUserModel extends UserModel {

    public NullUserModel() {
        this.SpId = new SimpleStringProperty("0000");
        this.SpName = new SimpleStringProperty("null");
        this.SpEmail = new SimpleStringProperty("null@bookmarks.com");
        this.SpPhone = new SimpleStringProperty("null");
        this.SpIsAdmin = false;
        bookBalance = new SimpleStringProperty("100");
        this.magazineBalance = new SimpleStringProperty("100");
        this.videoBalance = new SimpleStringProperty("100");
        this.allBook = new SimpleStringProperty("100");
        this.allMag = new SimpleStringProperty("100");
        this.allVideo = new SimpleStringProperty("100");
        this.bookedBook = new SimpleStringProperty("100");
        this.bookedMag = new SimpleStringProperty("100");
        this.bookedVideo = new SimpleStringProperty("100");
    }

}
