package com.travel.controller;

import com.travel.service.HotelService;
import com.travel.service.ProductService;
import com.travel.service.impl.HotelServiceImpl;
import com.travel.util.Page;
import com.travel.web.PageResponse;
import com.travel.web.Response;
import org.springframework.context.annotation.EnableAspectJAutoProxy;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.annotation.Resource;

/**
 * Created by Jim Wang on 2016/7/25.
 */
@Controller
@RequestMapping("/hotel")
public class HotelController {


    public void setHotelService(ProductService hotelService) {
        this.hotelService = hotelService;
    }

    public void setHotelSpecialService(HotelService hotelSpecialService) {
        this.hotelSpecialService = hotelSpecialService;
    }
    @Resource(name = "HotelService")
    private ProductService hotelService;
    @Resource
    private HotelService  hotelSpecialService;



    @ResponseBody
    @RequestMapping(value = "/search/{type}/{location}/{indexs}/{level}")
    public PageResponse searchHotels(@PathVariable String type,@PathVariable String location,@PathVariable("indexs") String keyword,@PathVariable String level, Page page){
        return hotelSpecialService.searchHotels(type,location,keyword,level);
    }
    @ResponseBody
    @RequestMapping(value = "/detail/{hotelId}")
    public Response getHotelDetail(@PathVariable int hotelId){
        return hotelService.getById(hotelId);
    }
}
