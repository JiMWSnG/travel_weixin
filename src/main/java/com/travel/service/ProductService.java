package com.travel.service;

import com.travel.bean.Route;
import com.travel.web.PageResponse;
import com.travel.web.Response;

/**
 * Created by Administrator on 2016/7/8.
 */
public interface ProductService {
    PageResponse getAll();

    Response getById(int id);

    int add(Route route);

    PageResponse getRecommends();



}
