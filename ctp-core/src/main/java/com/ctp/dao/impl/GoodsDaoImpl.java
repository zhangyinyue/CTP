package com.ctp.dao.impl;

import javax.annotation.Resource;

import org.springframework.stereotype.Repository;

import com.ctp.dao.base.inter.IBaseDao;
import com.ctp.dao.config.DaoName;
import com.ctp.dao.inter.IGoodsDao;

/**
 *  商品类别明细、商品信息、商品规格的dao
 *	@auther zyy
 *	@date 2016年10月24日下午9:50:04
 */
@Repository(DaoName.GOODS)
public class GoodsDaoImpl implements IGoodsDao {

	@Resource(name=DaoName.BASE)
	private IBaseDao baseDap;
	
}
