package com.travel.dao.impl;

import com.travel.bean.Product;
import com.travel.bean.ProductCalendar;
import com.travel.dao.CalendarDao;
import com.travel.dao.ProductDao;
import org.mybatis.spring.support.SqlSessionDaoSupport;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class RouteDaoImpl extends SqlSessionDaoSupport implements ProductDao,CalendarDao {
	//{PropertyConfigurator.configure("src/main/resources/conf/log4j.properties");}
	private static final Logger logger = LoggerFactory.getLogger(RouteDaoImpl.class);
	//TODO:需要写详细的日志，能明确表示数据库操作的开始和结束，以及操作结果。在完成功能;;;查询的要做分页
	@Override
	public int add(Product route) {
		logger.info("数据库操作：int RouteDao.add(Product route)");
		long currentTime= System.currentTimeMillis()/1000;//单位：秒
		route.setCreateTime(currentTime);
		route.setUpdateTime(currentTime);
		
		
		try {
			int ok = getSqlSession().insert("com.travel.bean.Route.addRoute",route);
			if(ok==1){
				logger.info("添加{}成功",route.toString());
				return route.getId();
			}
			logger.debug("添加{}时失败", route.toString());
			return -1;
		} catch (Exception e) {
			logger.error("添加{}时失败", route.toString());
			return -1;
			
		}
	}

	@Override
	public List<Product> query(String category, String location, String indexs) {
		//TODO: fenye chuli jiaru 
		logger.info("准备查询route，查询条件type:{},location:{},indexs:{}", category,location,indexs);
		Map<String,Object> params = new HashMap<String,Object>();
		params.put("type", category);
		params.put("location", location);
		params.put("indexs", indexs);
		try{
			
			List<Product> routes=getSqlSession().selectList("com.travel.bean.Route.getRoutesWithPage", params);
			if(routes!=null){
				logger.info("查询route成功，查询条件type:{},location:{},indexs:{}", category,location,indexs);
				return routes;
			}
			logger.debug("查询route失败，查询条件type:{},location:{},indexs:{}", category,location,indexs);
			return null;
		}catch(Exception e){
			logger.error("查询route失败，查询条件type:{},location:{},indexs:{}", category,location,indexs);
			return null;
		}
	}

	@Override
	public Product queryById(Integer id) {
		logger.info("准备通过id:{}查询route",id);
		try{
			Product route = getSqlSession().selectOne("com.travel.bean.Route.getRouteById", id);
			if(route!=null){
				logger.info("通过id:{}查询route成功",id);
				return route;
			}
			logger.debug("通过id:{}查询route失败",id);
			
			return null;
		}catch(Exception e){
			logger.error("通过id:{}查询route时失败",id);
			e.printStackTrace();
			return null;
		}
		
	}

	@Override
	public List<Product> queryAll() {
		logger.info("准备");
		try{
			List<Product> routes = getSqlSession().selectList("com.travel.bean.Route.getRouteAllWithPage");
			return routes;
		}catch(Exception e){
			logger.error("查询所有route失败");
			return null;
		}
	}

	@Override
	public int update(Product route) {
		route.setUpdateTime(System.currentTimeMillis()/1000);
		try{
			int ok=getSqlSession().update("com.travel.bean.Route.updateRouteById", route);
			if(ok>0){
				return route.getId();
			}
			logger.debug("更新route失败，更新值为{}",route.toString());
			return -1;
			
		}catch(Exception e){
			logger.error("更新route失败，更新值{}",route.toString());
			return -1;
		}
	}

	@Override
	public int remove(Integer id) {
		try{
			int ok = getSqlSession().delete("com.travel.bean.Route.deleteRouteById",id);
			if(ok>0){
				return id;
			}
			logger.debug("不存在id为{}的route");
			return -1;
		}catch(Exception e){
			logger.error("通过id:{}删除route失败",id);
			return -1;
		}
	}

	@Override
	public ProductCalendar queryCalendar(Integer routeId) {
		logger.info("准备通过routeId:{}查询routeCalendar",routeId);
		try{
			ProductCalendar routeCalendar = getSqlSession().selectOne("com.travel.bean.RouteCalendar.getRouteCalendarByRouteId", routeId);
			if(routeCalendar!=null){
				logger.info("成功通过routeId:{}查询routeCalendar",routeId);
				return routeCalendar;
			}
			logger.debug("通过routeId:{}查询routeCalendar失败",routeId);
			
			return null;
		}catch(Exception e){
			logger.error("通过routeId:{}查询routeCalendar时失败",routeId);
			e.printStackTrace();
			return null;
		}
	}

	@Override
	public int addCalendar(ProductCalendar routeCalendar) {
		logger.info("数据库操作：int RouteDao.add(ProductCalendar routeCalendar)");
		long currentTime= System.currentTimeMillis()/1000;//单位：秒
		routeCalendar.setCreateTime(currentTime);
		routeCalendar.setUpdateTime(currentTime);
		
		
		try {
			int ok = getSqlSession().insert("com.travel.bean.RouteCalendar.addRouteCalendar",routeCalendar);
			if(ok==1){
				logger.info("添加{}成功",routeCalendar.toString());
				return routeCalendar.getId();
			}
			logger.debug("添加{}时失败", routeCalendar.toString());
			return -1;
		} catch (Exception e) {
			logger.error("添加{}时失败", routeCalendar.toString());
			return -1;
			
		}
	}

	@Override
	public int updateCalendar(ProductCalendar routeCalendar) {
		routeCalendar.setUpdateTime(System.currentTimeMillis()/1000);
		try{
			int ok=getSqlSession().update("com.travel.bean.RouteCalendar.updateRouteCalendar", routeCalendar);
			if(ok>0){
				return routeCalendar.getId();
			}
			logger.debug("更新routeCalendar失败，更新值为{}",routeCalendar.toString());
			return -1;
			
		}catch(Exception e){
			logger.error("更新routeCalendar失败，更新值{}",routeCalendar.toString());
			return -1;
		}
	}

	@Override
	public int removeCalendar(Integer id) {
		try{
			int ok = getSqlSession().delete("com.travel.bean.RouteCalendar.deleteRouteCalendar",id);
			if(ok>0){
				return id;
			}
			logger.debug("不存在id为{}的routeCalendar");
			return -1;
		}catch(Exception e){
			logger.error("通过id:{}删除routeCalenadr失败",id);
			return -1;
		}
	}
	

}
