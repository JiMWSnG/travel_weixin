package com.travel.mcontroller;

import com.travel.bean.Route;
import com.travel.service.ProductService;
import com.travel.web.Response;
import com.travel.web.RouteRequest;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.annotation.Resource;

/**
 * Created by Jim Wang on 2016/8/5.
 */
@Controller
@RequestMapping("/backstage/route")
public class RouteManagerController {
    @Resource(name="RouteService")
    private ProductService routeService;

    @ResponseBody
    @RequestMapping(value = "/add",method = RequestMethod.POST)
    public Response addRoute(RouteRequest routeRequest)throws Exception{
          return  routeService.add(routeRequest);
    }

}
