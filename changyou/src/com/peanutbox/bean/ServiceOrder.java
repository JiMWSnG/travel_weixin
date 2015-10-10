package com.peanutbox.bean;

import java.util.Date;

public class ServiceOrder {
	private long serviceOrderId;
	private long smartBoxCellId;
	private long fromUserId;
	private long toUserId;
	private String toUserPhone;
	private String orderStatus;
	private String orderCode;
	private String orderDescription;
	private String verifyCode;
	private Date createTime;
	private Date finishTime;
	public long getServiceOrderId() {
		return serviceOrderId;
	}
	public void setServiceOrderId(long serviceOrderId) {
		this.serviceOrderId = serviceOrderId;
	}
	public long getSmartBoxCellId() {
		return smartBoxCellId;
	}
	public void setSmartBoxCellId(long smartBoxCellId) {
		this.smartBoxCellId = smartBoxCellId;
	}
	public long getFromUserId() {
		return fromUserId;
	}
	public void setFromUserId(long fromUserId) {
		this.fromUserId = fromUserId;
	}
	public long getToUserId() {
		return toUserId;
	}
	public void setToUserId(long toUserId) {
		this.toUserId = toUserId;
	}
	public String getToUserPhone() {
		return toUserPhone;
	}
	public void setToUserPhone(String toUserPhone) {
		this.toUserPhone = toUserPhone;
	}
	public String getOrderStatus() {
		return orderStatus;
	}
	public void setOrderStatus(String orderStatus) {
		this.orderStatus = orderStatus;
	}
	public String getOrderCode() {
		return orderCode;
	}
	public void setOrderCode(String orderCode) {
		this.orderCode = orderCode;
	}
	public String getOrderDescription() {
		return orderDescription;
	}
	public void setOrderDescription(String orderDescription) {
		this.orderDescription = orderDescription;
	}
	public String getVerifyCode() {
		return verifyCode;
	}
	public void setVerifyCode(String verifyCode) {
		this.verifyCode = verifyCode;
	}
	public Date getCreateTime() {
		return createTime;
	}
	public void setCreateTime(Date createTime) {
		this.createTime = createTime;
	}
	public Date getFinishTime() {
		return finishTime;
	}
	public void setFinishTime(Date finishTime) {
		this.finishTime = finishTime;
	}
	
}
