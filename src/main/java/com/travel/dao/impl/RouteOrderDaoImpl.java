package com.travel.dao.impl;

import com.travel.bean.Order;
import com.travel.bean.RouteOrder;
import com.travel.dao.BaseOrderDao;
import org.apache.commons.collections.map.HashedMap;
import org.mybatis.spring.support.SqlSessionDaoSupport;

import java.util.List;
import java.util.Map;

public class RouteOrderDaoImpl extends SqlSessionDaoSupport implements BaseOrderDao {
    @Override
    public int addOrder(Order order) {
        Map<String, Object> params = new HashedMap();
        if (order instanceof RouteOrder) {
            RouteOrder routeOrder = (RouteOrder) order;
            long currentTime = System.currentTimeMillis()/1000;
            routeOrder.setCreateTime(currentTime);
            routeOrder.setUpdateTime(currentTime);
            params.put("insured", routeOrder.getInsured());

        }else{
            return -1;
        }
        try {
            if (!params.isEmpty()) {
                getSqlSession().insert("com.travel.bean.Order.addOrder", order);
                params.put("orderId", order.getId());
                //route_info的id會自動添加到params裏面
                getSqlSession().insert("com.travel.bean.RouteOrder.addRouteOrder", params);

                return order.getId();
            }

        } catch (Exception e) {
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
