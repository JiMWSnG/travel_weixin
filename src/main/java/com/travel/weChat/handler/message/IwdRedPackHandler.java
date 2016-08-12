//package com.travel.weChat.handler.message;
//
//import com.bm.insurance.cloud.bean.Response;
//import com.bm.insurance.commonservice.wechat.RedPackService;
//import com.bm.insurance.constans.WeiXinConstant;
//import com.github.sd4324530.fastweixin.handle.MessageHandle;
//import com.github.sd4324530.fastweixin.message.BaseMsg;
//import com.github.sd4324530.fastweixin.message.TextMsg;
//import com.github.sd4324530.fastweixin.message.req.TextReqMsg;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.stereotype.Service;
//
///**
// * 38激活领红包处理类
// */
//@Service
//@Deprecated
//public class IwdRedPackHandler implements MessageHandle<TextReqMsg> {
//
//    @Autowired
//    private RedPackService redPackService;
//
//    public BaseMsg handle(TextReqMsg message) {
//
//
//        Response response = redPackService.firstActivation(message.getFromUserName());
//
//        TextMsg textMsg = new TextMsg();
//        textMsg.setToUserName(message.getFromUserName());
//        textMsg.setFromUserName(message.getToUserName());
//        textMsg.setCreateTime(System.currentTimeMillis());
//
//        if(response.isSuccess()){
//            textMsg.setContent("您已经成功领取红包!");
//        }else if(WeiXinConstant.RESPONSE_MSG_CODE == response.getCode()){
//            textMsg.setContent(response.getMsg());
//        }else{
//            textMsg.setContent("红包与您擦身而过，一定是抢红包的姿势不对！");
//        }
//
//        return textMsg;
//    }
//
//    public boolean beforeHandle(TextReqMsg message) {
//        String key = message.getContent().trim();
//        if((key.contains("3") && key.contains("8")) || (key.contains("三") && key.contains("八"))){
//            return true;
//        }
//        return false;
//    }
//}
