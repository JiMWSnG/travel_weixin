package com.peanutbox.commun;

public class RequestObj {
	private String beanName;
	private String methodName;
	private String reqParasJson;
	
	public RequestObj(){}
	public RequestObj(String reqXml){
		
	}
	public String getBeanName() {
		return beanName;
	}
	public void setBeanName(String beanName) {
		this.beanName = beanName;
	}
	public String getMethodName() {
		return methodName;
	}
	public void setMethodName(String methodName) {
		this.methodName = methodName;
	}
	public String getReqParasJson() {
		return reqParasJson;
	}
	public void setReqParasJson(String reqParasJson) {
		this.reqParasJson = reqParasJson;
	}
	@Override
	public String toString() {
		// TODO Auto-generated method stub
		return "beanName:"+beanName+",methodName"+methodName+",reqParasJson"+reqParasJson;
	}
	
}
