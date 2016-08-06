package com.travel.service.impl;

import com.travel.bean.SlideBox;
import com.travel.contants.Contants;
import com.travel.dao.SlideBoxDao;
import com.travel.service.SlideBoxService;
import com.travel.web.Response;

import javax.annotation.Resource;
import java.util.Date;
import java.util.List;

/**
 * Created by Jim Wang on 2016/7/25.
 */
public class SlideBoxServiceImpl implements SlideBoxService {


    private SlideBoxDao slideBoxDao;

    public void setSlideBoxDao(SlideBoxDao slideBoxDao) {
        this.slideBoxDao = slideBoxDao;
    }

    @Override
    public Response getSlideBoxs(String place, Integer status, Integer size) {
        List<SlideBox> slideBoxs;
        Response response = new Response();
        slideBoxs = slideBoxDao.queryByPlace(place, status);
        if (slideBoxs == null ) {

            response.setSuccess(false);
            response.setCode(Contants.DB_ERROR_CODE);
            return response;
        }

        response.setData(slideBoxs);
        response.setSuccess(true);
        return response;
    }

    @Override
    public Response addSlideBox(SlideBox slideBox) {
        Response response = new Response();
        if (slideBoxDao.addSlideBox(slideBox) < 0) {
            response.setSuccess(false);
            response.setCode(Contants.DB_ERROR_CODE);
            return response;
        }
        response.setSuccess(true);

        return response;
    }
}
