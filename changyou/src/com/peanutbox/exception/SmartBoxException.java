package com.peanutbox.exception;

public class SmartBoxException extends Exception{

	private static final long serialVersionUID = 1L ;
	
	/*异常编码*/
	private String code ;
	
	/*异常信息*/
	private String desc ;
	
	/*异常对象*/
	private Throwable th ; 
	
	public SmartBoxException(String code , String desc , Throwable th){
		this.code = code ;
		this.desc = desc ;
		this.th = th ; 
	}

	public String toString() {
		return " code is "+code+";desc is "+desc+"exception is "+th;
	}

	public String getCode() {
		return code;
	}

	public void setCode(String code) {
		this.code = code;
	}

	public String getDesc() {
		return desc;
	}

	public void setDesc(String desc) {
		this.desc = desc;
	}
	
	

}
