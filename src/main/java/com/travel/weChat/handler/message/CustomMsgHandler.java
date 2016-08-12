//package com.travel.weChat.handler.message;
//
//import com.bm.insurance.api.weixin.msg.CustomMsg;
//import com.bm.insurance.commonservice.constant.ConstantService;
//import com.github.sd4324530.fastweixin.handle.MessageHandle;
//import com.github.sd4324530.fastweixin.message.BaseMsg;
//import com.github.sd4324530.fastweixin.message.TextMsg;
//import com.github.sd4324530.fastweixin.message.req.TextReqMsg;
//import org.apache.commons.lang.StringUtils;
//import org.apache.log4j.Logger;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.stereotype.Service;
//
//import java.util.Calendar;
//
///**
// * Created by admin on 2015/11/24.
// * 客服消息
// */
//@Service
//public class CustomMsgHandler implements MessageHandle<TextReqMsg> {
//
//    private Logger logger = Logger.getLogger(CustomMsgHandler.class);
//
//    @Autowired
//    private ConstantService constantService;
//
//    public BaseMsg handle(TextReqMsg message) {
//
//        BaseMsg textMsg = null;
//
//        int dayWeek = Calendar.getInstance().get(Calendar.DAY_OF_WEEK);
//        int hour = Calendar.getInstance().get(Calendar.HOUR_OF_DAY);//24小时制
//        if(dayWeek == Calendar.SUNDAY || dayWeek == Calendar.SATURDAY || hour >=18 || hour <9){
//            textMsg = new TextMsg();
//            String content = "尊敬客户您好，由于腾讯官方升级，我们的服务号暂时无法为您提供人工咨询服务，非工作时间请您致电15321107132进行咨询，给您带来的不便，深表歉意，感谢您对豆包管家的关注，小豆包们将竭诚为您服务。";
//            ((TextMsg)textMsg).setContent(content);
//        }else{
//            textMsg = new CustomMsg();
//            //textMsg.setKfAccount("1703@doubaoguanjia");
//            String content = constantService.getValue(ConstantService.WX_REP_ONLINE_CUSTOMER);
//            if(StringUtils.isBlank(content)){
//                content = "您好，我是豆包客服，有什么可以帮到您的？";
//            }
//            ((CustomMsg)textMsg).setContent(content);
//        }
//        textMsg.setToUserName(message.getFromUserName());
//        textMsg.setFromUserName(message.getToUserName());
//        textMsg.setCreateTime(System.currentTimeMillis());
//        return textMsg;
//    }
//
//    public boolean beforeHandle(TextReqMsg message) {
//
//        return true;
//    }
//}
