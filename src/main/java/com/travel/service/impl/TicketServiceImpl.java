package com.travel.service.impl;

import com.travel.bean.Product;
import com.travel.contants.Contants;
import com.travel.dao.ProductDao;
import com.travel.service.ProductService;
import com.travel.util.PageContext;
import com.travel.web.PageResponse;
import com.travel.web.Response;
import com.travel.web.RouteRequest;

import java.util.List;

/**
 * jim wang
 * Created by jim wng on 2016/7/14.
 */
public class TicketServiceImpl implements ProductService {


    private ProductDao ticketDao;

    public void setTicketDao(ProductDao ticketDao) {
        this.ticketDao = ticketDao;
    }
    @Override
    public PageResponse search(String type, String location, String indexs) {
        return null;
    }

    @Override
    public PageResponse getRecommends() {
        PageResponse response = new PageResponse();
        List<Product> tickets = ticketDao.query(Contants.TICKET_TYPE_RECOMMEND, null, null);
        if(tickets!=null){
            response.setData(tickets);
            response.setPage(PageContext.getContext());
            response.setSuccess(true);
        }else {
            response.setSuccess(false);
        }
        return response;
    }

    @Override
    public Response add(RouteRequest route) {
        return null;
    }

    @Override
    public Response getById(int id) {
        return null;
    }

    @Override
    public PageResponse getAll() {
        return null;
    }
}
