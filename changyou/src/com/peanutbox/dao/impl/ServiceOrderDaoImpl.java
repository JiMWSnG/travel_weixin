package com.peanutbox.dao.impl;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.mybatis.spring.support.SqlSessionDaoSupport;

import com.peanutbox.bean.ServiceOrder;
import com.peanutbox.bean.SysUser;
import com.peanutbox.dao.ServiceOrderDao;

public class ServiceOrderDaoImpl extends SqlSessionDaoSupport implements ServiceOrderDao{

	public void addServiceOrder(ServiceOrder serviceOrder) {
		try {
			getSqlSession().insert("com.peanutbox.bean.ServiceOrder.insert",serviceOrder);
		} catch (Exception e) {
			throw new RuntimeException("添加订单时，发生异常",e);
		}
	}

	public List<ServiceOrder> querySysUserServiceOrder(SysUser sysUser) {
		try {
			List<ServiceOrder> serviceOrders = getSqlSession().selectList("com.peanutbox.bean.ServiceOrder.selectSysUserServiceOrder",sysUser);
			return serviceOrders;
		} catch (Exception e) {
			throw new RuntimeException("查询用户订单时，发生异常",e);
		}
	}
	public List<ServiceOrder> queryServiceOrderByUserAccount(String userAccount) {
		try {
			List<ServiceOrder> serviceOrders = getSqlSession().selectList("com.peanutbox.bean.ServiceOrder.selectServiceOrderByUserAccount",userAccount);
			return serviceOrders;
		} catch (Exception e) {
			throw new RuntimeException("根据用户账号查询用户订单时，发生异常",e);
		}
	}

	public void updateServiceOrderStatus(Long serviceOrderId, String orderStatus) {
		try {
			Map<String,Object> params = new HashMap<String,Object>();
			params.put("serviceOrderId", serviceOrderId);
			params.put("orderStatus", orderStatus);
			getSqlSession().update("com.peanutbox.bean.ServiceOrder.updateServiceOrderStatus",params);
		} catch (Exception e) {
			throw new RuntimeException("更新订单状态时，发生异常",e);
		}
	}

}
