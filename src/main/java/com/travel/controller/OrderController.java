package com.travel.controller;

import com.travel.bean.Contact;
import com.travel.bean.HotelOrder;
import com.travel.bean.Order;
import com.travel.bean.RouteOrder;
import com.travel.contants.Contants;
import com.travel.service.OrderService;
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
    @ResponseBody
    @RequestMapping(value = "/add",method = RequestMethod.POST)
    public Response addOrder(OrderRequest order, Contact contact){
        String kind =order.getType();
        order.setStatus(Contants.ORDER_STATUS_TOVERIFY);
        //TODO: 通过session得到userId
        order.setUserId(11);
        if("route".equals(kind)){
            RouteOrder routeOrder = new RouteOrder(order,order.getManInfo());
            return routeOrderService.addOrder(routeOrder,contact);
        }else if("hotel".equals(kind)){
            HotelOrder hotelOrder = new HotelOrder(order,order.getManInfo(),order.getRoomType(),order.getDay());
            return hotelOrderService.addOrder(hotelOrder,contact);
        }else if("ticket".equals(kind)){
            //TODO:
            return null;
        }else{
            //error
            return new Response(false, Contants.PARAM_ERROR_CODE,"订单类型参数错误",null);
        }


    }
    @ResponseBody
    @RequestMapping(value = "/showlist/{type}/{status}",method = RequestMethod.GET)
    public Response getOrderList(@PathVariable String type,@PathVariable String status) throws Exception{
        //TODO:通过session得到userId
        int userId = 11;


            return routeOrderService.showOrderList(type, status, userId);


    }

}


