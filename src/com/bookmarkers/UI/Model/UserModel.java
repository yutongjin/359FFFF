package com.bookmarkers.UI.Model;

import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;

import java.text.DecimalFormat;

public  class UserModel {

    StringProperty SpId;
    public StringProperty SpName;
    StringProperty SpEmail;
    StringProperty SpPhone;
    boolean SpIsAdmin;
    StringProperty bookBalance;
    StringProperty magazineBalance;
    StringProperty videoBalance;
    StringProperty allBook;
    StringProperty allMag;
    StringProperty allVideo;

    StringProperty bookedBook;
    StringProperty bookedMag;
    StringProperty bookedVideo;
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

    public void setSpName(String spName) {
        this.SpName.set(spName);
    }

    public UserModel() {
    }

    public UserModel(String spId, String spName, String spEmail, String spPhone, boolean spIsAdmin) {
        this.SpId = new SimpleStringProperty(spId);
        this.SpName = new SimpleStringProperty(spName);
        this.SpEmail = new SimpleStringProperty(spEmail);
        this.SpPhone = new SimpleStringProperty(spPhone);
        this.SpIsAdmin = spIsAdmin;
    }

    public String getAllBook() {
        return allBook.get();
    }

    public StringProperty allBookProperty() {
        return allBook;
    }

    public String getAllMag() {
        return allMag.get();
    }

    public StringProperty allMagProperty() {
        return allMag;
    }

    public String getAllVideo() {
        return allVideo.get();
    }

    public StringProperty allVideoProperty() {
        return allVideo;
    }

    public String getBookedBook() {
        return bookedBook.get();
    }

    public StringProperty bookedBookProperty() {
        return bookedBook;
    }

    public String getBookedMag() {
        return bookedMag.get();
    }

    public StringProperty bookedMagProperty() {
        return bookedMag;
    }

    public String getBookedVideo() {
        return bookedVideo.get();
    }

    public StringProperty bookedVideoProperty() {
        return bookedVideo;
    }

    public UserModel(String spId, String spName, String spEmail, String spPhone, boolean spIsAdmin, String bookBalance, String magazineBalance, String videoBalance, int allbook, String allmag, String allvideo, String bookedbook, String bookedmag, String bookedvideo) {
        this.SpId = new SimpleStringProperty(spId);
        this.SpName = new SimpleStringProperty(spName);
        this.SpEmail = new SimpleStringProperty(spEmail);
        this.SpPhone = new SimpleStringProperty(spPhone);
        this.SpIsAdmin = spIsAdmin;
        this.bookBalance= new SimpleStringProperty(bookBalance);
        this.magazineBalance = new SimpleStringProperty(magazineBalance);
        this.videoBalance = new SimpleStringProperty(videoBalance);
        this.allBook = new SimpleStringProperty(String.valueOf(allbook));
        this.allMag = new SimpleStringProperty(allmag);
        this.allVideo = new SimpleStringProperty(allvideo);

        this.bookedBook = new SimpleStringProperty(String.valueOf(new DecimalFormat("0.00").format(100*Double.valueOf(bookedbook)/Double.valueOf(allbook))));
        this.bookedMag = new SimpleStringProperty(String.valueOf(new DecimalFormat("0.00").format(100*Double.valueOf(bookedmag)/Double.valueOf(allmag))));
        this.bookedVideo = new SimpleStringProperty(String.valueOf(new DecimalFormat("0.00").format(100*Double.valueOf(bookedvideo)/Double.valueOf(allvideo))));



    }

    public String getBookBalance() {
        return bookBalance.get();
    }

    public StringProperty bookBalanceProperty() {
        return bookBalance;
    }

    public String getSpId() {
        return SpId.get();
    }

    public StringProperty spIdProperty() {
        return SpId;
    }

    public String getSpName() {
        return SpName.get();
    }

    public StringProperty spNameProperty() {
        return SpName;
    }

    public String getSpEmail() {
        return SpEmail.get();
    }

    public StringProperty spEmailProperty() {
        return SpEmail;
    }

    public String getSpPhone() {
        return SpPhone.get();
    }

    public StringProperty spPhoneProperty() {
        return SpPhone;
    }

    public boolean isSpIsAdmin() {
        return SpIsAdmin;
    }

}
