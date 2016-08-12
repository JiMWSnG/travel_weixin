package com.travel.weChat.msg;
import com.github.sd4324530.fastweixin.message.BaseMsg;

/**
 * 事件消息
 */
public class EventMsg extends BaseMsg {


    private String Event;
    private String EventKey;

    public String getEvent() {
        return Event;
    }

    public void setEvent(String event) {
        Event = event;
    }

    public String getEventKey() {
        return EventKey;
    }

    public void setEventKey(String eventKey) {
        EventKey = eventKey;
    }
}
