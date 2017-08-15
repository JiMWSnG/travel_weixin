package com.travel.controller;

import com.travel.bean.Contact;
import com.travel.bean.HotelOrder;
import com.travel.bean.RouteOrder;
import com.travel.contants.Contants;
import com.travel.service.CouponService;
import com.travel.service.OrderService;
import com.travel.util.RandomStringUtil;
import com.travel.web.CouponRequest;
import com.travel.web.OrderRequest;
import com.travel.web.Response;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.annotation.Resource;

/**
 * Created by Jim Wang on 2016/7/28.
 */
@Controller
@RequestMapping("/coupon")
public class CouponController {
    @Resource
    private CouponService couponService;

//    @Resource(name="TicketOrderService")
//    private OrderService ticketOrderService;


    @ResponseBody
    @RequestMapping(value = "/add",method = RequestMethod.POST)
    public Response addCoupon(CouponRequest coupon){
        //TODO: 通过session得到userId,优惠券生成的时候已经分配给某个用户
        //设计模式；
        coupon.setUserId(11);
        coupon.setCode(RandomStringUtil.getRandomString3(10));
        coupon.setName("通用优惠券");
        coupon.setPrice(10.00);
       return couponService.addCoupon(coupon);


    }

    /**
     *
     * @param type: route,ticket,hotel,normal,all
     * @param status:available,used,expired /0,1,-1
     * @return
     * @throws Exception
     */
    @ResponseBody
    @RequestMapping(value = "/showlist/{type}/{status}",method = RequestMethod.GET)
    public Response getCouponList(@PathVariable String type,@PathVariable Integer status) throws Exception{
        //TODO:通过session得到userId
        int userId = 11;
        return couponService.getCouponList(userId,status,type);
          //  return routeOrderService.showOrderList(type, status, userId);


    }

}


