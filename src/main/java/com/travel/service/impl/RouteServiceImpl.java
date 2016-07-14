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
 * Created by Administrator on 2016/7/8.
 */
public class RouteServiceImpl implements ProductService {


    private ProductDao routeDao;

    @Override
    public PageResponse getAll() {
        PageResponse response = new PageResponse();
        List<Product> routes = routeDao.queryAll();
       if(routes!=null){
           response.setSuccess(true);
           response.setData(routes);
       }else {
           response.setSuccess(false);
       }
        return response;
    }

    @Override
    public Response getById(int id) {
        Response response = new Response();
        Route route =  (Route) routeDao.queryById(id);
        if(route!=null){
            response.setSuccess(true);
            response.setData(route);
        }else {
            response.setSuccess(false);
        }

        return response;
    }

    @Override
    public PageResponse getRecommends() {
        PageResponse response = new PageResponse();
        List<Product> routes = routeDao.query(Contants.ROUTE_TYPE_RECOMMEND, null, null);
        if(routes!=null){
            response.setSuccess(true);
            response.setData(routes);
            response.setPage(PageContext.getContext());
        }else {
            response.setSuccess(false);
        }
        return response;
    }

    @Override
    public PageResponse search(String type, String location, String indexs) {
        PageResponse response = new PageResponse();
        List<Product> routes = routeDao.query(type, location, indexs);
        if(routes!=null){
            response.setSuccess(true);
            response.setData(routes);
            response.setPage(PageContext.getContext());
        }else {
            response.setSuccess(false);
        }
        return response;
    }

    @Override
    public int add(Route route) {
        return routeDao.add(route);
    }

    public void setRouteDao(ProductDao routeDao) {
    }
}
