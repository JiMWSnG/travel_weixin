package com.travel.service;

import com.travel.bean.Coupon;
import com.travel.web.RegisterRequest;
import com.travel.web.Response;
import com.travel.web.UserRequest;

/**
 * Created by Jim Wang on 2016/8/1.
 */
public interface CouponRuleService {
    Response getCouponList(Integer userId, Integer status, String category);
    Response updateCouponStatus(Coupon coupon);
    Response register(RegisterRequest registerRequest);
    //用户信息
    Response getUserInfo(Integer id);

    /**
     * 优先提供opneId，必须提供openID/id
     * @param userRequest
     * @return  Response,userId/-1
     */
    Response updateUserInfo(UserRequest userRequest);

}
