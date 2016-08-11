package com.travel.web;

import com.travel.bean.Contact;
import com.travel.bean.Order;

/**
 * Created by Jim Wang on 2016/8/10.
 */
public class OrderRequest extends Order implements Request {
    private String manInfo;
    private String roomType;
    private Integer day;

    public OrderRequest(){
        super();
    }
    public OrderRequest(Order order) {
        super(order);

    }



    public String getManInfo() {
        return manInfo;
    }

    public void setManInfo(String manInfo) {
        this.manInfo = manInfo;
    }

    public String getRoomType() {
        return roomType;
    }

    public void setRoomType(String roomType) {
        this.roomType = roomType;
    }

    public Integer getDay() {
        return day;
    }

    public void setDay(Integer day) {
        this.day = day;
    }
}
