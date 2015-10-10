package com.peanutbox.commun;

public class ResponseObj {
	private String rspCode;
	private String rspDesc;
	private String rspParasJson;
	public ResponseObj(){}
	public String getRspCode() {
		return rspCode;
	}
	public void setRspCode(String rspCode) {
		this.rspCode = rspCode;
	}
	public String getRspDesc() {
		return rspDesc;
	}
	public void setRspDesc(String rspDesc) {
		this.rspDesc = rspDesc;
	}
	public String getRspParasJson() {
		return rspParasJson;
	}
	public void setRspParasJson(String rspParasJson) {
		this.rspParasJson = rspParasJson;
	}
	@Override
	public String toString() {
		return "<Envelope>"+
			   "  <Header>"+
			   "	<ActionCode>1</ActionCode>"+
			   "	<SessionId>1000000001201109012344811231</SessionId>"+
			   "	<RspTime>20110901021101</RspTime>"+
			   "	<Response>"+
			   "		<RspCode>"+rspCode+"</RspCode>"+
			   "		<RspDesc>"+rspDesc+"</RspDesc>"+
			   "	</Response>"+
			   "  </Header>"+
			   "  <Body>"+
			   "		<RspParasJson>"+rspParasJson+"</RspParasJson>"+
			   "  </Body>"+
			   "</Envelope>";
	}
	
}
