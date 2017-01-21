package com.ctp.dao.impl;

import javax.annotation.Resource;

import org.springframework.stereotype.Repository;

import com.ctp.dao.base.inter.IBaseDao;
import com.ctp.dao.config.DaoName;
import com.ctp.dao.inter.IOrderDao;

/**
 *  订单明细、订单头、退款信息的dao
 *	@auther zyy
 *	@date 2016年10月24日下午10:03:06
 */
@Repository(DaoName.ORDER)
public class OrderDaoImpl implements IOrderDao {

	@Resource(name=DaoName.BASE)
	private IBaseDao baseDap;
	
}
