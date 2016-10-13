package com.travel.service.impl;

import com.travel.bean.RouteDescription;
import com.travel.dao.DescriptionDao;
import com.travel.entity.Description;
import com.travel.service.DescriptionService;

import javax.annotation.Resource;

/**
 * Created by Jim Wang on 2016/10/13.
 */
public class RouteDescriptionServiceImpl implements DescriptionService {
    @Resource
    private DescriptionDao routeDescriptionDao;

    @Override
    public Description getDescriptionByProductId(Integer routeId) {
        return routeDescriptionDao.queryDescriptionByProductId(routeId);
    }

    @Override
    public int addDescription(Description description) {
        return routeDescriptionDao.addDescription(description);
    }
}
