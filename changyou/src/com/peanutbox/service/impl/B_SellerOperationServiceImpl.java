package com.peanutbox.service.impl;

import java.util.HashMap;
import java.util.Map;

import com.peanutbox.bean.ServiceOrder;
import com.peanutbox.bean.SmartBoxCell;
import com.peanutbox.bean.SysUser;
import com.peanutbox.service.B_SellerOperationService;
import com.peanutbox.service.D_ServiceOrderService;
import com.peanutbox.service.D_SmartBoxCellService;
import com.peanutbox.service.D_SysUserService;
import com.peanutbox.util.ClientUtil;
import com.peanutbox.util.JsonUtil;

public class B_SellerOperationServiceImpl implements B_SellerOperationService{
	private D_SmartBoxCellService smartBoxCellService; 
	private D_ServiceOrderService serviceOrderService;
	private D_SysUserService sysUserService;
	/**
	 * 预占用格子
	 */
	public String reserveSmartBoxCell(String reqJson) {
		Map<String,Object> reqMap = JsonUtil.fromJsonToMap(reqJson);
		Integer smartBoxCellId = (Integer)reqMap.get("smartBoxCellId");
		SmartBoxCell sbc = smartBoxCellService.querySmartBoxCellById(smartBoxCellId);
		Map<String,Object> retMap = new HashMap<String,Object>();
		if("00".equals(sbc.getCellStatus())){
			smartBoxCellService.updateSmartBoxCellStatus(smartBoxCellId, "02");
			retMap.put("result", true);
		}else{
			retMap.put("result", false);
			retMap.put("reason","该格子状态不是空闲状态！");
		}
		String retJson = null;
		try {
			retJson = JsonUtil.obj2Json(retMap);
			return retJson;
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return retJson;
	}
	/**
	 * 创建订单
	 */
	public String createOrder(String reqJson) {
		Map<String,Object> reqMap = JsonUtil.fromJsonToMap(reqJson);
		Map<String,Object> retMap = new HashMap<String,Object>();
		Integer smartBoxCellId = (Integer)reqMap.get("smartBoxCellId");
		Integer fromUserId = (Integer)reqMap.get("fromUserId");
		String phoneNumber = (String)reqMap.get("phoneNumber");
		String orderDescription = (String)reqMap.get("orderDescription");
		SmartBoxCell sbc = smartBoxCellService.querySmartBoxCellById(smartBoxCellId);
		SysUser toUser = sysUserService.querySysUserByPhoneNumber(phoneNumber);
		if("00".equals(sbc.getCellStatus())){
			ServiceOrder so = new ServiceOrder();
			so.setSmartBoxCellId(smartBoxCellId);
			so.setFromUserId(fromUserId);
			if(toUser != null){
				so.setToUserId(toUser.getSysUserId());
			}
			so.setToUserPhone(phoneNumber);
			so.setOrderStatus("01");
			so.setOrderCode("TEST0001");
			so.setOrderDescription(orderDescription);
			serviceOrderService.addServiceOrder(so);
			smartBoxCellService.updateSmartBoxCellStatus(smartBoxCellId, "01");
			ClientUtil.exchange(sbc.getCellPort()+"", sbc.getSmartBox().getSmartBoxUrl());
			retMap.put("result", true);
		}else{
			retMap.put("result", false);
			retMap.put("reason","该格子状态不是空闲状态！");
		}
		String retJson = null;
		try {
			retJson = JsonUtil.obj2Json(retMap);
			return retJson;
		} catch (Exception e) {
			e.printStackTrace();
		}
		return retJson;
	}
	public D_SmartBoxCellService getSmartBoxCellService() {
		return smartBoxCellService;
	}
	public void setSmartBoxCellService(D_SmartBoxCellService smartBoxCellService) {
		this.smartBoxCellService = smartBoxCellService;
	}
	public D_ServiceOrderService getServiceOrderService() {
		return serviceOrderService;
	}
	public void setServiceOrderService(D_ServiceOrderService serviceOrderService) {
		this.serviceOrderService = serviceOrderService;
	}
	public D_SysUserService getSysUserService() {
		return sysUserService;
	}
	public void setSysUserService(D_SysUserService sysUserService) {
		this.sysUserService = sysUserService;
	}
	

}
