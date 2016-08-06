package com.travel.bean;

/**
 * Created by Jim Wang on 2016/7/29.
 */
public class RouteOrder  extends Order{


    private String insured;

    public RouteOrder( Order order,String insured) {
        super(order);
        this.insured = insured;
    }

    public String getInsured() {
        return insured;
    }

    public void setInsured(String insured) {
        this.insured = insured;
    }
}
