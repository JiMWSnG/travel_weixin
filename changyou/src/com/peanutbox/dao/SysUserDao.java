package com.peanutbox.dao;

import com.peanutbox.bean.SysUser;

public interface SysUserDao {
	public void addSysUser(SysUser sysUser) ;
	public SysUser querySysUserByUserAccount(String userAccount);
	public SysUser querySysUserByPhoneNumber(String phoneNumber);
}
