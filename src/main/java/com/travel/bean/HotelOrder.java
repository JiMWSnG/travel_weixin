package com.travel.bean;

/**
 * Created by Jim Wang on 2016/7/29.
 */
public class HotelOrder extends Order {
    private Integer day;
    private String roomType;
    private String checkMan;

    public HotelOrder(Order order,String checkMan,String roomType,Integer day) {
        super(order);
        this.day = day;
        this.checkMan = checkMan;
        this.roomType = roomType;

    }

    public Integer getDay() {
        return day;
    }

    public void setDay(Integer day) {
        this.day = day;
    }

    public String getRoomType() {
        return roomType;
    }

    public void setRoomType(String roomType) {
        this.roomType = roomType;
    }

    public String getCheckMan() {
        return checkMan;
    }

    public void setCheckMan(String checkMan) {
        this.checkMan = checkMan;
    }
}
