package com.travel.web;

import com.travel.bean.Hotel;

/**
 * Created by Jim Wang on 2016/8/6.
 */
public class HotelRequest extends Hotel implements Request{
    private String level;
    private String category;
    private String location;
    private String indexs;
    private String calendar;

    public String getCalendar() {
        return calendar;
    }

    public void setCalendar(String calendar) {
        this.calendar = calendar;
    }

    @Override
    public String getLocation() {
        return location;
    }

    @Override
    public void setLocation(String location) {
        this.location = location;
    }

    @Override
    public String getIndexs() {
        return indexs;
    }

    @Override
    public void setIndexs(String indexs) {
        this.indexs = indexs;
    }

    public String getLevel() {
        return level;
    }

    public void setLevel(String level) {
        this.level = level;
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }
}
