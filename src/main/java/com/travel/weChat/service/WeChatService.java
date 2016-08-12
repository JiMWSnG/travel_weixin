package com.travel.weChat.service;

import javax.servlet.http.HttpServletRequest;

/**
 * Created by Jim Wang on 2016/8/12.
 */
public interface WeChatService {
    //微信接口验证
    public boolean checkSignature(String signature,String timestamp,String nonce);
    //添加微信用户
    public String handle(HttpServletRequest request);




}
