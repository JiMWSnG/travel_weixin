package com.peanutbox.service;

import java.util.List;

import com.peanutbox.bean.ServiceOrder;
import com.peanutbox.bean.SysUser;

public interface D_ServiceOrderService {
	public void addServiceOrder(ServiceOrder serviceOrder);
	public List<ServiceOrder> queryServiceOrderByUser(SysUser sysUser);
	public List<ServiceOrder> queryServiceOrderByUserAccount(String userAccount);
	public void updateServiceOrderStatus(long serviceOrderId,String orderStatus);

}
