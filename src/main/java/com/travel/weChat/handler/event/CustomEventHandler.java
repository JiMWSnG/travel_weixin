package com.travel.weChat.handler.event;

import com.github.sd4324530.fastweixin.handle.EventHandle;
import com.github.sd4324530.fastweixin.message.BaseMsg;
import com.github.sd4324530.fastweixin.message.TextMsg;
import com.github.sd4324530.fastweixin.message.req.MenuEvent;
import org.apache.commons.lang.StringUtils;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * Created by admin on 2015/11/24.
 * 客服消息处理
 */
@Service
public class CustomEventHandler implements EventHandle<MenuEvent> {

    protected Log logger = LogFactory.getLog(CustomEventHandler.class);

    @Autowired
    //private ConstantService constantService;

    public BaseMsg handle(MenuEvent event) {
        TextMsg textMsg = new TextMsg();
        textMsg.setToUserName(event.getFromUserName());
        textMsg.setFromUserName(event.getToUserName());
        textMsg.setCreateTime(System.currentTimeMillis());
        String content =null;
        ////String content = constantService.getValue(ConstantService.WX_REP_ONLINE_CUSTOMER);
        if(StringUtils.isBlank(content)){
            content = "您好，我是豆包客服，有什么可以帮到您的？";
        }

        textMsg.setContent(content);
        logger.info(textMsg.toXml());
        return textMsg;
    }

    public boolean beforeHandle(MenuEvent event) {
        logger.info(event.getEventKey());
        if("online_customer".equals(event.getEventKey())){
            return true;
        }
        return false;
    }
}
