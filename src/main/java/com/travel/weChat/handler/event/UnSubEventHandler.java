//package com.travel.weChat.handler.event;
//
//import com.bm.insurance.cloud.bean.response.wx.Fan;
//import com.bm.insurance.cloud.orm.entity.WeiXinFan;
//import com.bm.insurance.commonservice.constant.ConstantService;
//import com.bm.insurance.commonservice.wechat.UserApi;
//import com.bm.insurance.commonservice.wechat.WeiXinFanService;
//import com.github.sd4324530.fastweixin.handle.EventHandle;
//import com.github.sd4324530.fastweixin.message.BaseMsg;
//import com.github.sd4324530.fastweixin.message.TextMsg;
//import com.github.sd4324530.fastweixin.message.req.BaseEvent;
//import com.github.sd4324530.fastweixin.message.req.EventType;
//import com.github.sd4324530.fastweixin.message.req.QrCodeEvent;
//import org.apache.commons.lang.StringUtils;
//import org.apache.commons.logging.Log;
//import org.apache.commons.logging.LogFactory;
//import org.springframework.beans.BeanUtils;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.stereotype.Service;
//
///**
// * Created by admin on 2015/11/24.
// * 关注事件
// */
//@Service
//public class UnSubEventHandler implements EventHandle<BaseEvent> {
//
//    protected Log logger = LogFactory.getLog(UnSubEventHandler.class);
//
//    @Autowired
//    private WeiXinFanService weiXinFanService;
//
//    @Autowired
//    private UserApi userApi;
//
//    @Autowired
//    private ConstantService constantService;
//
//
//
//
//    public BaseMsg handle(BaseEvent event) {
//        String fromUserName = event.getFromUserName();
//
//        WeiXinFan fan = new WeiXinFan();
//        fan.setOpenid(fromUserName);
//        fan.setStatus(WeiXinFan.UNFOCUS);
//        weiXinFanService.updateFan(fan);
//
//
//        return null;
//    }
//
//    public boolean beforeHandle(BaseEvent event) {
//
//        if(EventType.UNSUBSCRIBE.equals(event.getEvent())){
//            logger.info(event.getEvent());
//            return true;
//        }
//        return false;
//    }
//}
