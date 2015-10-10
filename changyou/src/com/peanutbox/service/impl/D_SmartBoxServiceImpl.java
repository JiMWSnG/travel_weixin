package com.peanutbox.service.impl;

import java.util.List;

import com.peanutbox.bean.SmartBox;
import com.peanutbox.dao.SmartBoxDao;
import com.peanutbox.service.D_SmartBoxService;
import com.peanutbox.util.JsonUtil;

public class D_SmartBoxServiceImpl implements D_SmartBoxService {
	private SmartBoxDao smartBoxDao;
	public String queryAllSmartBox(String reqJson) {
		List<SmartBox> sbs = smartBoxDao.queryAllSmartBox();
		try {
			String json = JsonUtil.obj2Json(sbs);
			return json;
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return null;
	}
	public SmartBoxDao getSmartBoxDao() {
		return smartBoxDao;
	}
	public void setSmartBoxDao(SmartBoxDao smartBoxDao) {
		this.smartBoxDao = smartBoxDao;
	}

}
