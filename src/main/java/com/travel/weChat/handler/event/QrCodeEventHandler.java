//package com.travel.weChat.handler.event;
//
//import com.bm.insurance.cloud.orm.entity.Activity;
//import com.bm.insurance.cloud.util.DateUtils;
//import com.bm.insurance.commonservice.activity.ActivityService;
//import com.bm.insurance.commonservice.constant.ConstantService;
//import com.github.sd4324530.fastweixin.handle.EventHandle;
//import com.github.sd4324530.fastweixin.message.BaseMsg;
//import com.github.sd4324530.fastweixin.message.TextMsg;
//import com.github.sd4324530.fastweixin.message.req.EventType;
//import com.github.sd4324530.fastweixin.message.req.QrCodeEvent;
//import org.apache.commons.lang3.StringUtils;
//import org.apache.commons.logging.Log;
//import org.apache.commons.logging.LogFactory;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.stereotype.Service;
//
//import java.util.Date;
//
///**
// * Created by admin on 2015/11/24.
// * 扫描二维码事件处理
// * Constant.QR_ID_FROM_EMAIL
// */
//@Service
//public class QrCodeEventHandler implements EventHandle<QrCodeEvent> {
//
//    protected Log logger = LogFactory.getLog(QrCodeEventHandler.class);
//
//    @Autowired
//    private ActivityService activityService;
//
//    @Autowired
//    private ConstantService constantService;
//
//    public BaseMsg handle(QrCodeEvent event) {
//        String eventKey = event.getEventKey();
//
//        TextMsg response = new TextMsg();
//        response.setToUserName(event.getFromUserName());
//        response.setFromUserName(event.getToUserName());
//        response.setCreateTime(System.currentTimeMillis());
//
//        String respContent = "";
//        if(StringUtils.isNotBlank(eventKey)){//带场景参数
//            String eventType = event.getEvent();
//            String scene_id = null;
//            if(EventType.SUBSCRIBE.equals(eventType)){//用户未关注时，进行关注后的事件推送
//                scene_id = eventKey.substring("qrscene_".length());//带场景关注
//                logger.info("用户未关注时，进行关注后的事件推送scene_id:" + scene_id);
//            }else if(EventType.SCAN.equals(eventType)){//用户已关注时的事件推送
//                scene_id = eventKey;
//                logger.info("用户已关注时的场景推送scene_id:" + scene_id);
//            }
//
//            int sceneId = Integer.parseInt(scene_id);
//            Activity activity = activityService.getActivityById(sceneId);
//            if(activity != null){
//                Date st = activity.getSt();
//                Date et = activity.getEt();
//                Date ct = new Date();
//                if(ct.before(st)){
//                    //respContent = "["+activity.getName()+"]活动未开始,开始时间:"+ DateUtils.format(st);
//                }else if(ct.after(et)){
//                    //respContent = "["+activity.getName()+"]活动已结束,结束时间:"+ DateUtils.format(et);
//                }else{
//                    respContent = constantService.getValue(ConstantService.WX_REP_ACTIVITY_+sceneId);
//                }
//            }else{
//                //respContent = constantService.getValue(ConstantService.WX_REP_OLD_SUBSCRIBE);
//            }
//        }else{//普通扫码关注
//            logger.debug("普通扫码关注");
//            //respContent = "普通扫码关注";
//        }
//
//        if(StringUtils.isNotBlank(respContent)){
//            response.setContent(respContent);
//        }else{
//            response = null;
//        }
//
//        return response;
//    }
//
//    public boolean beforeHandle(QrCodeEvent event) {
//        String e = event.getEvent();
//        if(EventType.SCAN.equals(e)){
//            return true;
//        }
//        return false;
//    }
//}
