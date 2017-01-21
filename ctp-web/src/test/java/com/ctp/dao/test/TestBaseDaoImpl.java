package com.ctp.dao.test;

import javax.annotation.Resource;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.AbstractTransactionalJUnit4SpringContextTests;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.transaction.TransactionConfiguration;

import com.ctp.dao.base.inter.IBaseDao;
import com.ctp.dao.config.DaoName;
import com.ctp.model.po.TUser;


/**
 *  基础dao测试
 *	@auther zyy
 *	@date 2016年10月29日下午11:04:12
 */
@RunWith(SpringJUnit4ClassRunner.class)
@TransactionConfiguration(transactionManager = "txManager", defaultRollback = true)
@ContextConfiguration(locations="classpath*:com/ctp/config/hibernate-datasource.xml")
public class TestBaseDaoImpl extends AbstractTransactionalJUnit4SpringContextTests{
	
	@Resource(name=DaoName.BASE)
	public IBaseDao baseDao;
	
	@Before
	public void setUp() {

		
	}
	
	@Test
	public void testSave() {
		TUser user = new TUser();
		user.setFname("zhang");
		user.setFage(1);
		user.setFpwd("123");
		byte sex = 1;
		user.setFsex(sex);
		baseDao.save(user);
	}
}
