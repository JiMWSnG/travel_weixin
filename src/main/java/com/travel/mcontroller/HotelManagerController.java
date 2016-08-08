package com.travel.mcontroller;

import com.travel.service.HotelService;
import com.travel.service.ProductService;
import com.travel.web.HotelRequest;
import com.travel.web.Response;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.annotation.Resource;

/**
 * Created by Jim Wang on 2016/8/6.
 */
@Controller
@RequestMapping("/backstage/hotel")
public class HotelManagerController {

    @Resource(name="HotelService")
    private ProductService hotelService;
    @Resource(name="HotelService")
    private HotelService hotelSpecialService;
    @ResponseBody
    @RequestMapping(value = "/add",method = RequestMethod.POST)
    public Response addHotel(HotelRequest hotelRequest){
        return hotelService.add(hotelRequest);
    }
    @ResponseBody
    @RequestMapping(value = "/addMeta",method = RequestMethod.POST)
    public Response addHotelMeta(HotelRequest hotelRequest){
        return hotelSpecialService.addHotelMeta(hotelRequest);
    }

}
