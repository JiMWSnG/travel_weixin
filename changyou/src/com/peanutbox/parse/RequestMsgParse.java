package com.peanutbox.parse;

import java.io.StringReader;
import java.util.ArrayList;

import javax.xml.parsers.SAXParser;
import javax.xml.parsers.SAXParserFactory;

import org.xml.sax.Attributes;
import org.xml.sax.InputSource;
import org.xml.sax.SAXException;
import org.xml.sax.helpers.DefaultHandler;

import com.peanutbox.commun.RequestObj;
import com.peanutbox.constant.Constants;
import com.peanutbox.exception.SmartBoxException;


public class RequestMsgParse extends DefaultHandler{
	
	/*请求对象*/
	private RequestObj requestObj ; 
	

	@SuppressWarnings("unchecked")
	private java.util.Stack tags=new java.util.Stack();
	
	 public RequestObj parserAgentCommand(String inMsg) throws SmartBoxException{
		 SAXParserFactory spf = SAXParserFactory.newInstance();
	     SAXParser saxParser=null;
	     try{
	            saxParser = spf.newSAXParser();
	            saxParser.setProperty("http://apache.org/xml/properties/input-buffer-size",new Integer(20*2048));//设置读入xml长度参数
	            
	        }catch(Exception e){
	            throw new SmartBoxException(Constants.ERROR_CODE_9999,"xml格式出错",e);
	        }
	        try{
	            saxParser.parse(new   InputSource(new   StringReader(inMsg)),this);
	            return requestObj;
	        }catch(Exception e){
	            throw new SmartBoxException(Constants.ERROR_CODE_9999,"xml格式出错",e);
	        }
	 }
	 
	 public void characters(char[] ch, int start, int length) throws SAXException {
		 String tag=(String) tags.peek();
		 if(tag.equals("BeanName")) requestObj.setBeanName(new String(ch,start,length));
		 if(tag.equals("MethodName")) requestObj.setMethodName(new String(ch,start,length));
		 if(tag.equals("ReqParasJson")) requestObj.setReqParasJson(new String(ch,start,length));
	 }
	
	 
	 @SuppressWarnings("unchecked")
	public void startElement(String uri, String localName, String name,Attributes attributes) throws SAXException {
		 tags.push(name);
		 if(name.equals("Envelope")){
			 requestObj = new RequestObj ();
	     }
	 }
	 
	 public void endElement(String uri, String localName, String name)throws SAXException {
		 tags.pop();
	 }
	 
	 public static void main(String[] args) throws SmartBoxException {
		 RequestMsgParse parse = new RequestMsgParse();
		 String inMsg =   "<Envelope>"
						 +" <Header>"
						 +"	<ActionCode>0</ActionCode>"
						 +"	<SessionId>verrantque1per1auras</SessionId>"
						 +"	<ServiceLevel>1</ServiceLevel>"
						 +"	<BusCode>BUS33001</BusCode>"
						 +"	<ServiceCode>SVC33003</ServiceCode>"
						 +"	<ServiceContractVer>SVC3300320110501</ServiceContractVer>"
						 +"	<SrcOrgID>100000</SrcOrgID>"
						 +"	<SrcSysID>1000000063</SrcSysID>"
						 +"	<ReqTime>20101213121212</ReqTime>"
						 +" </Header>"
						 +" <Body>"
						 +"	<BeanName>smartBoxDao</BeanName>"
						 +"	<MethodName>addSmartBox</MethodName>"
						 +"	<ReqParasJson>quae1divum1incedo</ReqParasJson>"
						 +" </Body>"
						 +"</Envelope>";
		 RequestObj requestObj = parse.parserAgentCommand(inMsg);
		 System.out.println(requestObj);
	}
}
