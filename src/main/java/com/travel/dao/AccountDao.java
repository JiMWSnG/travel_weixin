package com.travel.dao;

import com.travel.bean.Account;

import java.sql.SQLException;

public interface AccountDao {
	public Account queryByUserId(Integer userId);

	public int updatePasswordByUserId(Integer userId, String password);

	Account queryByUsername(String username) throws SQLException;

	int addAccount(Account account);
}
