package com.peanutbox.util;

import org.apache.commons.httpclient.DefaultHttpMethodRetryHandler;
import org.apache.commons.httpclient.HttpClient;
import org.apache.commons.httpclient.HttpStatus;
import org.apache.commons.httpclient.methods.PostMethod;
import org.apache.commons.httpclient.methods.StringRequestEntity;
import org.apache.commons.httpclient.params.HttpMethodParams;

public class ClientUtil {
	
	public static String exchange(String inMsg,String url){
		try{
			PostMethod post = null ;
			HttpClient httpClient = new HttpClient();
	    	String respMessage = null;
	        post = new PostMethod(url);
	        post.setRequestEntity(new StringRequestEntity(inMsg,"text/xml; charset=UTF-8","UTF-8"));
	        httpClient.getParams().setSoTimeout(10*1000);
	        int retryCount = 0; 
	        httpClient.getParams().setParameter(HttpMethodParams.RETRY_HANDLER,
	        new DefaultHttpMethodRetryHandler(retryCount, false));
	        int result = httpClient.executeMethod(post);
	        if(result != HttpStatus.SC_OK){
	        }else{
	            respMessage = post.getResponseBodyAsString();
	        }
	        return respMessage;
		}catch (Exception e) {
			return null ;
		}
	}
}
