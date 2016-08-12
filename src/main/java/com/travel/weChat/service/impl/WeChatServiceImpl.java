package com.travel.weChat.service.impl;

import com.travel.weChat.wContants.WeChatContants;
import com.travel.weChat.service.WeChatService;
import org.apache.commons.lang.StringUtils;

import javax.servlet.http.HttpServletRequest;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.Arrays;

/**
 * Created by Jim Wang on 2016/8/12.
 */
public class WeChatServiceImpl  implements WeChatService {
    @Override
    public String handle(HttpServletRequest request) {
        return null;
    }

    public boolean checkSignature(String signature, String timestamp, String nonce) {
        boolean flag = false;
        if(!StringUtils.isEmpty(signature) && !StringUtils.isEmpty(timestamp)  && !StringUtils.isEmpty(nonce) ){
            String[] tmpArr = {WeChatContants.WECHAT_TOKEN, timestamp, nonce};
            Arrays.sort(tmpArr);
            String tmpStr = ArrayToString(tmpArr);
            tmpStr = SHA1Encode(tmpStr).toLowerCase();
            /*logger.info("signature="+signature);
            logger.info("   tmpStr="+tmpStr);*/
            if (tmpStr.equalsIgnoreCase(signature)) {
                flag = true;
            }
        }
        return flag;
    }

    private String ArrayToString(String[] arr) {
        StringBuffer bf = new StringBuffer();
        for (int i = 0; i < arr.length; i++) {
            bf.append(arr[i]);
        }
        return bf.toString();
    }
    //sha1加密
    private String SHA1Encode(String sourceString) {
        String resultString = null;
        resultString = sourceString;
        MessageDigest md = null;
        try {
            md = MessageDigest.getInstance("SHA-1");
        } catch (NoSuchAlgorithmException e) {
            e.printStackTrace();
        }
        resultString = byte2hexString(md.digest(resultString.getBytes()));
        return resultString;
    }
    private String byte2hexString(byte[] bytes) {
        StringBuffer buf = new StringBuffer(bytes.length * 2);
        for (int i = 0; i < bytes.length; i++) {
            if (((int) bytes[i] & 0xff) < 0x10) {
                buf.append("0");
            }
            buf.append(Long.toString((int) bytes[i] & 0xff, 16));
        }
        return buf.toString().toUpperCase();
    }
}
