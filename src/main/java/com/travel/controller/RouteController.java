package com.travel.controller;

import com.travel.bean.Product;
import com.travel.service.ProductService;
import com.travel.service.SlideBoxService;
import com.travel.util.Page;
import com.travel.web.PageResponse;
import com.travel.web.Response;
import org.apache.commons.collections.functors.ExceptionPredicate;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.annotation.Resource;
import java.util.List;

/**
 * Created by Jim Wang on 2016/7/15.
 */
@Controller
@RequestMapping("/route")
public class RouteController {
    @Resource(name = "RouteService")
    private ProductService routeService;
    @Resource
    private SlideBoxService slideBoxService;

    public void setSlideBoxService(SlideBoxService slideBoxService) {
        this.slideBoxService = slideBoxService;
    }

    public void setRouteService(ProductService routeService) {
        this.routeService = routeService;
    }
    @ResponseBody
    @RequestMapping("slideBox")
    public Response getSlideBox()throws Exception{
        //返回图片
        return slideBoxService.getSlideBoxs("route",1,null);
    }
    @ResponseBody
    @RequestMapping("search/{type}/{location}/{indexs}")
    public PageResponse searchRoutes(@PathVariable("type") String type,
         @PathVariable("location") String location, @PathVariable("indexs") String indexs,Page page) throws Exception{
        return routeService.search(type,location,indexs);
    }
    @ResponseBody
    @RequestMapping("detail/{routeId}")
    public Response getRouteDetail(@PathVariable("routeId") int routeId) throws Exception {
         return routeService.getById(routeId);
    }

}
