package com.peanutbox.service.impl;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.log4j.Logger;

import com.peanutbox.bean.ServiceOrder;
import com.peanutbox.bean.SmartBoxCell;
import com.peanutbox.service.B_BuyerOperationService;
import com.peanutbox.service.D_ServiceOrderService;
import com.peanutbox.service.D_SmartBoxCellService;
import com.peanutbox.service.D_SysUserService;
import com.peanutbox.util.ClientUtil;
import com.peanutbox.util.JsonUtil;
import com.peanutbox.web.SmartBoxServlet;

public class B_BuyerOperationServiceImpl implements B_BuyerOperationService{
	private static Logger logger = Logger.getLogger(B_BuyerOperationServiceImpl.class);

	private D_SysUserService sysUserService;
	private D_ServiceOrderService serviceOrderService;
	private D_SmartBoxCellService smartBoxCellService;
	public D_SysUserService getSysUserService() {
		return sysUserService;
	}
	public void setSysUserService(D_SysUserService sysUserService) {
		this.sysUserService = sysUserService;
	}
	public D_ServiceOrderService getServiceOrderService() {
		return serviceOrderService;
	}
	public void setServiceOrderService(D_ServiceOrderService serviceOrderService) {
		this.serviceOrderService = serviceOrderService;
	}
	public String queryServiceOrderByUserAccount(String reqJson) {
		Map<String,Object> reqMap = JsonUtil.fromJsonToMap(reqJson);
		String userAccount = (String)reqMap.get("userAccount");
		List<ServiceOrder> serviceOrders = serviceOrderService.queryServiceOrderByUserAccount(userAccount);
		try {
			String retJson = JsonUtil.obj2Json(serviceOrders);
			return retJson;
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}
	public String takeThings(String reqJson) {
			Map<String,Object> reqMap = JsonUtil.fromJsonToMap(reqJson);
			Integer smartBoxCellId = (Integer)reqMap.get("smartBoxCellId");
			Integer serviceOrderId = (Integer)reqMap.get("serviceOrderId");
			SmartBoxCell sbc = smartBoxCellService.querySmartBoxCellById(smartBoxCellId);
			try {
				Map<String,Object> retMap = new HashMap<String,Object>();
				smartBoxCellService.updateSmartBoxCellStatus(smartBoxCellId, "00");
				serviceOrderService.updateServiceOrderStatus(serviceOrderId, "02");
				logger.debug(sbc.getSmartBox().getSmartBoxUrl());
				ClientUtil.exchange(sbc.getCellPort()+"", sbc.getSmartBox().getSmartBoxUrl());
				retMap.put("result", true);
				String retJson = JsonUtil.obj2Json(retMap);
				return retJson;
			} catch (Exception e) {
				e.printStackTrace();
			}
			return null;
	}
	public D_SmartBoxCellService getSmartBoxCellService() {
		return smartBoxCellService;
	}
	public void setSmartBoxCellService(D_SmartBoxCellService smartBoxCellService) {
		this.smartBoxCellService = smartBoxCellService;
	}


}
