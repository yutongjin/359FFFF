package com.bookmarkers.UI.Model;

import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;

public abstract class UserModel {

    StringProperty SpId;
    public StringProperty SpName;
    StringProperty SpEmail;
    StringProperty SpPhone;
    boolean SpIsAdmin;

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
