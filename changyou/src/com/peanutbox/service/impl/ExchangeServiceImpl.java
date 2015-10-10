package com.peanutbox.service.impl;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

import org.apache.log4j.Logger;
import org.springframework.context.ApplicationContext;
import org.springframework.web.context.ContextLoader;

import com.peanutbox.commun.RequestObj;
import com.peanutbox.exception.SmartBoxException;
import com.peanutbox.parse.RequestMsgParse;
import com.peanutbox.service.ExchangeService;
import com.peanutbox.commun.ResponseObj;

public class ExchangeServiceImpl implements ExchangeService {
	private static Logger logger = Logger.getLogger(ExchangeServiceImpl.class);

	public String service(String message) {
		ResponseObj responseObj = new ResponseObj();
		try {
			String jsonMsg = null;
			RequestMsgParse parse = new RequestMsgParse();
			RequestObj requestObj = parse.parserAgentCommand(message);
			ApplicationContext applicationContext = ContextLoader.getCurrentWebApplicationContext();
			Object object = applicationContext.getBean(requestObj.getBeanName());
			Class clazz = object.getClass();
			Method m1 = clazz.getDeclaredMethod(requestObj.getMethodName(),String.class);
			jsonMsg = (String) m1.invoke(object, requestObj.getReqParasJson());
			responseObj.setRspCode("0000");
			responseObj.setRspDesc("SUCCESS");
			responseObj.setRspParasJson(jsonMsg);
		} catch(SmartBoxException e){
			logger.error(e.getMessage(), e);
			responseObj.setRspCode(e.getCode());
			responseObj.setRspDesc(e.getDesc());
		} catch (Throwable e) {
			if (e instanceof InvocationTargetException) {
				e = ((InvocationTargetException) e).getTargetException();
			}
			logger.error(e.getMessage(), e);
			responseObj.setRspCode("0001");
			responseObj.setRspDesc(e.getMessage());
		}
		logger.debug(responseObj.toString());
		return responseObj.toString();
	}

}
