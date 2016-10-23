package com.travel.service;

import com.travel.bean.Contact;
import com.travel.bean.Order;
import com.travel.web.Response;

/**
 * Created by Jim Wang on 2016/7/28.
 */
public interface OrderService {
    Response addOrder(Order order, Contact contact);
    Response showOrderList(String type,String status,Integer userId);
    Response showOrderDetail(int orderId);
    Response deleteOrder(int orderId);

}
