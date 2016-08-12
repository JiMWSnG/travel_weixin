//package com.travel.weChat.handler.message;
//
//import com.bm.insurance.api.weixin.enums.ChrActEnum;
//import com.bm.insurance.cloud.bean.Response;
//import com.bm.insurance.cloud.orm.bean.RedPackBean;
//import com.bm.insurance.cloud.orm.entity.Activity;
//import com.bm.insurance.cloud.util.DateUtils;
//import com.bm.insurance.commonservice.activity.ActivityService;
//import com.bm.insurance.commonservice.constant.ConstantService;
//import com.bm.insurance.commonservice.wechat.RedPackService;
//import com.bm.insurance.commonservice.wechat.WeiXinFanService;
//import com.github.sd4324530.fastweixin.handle.MessageHandle;
//import com.github.sd4324530.fastweixin.message.BaseMsg;
//import com.github.sd4324530.fastweixin.message.TextMsg;
//import com.github.sd4324530.fastweixin.message.req.TextReqMsg;
//import org.apache.log4j.Logger;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.stereotype.Service;
//
//import java.util.Date;
//import java.util.List;
//import java.util.Random;
//
///**
// * Created by admin on 2015/11/24.
// * 圣诞活动
// */
//@Service
//public class ChristmasHandler implements MessageHandle<TextReqMsg> {
//
//    Logger logger = Logger.getLogger(ChristmasHandler.class);
//    private final static ChrActEnum[] chrActEnumArr = ChrActEnum.values();
//    private final static String REMARK = "感谢您一直以来对豆包网的支持，Marry Christmas！";
//    private static List<String> ADMIN_WX_LIST = null;
//
//    @Autowired
//    private RedPackService redPackService;
//
//    @Autowired
//    WeiXinFanService weiXinFanService;
//
//    @Autowired
//    private ActivityService activityService;
//
//    @Autowired
//    private ConstantService constantService;
//
//    public BaseMsg handle(TextReqMsg message) {
//        String key = message.getContent();
//        String openId = message.getFromUserName();
//
//        if(ADMIN_WX_LIST == null){
//            ADMIN_WX_LIST  = constantService.getValues(ConstantService.WX_NOTICE_ADMIN_LIST);
//        }
//
//        boolean isAdmin = false;
//        for(String wx:ADMIN_WX_LIST){
//            if(wx.equals(openId)){
//                isAdmin = true;
//                break;
//            }
//        }
//
//        TextMsg textMsg = new TextMsg();
//        textMsg.setToUserName(openId);
//        textMsg.setFromUserName(message.getToUserName());
//        textMsg.setCreateTime(System.currentTimeMillis());
//
//        int aId = 0;
//        for(ChrActEnum chrAct: chrActEnumArr){
//            if(chrAct.getKey().equals(key)){
//                aId = chrAct.getaId();
//                break;
//            }
//        }
//
//        Activity activity = activityService.getActivityById(aId);
//        if(activity != null){
//            Date curDate = new Date();
//            logger.info("当前时间："+DateUtils.format(curDate)+",活动开始时间："+DateUtils.format(activity.getSt())+"至"+DateUtils.format(activity.getEt()));
//            if(curDate.before(activity.getSt())){
//                textMsg.setContent("活动未开始！开始时间:"+DateUtils.format(activity.getSt()));
//            }else if(curDate.after(activity.getEt())){
//                textMsg.setContent("活动已结束！");
//            }else{
//                RedPackBean redPackBean = null;
//                synchronized (this){
//                    redPackBean = weiXinFanService.getRedPackInfoByAid(null,aId);
//                    //sumCount = weiXinFanService.getFanRedPackCountByAid(null,aId);
//                }
//                if(redPackBean.getCount() < 200 && redPackBean.getAmount() < 30000){//活动限参加人数200或金额为300元
//                //if(redPackBean.getCount() < 3 && redPackBean.getAmount() < 2000){//活动限参加人数3或金额为10元
//                    RedPackBean packBean = weiXinFanService.getChristmasRedPackInfo(openId);
//                    if(packBean.getCount() >= activity.getPnum()){//每人限次
//                        textMsg.setContent("今天已领过红包，敬请期待其他活动！！");
//                    }else{
//                        int amount = new Random().nextInt(200)+100;//随机(1-3元)
//                        if(isAdmin){
//                            amount = 300;//管理员最大金额
//                        }
//                        Response response = redPackService.sendRedPack(openId,amount,aId,activity.getName(),REMARK,null);
//                        if(response.isSuccess()){
//                            textMsg = null;
//                        }else{
//                            textMsg.setContent("领红包人太多啦，稍后再试哦！");
//                        }
//                    }
//                }else{
//                    if(key.equals(ChrActEnum.LPXDB.getKey())){
//                        textMsg.setContent("哎呀，红包太抢手，300个红包已经派完啦~ 【下一次开抢时间17：00】，小伙伴们，调整姿势，早做准备，下个100块可能就是你的了！！");
//                    }else if(key.equals(ChrActEnum.DBFWCTX.getKey())){
//                        textMsg.setContent("哎呀，你与圣诞老人擦肩而过，【据他说18：00会再来一次】，不要气馁，调整姿势，把握住最后一次机会！");
//                    }else{
//                        textMsg.setContent("真不巧，你与最后红包擦肩而过，最后一个红包已经派完啦，敬请期待其他精彩活动！！");
//                    }
//                }
//            }
//        }else{
//            textMsg.setContent("sorry!!!");
//        }
//
//        return textMsg;
//    }
//
//    public boolean beforeHandle(TextReqMsg message) {
//        String key = message.getContent();
//        for(ChrActEnum chrAct: chrActEnumArr){
//            if(chrAct.getKey().equals(key)){
//                return true;
//            }
//        }
//        return false;
//    }
//}
