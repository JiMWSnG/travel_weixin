package com.peanutbox.bean;

import java.util.Date;

public class SmartBoxCell {
	private long smartBoxCellId;
	private SmartBox smartBox;
	private String cellCode;
	private String cellPosition;
	private int cellPort;
	private String cellStatus;
	private String cellSize;
	private Date updateTime;
	public long getSmartBoxCellId() {
		return smartBoxCellId;
	}
	public void setSmartBoxCellId(long smartBoxCellId) {
		this.smartBoxCellId = smartBoxCellId;
	}
	public String getCellCode() {
		return cellCode;
	}
	public void setCellCode(String cellCode) {
		this.cellCode = cellCode;
	}
	public String getCellPosition() {
		return cellPosition;
	}
	public void setCellPosition(String cellPosition) {
		this.cellPosition = cellPosition;
	}
	public String getCellStatus() {
		return cellStatus;
	}
	public void setCellStatus(String cellStatus) {
		this.cellStatus = cellStatus;
	}
	public String getCellSize() {
		return cellSize;
	}
	public void setCellSize(String cellSize) {
		this.cellSize = cellSize;
	}
	public Date getUpdateTime() {
		return updateTime;
	}
	public void setUpdateTime(Date updateTime) {
		this.updateTime = updateTime;
	}
	public SmartBox getSmartBox() {
		return smartBox;
	}
	public void setSmartBox(SmartBox smartBox) {
		this.smartBox = smartBox;
	}
	public int getCellPort() {
		return cellPort;
	}
	public void setCellPort(int cellPort) {
		this.cellPort = cellPort;
	}
	
}
