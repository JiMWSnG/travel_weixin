package com.travel.service.impl;

import com.travel.bean.Product;
import com.travel.bean.Route;
import com.travel.bean.RouteCalendar;
import com.travel.contants.Contants;
import com.travel.dao.CalendarDao;
import com.travel.dao.ProductDao;
import com.travel.service.ProductService;
import com.travel.util.PageContext;
import com.travel.web.PageResponse;
import com.travel.web.Request;
import com.travel.web.Response;
import com.travel.web.RouteRequest;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by Administrator on 2016/7/8.
 */
public class RouteServiceImpl implements ProductService {

    private ProductDao routeDao;
    private CalendarDao routeCalendarDao;

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
        Route route;
        RouteCalendar routeCalendar;
        route = (Route) routeDao.queryById(id);
        routeCalendar = (RouteCalendar) routeCalendarDao.queryCalendar(id);
        if(route==null||routeCalendar==null) {
            response.setSuccess(false);
            response.setMsg("数据库故障");
            response.setCode(Contants.DB_ERROR_CODE);
            return response;
        }

        Map<String, Object> routeDetail = new HashMap<String, Object>();
        //if(route!=null){
        routeDetail.put("route",route);
        //}

       // if(routeCalendar!=null){
        routeDetail.put("routeCalendar",routeCalendar);
        //}
        if(routeDetail!=null){
            response.setSuccess(true);
            response.setData(routeDetail);
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
            response.setCode(Contants.DB_ERROR_CODE);
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
    public Response add(Request request) {
        Response response = new Response();
        RouteRequest routeRequest= (RouteRequest) request;
        if(routeRequest ==null){
            response.setSuccess(false);
            response.setCode(Contants.PARAM_ERROR_CODE);
            response.setMsg("参数为空");
            return response;
        }
        int routeId = routeDao.add(routeRequest);
        if(routeId<0){
            response.setSuccess(false);
            response.setCode(Contants.DB_ERROR_CODE);
            response.setMsg("数据库故障");
            return response;
        }
        RouteCalendar routeCalendar = new RouteCalendar();
        routeCalendar.setCalendar(routeRequest.getCalendar());
        routeCalendar.setProductId(routeId);
        if(routeCalendarDao.addCalendar(routeCalendar)<0){
            routeDao.remove(routeId);
            response.setSuccess(false);
            response.setCode(Contants.DB_ERROR_CODE);
            response.setMsg("数据库故障");
            return response;
        }
        response.setSuccess(true);
        response.setData(routeId);
        return response;



    }

    public void setRouteDao(ProductDao routeDao) {
        this.routeDao = routeDao;
    }

    public void setRouteCalendarDao(CalendarDao routeCalendarDao) {
        this.routeCalendarDao = routeCalendarDao;
    }

}
