package com.travel.service.impl;

import com.travel.bean.Product;
import com.travel.bean.Route;
import com.travel.contants.Contants;
import com.travel.dao.ProductDao;
import com.travel.service.RouteService;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/**
 * Created by Administrator on 2016/7/8.
 */
public class RouteServiceImpl implements RouteService {
    @Autowired
    private ProductDao routeDao;

    @Override
    public List<Route> getAllRoutes() {
        List<Product> routes = routeDao.queryAll();
        List<Route> result = new ArrayList<Route>();
        Iterator<Product> itr = routes.iterator();
        while (itr.hasNext()) {
            result.add((Route) itr.next());
        }
        return result;
    }

    @Override
    public Route searchRouteById(int id) {
        return (Route) routeDao.queryById(id);
    }

    @Override
    public List<Route> getRecommendRoutes() {
        List<Product> routes = routeDao.query(Contants.ROUTE_TYPE_RECOMMEND, null, null);
        List<Route> result = new ArrayList<Route>();
        Iterator<Product> itr = routes.iterator();
        while (itr.hasNext()) {
            result.add((Route) itr.next());
        }
        return result;
    }

    @Override
    public int addRoute(Route route) {
        return routeDao.add(route);
    }
}
