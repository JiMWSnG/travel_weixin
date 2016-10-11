package com.travel.bean;

/**
 * Created by Jim Wang on 2016/7/29.
 */
public class Contact {
    private Integer id;
    private String cname;
    private String IdType;
    private String IdCard;
    private String phone;
    private Integer orderId;

    public Integer getUserId() {
        return userId;
    }

    public void setUserId(Integer userId) {
        this.userId = userId;
    }

    private Integer userId;
    public String getIdType() {
        return IdType;
    }

    public void setIdType(String idType) {
        IdType = idType;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getCname() {
        return cname;
    }

    public void setCname(String cname) {
        this.cname = cname;
    }

    public String getIdCard() {
        return IdCard;
    }

    public void setIdCard(String idCard) {
        IdCard = idCard;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public Integer getOrderId() {
        return orderId;
    }

    public void setOrderId(Integer orderId) {
        this.orderId = orderId;
    }
}
