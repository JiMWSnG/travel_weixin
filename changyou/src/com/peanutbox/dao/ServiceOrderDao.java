package com.peanutbox.dao;

import java.util.List;

import com.peanutbox.bean.ServiceOrder;
import com.peanutbox.bean.SysUser;

public interface ServiceOrderDao {
	public void addServiceOrder(ServiceOrder serviceOrder);
	public List<ServiceOrder> querySysUserServiceOrder(SysUser sysUser);
	public List<ServiceOrder> queryServiceOrderByUserAccount(String userAccount);
	public void updateServiceOrderStatus(Long serviceOrderId,String orderStatus);
}
