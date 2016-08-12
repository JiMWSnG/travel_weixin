//package com.travel.weChat.handler.message;
//
//import com.bm.insurance.commonservice.message.MessageService;
//import com.github.sd4324530.fastweixin.handle.MessageHandle;
//import com.github.sd4324530.fastweixin.message.BaseMsg;
//import com.github.sd4324530.fastweixin.message.TextMsg;
//import com.github.sd4324530.fastweixin.message.req.TextReqMsg;
//import org.apache.log4j.Logger;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.stereotype.Service;
//
///**
// * Created by admin on 2015/11/24.
// * 关键词
// */
//@Service
//public class KeyWordMsgHandler implements MessageHandle<TextReqMsg> {
//
//    private Logger logger = Logger.getLogger(KeyWordMsgHandler.class);
//
//    @Autowired
//    private MessageService messageService;
//
//    public BaseMsg handle(TextReqMsg message) {
//        messageService.statsBalance();
//        TextMsg textMsg = new TextMsg();
//        textMsg.setToUserName(message.getFromUserName());
//        textMsg.setFromUserName(message.getToUserName());
//        textMsg.setCreateTime(System.currentTimeMillis());
//        textMsg.setContent(message.getFromUserName());
//        return textMsg;
//    }
//
//    public boolean beforeHandle(TextReqMsg message) {
//        if("短信渠道".equals(message.getContent().trim())){
//            return true;
//        }
//        return false;
//    }
//}
