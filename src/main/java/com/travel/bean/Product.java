package com.travel.bean;

public class Product {
	protected int id;
	protected String picturePath;
	protected String name;
	protected String type;
	protected String description;
	protected long createTime;
	protected long updateTime;
	protected double price;
	protected String location;
	protected String status;
	protected String indexs;
	protected Integer themeId;
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getPicturePath() {
		return picturePath;
	}
	public void setPicturePath(String picturePath) {
		this.picturePath = picturePath;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getType() {
		return type;
	}
	public void setType(String type) {
		this.type = type;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
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
	public void setUpdateTime(long updatetime) {
		this.updateTime = updatetime;
	}
	public double getPrice() {
		return price;
	}
	public void setPrice(double price) {
		this.price = price;
	}
	public String getLocation() {
		return location;
	}
	public void setLocation(String location) {
		this.location = location;
	}
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}
	public String getIndexs() {
		return indexs;
	}
	public void setIndexs(String indexs) {
		this.indexs = indexs;
	}
	public Integer getThemeId() {
		return themeId;
	}
	public void setThemeId(Integer themeId) {
		this.themeId = themeId;
	}
	@Override
	public String toString() {
		return "Product [id=" + id + ", picturePath=" + picturePath + ", name=" + name + ", type=" + type
				+ ", description=" + description + ", createTime=" + createTime + ", updatetime=" + updateTime
				+ ", price=" + price + ", location=" + location + ", status=" + status + ", indexs=" + indexs
				+ ", themeId=" + themeId + "]";
	}
	

}
