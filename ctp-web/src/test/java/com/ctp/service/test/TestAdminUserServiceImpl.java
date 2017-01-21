package com.ctp.service.test;

import javax.annotation.Resource;

import org.apache.log4j.Logger;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.transaction.TransactionConfiguration;

import com.ctp.model.po.TUser;
import com.ctp.model.vo.AuthTreeVO;
import com.ctp.service.admin.inter.IAdminUserService;
import com.ctp.service.config.ServiceName;

/**
 *  用户服务类测试
 *	@auther zyy
 *	@date 2016年11月6日下午9:39:10
 */
@RunWith(SpringJUnit4ClassRunner.class)
@TransactionConfiguration(transactionManager = "txManager", defaultRollback = true)
@ContextConfiguration(locations="classpath*:com/ctp/config/hibernate-datasource.xml")
public class TestAdminUserServiceImpl {

	private Logger logger = Logger.getLogger(TestAdminUserServiceImpl.class);
	
	@Resource(name=ServiceName.ADMIN_USER)
	private IAdminUserService adminUserService;
	
	@Test
	public void testGetAuthTreeByUser(){
		TUser user = new TUser();
		user.setFroleID("1");
		AuthTreeVO authTreeVO = adminUserService.getAuthTreeByUser(user);
		for(int i = 0; i < authTreeVO.size(); i++){
			logger.info(authTreeVO.getNode(i));
		}
	}
	
	@Test
	public void testLogin(){
		TUser user = new TUser();
		String result = adminUserService.login(user);
		logger.info(result);
		
		user.setFname("1");
		 result = adminUserService.login(user);
		logger.info(result);
		
		user.setFname("12");
		user.setFpwd("12");
		 result = adminUserService.login(user);
		logger.info(result);
		
		user.setFname("1");
		user.setFpwd("z");
		 result = adminUserService.login(user);
		logger.info(result);
		
		user.setFname("1");
		user.setFpwd("123");
		 result = adminUserService.login(user);
		logger.info(result);
	}
	
}
