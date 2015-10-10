package com.peanutbox.dao;

import java.util.List;

import com.peanutbox.bean.SmartBox;

public interface SmartBoxDao {
	public void addSmartBox(SmartBox smartBox);
	public String addSmartBox(String inStr);
	public List<SmartBox> queryAllSmartBox();
}
