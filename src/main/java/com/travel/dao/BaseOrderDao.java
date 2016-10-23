package com.travel.dao;

import com.travel.bean.Order;

import java.util.List;

public interface BaseOrderDao {
    /**
     *
     * @param order
     * @return 返回order的id
     */
    int addOrder(Order order);
    int removeOrder(Order order);
    List<Order> getOrders(String status, int userId, String type);
}
