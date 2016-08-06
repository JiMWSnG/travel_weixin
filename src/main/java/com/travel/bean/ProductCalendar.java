package com.travel.bean;

public class ProductCalendar {
    protected int id;
    protected int productId;
    protected String calendar;
    protected long createTime;
    protected long updateTime;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getProductId() {
        return productId;
    }

    public void setProductId(int productId) {
        this.productId = productId;
    }

    public String getCalendar() {
        return calendar;
    }

    public void setCalendar(String calendar) {
        this.calendar = calendar;
    }

    public long getCreateTime() {
        return createTime;
    }

    public void setCreateTime(long createTime) {
        this.createTime = createTime;
    }

    public long getUpdateTime() {
        return updateTime;
    }

    public void setUpdateTime(long updateTime) {
        this.updateTime = updateTime;
    }

    @Override
    public String toString() {
        return "ProductCalendar [id=" + id + ", productId=" + productId + ", calendar=" + calendar + ", createTime="
                + createTime + ", updateTime=" + updateTime + "]";
    }

}
