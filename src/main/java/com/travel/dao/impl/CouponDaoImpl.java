package com.travel.dao.impl;

import com.travel.bean.Coupon;
import com.travel.dao.CouponDao;
import org.mybatis.spring.support.SqlSessionDaoSupport;

import java.util.*;

/**
 * Created by Jim Wang on 2016/7/28.
 */
public class CouponDaoImpl extends SqlSessionDaoSupport implements CouponDao{

    @Override
    public List<Coupon> queryCouponsByUserId(Integer userId, Integer status, String category) {
        List<Coupon> couponList = new ArrayList<Coupon>();
        Map<String ,Object> params = new HashMap<String,Object>();
        params.put("userId",userId);
        params.put("status",status);
        params.put("category",category);

        try{
            //TODO:mapper unfinished
          return  getSqlSession().selectList("com.travel.bean.Coupon.getCouponListByUserId",params);
        }catch (Exception e ){
            return null ;
        }
    }

    @Override
    public int addCoupon(Coupon coupon) {
        if(coupon ==null){
            return -1;
        }
        long currentTime = System.currentTimeMillis()/1000;
        long effective = 0;
        if(coupon.getEffective()!=null){
            effective = coupon.getEffective()*3600;
        }

        coupon.setCreateTime(currentTime);
        coupon.setUpdateTime(currentTime);
        coupon.setStartTime(currentTime);
        coupon.setEndTime(currentTime+effective);
        try{
            int ok =  getSqlSession().insert("com.travel.bean.Coupon.addCoupon",coupon);
            if(ok==1){
                return coupon.getId();
            }
        }catch (Exception e ){
            return -1;
        }
        return -1;
    }

    @Override
    public int updateCoupon(Coupon coupon) {
        try{
            int ok  = getSqlSession().update("com.travel.bean.Coupon.updateCoupon",coupon);
            if(ok == 1)
                return coupon.getId();
        }catch (Exception e ){
            return -1 ;
        }
        return -1;
    }

    @Override
    public int removeCoupon(Integer id) {
        try{
            //TODO:mapper unfinished
           return  getSqlSession().delete("com.travel.bean.Coupon.removeCoupon",id);

        }catch (Exception e ){
            return -1 ;
        }

    }


}
