package com.travel.dao.impl;

import java.sql.SQLException;
import java.util.Date;
import java.util.List;

import org.mybatis.spring.support.SqlSessionDaoSupport;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.travel.bean.User;
import com.travel.dao.UserDao;

public class UserDaoImpl extends SqlSessionDaoSupport implements UserDao{
	private static final Logger logger = LoggerFactory.getLogger(UserDaoImpl.class);
	@Override
	public int add(User user) {
		user.setCreateTime(new Date().getTime()/1000);
		user.setUpdateTime(new Date().getTime()/1000);
		try {
			return getSqlSession().insert("com.travel.bean.User.addUser",user);
		} catch (Exception e) {
			e.printStackTrace();
			return -1;
		}
	}

	@Override
	public User queryByPhone(String phoneNumber) throws SQLException {
		try {
			User user = getSqlSession().selectOne("com.travel.bean.User.getUserByPhoneNumber",phoneNumber);
			return user;
		} catch (Exception e) {
			throw new SQLException("通过phoneNumber查询用户时，发生异常",e);
		}	
	}

	@Override
	public User queryById(Integer userId) throws SQLException {
		try {
			User user = getSqlSession().selectOne("com.travel.bean.User.getUserById",userId);
			return user;
		} catch (Exception e) {
			throw new SQLException("添加用户时，发生异常",e);
		}
	}
	@Override
	public User queryByOpenId(String openId) throws SQLException {
		try {
			User user = getSqlSession().selectOne("com.travel.bean.User.getUserByOpenId",openId);
			return user;
		} catch (Exception e) {
			throw new SQLException("添加用户时，发生异常",e);
		}
	}
	@Override
	public List<User> queryAll() throws SQLException {
		logger.info("准备");
		try{
			return getSqlSession().selectList("com.travel.bean.User.getUserAllWithPage");
		}catch(Exception e){
			logger.error("查询所有user失败");
			return null;
		}
	}

	@Override
	public int update(User user) throws SQLException {
		user.setUpdateTime(System.currentTimeMillis()/1000);
		try{
			int ok=0;
			if(user.getOpenId()!=null&&!"".equals(user.getOpenId())){
				ok=getSqlSession().update("com.travel.bean.User.updateUserByOpenId", user);
			} else if(user.getId()!=0){
				ok=getSqlSession().update("com.travel.bean.User.updateUserById", user);
			}

			if(ok>0){
				return user.getId();
			}
			logger.debug("更新user失败，更新值为{}",user.toString());
			return -1;
			
		}catch(Exception e){
			logger.error("更新user失败，更新值{}",user.toString());
			return -1;
		}
	}

	@Override
	public int remove(Integer id) {
		try{
			int ok = getSqlSession().delete("com.travel.bean.User.deleteUserById",id);
			if(ok>0){
				return id;
			}
			logger.debug("不存在id为{}的user");
			return -1;
		}catch(Exception e){
			logger.error("通过id:{}删除user失败",id);
			return -1;
		}
	}



}
