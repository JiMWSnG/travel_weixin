package com.peanutbox.service;

import com.peanutbox.bean.SmartBoxCell;

public interface D_SmartBoxCellService {
	public String querySmartBoxCellsBySmartBoxId(String reqJson);
	public void updateSmartBoxCellStatus(long smartBoxCellId,String cellStatus);
	public SmartBoxCell querySmartBoxCellById(long smartBoxCellId); 
}
