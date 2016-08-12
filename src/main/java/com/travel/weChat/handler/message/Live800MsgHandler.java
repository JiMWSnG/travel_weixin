//package com.travel.weChat.handler.message;
//
//import com.bm.insurance.api.weixin.service.Live800Service;
//import com.bm.insurance.cloud.orm.entity.PersonalUserAccount;
//import com.bm.insurance.commonservice.constant.ConstantService;
//import com.bm.insurance.commonservice.wechat.WeiXinFanService;
//import com.github.sd4324530.fastweixin.handle.MessageHandle;
//import com.github.sd4324530.fastweixin.message.BaseMsg;
//import com.github.sd4324530.fastweixin.message.RespType;
//import com.github.sd4324530.fastweixin.message.req.*;
//import com.github.sd4324530.fastweixin.message.util.MessageBuilder;
//import org.apache.log4j.Logger;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.stereotype.Service;
//
///**
// * Created by admin on 2015/11/24.
// * 客服消息
// */
//@Service
//public class Live800MsgHandler implements MessageHandle<BaseReqMsg> {
//
//    private Logger logger = Logger.getLogger(Live800MsgHandler.class);
//
//    @Autowired
//    private Live800Service live800Service;
//
//    @Autowired
//    private WeiXinFanService weiXinFanService;
//
//    public BaseMsg handle(BaseReqMsg message) {
//
//
//
//        return null;
//    }
//
//    public boolean beforeHandle(BaseReqMsg message) {
//        MessageBuilder mb = new MessageBuilder();
//        mb.addData("ToUserName", message.getToUserName());
//        mb.addData("FromUserName", message.getFromUserName());
//        mb.addTag("CreateTime", ""+message.getCreateTime());
//        mb.addData("MsgType", message.getMsgType());
//        if(message.getMsgType().equals(RespType.TEXT)){
//            PersonalUserAccount account = weiXinFanService.findAccountByOpenId(message.getFromUserName());
//            if(account != null){
//                mb.addData("Content", new StringBuffer(((TextReqMsg)message).getContent()).append("[").append(account.getPname()).append("-").append(account.getIdcard()).append("]").toString());
//            }else{
//                mb.addData("Content", ((TextReqMsg)message).getContent());
//            }
//        }else if(message.getMsgType().equals(RespType.IMAGE)){
//            mb.addData("PicUrl", ((ImageReqMsg)message).getPicUrl());
//            mb.addData("MediaId", ((ImageReqMsg)message).getMediaId());
//        }else if(message.getMsgType().equals(RespType.VOICE)){
//            mb.addData("MediaId", ((VoiceReqMsg)message).getMediaId());
//            mb.addData("Recognition", ((VoiceReqMsg)message).getRecognition());
//        }else if(message.getMsgType().equals(RespType.VIDEO)){
//            mb.addData("MediaId", ((VideoReqMsg)message).getMediaId());
//            mb.addData("ThumbMediaId", ((VideoReqMsg)message).getThumbMediaId());
//        }
//        mb.addTag("MsgId", message.getMsgId());
//        mb.surroundWith("xml");
//        String s = mb.toString();
//        logger.debug(s);
//        live800Service.sendMsg(s);
//        return false;
//    }
//}
