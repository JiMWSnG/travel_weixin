package com.travel.service.impl;

import com.travel.bean.Route;
import com.travel.dao.ProductDao;
import com.travel.service.ProductService;
import com.travel.web.PageResponse;
import com.travel.web.Response;
import org.springframework.beans.factory.annotation.Autowired;

import javax.annotation.Resource;

/**
 * Created by Administrator on 2016/7/13.
 */
public class HotelServiceImpl implements ProductService {


    @Resource
    private ProductDao hotelDao;
    @Override
    public PageResponse getAll() {
        return null;
    }

    @Override
    public Response getById(int id) {
        return null;
    }

    @Override
    public int add(Route route) {
        return 0;
    }

    @Override
    public PageResponse getRecommends() {
        return null;
    }
}
