package com.travel.controller;

import com.travel.service.ProductService;
import com.travel.service.SlideBoxService;
import com.travel.util.Page;
import com.travel.web.PageResponse;
import com.travel.web.Response;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;

@Controller
public class IndexController {


    @Resource(name = "RouteService" )
    private ProductService routeService;
    @Resource(name = "HotelService" )
    private ProductService hotelService;
    @Resource(name = "TicketService" )
    private ProductService ticketService;
    @Resource
    private SlideBoxService slideBoxService;

    public void setSlideBoxService(SlideBoxService slideBoxService) {
        this.slideBoxService = slideBoxService;
    }

    public void setRouteService(ProductService routeService) {
        this.routeService = routeService;
    }

    public void setHotelService(ProductService hotelService) {
        this.hotelService = hotelService;
    }

    public void setTicketService(ProductService ticketService) {
        this.ticketService = ticketService;
    }
    @ResponseBody
    @RequestMapping(value = "/route/recommends")
    public PageResponse getRecommendRoutes(Page page) throws Exception {

        return routeService.getRecommends();
    }
    @ResponseBody
    @RequestMapping(value = "/hotel/recommends")
    public PageResponse getRecommendHotels(Page page) throws Exception {

        return hotelService.getRecommends();
    }
    @ResponseBody
    @RequestMapping(value = "/ticket/recommends")
    public PageResponse getRecommendTickets(Page page) throws Exception {


        return hotelService.getRecommends();
    }
    @ResponseBody
    @RequestMapping(value = "/index/slideBox")
    public Response getSlideBox(HttpServletRequest request) throws Exception {
        //返回图片

        return slideBoxService.getSlideBoxs("index", 1, null);
    }

}
