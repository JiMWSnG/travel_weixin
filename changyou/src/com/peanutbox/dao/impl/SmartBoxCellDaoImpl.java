package com.peanutbox.dao.impl;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.mybatis.spring.support.SqlSessionDaoSupport;

import com.peanutbox.bean.SmartBoxCell;
import com.peanutbox.dao.SmartBoxCellDao;

public class SmartBoxCellDaoImpl extends SqlSessionDaoSupport implements SmartBoxCellDao{

	public List<SmartBoxCell> querySmartBoxCellsBySmartBoxId(long smartBoxId) {
		try {
			List<SmartBoxCell> sbcs = getSqlSession().selectList("com.peanutbox.bean.SmartBoxCell.selectSmartBoxCellBySmartBoxId",smartBoxId);
			return sbcs;
		} catch (Exception e) {
			throw new RuntimeException("查询柜子所有格子时，发生异常",e);
		}
	}

	public SmartBoxCell querySmartBoxCellById(long smartBoxCellId) {
		try {
			SmartBoxCell sbc = getSqlSession().selectOne("com.peanutbox.bean.SmartBoxCell.selectSmartBoxCellById",smartBoxCellId);
			return sbc;
		} catch (Exception e) {
			throw new RuntimeException("根据格子ID查询柜子格子时，发生异常",e);
		}
	}

	public void updateSmartBoxCellStatus(long smartBoxCellId, String status) {
		try {
			Map<String,Object> params = new HashMap<String,Object>();
			params.put("smartBoxCellId", smartBoxCellId);
			params.put("cellStatus", status);
			getSqlSession().update("com.peanutbox.bean.SmartBoxCell.updateSmartBoxCellStatus",params);
		} catch (Exception e) {
			throw new RuntimeException("更新柜子格子状态时，发生异常",e);
		}
		
	}

}
