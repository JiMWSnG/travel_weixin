package com.travel.weChat.api;

import com.alibaba.fastjson.JSONObject;
import com.travel.util.JsonUtil;
import com.travel.weChat.WeChatutil.HttpUtil;
import com.travel.weChat.bean.WeChatUser;
import com.travel.weChat.wContants.WeChatContants;

import java.io.IOException;

/**
 * Created by Jim Wang on 2016/8/12.
 */
public class WeChatUserApi {
    AccessTokenApi accessTokenApi;
    public WeChatUser getFanInfo(String openId) {
        WeChatUser user = null;
        try {
            String json = HttpUtil.get(WeChatContants.USER_INFO_URL.replace("ACCESS_TOKEN", accessTokenApi.getAccesstoken()).replace("OPENID", openId));
            user = JsonUtil.fromJsonToObject(json,WeChatUser.class);
        } catch (IOException e) {
            e.printStackTrace();
        }

        return user;
    }
}
