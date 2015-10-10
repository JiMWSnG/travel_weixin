package com.peanutbox.service;

import com.peanutbox.bean.SysUser;

public interface D_SysUserService {
	public void addSysUser(SysUser sysUser);
	public SysUser querySysUserByUserAccount(String userAccount);
	public SysUser querySysUserByPhoneNumber(String phoneNumber);
}
