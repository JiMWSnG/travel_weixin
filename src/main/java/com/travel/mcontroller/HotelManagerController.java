package com.travel.mcontroller;

import com.travel.service.ProductService;
import com.travel.web.HotelRequest;
import com.travel.web.Response;
import org.springframework.stereotype.Controller;

import javax.annotation.Resource;

/**
 * Created by Jim Wang on 2016/8/6.
 */
@Controller
public class HotelManagerController {

    @Resource(name="HotelService")
    private ProductService hotelService;

    public Response addHotel(HotelRequest hotelRequest){
        return null;
    }

}
