package com.travel.dao;

import com.travel.bean.ProductCalendar;

public interface CalendarDao {
	public ProductCalendar  queryCalendar(Integer productId);
	public int addCalendar(ProductCalendar productCalendar);
	public int updateCalendar(ProductCalendar productCalendar);
	public int removeCalendar(Integer id);
}
