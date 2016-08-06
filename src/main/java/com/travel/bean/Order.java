package com.travel.bean;

public  abstract class Order {
	int id;
	String type;
	String name;
	String description;
	double discount;
	double price;
	int productId;
	int couponId;//for extend
	String status;
	String statusMsg;
	int userId;
	int num;
	long createTime;
	long updateTime;
	String orderFrom;

	public Order(Order order) {
		this.id = order.getId();
		this.type = order.getType();
		this.name = order.getName();
		this.description = order.getDescription();
		this.discount = order.getDiscount();
		this.price = order.getPrice();
		this.productId = order.getProductId();
		this.couponId = order.getCouponId();
		this.status = order.getStatus();
		this.statusMsg = order.getStatusMsg();
		this.userId = order.getUserId();
		this.num = order.getNum();
		this.createTime = order.getCreateTime();
		this.updateTime = order.getUpdateTime();
		this.orderFrom = order.getOrderFrom();
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public double getDiscount() {
		return discount;
	}

	public void setDiscount(double discount) {
		this.discount = discount;
	}

	public double getPrice() {
		return price;
	}

	public void setPrice(double price) {
		this.price = price;
	}

	public int getProductId() {
		return productId;
	}

	public void setProductId(int productId) {
		this.productId = productId;
	}

	public int getCouponId() {
		return couponId;
	}

	public void setCouponId(int couponId) {
		this.couponId = couponId;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public String getStatusMsg() {
		return statusMsg;
	}

	public void setStatusMsg(String statusMsg) {
		this.statusMsg = statusMsg;
	}

	public int getUserId() {
		return userId;
	}

	public void setUserId(int userId) {
		this.userId = userId;
	}

	public int getNum() {
		return num;
	}

	public void setNum(int num) {
		this.num = num;
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

	public String getOrderFrom() {
		return orderFrom;
	}

	public void setOrderFrom(String orderFrom) {
		this.orderFrom = orderFrom;
	}
}
