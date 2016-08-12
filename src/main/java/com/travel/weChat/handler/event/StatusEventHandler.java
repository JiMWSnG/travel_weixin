//package com.travel.weChat.handler.event;
//
//import com.bm.insurance.cloud.orm.entity.Message;
//import com.bm.insurance.commonservice.message.MessageService;
//import com.bm.insurance.msg.MsgStatusEnum;
//import com.github.sd4324530.fastweixin.handle.EventHandle;
//import com.github.sd4324530.fastweixin.message.BaseMsg;
//import com.github.sd4324530.fastweixin.message.req.BaseEvent;
//import com.github.sd4324530.fastweixin.message.req.EventType;
//import com.github.sd4324530.fastweixin.message.req.TemplateMsgEvent;
//import org.apache.commons.logging.Log;
//import org.apache.commons.logging.LogFactory;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.stereotype.Service;
//
///**
// * Created by admin on 2015/11/24.
// * 在模版消息发送任务完成后，微信服务器会将是否送达成功作为通知，发送到开发者中心中填写的服务器配置地址中
// * http://mp.weixin.qq.com/wiki/5/6dde9eaa909f83354e0094dc3ad99e05.html
// */
//@Service
//public class StatusEventHandler implements EventHandle<TemplateMsgEvent> {
//
//    protected Log logger = LogFactory.getLog(StatusEventHandler.class);
//
//    enum StatusEnum{
//
//        SUCCESS("success","成功接收"),
//        USERBLOCK("failed:user block","用户设置拒绝接收公众号消息"),
//        OTHERERROR("failed: system failed","其他原因失败");
//
//        private String code;
//        private String remark;
//
//        StatusEnum(String code,String remark){
//            this.code = code;
//            this.remark = remark;
//        }
//    }
//
//    @Autowired
//    private MessageService messageService;
//
//    public BaseMsg handle(TemplateMsgEvent event) {
//        String msgId = event.getMsgId();
//        String statusCode = event.getStatus();
//
//        Message response = new Message();
//        response.setTaskId(msgId);
//        response.setStatusCode(statusCode);
//        response.setStatus(MsgStatusEnum.STATUS_FAIL.getStatus());
//
//        StatusEnum statusEnum = null;
//
//        if(StatusEnum.SUCCESS.code.equals(statusCode)){
//            statusEnum = StatusEnum.SUCCESS;
//            response.setStatus(MsgStatusEnum.STATUS_SUCCESS.getStatus());
//        }else if(StatusEnum.USERBLOCK.code.equals(statusCode)){
//            statusEnum = StatusEnum.USERBLOCK;
//        }else{
//            statusEnum = StatusEnum.OTHERERROR;
//        }
//
//        response.setRemark(statusEnum.remark);
//        try {
//            Thread.sleep(1000);
//        } catch (InterruptedException e) {
//            e.printStackTrace();
//        }
//        int count = messageService.updateTaskByResponse(response);
//        logger.info("msgId="+msgId+",statusCode="+statusCode+",count="+count);
//        return null;
//    }
//
//    public boolean beforeHandle(TemplateMsgEvent event) {
//        if(event.getEvent().equals(EventType.TEMPLATESENDJOBFINISH)){
//            return  true;
//        }
//        return false;
//    }
//}
