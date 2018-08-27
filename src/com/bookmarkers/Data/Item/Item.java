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
    private User booker;

    public String getId() {
        return Id;
    }


    public StringProperty spIdProperty() {
        return SpId;
    }

    StringProperty SpId;

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
    public Item(String id, String name, Date dateCreated, boolean active, Date returnDate, User booker, List<String> keyWord) {
        Id = id;
        this.name = name;
        this.dateCreated = dateCreated;
        this.active = active;
        this.returnDate = returnDate;
        this.booker = booker;

        KeyWord = keyWord;
    }

    @Override
    public void addListener(InvalidationListener listener) {

    }

    @Override
    public void removeListener(InvalidationListener listener) {

    }
}
