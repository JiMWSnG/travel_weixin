package com.travel.service;

import com.travel.bean.Coupon;
import com.travel.web.LoginRequest;
import com.travel.web.RegisterRequest;
import com.travel.web.Response;
import com.travel.web.UserRequest;

/**
 * Created by Jim Wang on 2016/8/1.
 */
public interface CouponService {
    //TODO:last code

    /**
     *  得到优惠券的列表
     * @param userId
     * @param status :expired,used,available
     * @param category :route,ticket ,hotel,all
     * @return coupon list
     */
    Response getCouponList(Integer userId,Integer status,String category);

    /**更新coupon的状态
     *
     * @param coupon
     * @return couponId>0 /-1
     */
    Response updateCouponStatus(Coupon coupon );

    /**
     * 添加coupon
     * @param coupon
     * @return couponId>0 /-1
     */
    Response addCoupon(Coupon coupon);



}
