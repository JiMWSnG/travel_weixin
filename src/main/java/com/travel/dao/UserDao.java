package com.travel.dao;

import java.sql.SQLException;
import java.util.List;

import com.travel.bean.Account;
import com.travel.bean.User;

public interface UserDao {
	public int add(User user) throws SQLException;

	public User queryByPhone(String phoneNum) throws SQLException;

	public User queryById(Integer id) throws SQLException;

	public List<User> queryAll() throws SQLException;

	public int update(User user) throws SQLException;

	public int remove(Integer id) throws SQLException;

	//public Account getAccountBy(Integer userId);

	//public int updateAccountPasswordById(Integer userId, String password);
}
