package com.travel.dao.impl;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.mybatis.spring.support.SqlSessionDaoSupport;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.travel.bean.Product;
import com.travel.dao.ProductDao;

public class TicketDaoImpl extends SqlSessionDaoSupport implements ProductDao {
	private static final Logger logger = LoggerFactory.getLogger(TicketDaoImpl.class);
	
	@Override
	public int add(Product ticket) {
		logger.info("数据库操作：int TicketDao.add(Product ticket)");
		long currentTime= System.currentTimeMillis()/1000;//单位：秒
		ticket.setCreateTime(currentTime);
		ticket.setUpdateTime(currentTime);
		
		
		try {
			int ok = getSqlSession().insert("com.travel.bean.Ticket.addTicket",ticket);
			if(ok==1){
				logger.info("成功添加{}",ticket.toString());
				return ticket.getId();
			}
			logger.debug("添加{}时失败", ticket.toString());
			return -1;
		} catch (Exception e) {
			logger.error("添加{}时失败", ticket.toString());
			return -1;
			
		}
	}

	@Override
	public Product queryById(Integer id) {
		logger.info("准备通过id:{}查询route",id);
		try{
			Product ticket = getSqlSession().selectOne("com.travel.bean.Ticket.getTicketById", id);
			if(ticket!=null){
				logger.info("通过id:{}查询ticket成功",id);
				return ticket;
			}
			logger.debug("通过id:{}查询ticket失败",id);
			
			return null;
		}catch(Exception e){
			logger.error("通过id:{}查询ticket时失败",id);
			e.printStackTrace();
			return null;
		}
	}

	@Override
	public List<Product> query(String type, String location, String indexs) {
		logger.info("准备查询ticket，查询条件type:{},location:{},indexs:{}",type,location,indexs);
		Map<String,Object> params = new HashMap<>();
		params.put("type", type);
		params.put("location", location);
		params.put("indexs", indexs);
		try{
			
			List<Product> tickets=getSqlSession().selectList("com.travel.bean.Ticket.getTickets", params);
			if(tickets!=null){
				logger.info("成功查询tickets，查询条件type:{},location:{},indexs:{}",type,location,indexs);
				return tickets;
			}
			logger.debug("查询tickets失败，查询条件type:{},location:{},indexs:{}",type,location,indexs);
			return null;
		}catch(Exception e){
			logger.error("查询tickets失败，查询条件type:{},location:{},indexs:{}",type,location,indexs);
			return null;
		}
	}

	@Override
	public List<Product> queryAll() {
		logger.info("准备");
		try{
			return getSqlSession().selectList("com.travel.bean.Ticket.getTicketAll");
		}catch(Exception e){
			logger.error("查询所有ticket失败");
			return null;
		}
	}

	@Override
	public int update(Product ticket) {
		ticket.setUpdateTime(System.currentTimeMillis()/1000);
		try{
			int ok=getSqlSession().update("com.travel.bean.Ticket.updateTicketById", ticket);
			if(ok>0){
				return ticket.getId();
			}
			logger.debug("更新ticket失败，更新值为{}",ticket.toString());
			return -1;
			
		}catch(Exception e){
			logger.error("更新ticket失败，更新值{}",ticket.toString());
			return -1;
		}
	}

	@Override
	public int remove(Integer id) {
		try{
			int ok = getSqlSession().delete("com.travel.bean.Ticket.deleteTicketById",id);
			if(ok>0){
				return id;
			}
			logger.debug("不存在id为{}的ticket");
			return -1;
		}catch(Exception e){
			logger.error("通过id:{}删除ticket失败",id);
			return -1;
		}
	}

}
