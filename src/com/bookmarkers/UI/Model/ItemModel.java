package com.bookmarkers.UI.Model;

import com.bookmarkers.Data.Item.Item;
import com.jfoenix.controls.datamodels.treetable.RecursiveTreeObject;
import javafx.beans.InvalidationListener;
import javafx.beans.Observable;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;

import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * @Author : Yutong Jin
 * @date : 8/29/18
 * @Description :
 */
public class ItemModel extends RecursiveTreeObject<ItemModel> implements Observable {

    StringProperty SpId;
    StringProperty SpName;

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

    public String getSpAuthor() {
        return SpAuthor.get();
    }

    public StringProperty spAuthorProperty() {
        return SpAuthor;
    }

    public String getSpType() {
        return SpType.get();
    }

    public StringProperty spTypeProperty() {
        return SpType;
    }

    public String getSpDetailedType() {
        return SpDetailedType.get();
    }

    public StringProperty spDetailedTypeProperty() {
        return SpDetailedType;
    }

    public String getSpDateCreated() {
        return SpDateCreated.get();
    }

    public StringProperty spDateCreatedProperty() {
        return SpDateCreated;
    }

    public String getSpActive() {
        return SpActive.get();
    }

    public StringProperty spActiveProperty() {
        return SpActive;
    }

    public String getSpBooker() {
        return SpBooker.get();
    }

    public StringProperty spBookerProperty() {
        return SpBooker;
    }

    public String getSpReturnDate() {
        return SpReturnDate.get();
    }

    public StringProperty spReturnDateProperty() {
        return SpReturnDate;
    }

    public String getSpLoc() {
        return SpLoc.get();
    }

    public StringProperty spLocProperty() {
        return SpLoc;
    }

    StringProperty SpAuthor;
    StringProperty SpType;
    StringProperty SpDetailedType;
    StringProperty SpDateCreated;
    StringProperty SpActive;
    StringProperty SpBooker;
    StringProperty SpReturnDate;
    StringProperty SpLoc;
    public ItemModel(String Id, String name , String Author, String Type, String DetailedType, Date ReturnDate, boolean active, String loc, String booker){
        this.SpId =new SimpleStringProperty(Id);
        this.SpName = new SimpleStringProperty(name);
        this.SpAuthor = new SimpleStringProperty(Author);
        this.SpType = new SimpleStringProperty(Type);
        this.SpDetailedType = new SimpleStringProperty(DetailedType);
        this.SpReturnDate = new SimpleStringProperty(new SimpleDateFormat("yyyy/MM/dd").format(ReturnDate));
        this.SpActive = new SimpleStringProperty(active?"yes" : "No");
        this.SpLoc = new SimpleStringProperty(loc);
        this.SpBooker = new SimpleStringProperty(booker);
    }
    public void setSpId(String spId) {
        this.SpId.set(spId);
    }

    public void setSpName(String spName) {
        this.SpName.set(spName);
    }

    public void setSpAuthor(String spAuthor) {
        this.SpAuthor.set(spAuthor);
    }

    public void setSpType(String spType) {
        this.SpType.set(spType);
    }

    public void setSpDetailedType(String spDetailedType) {
        this.SpDetailedType.set(spDetailedType);
    }

    public void setSpDateCreated(String spDateCreated) {
        this.SpDateCreated.set(spDateCreated);
    }

    public void setSpActive(String spActive) {
        this.SpActive.set(spActive);
    }

    public void setSpBooker(String spBooker) {
        this.SpBooker.set(spBooker);
    }

    public void setSpReturnDate(String spReturnDate) {
        this.SpReturnDate.set(spReturnDate);
    }

    public void setSpLoc(String spLoc) {
        this.SpLoc.set(spLoc);
    }

    @Override
    public void addListener(InvalidationListener listener) {

    }

    @Override
    public void removeListener(InvalidationListener listener) {

    }
}
