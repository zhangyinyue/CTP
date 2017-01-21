package com.ctp.dao.impl;

import javax.annotation.Resource;

import org.springframework.stereotype.Repository;

import com.ctp.dao.base.inter.IBaseDao;
import com.ctp.dao.config.DaoName;
import com.ctp.dao.inter.IUserLoginLogDao;

/**
 *  登陆日志dao
 *	@auther zyy
 *	@date 2016年10月24日下午10:04:10
 */
@Repository(DaoName.USER_LOGIN_LOG)
public class UserLoginLogDaoImpl implements IUserLoginLogDao{

	@Resource(name=DaoName.BASE)
	private IBaseDao baseDap;
	
}
