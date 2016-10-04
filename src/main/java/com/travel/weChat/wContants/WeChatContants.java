package com.travel.weChat.wContants;

import org.springframework.beans.factory.annotation.Value;

import java.util.Random;

/**
 * Created by Jim Wang on 2016/8/12.
 */
public class WeChatContants {

    public static final String WECHAT_APPID = "";
    public static final String WECHAT_NAME = "";
    public static final String WECHAT_APPSECRET = "";
    public static final String WECHAT_TOKEN = "151DG3126bBLPArUBkFRAl7UcmO5YZJnD";
    public static final String WECHAT_AESKEY = "";
    public static final String WECHAT_ = "";

    public   static  String  WECHAT_ACCESSTOKEN = "";
    public static String ACCESS_TOKEN_URL = "https://api.weixin.qq.com/cgi-bin/token?grant_type=client_credential&appid=APPID&secret=APPSECRET";

    public static String USER_INFO_URL = "https://api.weixin.qq.com/cgi-bin/user/info?access_token=ACCESS_TOKEN&openid=OPENID&lang=zh_CN";

    /****************************/

    public static String SNS_ACCESS_TOKEN_URL = "https://api.weixin.qq.com/sns/oauth2/access_token?appid=APPID&secret=APPSECRET&code=CODE&grant_type=authorization_code";

    public static String SNS_USER_INFO_URL    = "https://api.weixin.qq.com/sns/userinfo?access_token=ACCESS_TOKEN&openid=OPENID&lang=zh_CN";


    public static String WX_MENU_MYDOUBAO = "myDoubao";
    public static String WX_MENU_MYCLAIMS = "myClaims";
    public static String WX_MENU_POPACTIVE = "popactive";

    public static int RESPONSE_MSG_CODE = 99999;//response中code为此值时，获取msg信息


    //
    public static String myDo = "https://open.weixin.qq.com/connect/oauth2/authorize?appid=APPID&redirect_uri=http%3A%2F%2Fwww.17doubao.cn%2Fpersonal%2Flogin&response_type=code&scope=snsapi_userinfo&state=myDoubao#wechat_redirect";



    //发送红包
    public static String URL_SEND_REDPACK = "https://api.mch.weixin.qq.com/mmpaymkttransfers/sendredpack";


    public static String URL_BATCHGET_MATERIAL = "https://api.weixin.qq.com/cgi-bin/material/batchget_material?access_token=ACCESS_TOKEN";



    /**
     * 首次激活领红包,祝福语
     */
    private static String[] ACTIVE_WISH = {"上豆包网，让您的健康生活更有保障。",
            "上豆包网，保险产品的优选服务平台。",
            "上豆包网，拼的就是优质服务。",
            "上豆包网，讲的就是贴心、快捷、零骚扰。",
            "上豆包网，美好生活豆包都保。"};

    public static final int AID_FIRST_ACTIVATION = 1;//首次激活领红包

    public static String activeWish() {
        Random random = new Random();
        return ACTIVE_WISH[random.nextInt(ACTIVE_WISH.length)];
    }


    /**
     * 消息
     */
    public static final String SEND_MESSAGE_URL = "https://api.weixin.qq.com/cgi-bin/message/template/send?access_token=ACCESS_TOKEN";
    /**
     * 带参数二维码获取ticketurl(临时)post
     */
    public static final String GET_TICKET_URL = "https://api.weixin.qq.com/cgi-bin/qrcode/create?access_token=ACCESS_TOKEN";
    /**
     * 获取带参数的二维码(get)TICKET记得进行UrlEncode
     */
    public static  final String GET__QRCODE_URL = "https://mp.weixin.qq.com/cgi-bin/showqrcode?ticket=TICKET";


    //客服接口-发消息
    public static  final String CUSTOM_SEND_URL = "https://api.weixin.qq.com/cgi-bin/message/custom/send?access_token=ACCESS_TOKEN";





}
