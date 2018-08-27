package com.bookmarkers.Data.Item;

import java.util.Date;
import java.util.List;

import com.bookmarkers.Data.User;
import com.jfoenix.controls.datamodels.treetable.RecursiveTreeObject;
import javafx.beans.InvalidationListener;
import javafx.beans.Observable;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;
import javafx.beans.value.ObservableValue;

/**
 * @Author : Yutong Jin
 * @date : 8/15/18
 * @Description :
 */
public  class Item extends RecursiveTreeObject<Item> implements Observable {
    private String Id; // id number
    private String name; // item name
    private String author;
    private String type;
    private String detailedType;
    private Date dateCreated;
    private boolean active;
    private Date returnDate;
    private String booker;

    StringProperty SpId;
    StringProperty SpName;
    StringProperty SpAuthor;
    StringProperty SpType;
    StringProperty SpDetailedType;
    StringProperty SpDateCreated;
    StringProperty SpActive;
    StringProperty SpBooker;

    public String getId() {
        return Id;
    }

    public String getSpName() {
        return SpName.get();
    }

    public StringProperty spNameProperty() {
        return SpName;
    }

    public void setSpName(String spName) {
        this.SpName.set(spName);
    }

    public String getSpAuthor() {
        return SpAuthor.get();
    }

    public StringProperty spAuthorProperty() {
        return SpAuthor;
    }

    public void setSpAuthor(String spAuthor) {
        this.SpAuthor.set(spAuthor);
    }

    public String getSpType() {
        return SpType.get();
    }

    public StringProperty spTypeProperty() {
        return SpType;
    }

    public void setSpType(String spType) {
        this.SpType.set(spType);
    }

    public String getSpDetailedType() {
        return SpDetailedType.get();
    }

    public StringProperty spDetailedTypeProperty() {
        return SpDetailedType;
    }

    public void setSpDetailedType(String spDetailedType) {
        this.SpDetailedType.set(spDetailedType);
    }

    public String getSpDateCreated() {
        return SpDateCreated.get();
    }

    public StringProperty spDateCreatedProperty() {
        return SpDateCreated;
    }

    public void setSpDateCreated(String spDateCreated) {
        this.SpDateCreated.set(spDateCreated);
    }

    public String getSpActive() {
        return SpActive.get();
    }

    public StringProperty spActiveProperty() {
        return SpActive;
    }

    public void setSpActive(String spActive) {
        this.SpActive.set(spActive);
    }

    public String getSpBooker() {
        return SpBooker.get();
    }

    public StringProperty spBookerProperty() {
        return SpBooker;
    }

    public void setSpBooker(String spBooker) {
        this.SpBooker.set(spBooker);
    }

    public StringProperty spIdProperty() {
        return SpId;
    }



    public Item(String Id){
        this.SpId = new SimpleStringProperty(Id);
    }

    List<String> KeyWord;

    public void setId(String id) {
        Id = id;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public void setType(String type) {
        this.type = type;
    }

    public void setDetailedType(String detailedType) {
        this.detailedType = detailedType;
    }

    public void setReturnDate(Date returnDate) {
        this.returnDate = returnDate;
    }

    public Item(){

    }


    @Override
    public void addListener(InvalidationListener listener) {

    }

    @Override
    public void removeListener(InvalidationListener listener) {

    }
}
