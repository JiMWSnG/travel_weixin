package com.travel.controller;

import com.travel.service.ProductService;
import com.travel.web.PageResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

public class IndexController {
	@Autowired
	private ProductService productService;
	@RequestMapping(value="route/recommends",method=RequestMethod.GET)
	public PageResponse getRecommendRoutes()throws Exception{
		return productService.getRecommends();
	}
}
