package com.travel.bean;

public class Ticket  extends Product{

	@Override
	public String toString() {
		return "Ticket [id=" + id + ", picturePath=" + picturePath + ", name=" + name + ", type=" + type
				+ ", description=" + description + ", createTime=" + createTime + ", updateTime=" + updateTime
				+ ", price=" + price + ", location=" + location + ", status=" + status + ", indexs=" + indexs
				+ ", themeId=" + themeId + "]";
	}

	
	
}
