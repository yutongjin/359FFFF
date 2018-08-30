package com.bookmarkers.UI.Model;

import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;


/**
 * @Author : Yutong Jin
 * @date : 8/29/18
 * @Description :
 */
public class MemberModel extends UserModel {

//    StringProperty SpId;
//    public StringProperty SpName;
//    StringProperty SpEmail;
//    StringProperty SpPhone;
//    boolean SpIsAdmin;

    StringProperty bookBalance;
    public MemberModel(String spId, String spName, String spEmail, String spPhone, boolean spIsAdmin) {
        super(spId, spName, spEmail, spPhone, spIsAdmin);

    }

    public String getBookBalance() {
        return bookBalance.get();
    }

    public StringProperty bookBalanceProperty() {
        return bookBalance;
    }

    public MemberModel(String spId, String spName, String spEmail, String spPhone, boolean spIsAdmin, String bookBalance) {
        super(spId, spName, spEmail, spPhone, spIsAdmin);
        this.bookBalance = new SimpleStringProperty(bookBalance);

    }

//    public void setSpName(String spName) {
//        this.SpName.set(spName);
//    }
//
//    public String getSpId() {
//        return SpId.get();
//    }
//
//    public StringProperty spIdProperty() {
//        return SpId;
//    }
//
//    public String getSpName() {
//        return SpName.get();
//    }
//
//    public StringProperty spNameProperty() {
//        return SpName;
//    }
//
//    public String getSpEmail() {
//        return SpEmail.get();
//    }
//
//    public StringProperty spEmailProperty() {
//        return SpEmail;
//    }
//
//    public String getSpPhone() {
//        return SpPhone.get();
//    }
//
//    public StringProperty spPhoneProperty() {
//        return SpPhone;
//    }
//
//    public boolean isSpIsAdmin() {
//        return SpIsAdmin;
//    }


}
