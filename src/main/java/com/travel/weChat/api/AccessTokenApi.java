package com.travel.weChat.api;

import com.travel.util.JsonUtil;
import com.travel.util.JsonWriter;
import com.travel.weChat.WeChatutil.HttpUtil;
import com.travel.weChat.bean.AccessToken;
import com.travel.weChat.wContants.WeChatContants;
import net.sf.json.JSONException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.scheduling.annotation.Scheduled;

import java.io.IOException;

/**
 * Created by Jim Wang on 2016/8/12.
 */
public class AccessTokenApi {

    private static final Logger logger = LoggerFactory.getLogger(JsonWriter.class);
    private static  String accesstoken;

    public String getAccesstoken() {
        return accesstoken;
    }

    public void setAccesstoken(String accesstoken) {
        this.accesstoken = accesstoken;
    }
    @Scheduled
    public void setAccessToken()
    {
       this.accesstoken =  requestAccessToken();
    }



    private synchronized String requestAccessToken() {
        String accessToken = null;

        //Object obj = cacheService.getWithOutEnv(ICacheService.CK_WX_TOKEN);
        Object obj=null;
        if(obj == null){
            try {
                String json = HttpUtil.get(WeChatContants.ACCESS_TOKEN_URL.replace("APPID", WeChatContants.WECHAT_APPID).replace("APPSECRET", WeChatContants.WECHAT_APPSECRET));
                AccessToken token = JsonUtil.fromJsonToObject(json,AccessToken.class);
                if(token != null && token.getAccess_token() != null){
                    accessToken = token.getAccess_token();
                    //cacheService.setWithOutEnv(ICacheService.CK_WX_TOKEN,accessToken,token.getExpires_in() - 200);
                }else{
                    logger.error("token 获取失败,errorcode:"+token.getErrcode()+" msg:"+token.getErrmsg());
                }
            } catch (JSONException je){
                je.printStackTrace();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }else {
            accessToken = (String)obj;
        }
        logger.info("AccessToken="+accessToken);
        return accessToken;
    }

}
