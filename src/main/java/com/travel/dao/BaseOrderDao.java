package com.travel.dao;

import com.travel.bean.Order;

public interface BaseOrderDao {
    /**
     *
     * @param order
     * @return 返回order的id
     */
    int addOrder(Order order);
}
