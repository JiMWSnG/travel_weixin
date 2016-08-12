package com.travel.weChat.handler.event;

import com.github.sd4324530.fastweixin.handle.EventHandle;
import com.github.sd4324530.fastweixin.message.BaseMsg;
import com.github.sd4324530.fastweixin.message.req.BaseEvent;
import com.github.sd4324530.fastweixin.message.req.EventType;
import org.springframework.stereotype.Service;

/**
 * Created by admin on 2015/11/24.
 * 订阅处理
 */
@Service
public class LocationEventHandler implements EventHandle<BaseEvent> {


    public BaseMsg handle(BaseEvent event) {
        return null;
    }

    public boolean beforeHandle(BaseEvent event) {
        if(event.getEvent().equals(EventType.LOCATION)){

        }
        return false;
    }
}
