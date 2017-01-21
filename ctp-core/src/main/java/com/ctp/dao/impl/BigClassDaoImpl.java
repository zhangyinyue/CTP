package com.ctp.dao.impl;

import javax.annotation.Resource;

import org.springframework.stereotype.Repository;

import com.ctp.dao.base.inter.IBaseDao;
import com.ctp.dao.config.DaoName;
import com.ctp.dao.inter.IBigClassDao;

/**
 *  商品大类别、商品小类别的dao
 *	@auther zyy
 *	@date 2016年10月24日下午9:49:03
 */
@Repository(DaoName.BIG_CLASS)
public class BigClassDaoImpl implements IBigClassDao{

	@Resource(name=DaoName.BASE)
	private IBaseDao baseDap;
	
}
