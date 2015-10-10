package com.peanutbox.parse;

import java.io.StringReader;

import javax.xml.parsers.SAXParser;
import javax.xml.parsers.SAXParserFactory;

import org.xml.sax.Attributes;
import org.xml.sax.InputSource;
import org.xml.sax.SAXException;
import org.xml.sax.helpers.DefaultHandler;

import com.peanutbox.commun.ResponseObj;
import com.peanutbox.constant.Constants;
import com.peanutbox.exception.SmartBoxException;


public class ResponseMsgParse extends DefaultHandler{
	
	/*请求对象*/
	private ResponseObj responseObj ; 
	

	@SuppressWarnings("unchecked")
	private java.util.Stack tags=new java.util.Stack();
	
	 public ResponseObj parserResponseMsg(String inMsg) throws SmartBoxException{
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
	            return responseObj;
	        }catch(Exception e){
	            throw new SmartBoxException(Constants.ERROR_CODE_9999,"xml格式出错",e);
	        }
	 }
	 
	 public void characters(char[] ch, int start, int length) throws SAXException {
		 String tag=(String) tags.peek();
		 if(tag.equals("RspCode")) responseObj.setRspCode(new String(ch,start,length));
		 if(tag.equals("RspDesc")) responseObj.setRspDesc(new String(ch,start,length));
		 if(tag.equals("RspParasJson")) responseObj.setRspParasJson(new String(ch,start,length));
	 }
	
	 
	 @SuppressWarnings("unchecked")
	public void startElement(String uri, String localName, String name,Attributes attributes) throws SAXException {
		 tags.push(name);
		 if(name.equals("Envelope")){
			 responseObj = new ResponseObj ();
	     }
	 }
	 
	 public void endElement(String uri, String localName, String name)throws SAXException {
		 tags.pop();
	 }
	 
	 public static void main(String[] args) throws SmartBoxException {
		 ResponseMsgParse parse = new ResponseMsgParse();
		 /*String inMsg =  
							" <Envelope>"+
							"    <Header>"+
								"	<ActionCode>1</ActionCode>"+
								"	<SessionId>1000000001201109012344811231</SessionId>"+
								"	<RspTime>20110901021101</RspTime>"+
								"	<Response>"+
								"		<RspType>0</RspType>"+
								"		<RspCode>0000</RspCode>"+
								"		<RspDesc>成功</RspDesc>"+
								"	</Response>"+
							  "  </Header>"+
							 "   <Body>"+
							"		<RspParasJson>quae1divum1incedo</RspParasJson>"+
							"    </Body>"+
							"</Envelope>";*/
		 String inMsg = "<Envelope>  <Header>	<ActionCode>1</ActionCode>	<SessionId>1000000001201109012344811231</SessionId>	<RspTime>20110901021101</RspTime>	<Response>		<RspCode>0000</RspCode>		<RspDesc>SUCCESS</RspDesc>	</Response>  </Header>  <Body>		<RspParasJson>[{\"cellPosition\":\"第一个\",\"createTime\":\"2015-06-14 18:06:37\",\"finishTime\":\"2015-06-14 18:06:37\",\"fromUserId\":1,\"orderCode\":null,\"orderDescription\":\"qqq\",\"orderStatus\":\"01\",\"serviceOrderId\":17,\"smartBoxAddr\":\"测试01\",\"smartBoxCellId\":1,\"toUserId\":1,\"toUserPhone\":\"18010181009\",\"verifyCode\":null},{\"cellPosition\":\"第二个\",\"createTime\":\"2015-06-14 17:35:52\",\"finishTime\":\"2015-06-14 17:35:52\",\"fromUserId\":1,\"orderCode\":null,\"orderDescription\":\"qqq\",\"orderStatus\":\"01\",\"serviceOrderId\":14,\"smartBoxAddr\":\"测试01\",\"smartBoxCellId\":2,\"toUserId\":1,\"toUserPhone\":\"18010181009\",\"verifyCode\":null},{\"cellPosition\":\"第二个\",\"createTime\":\"2015-06-14 17:39:53\",\"finishTime\":\"2015-06-14 17:39:53\",\"fromUserId\":1,\"orderCode\":null,\"orderDescription\":\"qq\n\",\"orderStatus\":\"01\",\"serviceOrderId\":15,\"smartBoxAddr\":\"北京语言大学3号宿舍楼\",\"smartBoxCellId\":4,\"toUserId\":1,\"toUserPhone\":\"18010181009\",\"verifyCode\":null},{\"cellPosition\":\"第一个\",\"createTime\":\"2015-06-14 17:40:20\",\"finishTime\":\"2015-06-14 17:40:20\",\"fromUserId\":1,\"orderCode\":null,\"orderDescription\":\"qqq\",\"orderStatus\":\"01\",\"serviceOrderId\":16,\"smartBoxAddr\":\"北京语言大学3号宿舍楼\",\"smartBoxCellId\":3,\"toUserId\":1,\"toUserPhone\":\"18010181009\",\"verifyCode\":null}]</RspParasJson>  </Body></Envelope>";
		 ResponseObj responseObj = parse.parserResponseMsg(inMsg);
		 System.out.println(responseObj.getRspParasJson());
	}
}
