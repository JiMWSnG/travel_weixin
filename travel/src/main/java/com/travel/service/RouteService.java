package com.travel.service;

import com.travel.bean.Route;

import java.util.List;

/**
 * Created by Administrator on 2016/7/8.
 */
public interface RouteService {
    List<Route> getAllRoutes();

    Route searchRouteById(int id);

    int addRoute(Route route);

    List<Route> getRecommendRoutes();


}
