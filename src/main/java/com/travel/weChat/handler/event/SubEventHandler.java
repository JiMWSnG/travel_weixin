package com.travel.weChat.handler.event;

import com.github.sd4324530.fastweixin.handle.EventHandle;
import com.github.sd4324530.fastweixin.message.BaseMsg;
import com.github.sd4324530.fastweixin.message.TextMsg;
import com.github.sd4324530.fastweixin.message.req.BaseEvent;
import com.github.sd4324530.fastweixin.message.req.EventType;
import com.github.sd4324530.fastweixin.message.req.QrCodeEvent;
import com.travel.bean.User;
import com.travel.dao.UserDao;
import com.travel.weChat.api.WeChatUserApi;
import com.travel.weChat.bean.WeChatUser;
import org.apache.commons.lang.StringUtils;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 */
@Service
public class SubEventHandler implements EventHandle<BaseEvent> {

    protected Log logger = LogFactory.getLog(SubEventHandler.class);


    @Autowired
    private WeChatUserApi userApi;


    private UserDao userDao;


    public BaseMsg handle(BaseEvent event) {
        String fromUserName = event.getFromUserName();

        TextMsg response = new TextMsg();
        response.setToUserName(event.getFromUserName());
        response.setFromUserName(event.getToUserName());
        response.setCreateTime(System.currentTimeMillis());

        User wxuser = new User();
        wxuser.setOpenId(fromUserName);
        wxuser.setSubscribe("1");//1是关注，0是未关注

        String respContent = "";
        User user =null;
        try{
           user = userDao.queryByOpenId(fromUserName);
        }catch (Exception e){
            //shujuku baocuo
        }
        if(user == null){
            logger.info("新用户关注"+fromUserName);
            WeChatUser fan = userApi.getFanInfo(wxuser.getOpenId());
            if(fan != null && StringUtils.isNotBlank(fan.getOpenid())){
                BeanUtils.copyProperties(fan, wxuser);
            }
            if(userDao.add(wxuser) > 0){
                //TODO:暂时写死，以后可以加入业务 ；
                respContent = "欢迎关注本宝宝！！>_<";
            }else {
                logger.error("添加用户失败!");
            }
        }else{
            logger.info("老用户再次关注:"+fromUserName);
            try{
                userDao.update(wxuser);//将状态置为关注
            }catch (Exception e){
                //shujulkubaocuo
            }

//            if(weiXinFan.getuId() == null){//已关注未绑定
//                respContent = constantService.getValue(ConstantService.WX_REP_UBSCRIBE_UNBIND);
//            }else{//已关注已绑定
//                respContent = constantService.getValue(ConstantService.WX_REP_OLD_SUBSCRIBE);
//            }
            /*logger.info("weiXinFanService.updateFan(wxfan);");*/
        }
        response.setContent(respContent);

//        if(event instanceof QrCodeEvent){//扫码关注
//            QrCodeEvent qrCodeEvent = (QrCodeEvent)event;
//            String eventKey = qrCodeEvent.getEventKey();
//            if(StringUtils.isNotBlank(eventKey)){//带场景关注
//                logger.info("带场景关注");
//                return qrCodeEventHandler.handle(qrCodeEvent);
//            }
//        }


        return response;
    }

    public boolean beforeHandle(BaseEvent event) {
    String e = event.getEvent();
    logger.info("beforeHandle getEvent--->"+event.toString());
    if(EventType.SUBSCRIBE.equals(e)){
        return true;
    }
    return false;
}
}
