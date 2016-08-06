package com.travel.service.impl;

import com.travel.bean.Contact;
import com.travel.bean.HotelOrder;
import com.travel.bean.Order;
import com.travel.bean.RouteOrder;
import com.travel.contants.Contants;
import com.travel.dao.BaseOrderDao;
import com.travel.dao.ContactDao;
import com.travel.service.OrderService;
import com.travel.web.Response;
import org.apache.commons.collections.map.HashedMap;
import org.mybatis.spring.support.SqlSessionDaoSupport;

import java.util.Map;

/**
 * Created by Jim Wang on 2016/8/1.
 */
public class HotelOrderServiceImpl implements OrderService {


    private BaseOrderDao hotelOrderDao;

    private ContactDao contactDao;

    public void setHotelOrderDao(BaseOrderDao orderDao) {
        this.hotelOrderDao = orderDao;
    }

    public void setContactDao(ContactDao contactDao) {
        this.contactDao = contactDao;
    }

    @Override
    public Response addOrder(Order order,Contact contact) {
        HotelOrder hotelOrder  = (HotelOrder) order;
        Response response = new Response();
        int orderId = hotelOrderDao.addOrder(hotelOrder);
        if ( orderId!= -1) {
            contact.setOrderId(orderId);
            if(contactDao.addContact(contact)!=-1){
                response.setSuccess(true);
                return response;
            }else{
                //TODO:删除已经添加的order,回滚

            }

        }
        response.setSuccess(false);
        response.setCode(Contants.DB_ERROR_CODE);
        return response;
    }
}
