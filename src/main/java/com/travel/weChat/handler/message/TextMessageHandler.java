//package com.travel.weChat.handler.message;
//
//import com.bm.insurance.commonservice.wechat.AccessTokenApi;
//import com.github.sd4324530.fastweixin.handle.MessageHandle;
//import com.github.sd4324530.fastweixin.message.BaseMsg;
//import com.github.sd4324530.fastweixin.message.req.TextReqMsg;
//import org.apache.commons.logging.Log;
//import org.apache.commons.logging.LogFactory;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.stereotype.Service;
//
///**
// * Created by admin on 2015/11/24.
// */
//@Service
//public class TextMessageHandler implements MessageHandle<TextReqMsg> {
//
//    protected Log logger = LogFactory.getLog(TextMessageHandler.class);
//
//
//    @Autowired
//    private AccessTokenApi accessTokenApi;
//
//    public BaseMsg handle(TextReqMsg message) {
//        return null;
//    }
//
//    public boolean beforeHandle(TextReqMsg message) {
//        logger.info("openId="+message.getFromUserName());
//        accessTokenApi.getAccessToken();
//        return false;
//    }
//}
