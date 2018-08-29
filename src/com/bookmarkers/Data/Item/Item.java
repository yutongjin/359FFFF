package com.bookmarkers.Data.Item;

import java.text.SimpleDateFormat;
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
public  class Item  {
    private String Id; // id number
    private String name; // item name
    private String author;
    private String type;
    private String detailedType;
    private Date dateCreated;
    private boolean active;
    private Date returnDate;
    private String booker;
    private String loc;

    public String getId() {
        return Id;
    }

    public void setDateCreated(Date dateCreated) {
        this.dateCreated = dateCreated;
    }

    public void setActive(boolean active) {
        this.active = active;
    }

    public void setBooker(String booker) {
        this.booker = booker;
    }

    public void setLoc(String loc) {
        this.loc = loc;
    }


    public void setKeyWord(List<String> keyWord) {
        KeyWord = keyWord;
    }

    public String getLoc() {
        return loc;
    }



    public String getName() {
        return name;
    }

    public String getAuthor() {
        return author;
    }

    public String getType() {
        return type;
    }

    public String getDetailedType() {
        return detailedType;
    }

    public Date getDateCreated() {
        return dateCreated;
    }

    public boolean isActive() {
        return active;
    }

    public Date getReturnDate() {
        return returnDate;
    }

    public String getBooker() {
        return booker;
    }


    public List<String> getKeyWord() {
        return KeyWord;
    }

    List<String> KeyWord;

    public void setId(String id) {
        this.Id = id;
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
}
