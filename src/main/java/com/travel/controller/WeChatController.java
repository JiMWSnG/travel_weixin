package com.travel.controller;

import com.travel.weChat.service.WeChatService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

/**
 * Created by Jim Wang on 2016/8/11.
 */
@RestController
public class WeChatController {

    private WeChatService weChatService;
    private static final Logger logger = LoggerFactory.getLogger(WeChatController.class);

    @RequestMapping(value = "/token",method = RequestMethod.GET)
    public  String index(String signature,String timestamp,String nonce,String echostr) {
        logger.info("signature="+signature+",timestamp="+timestamp+",nonce="+nonce+",echostr="+echostr);

        /*List<Version> versionList = wxVersionDao.getVersions();
        if(versionList != null && versionList.size() > 0){
            logger.info(versionList.get(0).getInfo());
        }*/

        if(!weChatService.checkSignature(signature, timestamp, nonce)){
            echostr = "echostr error!!!";
        }
        logger.info("echostr="+echostr);
        return echostr;
    }
//TODO:添加user信息



}
