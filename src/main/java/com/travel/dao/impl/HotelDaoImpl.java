package com.travel.dao.impl;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.mybatis.spring.support.SqlSessionDaoSupport;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.travel.bean.Product;
import com.travel.bean.ProductCalendar;
import com.travel.dao.CalendarDao;
import com.travel.dao.ProductDao;

public class HotelDaoImpl extends SqlSessionDaoSupport  implements ProductDao,CalendarDao{
	private static final Logger logger = LoggerFactory.getLogger(HotelDaoImpl.class);
	@Override
	public int add(Product hotel) {
		logger.info("数据库操作：int RouteDao.add(Product hotel)");
		long currentTime= System.currentTimeMillis()/1000;//单位：秒
		hotel.setCreateTime(currentTime);
		hotel.setUpdateTime(currentTime);
		
		
		try {
			int ok = getSqlSession().insert("com.travel.bean.Hotel.addHotel",hotel);
			if(ok==1){
				logger.info("添加{}成功",hotel.toString());
				return hotel.getId();
			}
			logger.debug("添加{}时失败", hotel.toString());
			return -1;
		} catch (Exception e) {
			logger.error("添加{}时失败", hotel.toString());
			return -1;
			
		}
	}

	@Override
	public Product queryById(Integer id) {
		logger.info("准备通过id:{}查询hotel",id);
		try{
			Product hotel = getSqlSession().selectOne("com.travel.bean.Hotel.getHotelById", id);
			if(hotel!=null){
				logger.info("通过id:{}查询hotel成功",id);
				return hotel;
			}
			logger.debug("通过id:{}查询hotel失败",id);
			
			return null;
		}catch(Exception e){
			logger.error("通过id:{}查询hotel时失败",id);
			e.printStackTrace();
			return null;
		}
	}

	@Override
	public List<Product> query(String type, String location, String indexs) {
		logger.info("准备查询hotel，查询条件type:{},location:{},indexs:{}",type,location,indexs);
		Map<String,Object> params = new HashMap<>();
		params.put("location", location);
		params.put("type", type);
		params.put("indexs", indexs);
		try{
			List<Product> hotels=getSqlSession().selectList("com.travel.bean.Hotel.getHotelsWithPage", params);
			if(hotels!=null){
				logger.info("查询hotel成功，查询条件type:{},location:{},indexs:{}",type,location,indexs);
				return hotels;
			}
			logger.debug("查询hotel失败，查询条件type:{},location:{},indexs:{}",type,location,indexs);
			return null;
		}catch(Exception e){
			logger.error("查询hotel失败，查询条件type:{},location:{},indexs:{}",type,location,indexs);
			return null;
		}
	}

	@Override
	public List<Product> queryAll() {
		logger.info("准备");
		try{
			return getSqlSession().selectList("com.travel.bean.Hotel.getHotelAllWithPage");
		}catch(Exception e){
			logger.error("查询所有hotel失败");
			return null;
		}
	}

	@Override
	public int update(Product hotel) {
		hotel.setUpdateTime(System.currentTimeMillis()/1000);
		try{
			int ok=getSqlSession().update("com.travel.bean.Hotel.updateHotelById", hotel);
			if(ok>0){
				return hotel.getId();
			}
			logger.debug("更新hotel失败，更新值为{}",hotel.toString());
			return -1;
			
		}catch(Exception e){
			logger.error("更新hotel失败，更新值{}",hotel.toString());
			return -1;
		}
	}

	@Override
	public int remove(Integer id) {
		try{
			int ok = getSqlSession().delete("com.travel.bean.Hotel.deleteHotelById",id);
			if(ok>0){
				return id;
			}
			logger.debug("不存在id为{}的hotel");
			return -1;
		}catch(Exception e){
			logger.error("通过id:{}删除hotel失败",id);
			return -1;
		}
	}

	@Override
	public ProductCalendar queryCalendar(Integer hotelId) {
		logger.info("准备通过hotelId:{}查询hotelCalendar",hotelId);
		try{
			ProductCalendar hotelCalendar = getSqlSession().selectOne("com.travel.bean.HotelCalendar.getHotelCalendarByHotelId", hotelId);
			if(hotelCalendar!=null){
				logger.info("成功通过rouhotelIdteId:{}查询hotelCalendar",hotelId);
				return hotelCalendar;
			}
			logger.debug("通过hotelId:{}查询hotelCalendar失败",hotelId);
			
			return null;
		}catch(Exception e){
			logger.error("通过hotelId:{}查询hotelCalendar时失败",hotelId);
			e.printStackTrace();
			return null;
		}
	}

	@Override
	public int addCalendar(ProductCalendar hotelCalendar) {
		logger.info("数据库操作：int HotelDao.add(ProductCalendar hotelCalendar)");
		long currentTime= System.currentTimeMillis()/1000;//单位：秒
		hotelCalendar.setCreateTime(currentTime);
		hotelCalendar.setUpdateTime(currentTime);
		
		
		try {
			int ok = getSqlSession().insert("com.travel.bean.HotelCalendar.addHotelCalendar",hotelCalendar);
			if(ok==1){
				logger.info("添加{}成功",hotelCalendar.toString());
				return hotelCalendar.getId();
			}
			logger.debug("添加{}时失败", hotelCalendar.toString());
			return -1;
		} catch (Exception e) {
			logger.error("添加{}时失败", hotelCalendar.toString());
			return -1;
			
		}
	}

	@Override
	public int updateCalendar(ProductCalendar hotelCalendar) {
		hotelCalendar.setUpdateTime(System.currentTimeMillis()/1000);
		try{
			int ok=getSqlSession().update("com.travel.bean.HotelCalendar.updateHotelCalendar", hotelCalendar);
			if(ok>0){
				return hotelCalendar.getId();
			}
			logger.debug("更新hotelCalendar失败，更新值为{}",hotelCalendar.toString());
			return -1;
			
		}catch(Exception e){
			logger.error("更新hotelCalendar失败，更新值{}",hotelCalendar.toString());
			return -1;
		}
	}

	@Override
	public int removeCalendar(Integer id) {
		try{
			int ok = getSqlSession().delete("com.travel.bean.HotelCalendar.deleteHotelCalendar",id);
			if(ok>0){
				return id;
			}
			logger.debug("不存在id为{}的hotelCalendar");
			return -1;
		}catch(Exception e){
			logger.error("通过id:{}删除hotelCalendar失败",id);
			return -1;
		}
	}

	

}
