package com.ctp.dao.impl;

import javax.annotation.Resource;

import org.springframework.stereotype.Repository;

import com.ctp.dao.base.inter.IBaseDao;
import com.ctp.dao.config.DaoName;
import com.ctp.dao.inter.IGoodsEvaluateDao;

/**
 *  商品评价、商品评价图片的dao
 *	@auther zyy
 *	@date 2016年10月24日下午9:57:38
 */
@Repository(DaoName.GOODS_EVALUATE)
public class GoodsEvaluateDaoImpl implements IGoodsEvaluateDao {

	@Resource(name=DaoName.BASE)
	private IBaseDao baseDap;
	
}
