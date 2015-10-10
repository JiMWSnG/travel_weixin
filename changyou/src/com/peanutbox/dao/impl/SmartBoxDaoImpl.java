package com.peanutbox.dao.impl;

import java.util.Date;
import java.util.List;

import org.mybatis.spring.support.SqlSessionDaoSupport;

import com.peanutbox.bean.SmartBox;
import com.peanutbox.dao.SmartBoxDao;

public class SmartBoxDaoImpl extends SqlSessionDaoSupport implements SmartBoxDao{

	public void addSmartBox(SmartBox smartBox) {
		getSqlSession().insert("com.peanutbox.bean.SmartBox.insert",smartBox);
	}

	public String addSmartBox(String inStr){
		try {
			SmartBox sb = new SmartBox();
			sb.setSmartBoxCode("0001");
			sb.setSmartBoxName("test");
			sb.setSmartBoxAddr("test");
			sb.setSmartBoxVersion("01");
			sb.setSmartBoxStatus("-1");
			sb.setSmartBoxUrl("192.168.1.40");
			sb.setUpdateTime(new Date());
			sb.setDescription("测试测试");
			getSqlSession().insert("com.peanutbox.bean.SmartBox.insert",sb);
			return "{result:ok}";
		} catch (Exception e) {
			throw new RuntimeException("发生异常",e);
		}
	}

	public List<SmartBox> queryAllSmartBox() {
		try {
			List<SmartBox> sbs = getSqlSession().selectList("com.peanutbox.bean.SmartBox.selectAll");
			return sbs;
		} catch (Exception e) {
			throw new RuntimeException("查询所有柜子时，发生异常",e);
		}
	}

}
