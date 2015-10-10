package com.peanutbox.bean;

import java.util.Date;

public class SmartBox {
	private long smartBoxId;
	private String smartBoxCode;
	private String smartBoxName;
	private String smartBoxVersion;
	private String smartBoxStatus;
	private String smartBoxUrl ;
	private String smartBoxAddr;
	private Date updateTime;
	private String description;
	public long getSmartBoxId() {
		return smartBoxId;
	}
	public void setSmartBoxId(long smartBoxId) {
		this.smartBoxId = smartBoxId;
	}
	public String getSmartBoxCode() {
		return smartBoxCode;
	}
	public void setSmartBoxCode(String smartBoxCode) {
		this.smartBoxCode = smartBoxCode;
	}
	public String getSmartBoxName() {
		return smartBoxName;
	}
	public void setSmartBoxName(String smartBoxName) {
		this.smartBoxName = smartBoxName;
	}
	public String getSmartBoxVersion() {
		return smartBoxVersion;
	}
	public void setSmartBoxVersion(String smartBoxVersion) {
		this.smartBoxVersion = smartBoxVersion;
	}
	public String getSmartBoxStatus() {
		return smartBoxStatus;
	}
	public void setSmartBoxStatus(String smartBoxStatus) {
		this.smartBoxStatus = smartBoxStatus;
	}
	public String getSmartBoxAddr() {
		return smartBoxAddr;
	}
	public void setSmartBoxAddr(String smartBoxAddr) {
		this.smartBoxAddr = smartBoxAddr;
	}
	public Date getUpdateTime() {
		return updateTime;
	}
	public void setUpdateTime(Date updateTime) {
		this.updateTime = updateTime;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public String getSmartBoxUrl() {
		return smartBoxUrl;
	}
	public void setSmartBoxUrl(String smartBoxUrl) {
		this.smartBoxUrl = smartBoxUrl;
	}
	
}
