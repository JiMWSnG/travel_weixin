package com.travel.service.impl;

import com.travel.bean.Hotel;
import com.travel.bean.HotelCalendar;
import com.travel.bean.HotelMeta;
import com.travel.bean.Product;
import com.travel.contants.Contants;
import com.travel.dao.CalendarDao;
import com.travel.dao.HotelDao;
import com.travel.dao.ProductDao;
import com.travel.service.HotelService;
import com.travel.service.ProductService;
import com.travel.util.PageContext;
import com.travel.web.HotelRequest;
import com.travel.web.PageResponse;
import com.travel.web.Request;
import com.travel.web.Response;

import java.util.List;

/**
 * Created by Administrator on 2016/7/13.
 */
public class HotelServiceImpl implements HotelService,ProductService {
    private HotelDao  hotelDaoSpecial;
    private ProductDao hotelDao;

    private CalendarDao hotelCalendarDao;

    public void setHotelCalendarDao(CalendarDao hotelCalendarDao) {
        this.hotelCalendarDao = hotelCalendarDao;
    }
    @Override
    public PageResponse searchHotels(String type, String location, String keyword, String level) {
        PageResponse response = new PageResponse();
        List<Hotel> hotels = hotelDaoSpecial.queryHotel(type,location,keyword,level);
        if(hotels!=null){
            response.setPage(PageContext.getContext());
            response.setData(hotels);
            response.setSuccess(true);

        }else {
            response.setCode(Contants.DB_ERROR_CODE);
            response.setSuccess(false);
        }
        return response;

    }



    public void setHotelDaoSpecial(HotelDao hotelDaoSpecial) {
        this.hotelDaoSpecial = hotelDaoSpecial;
    }
    public void setHotelDao(ProductDao hotelDao) {
        this.hotelDao = hotelDao;
    }
    @Override
    public PageResponse getAll() {
        return null;
    }

    @Override
    public Response getById(int id) {//TODO:写到这里，正准备添加 hoteldescriptipn
        Response response = new Response();
        Hotel hotel = (Hotel) hotelDao.queryById(id);;
        if(hotel==null){
            response.setSuccess(false);
            response.setCode(Contants.DB_ERROR_CODE);
            return response;
        }
        response.setData(hotel);
        response.setSuccess(true);
        return response;
    }

    @Override
    public Response add(Request request) {
        Response response =new Response();
        HotelRequest hotelRequest =(HotelRequest)request;
        Hotel hotel = hotelRequest;
        int hotelId = hotelDao.add(hotel);
        if(hotelId<0){
            response.setSuccess(false);
            response.setCode(Contants.DB_ERROR_CODE);
            return response;
        }
        HotelCalendar hotelCalendar = new HotelCalendar();
        hotelCalendar.setProductId(hotelId);
        hotelCalendar.setCalendar(hotelRequest.getCalendar());
        if(hotelCalendarDao.addCalendar(hotelCalendar)<0){
            hotelDao.remove(hotelId);
            response.setSuccess(false);
            response.setCode(Contants.DB_ERROR_CODE);
            return response;
        }
        response.setSuccess(true);
        response.setData(hotelId);
        return response;
    }

    @Override
    public PageResponse search(String type, String location, String indexs) {
        return null;
    }

    @Override
    public PageResponse getRecommends() {
        PageResponse response = new PageResponse();
        List<Product> hotels = hotelDao.query(Contants.HOTEL_CATEGORY_RECOMMEND, null, null);
        if(hotels!=null){
            response.setPage(PageContext.getContext());
            response.setData(hotels);
            response.setSuccess(true);
        }else {
            response.setSuccess(false);
            response.setCode(Contants.DB_ERROR_CODE);
        }
        return response;
    }

    @Override
    public Response addHotelMeta(HotelRequest hotelRequest) {
        Response response = new Response();
        HotelMeta hotelMeta = new HotelMeta();
        hotelMeta.setCategory(hotelRequest.getCategory());
        hotelMeta.setLevel(hotelRequest.getLevel());
        hotelMeta.setName(hotelRequest.getName());
        hotelMeta.setLocation(hotelRequest.getLocation());
        hotelMeta.setIndexs(hotelRequest.getIndexs());
        int hotelMetaId = hotelDaoSpecial.addHotelMeta(hotelMeta);
        if(hotelMetaId<0){
            response.setSuccess(false);
            response.setCode(Contants.DB_ERROR_CODE);
            return response;
        }
        response.setSuccess(true);
        response.setData(hotelMetaId);
        return response;
    }
}
