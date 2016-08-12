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
// * Created by admin on 2015/11/24.
// * 首次激活领红包处理类
// */
//@Service
//public class RedPackHandler implements MessageHandle<TextReqMsg> {
//
//    @Autowired
//    private RedPackService redPackService;
//
//    public BaseMsg handle(TextReqMsg message) {
//
//
//        Response response = redPackService.firstActivation(message.getFromUserName());
//
//
//        TextMsg textMsg = new TextMsg();
//        textMsg.setToUserName(message.getFromUserName());
//        textMsg.setFromUserName(message.getToUserName());
//        textMsg.setCreateTime(System.currentTimeMillis());
//
//        if(response.isSuccess()){
//            textMsg.setContent("首次激活领红包已发，请查收!");
//        }else if(WeiXinConstant.RESPONSE_MSG_CODE == response.getCode()){
//            textMsg.setContent(response.getMsg());
//        }else{
//            textMsg.setContent("今天的红包被抢光了~ 稍后再来试试吧！");
//        }
//
//        return textMsg;
//    }
//
//    public boolean beforeHandle(TextReqMsg message) {
//
//        String key = message.getContent();
//
//        if(key.equals("我爱豆包") || key.contains("红包") || "我要红包".equals(key)){
//            return true;
//        }
//        return false;
//    }
//}
