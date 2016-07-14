package com.travel.service.impl;

import com.travel.bean.Product;
import com.travel.bean.Route;
import com.travel.contants.Contants;
import com.travel.dao.ProductDao;
import com.travel.service.ProductService;
import com.travel.util.PageContext;
import com.travel.web.PageResponse;
import com.travel.web.Response;
import org.springframework.beans.factory.annotation.Autowired;

import javax.annotation.Resource;
import java.util.List;

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
    public PageResponse search(String type, String location, String indexs) {
        return null;
    }

    @Override
    public PageResponse getRecommends() {
        PageResponse response = new PageResponse();
        List<Product> hotels = hotelDao.query(Contants.HOTEL_TYPE_RECOMMEND, null, null);
        if(hotels!=null){
            response.setPage(PageContext.getContext());
            response.setData(hotels);
            response.setSuccess(true);
        }else {
            response.setSuccess(false);
        }
        return response;
    }
}
