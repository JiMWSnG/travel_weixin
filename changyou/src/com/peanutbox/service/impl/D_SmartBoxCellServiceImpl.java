package com.peanutbox.service.impl;

import java.util.List;
import java.util.Map;

import com.peanutbox.bean.SmartBoxCell;
import com.peanutbox.dao.SmartBoxCellDao;
import com.peanutbox.service.D_SmartBoxCellService;
import com.peanutbox.util.JsonUtil;

public class D_SmartBoxCellServiceImpl implements D_SmartBoxCellService {
	private SmartBoxCellDao smartBoxCellDao;

	public String querySmartBoxCellsBySmartBoxId(String reqJson) {
		Map<String,Object> reqMap = JsonUtil.fromJsonToMap(reqJson);
		Integer smartBoxId = (Integer)reqMap.get("smartBoxId");
		List<SmartBoxCell> smartBoxCells = smartBoxCellDao.querySmartBoxCellsBySmartBoxId(smartBoxId);
		String retJson;
		try {
			retJson = JsonUtil.obj2Json(smartBoxCells);
			return retJson;
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}

	public SmartBoxCellDao getSmartBoxCellDao() {
		return smartBoxCellDao;
	}

	public void setSmartBoxCellDao(SmartBoxCellDao smartBoxCellDao) {
		this.smartBoxCellDao = smartBoxCellDao;
	}

	public void updateSmartBoxCellStatus(long smartBoxCellId, String cellStatus) {
		smartBoxCellDao.updateSmartBoxCellStatus(smartBoxCellId, cellStatus);
	}

	public SmartBoxCell querySmartBoxCellById(long smartBoxCellId) {
		SmartBoxCell sbc = smartBoxCellDao.querySmartBoxCellById(smartBoxCellId);
		return sbc;
	}


}
