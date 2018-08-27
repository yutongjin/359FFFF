package com.bookmarkers.Data.Item;

import com.bookmarkers.Data.User;

import java.util.Date;
import java.util.List;

/**
 * @Author : Yutong Jin
 * @date : 8/15/18
 * @Description :
 */
public class IndividualItem extends Item{
    public IndividualItem(String id, String name, Date dateCreated, boolean active, Date returnDate, User booker,List<String> keyWord) {
        super(id, name, dateCreated, active, returnDate, booker, keyWord);
    }
}
