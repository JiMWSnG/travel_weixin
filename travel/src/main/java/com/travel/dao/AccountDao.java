package com.travel.dao;

import com.travel.bean.Account;

public interface AccountDao {
	public Account queryByUserId(Integer userId);

	public int updatePasswordByUserId(Integer userId, String password);
}
