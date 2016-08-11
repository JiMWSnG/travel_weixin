package com.travel.service.impl;

import com.sun.crypto.provider.RSACipher;
import com.travel.bean.Contact;
import com.travel.bean.Order;
import com.travel.bean.Route;
import com.travel.bean.RouteOrder;
import com.travel.contants.Contants;
import com.travel.dao.BaseOrderDao;
import com.travel.dao.ContactDao;
import com.travel.service.OrderService;
import com.travel.web.Response;

/**
 * Created by Jim Wang on 2016/7/28.
 */
public class RouteOrderServiceImpl implements OrderService {


    private BaseOrderDao routeOrderDao;
    private ContactDao contactDao;

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
}
