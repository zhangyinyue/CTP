package com.ctp.dao.impl;

import javax.annotation.Resource;

import org.springframework.stereotype.Repository;

import com.ctp.dao.base.inter.IBaseDao;
import com.ctp.dao.config.DaoName;
import com.ctp.dao.inter.IShoppingCarDao;

/**
 *  购物车dao
 *	@auther zyy
 *	@date 2016年10月24日下午10:03:22
 */
@Repository(DaoName.SHOPPING_CAR)
public class ShoppingCarDao implements IShoppingCarDao {

	@Resource(name=DaoName.BASE)
	private IBaseDao baseDap;
	
}
