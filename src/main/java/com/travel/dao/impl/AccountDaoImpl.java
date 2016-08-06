package com.travel.dao.impl;

import com.travel.bean.Account;
import com.travel.dao.AccountDao;
import org.mybatis.spring.support.SqlSessionDaoSupport;

import java.sql.SQLException;
import java.util.Date;

/**
 * Created by Jim Wang on 2016/7/28.
 */
public class AccountDaoImpl extends SqlSessionDaoSupport implements AccountDao{
    @Override
    public Account queryByUserId(Integer userId) {
        return null;
    }

    @Override
    public int updatePasswordByUserId(Integer userId, String password) {
        return 0;
    }

    @Override
    public Account queryByUsername(String username) throws SQLException {
        try{
            return getSqlSession().selectOne("com.travel.bean.Account.getAccountByUsername",username);

        }catch (Exception e){
            throw new SQLException("查询账户时发生异常",e);
        }
    }

    @Override
    public int addAccount(Account account) {
        account.setCreateTime(new Date().getTime()/1000);
        account.setUpdateTime(new Date().getTime()/1000);
        try{
            return getSqlSession().insert("com.travel.bean.Account.addAccount",account);

        }catch (Exception e){
            return -1;
        }
    }
}
