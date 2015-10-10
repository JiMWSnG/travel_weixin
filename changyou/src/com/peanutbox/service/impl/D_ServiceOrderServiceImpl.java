package com.peanutbox.service.impl;

import java.util.List;

import com.peanutbox.bean.ServiceOrder;
import com.peanutbox.bean.SysUser;
import com.peanutbox.dao.ServiceOrderDao;
import com.peanutbox.service.D_ServiceOrderService;

public class D_ServiceOrderServiceImpl implements D_ServiceOrderService {
	private ServiceOrderDao serviceOrderDao;

	public ServiceOrderDao getServiceOrderDao() {
		return serviceOrderDao;
	}

	public void setServiceOrderDao(ServiceOrderDao serviceOrderDao) {
		this.serviceOrderDao = serviceOrderDao;
	}

	public void addServiceOrder(ServiceOrder serviceOrder) {
		serviceOrderDao.addServiceOrder(serviceOrder);
	}

	public List<ServiceOrder> queryServiceOrderByUser(SysUser sysUser) {
		return serviceOrderDao.querySysUserServiceOrder(sysUser);
	}

	public List<ServiceOrder> queryServiceOrderByUserAccount(String userAccount) {

		return serviceOrderDao.queryServiceOrderByUserAccount(userAccount);
	}

	public void updateServiceOrderStatus(long serviceOrderId, String orderStatus) {
		serviceOrderDao.updateServiceOrderStatus(serviceOrderId, orderStatus);
	}
	

}
