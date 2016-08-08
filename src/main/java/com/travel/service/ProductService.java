package com.travel.service;

import com.travel.web.PageResponse;
import com.travel.web.Request;
import com.travel.web.Response;

/**
 * Created by Administrator on 2016/7/8.
 */
public interface ProductService {
    PageResponse getAll();

    Response getById(int id);

    Response add(Request request);

    PageResponse getRecommends();

    PageResponse search(String type,String location,String indexs);



}
