package com.travel.controller;

import com.travel.bean.Contact;
import com.travel.bean.HotelOrder;
import com.travel.bean.Order;
import com.travel.bean.RouteOrder;
import com.travel.contants.Contants;
import com.travel.service.OrderService;
import com.travel.web.Response;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import javax.annotation.Resource;

/**
 * Created by Jim Wang on 2016/7/28.
 */
@Controller
@RequestMapping("/order")
public class OrderController {
    @Resource(name = "RouteOrderService")
    private OrderService routeOrderService;
    @Resource(name = "HotelOrderService")
    private OrderService hotelOrderService;
//    @Resource(name="TicketOrderService")
//    private OrderService ticketOrderService;

    public void setRouteOrderService(OrderService routeOrderService) {
        this.routeOrderService = routeOrderService;
    }

    public void setHotelOrderService(OrderService hotelOrderService) {
        this.hotelOrderService = hotelOrderService;
    }
    @RequestMapping(value = "/add",method = RequestMethod.POST)
    public Response addOrder(Order order, String kind, Contact contact, String manInfo, String roomType, Integer day){
        if("route".equals(kind)){
            String insured = manInfo;
            RouteOrder routeOrder = new RouteOrder(order,insured);
            return routeOrderService.addOrder(routeOrder,contact);
        }else if("hotel".equals(kind)){
            String checkMan = manInfo;
            HotelOrder hotelOrder = new HotelOrder(order,checkMan,roomType,day);
            return hotelOrderService.addOrder(hotelOrder,contact);
        }else if("ticket".equals(kind)){
            //TODO:
            return null;
        }else{
            //error
            return new Response(false, Contants.PARAM_ERROR_CODE,"订单类型参数错误",null);
        }


    }


}
