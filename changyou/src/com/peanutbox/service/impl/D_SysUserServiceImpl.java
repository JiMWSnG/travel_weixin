package com.peanutbox.service.impl;

import com.peanutbox.bean.SysUser;
import com.peanutbox.dao.SysUserDao;
import com.peanutbox.service.D_SysUserService;

public class D_SysUserServiceImpl implements D_SysUserService {
	private SysUserDao sysUserDao;

	public SysUserDao getSysUserDao() {
		return sysUserDao;
	}

	public void setSysUserDao(SysUserDao sysUserDao) {
		this.sysUserDao = sysUserDao;
	}
	
	public SysUser querySysUserByUserAccount(String userAccount){
		return sysUserDao.querySysUserByUserAccount(userAccount);
	}

	public void addSysUser(SysUser sysUser) {
		sysUserDao.addSysUser(sysUser);
	}

	public SysUser querySysUserByPhoneNumber(String phoneNumber) {
		return sysUserDao.querySysUserByPhoneNumber(phoneNumber);
	}
}
