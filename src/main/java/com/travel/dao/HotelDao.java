package com.travel.dao;

import com.travel.bean.Hotel;
import com.travel.bean.HotelMeta;

import java.util.List;

/**
 * Created by Jim Wang on 2016/7/25.
 */
public interface HotelDao {
     List<Hotel> queryHotel(String type,String location,String keyword,String level);
     int addHotelMeta(HotelMeta hotelMeta);
     int removeHotelMeta(int hotelMetaId);
}
