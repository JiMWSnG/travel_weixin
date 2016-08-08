package com.travel.web;

import com.travel.bean.Route;

/**
 * Created by Jim Wang on 2016/8/5.
 */
public class RouteRequest extends Route implements Request{
    protected String calendar;

    public String getCalendar() {
        return calendar;
    }

    public void setCalendar(String calendar) {
        this.calendar = calendar;
    }
}
