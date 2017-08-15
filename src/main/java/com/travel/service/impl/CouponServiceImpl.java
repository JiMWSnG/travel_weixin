package com.travel.service.impl;

import com.travel.bean.Coupon;
import com.travel.contants.Contants;
import com.travel.dao.CouponDao;
import com.travel.service.CouponService;
import com.travel.web.Response;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by Jim Wang on 2016/10/31.
 */
public class CouponServiceImpl implements CouponService {

    private CouponDao couponDao;

    public void setCouponDao(CouponDao couponDao) {
        this.couponDao = couponDao;
    }

    @Override
    public Response getCouponList(Integer userId, Integer status, String category) {

        Response response = new Response();
        if(userId ==null || userId<0){
            response.setSuccess(false);
            response.setCode(Contants.PARAM_ERROR_CODE);
            response.setMsg("userId错误");
            return response;
        }
        List<Coupon> couponList = new ArrayList<Coupon>();
        if("all".equals(category) ){
            category =null;
        }
        couponList =  couponDao.queryCouponsByUserId(userId,status,category);
        response.setData(couponList);
        if(couponList==null){
            response.setCode(Contants.DB_ERROR_CODE);
            response.setSuccess(false);
        }else {
            response.setSuccess(true);
        }
        return response;

    }

    @Override
    public Response updateCouponStatus(Coupon coupon) {
        Response response = new Response();
        int ok =couponDao.updateCoupon(coupon);
        boolean isTrue = ok>0;
        response.setSuccess(isTrue);
        return response;
    }


    @Override
    public Response addCoupon(Coupon coupon) {
        Response response = new Response();

        int ok =couponDao.addCoupon(coupon);
        boolean isTrue = ok>0;
        response.setSuccess(isTrue);
        return response;
    }
}
