package com.travel.service;

import com.travel.web.PageResponse;
import com.travel.web.Response;
import com.travel.web.RouteRequest;

/**
 * Created by Administrator on 2016/7/8.
 */
public interface ProductService {
    PageResponse getAll();

    Response getById(int id);

    Response add(RouteRequest route);

    PageResponse getRecommends();

    PageResponse search(String type,String location,String indexs);



}
