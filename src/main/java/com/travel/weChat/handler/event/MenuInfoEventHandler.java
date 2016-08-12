//package com.travel.weChat.handler.event;
//
//import com.bm.insurance.api.weixin.enums.MenuClickEnum;
//import com.bm.insurance.commonservice.constant.ConstantService;
//import com.bm.insurance.commonservice.wechat.AccessTokenApi;
//import com.bm.insurance.commonservice.wechat.BatchMaterialApi;
//import com.github.sd4324530.fastweixin.handle.EventHandle;
//import com.github.sd4324530.fastweixin.message.BaseMsg;
//import com.github.sd4324530.fastweixin.message.MpNewsMsg;
//import com.github.sd4324530.fastweixin.message.TextMsg;
//import com.github.sd4324530.fastweixin.message.req.MenuEvent;
//import com.travel.weChat.api.AccessTokenApi;
//import org.apache.commons.lang.StringUtils;
//import org.apache.commons.logging.Log;
//import org.apache.commons.logging.LogFactory;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.stereotype.Service;
//
///**
// * Created by admin on 2015/11/24.
// * 豆包资讯菜单处理
// */
//@Service
//public class MenuInfoEventHandler implements EventHandle<MenuEvent> {
//
//    protected Log logger = LogFactory.getLog(MenuInfoEventHandler.class);
//
//    @Autowired
//    private ConstantService constantService;
//
//    @Autowired
//    private AccessTokenApi accessTokenApi;
//
//    @Autowired
//    private BatchMaterialApi batchMaterialApi;
//
//    public BaseMsg handle(MenuEvent event) {
//
//        String eventKey = event.getEventKey();
//        if(MenuClickEnum.ACTIVITY.getKey().equals(eventKey)){
//            TextMsg msg = new TextMsg();
//            msg.setToUserName(event.getFromUserName());
//            msg.setFromUserName(event.getToUserName());
//            msg.setCreateTime(System.currentTimeMillis());
//
//            String rep = constantService.getValue(ConstantService.WX_REP_WONDERFUL_ACTIVITY);
//            if(StringUtils.isNotBlank(rep)){
//                msg.setContent(rep);
//            }else{
//                msg.setContent("精彩活动即将呈现，请持续关注豆包管家");
//            }
//
//            return msg;
//        }/*else if(MenuClickEnum.SCIENCE.getKey().equals(eventKey)){
//            MpNewsMsg msg = new MpNewsMsg();
//            msg.setToUserName(event.getFromUserName());
//            msg.setFromUserName(event.getToUserName());
//            msg.setCreateTime(System.currentTimeMillis());
//            msg.setMediaId("1rFe0k0clpLBo-g0sUdI0wvHTu5_LkcJ1iOedkt1tYE");
//            return msg;
//        }else if(MenuClickEnum.MEMORABILIA.getKey().equals(eventKey)){
//            msg.setToUserName(event.getFromUserName());
//            msg.setFromUserName(event.getToUserName());
//            msg.setCreateTime(System.currentTimeMillis());
//            msg.setMediaId("1rFe0k0clpLBo-g0sUdI09042LCizf1j_iE0HFUijAE");
//            logger.info(msg.toXml());
//            return null;
//        }*/
//        return null;
//    }
//
//    public boolean beforeHandle(MenuEvent event) {
//        String eventKey = event.getEventKey();
//        logger.info(eventKey);
//        accessTokenApi.getAccessToken();
//        //batchMaterialApi.getList();
//        if(MenuClickEnum.ACTIVITY.getKey().equals(eventKey)
//                || MenuClickEnum.SCIENCE.getKey().equals(eventKey)
//                || MenuClickEnum.MEMORABILIA.getKey().equals(eventKey)){
//            return true;
//        }
//        return false;
//    }
//}
