package com.travel.service.impl;

import com.travel.bean.*;
import com.travel.contants.Contants;
import com.travel.dao.BaseOrderDao;
import com.travel.dao.ContactDao;
import com.travel.dao.impl.OrderDaoImpl;
import com.travel.service.OrderService;
import com.travel.web.Response;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by Jim Wang on 2016/7/28.
 */
public class RouteOrderServiceImpl implements OrderService {
    private BaseOrderDao orderDao;
    private BaseOrderDao routeOrderDao;
    private ContactDao contactDao;


    public void setOrderDao(BaseOrderDao orderDao) {
        this.orderDao = orderDao;
    }

    public void setContactDao(ContactDao contactDao) {
        this.contactDao = contactDao;
    }

    public void setRouteOrderDao(BaseOrderDao orderDao) {
        this.routeOrderDao = orderDao;
    }

    @Override
    public Response addOrder(Order order,Contact contact) {
        Response response = new Response();
        RouteOrder routeOrder;
        if(order instanceof RouteOrder){

            routeOrder = (RouteOrder) order;
        }else{
            response.setSuccess(false);
            response.setCode(Contants.PARAM_ERROR_CODE);
            return response;
        }
        int orderId = routeOrderDao.addOrder(routeOrder);
        if(orderId!=-1){//订单添加成功
            //response.setSuccess(true);
            contact.setOrderId(orderId);
            if(contactDao.addContact(contact)!=-1){
                response.setSuccess(true);
                response.setData(orderId);
                return response;
            }else{
                //TODO:删除已经添加的routeorder,回滚
                //routeOrderDao.remove(orderId);

            }
        }
        response.setSuccess(false);
        response.setCode(Contants.DB_ERROR_CODE);
        return response;
    }

    @Override
    public Response showOrderList(String type, String status, Integer userId) {
        Response response= new Response();
        List<Order> orders =
                 orderDao.getOrders(status,userId,type);
        if(orders!=null){
            response.setData(orders);
            response.setSuccess(true);
        }else{
            response.setSuccess(false);
            response.setCode(Contants.DB_ERROR_CODE);
        }
        return response;
    }

    @Override
    public Response showOrderDetail(int orderId) {
        return null;
    }

    @Override
    public Response deleteOrder(int orderId) {
        return null;
    }
}
