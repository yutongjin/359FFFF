package com.bookmarkers.DB.DAO.Impl.Builder;

import com.bookmarkers.Data.Item.Item;

import java.text.ParseException;
import java.text.SimpleDateFormat;

public interface Builder {
    public void buildId();
    public void buildName();
    public void buildType();
    public void buildDetailedType();
    public void buildAuthor();
    public void buildReturnDate();
    public void buildActive();
    public void buildLoc();
    public void buildBooker();
    public Item getItem();
}
