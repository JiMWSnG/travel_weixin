//package com.travel.weChat.handler.message;
//
//import com.bm.insurance.commonservice.wechat.WeiXinFanService;
//import com.github.sd4324530.fastweixin.handle.MessageHandle;
//import com.github.sd4324530.fastweixin.message.BaseMsg;
//import com.github.sd4324530.fastweixin.message.TextMsg;
//import com.github.sd4324530.fastweixin.message.req.TextReqMsg;
//import org.apache.commons.logging.Log;
//import org.apache.commons.logging.LogFactory;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.stereotype.Service;
//
///**
// * Created by admin on 2015/11/24.
// * 解绑微信
// */
//@Service
//public class LogOffMsgHandler implements MessageHandle<TextReqMsg> {
//
//    protected Log logger = LogFactory.getLog(LogOffMsgHandler.class);
//
//
//    @Autowired
//    private WeiXinFanService weiXinFanService;
//
//    public BaseMsg handle(TextReqMsg message) {
//        TextMsg textMsg = new TextMsg();
//        textMsg.setToUserName(message.getFromUserName());
//        textMsg.setFromUserName(message.getToUserName());
//        textMsg.setCreateTime(System.currentTimeMillis());
//
//
//        if(weiXinFanService.logOff(message.getFromUserName())){
//            textMsg.setContent("解绑微信成功！");
//        }else{
//            textMsg.setContent("您没有绑定微信，无需解绑!");
//        }
//
//        return textMsg;
//    }
//
//    public boolean beforeHandle(TextReqMsg message) {
//        if("我要解绑".equals(message.getContent().trim())){
//            return true;
//        }
//        return false;
//    }
//}
