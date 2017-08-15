package com.travel.entity;

/**
 * Created by Jim Wang on 2016/10/28.
 */
public class CouponContext {
    private  CouponRule couponRule;

    public CouponContext(CouponRule couponRule){
        this.couponRule = couponRule;
    }

    public CouponRule getCouponRule() {
        return couponRule;
    }

    public void setCouponRule(CouponRule couponRule) {
        this.couponRule = couponRule;
    }
    //TODO:interface
    public void matchCouponRule(){
        couponRule.getClass();
    }
}
