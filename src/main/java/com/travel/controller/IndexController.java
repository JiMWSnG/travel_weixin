package com.travel.controller;

import com.travel.service.ProductService;
import com.travel.util.Page;
import com.travel.web.PageResponse;
import com.travel.web.Response;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import javax.annotation.Resource;

public class IndexController {
	@Resource
	private ProductService routeService;
	@Resource
	private ProductService hotelService;
	@Resource
	private ProductService ticketService;
	@RequestMapping(value="route/recommends")
	public PageResponse getRecommendRoutes(Page page)throws Exception{

		return routeService.getRecommends();
	}

	@RequestMapping(value="hotel/recommends")
	public PageResponse getRecommendHotels(Page page)throws Exception{

		return hotelService.getRecommends();
	}

	@RequestMapping(value="ticket/recommends")
	public PageResponse getRecommendTickets(Page page)throws Exception{


		return hotelService.getRecommends();
	}

	@RequestMapping(value="index/slideBox")
	public Response getslideBox()throws Exception{
		//返回图片
		return new Response();
	}
}
