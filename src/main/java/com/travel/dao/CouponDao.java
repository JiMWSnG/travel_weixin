package com.travel.dao;

import com.travel.bean.Coupon;

import java.util.List;

public interface CouponDao {
    /**
     *
     * @param userId
     * @param stauts
     * @param category
     * @return couponlist/null
     */
	 List<Coupon> queryCouponsByUserId(Integer userId, Integer stauts, String category);
	 int addCoupon(Coupon coupon);
	 int updateCoupon(Coupon coupon);
	 int removeCoupon(Integer id);
}
