package com.travel.bean;

/**
 * Created by Jim Wang on 2016/10/25.
 */
public class Coupon {
    private int id;
    private String name;
    private Double price;
    private String code;
    private Integer priority;
    private  String category;
    private Integer status;
    private Integer orderId;
    private Integer userId;
    private Long createTime;
    private Long startTime;
    private Long endTime;
    private Integer effective;
    private Double limit;
    private Integer productId;
    private Long updateTime;

    public Long getUpdateTime() {
        return updateTime;
    }

    public void setUpdateTime(Long updateTime) {
        this.updateTime = updateTime;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setPrice(Double price) {
        this.price = price;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public void setPriority(Integer priority) {
        this.priority = priority;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }

    public void setOrderId(Integer orderId) {
        this.orderId = orderId;
    }

    public void setUserId(Integer userId) {
        this.userId = userId;
    }

    public void setCreateTime(Long createTime) {
        this.createTime = createTime;
    }

    public void setStartTime(Long startTime) {
        this.startTime = startTime;
    }

    public void setEndTime(Long endTime) {
        this.endTime = endTime;
    }

    public void setEffective(Integer effective) {
        this.effective = effective;
    }

    public void setLimit(Double limit) {
        this.limit = limit;
    }

    public void setProductId(Integer productId) {
        this.productId = productId;
    }

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public Double getPrice() {
        return price;
    }

    public String getCode() {
        return code;
    }

    public Integer getPriority() {
        return priority;
    }

    public String getCategory() {
        return category;
    }

    public Integer getStatus() {
        return status;
    }

    public Integer getOrderId() {
        return orderId;
    }

    public Integer getUserId() {
        return userId;
    }

    public Long getCreateTime() {
        return createTime;
    }

    public Long getStartTime() {
        return startTime;
    }

    public Long getEndTime() {
        return endTime;
    }

    public Integer getEffective() {
        return effective;
    }

    public Double getLimit() {
        return limit;
    }

    public Integer getProductId() {
        return productId;
    }
}
