package com.travel.service;

import com.travel.web.HotelRequest;
import com.travel.web.PageResponse;
import com.travel.web.Response;

/**
 * Created by Administrator on 2016/7/13.
 */
//暫時不用
public interface HotelService {
     PageResponse searchHotels(String type,String location,String keyword,String level);
     Response addHotelMeta(HotelRequest hotelRequest);
}
