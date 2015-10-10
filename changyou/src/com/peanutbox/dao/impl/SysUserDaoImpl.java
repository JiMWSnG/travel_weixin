package com.peanutbox.dao.impl;

import org.mybatis.spring.support.SqlSessionDaoSupport;

import com.peanutbox.bean.SmartBox;
import com.peanutbox.bean.SmartBoxCell;
import com.peanutbox.bean.SysUser;
import com.peanutbox.dao.SysUserDao;

public class SysUserDaoImpl extends SqlSessionDaoSupport implements SysUserDao{
	public void addSysUser(SysUser sysUser) {
		try {
			getSqlSession().insert("com.peanutbox.bean.SysUser.insert",sysUser);
		} catch (Exception e) {
			throw new RuntimeException("添加用户时，发生异常",e);
		}
	}

	public SysUser querySysUserByUserAccount(String userAccount) {
		try {
			SysUser sysUser = getSqlSession().selectOne("com.peanutbox.bean.SysUser.selectSysUserByUserAccount",userAccount);
			return sysUser;
		} catch (Exception e) {
			throw new RuntimeException("根据用户名查询用户时，发生异常",e);
		}
	}

	public SysUser querySysUserByPhoneNumber(String phoneNumber) {
		try {
			SysUser sysUser = getSqlSession().selectOne("com.peanutbox.bean.SysUser.selectSysUserByPhoneNumber",phoneNumber);
			return sysUser;
		} catch (Exception e) {
			throw new RuntimeException("根据用户号码查询用户时，发生异常",e);
		}
	}


}
