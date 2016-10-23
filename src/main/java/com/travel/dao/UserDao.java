package com.travel.dao;

import java.sql.SQLException;
import java.util.List;

import com.travel.bean.User;

public interface UserDao {
	public int add(User user);

	public User queryByPhone(String phoneNum) throws SQLException;

	public User queryById(Integer id) throws SQLException;

	public User queryByOpenId(String openId) throws SQLException;

	public List<User> queryAll() throws SQLException;

	/**
	 * 优先通过openId更新,需要openId或id
	 * @param user
	 * @return userId>0/-1
	 * @throws SQLException
     */
	public int update(User user) throws SQLException;

	public int remove(Integer id);

	//public Account getAccountBy(Integer userId);

	//public int updateAccountPasswordById(Integer userId, String password);
}
