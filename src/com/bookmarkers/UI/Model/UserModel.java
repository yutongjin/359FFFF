package com.bookmarkers.UI.Model;

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
