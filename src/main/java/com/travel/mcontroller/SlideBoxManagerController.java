package com.travel.mcontroller;

import com.travel.bean.SlideBox;
import com.travel.service.SlideBoxService;
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
@RequestMapping("/backstage/slideBox")
public class SlideBoxManagerController {
    @Resource
    private SlideBoxService slideBoxService;
    @ResponseBody
    @RequestMapping(value = "add",method = RequestMethod.POST)
    public Response addSlideBox(SlideBox slideBox)throws Exception{
        return slideBoxService.addSlideBox(slideBox);
    }
}
