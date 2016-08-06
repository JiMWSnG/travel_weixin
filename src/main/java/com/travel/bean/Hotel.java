package com.travel.bean;

public class Hotel extends Product {
	private int hotelMetaId;

	public int getHotelMetaId() {
		return hotelMetaId;
	}

	public void setHotelMetaId(int hotelMetaId) {
		this.hotelMetaId = hotelMetaId;
	}

	@Override
	public String toString() {
		return "Hotel [id=" + id + ", picturePath=" + picturePath + ", name=" + name + ", type=" + type
				+ ", description=" + description + ", createTime=" + createTime + ", updateTime=" + updateTime
				+ ", price=" + price + ", location=" + location + ", status=" + status + ", indexs=" + indexs
				+ ", themeId=" + themeId + "]";
	}

}
