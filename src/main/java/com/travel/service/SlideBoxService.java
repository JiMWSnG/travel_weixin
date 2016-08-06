package com.travel.service;

import com.travel.bean.SlideBox;
import com.travel.web.Response;

/**
 * Created by Jim Wang on 2016/7/25.
 */
public interface SlideBoxService {
    Response getSlideBoxs(String place, Integer status, Integer size);
    Response addSlideBox(SlideBox slideBox);
}
