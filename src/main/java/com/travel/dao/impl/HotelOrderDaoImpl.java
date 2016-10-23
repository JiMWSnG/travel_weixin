package com.travel.dao.impl;

import com.travel.bean.HotelOrder;
import com.travel.bean.Order;
import com.travel.bean.RouteOrder;
import com.travel.dao.BaseOrderDao;
import org.apache.commons.collections.map.HashedMap;
import org.mybatis.spring.support.SqlSessionDaoSupport;

import java.util.List;
import java.util.Map;

/**
 * Created by Jim Wang on 2016/8/1.
 */
public class HotelOrderDaoImpl extends SqlSessionDaoSupport implements BaseOrderDao {
    @Override
    public int addOrder(Order order) {
        Map<String ,Object> params = new HashedMap();
        if(order instanceof HotelOrder){
            HotelOrder hotelOrder = (HotelOrder) order;
            params.put("checkMan",hotelOrder.getCheckMan());
            params.put("day",hotelOrder.getDay());
            params.put("roomType",hotelOrder.getRoomType());
        }else{
            return -1;
        }
        try{
            if(!params.isEmpty()){
                getSqlSession().insert("com.travel.bean.Order.addOrder",order);
                params.put("orderId",order.getId());
                getSqlSession().insert("com.travel.bean.HotelOrder.addHotelOrder",params);

                return order.getId();
            }
        }catch (Exception e){
            return -1;
        }
        return -1;
    }

    @Override
    public int removeOrder(Order order) {
        return 0;
    }

    @Override
    public List<Order> getOrders(String status, int userId, String type) {
        return null;
    }
}
