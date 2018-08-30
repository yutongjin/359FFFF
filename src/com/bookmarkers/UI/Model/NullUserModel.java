package com.bookmarkers.UI.Model;

import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;

public class NullUserModel extends UserModel {

    StringProperty bookBalance;
    StringProperty magazineBalance;
    StringProperty videoBalance;
    StringProperty allBook;
    StringProperty allMag;
    StringProperty allVideo;
    StringProperty bookedBook;
    StringProperty bookedMag;
    StringProperty bookedVideo;

    @Override
    public String getBookedBook() {
        return bookedBook.get();
    }

    @Override
    public StringProperty bookedBookProperty() {
        return bookedBook;
    }

    @Override
    public String getBookedMag() {
        return bookedMag.get();
    }

    @Override
    public StringProperty bookedMagProperty() {
        return bookedMag;
    }

    @Override
    public String getBookedVideo() {
        return bookedVideo.get();
    }

    @Override
    public StringProperty bookedVideoProperty() {
        return bookedVideo;
    }

    public String getMagazineBalance() {
        return magazineBalance.get();
    }

    public StringProperty magazineBalanceProperty() {
        return magazineBalance;
    }

    public String getVideoBalance() {
        return videoBalance.get();
    }

    public StringProperty videoBalanceProperty() {
        return videoBalance;
    }

    @Override
    public String getAllBook() {
        return allBook.get();
    }

    @Override
    public StringProperty allBookProperty() {
        return allBook;
    }

    @Override
    public String getAllMag() {
        return allMag.get();
    }

    @Override
    public StringProperty allMagProperty() {
        return allMag;
    }

    @Override
    public String getAllVideo() {
        return allVideo.get();
    }

    @Override
    public StringProperty allVideoProperty() {
        return allVideo;
    }

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

    @Override
    public String getBookBalance() {
        return bookBalance.get();
    }

    @Override
    public StringProperty bookBalanceProperty() {
        return bookBalance;
    }
}
