package com.bookmarkers.DB.DAO.Impl.Builder;

import com.bookmarkers.Data.Item.Item;

import java.text.ParseException;
import java.text.SimpleDateFormat;

/**
 * @Author : Yutong Jin
 * @date : 8/29/18
 * @Description :
 */
public class ConcreteBuilder implements Builder {
    Item item;
    String[] s;

    public ConcreteBuilder(String[] s) {
        this.s = s;
        item = new Item();
    }


    @Override
    public void buildId() {
        item.setId(s[0]);

    }

    @Override
    public void buildName() {
        item.setName(s[1]);
    }

    @Override
    public void buildType() {

        item.setType(s[2]);

    }

    @Override
    public void buildDetailedType() {
        item.setDetailedType(s[3]);
    }

    @Override
    public void buildAuthor() {
        item.setAuthor(s[4]);
    }

    @Override
    public void buildReturnDate() {
        try {
            if (s[5] != null && !s[5].equals("")) {
                item.setReturnDate(new SimpleDateFormat("yyyy-MM-dd").parse(s[5]));
            } else {
                item.setReturnDate((new SimpleDateFormat("yyyy-MM-dd").parse("0000-00-00")));
            }
        }
     catch(ParseException e){
            e.printStackTrace();
        }

    }

    @Override
    public void buildActive() {
        item.setActive(s[6].equals("1")?true:false);
    }

    @Override
    public void buildLoc() {
        item.setLoc(s[7]);
    }

    @Override
    public void buildBooker() {
        item.setBooker(s[8]);
    }

    @Override
    public Item getItem() {
        return item;
    }
}
