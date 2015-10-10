package com.peanutbox.dao;

import java.util.List;

import com.peanutbox.bean.SmartBoxCell;

public interface SmartBoxCellDao {
	public List<SmartBoxCell> querySmartBoxCellsBySmartBoxId(long smartBoxId);
	public SmartBoxCell querySmartBoxCellById(long smartBoxCellId);
	public void updateSmartBoxCellStatus(long smartBoxCellId,String status);
}
