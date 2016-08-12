//package com.travel.weChat.handler.message;
//
//import com.bm.insurance.commonservice.constant.ConstantService;
//import com.bm.insurance.commonservice.message.MsgService;
//import com.bm.insurance.commonservice.wechat.WeChatConstant;
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
// * 微信回复openId
// */
//@Service
//public class OpenIdMsgHandler implements MessageHandle<TextReqMsg> {
//
//    protected Log logger = LogFactory.getLog(OpenIdMsgHandler.class);
//
//    private final static String ADD_WHITE_LIST = "请加白名单";
//    private final static String VIEW_WHITE_LIST = "查看白名单";
//
//    @Autowired
//    private ConstantService constantService;
//
//    @Autowired
//    private MsgService msgService;
//
//    @Autowired
//    private WeChatConstant weChatConstant;
//
//    public BaseMsg handle(TextReqMsg message) {
//        TextMsg textMsg = new TextMsg();
//        textMsg.setToUserName(message.getFromUserName());
//        textMsg.setFromUserName(message.getToUserName());
//        textMsg.setCreateTime(System.currentTimeMillis());
//
//        String content = message.getContent().trim();
//
//        if(content.startsWith(ADD_WHITE_LIST)){
//            if(msgService.isWhiteOpenId(message.getFromUserName())){
//                textMsg.setContent("你的微信openId="+message.getFromUserName()+"，已在白名单");
//            }else{
//                String name [] = content.split("#");
//                if(name != null && name.length == 2){
//                    com.bm.insurance.cloud.orm.entity.Constant constant = new com.bm.insurance.cloud.orm.entity.Constant();
//                    constant.setKey("WECHAT_WHITE_LIST");
//                    constant.setContent(message.getFromUserName());
//                    constant.setName(name[1]);
//                    constant.setDescription(weChatConstant.getWxName());
//                    constant.setStatus(1);
//                    if(constantService.insert(constant)){
//                        textMsg.setContent("你的微信openId="+message.getFromUserName()+"，已添加白名单");
//                    }else{
//                        textMsg.setContent("你的微信openId="+message.getFromUserName()+"，添加失败");
//                    }
//                }else{
//                    textMsg.setContent("你的微信openId="+message.getFromUserName()+"，回复有误，请回复:请加白名单#姓名");
//                }
//            }
//        }else if(VIEW_WHITE_LIST.equals(content)){
//            textMsg.setContent("微信openId="+message.getFromUserName());
//        }
//        return textMsg;
//    }
//
//    public boolean beforeHandle(TextReqMsg message) {
//        String content = message.getContent().trim();
//        if(content.startsWith(ADD_WHITE_LIST) || VIEW_WHITE_LIST.equals(content)){
//            return true;
//        }
//        return false;
//    }
//}
