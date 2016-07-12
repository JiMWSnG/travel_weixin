package com.travel.bean;

public class Route extends Product {
	
	public static void main(String[] args){
		Route route = new Route();
		route.setId(12);
		Product route1 = route;
		System.out.print(route1.getId());
		System.out.println(route1.toString());

//		Date date = new Date();
//	System.out.print(	date.getTime());
//		System.out.println(System.currentTimeMillis());
//		System.out.print("helloworld");
	}

	@Override
	public String toString() {
		return "Route [id=" + id + ", picturePath=" + picturePath + ", name=" + name + ", type=" + type
				+ ", description=" + description + ", createTime=" + createTime + ", updateTime=" + updateTime
				+ ", price=" + price + ", location=" + location + ", status=" + status + ", indexs=" + indexs
				+ ", themeId=" + themeId + "]";
	}

	
	
	
}
