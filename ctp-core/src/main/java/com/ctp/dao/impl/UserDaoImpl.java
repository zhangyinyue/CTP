package com.ctp.dao.impl;

import javax.annotation.Resource;

import org.springframework.stereotype.Repository;

import com.ctp.dao.base.impl.ListPage;
import com.ctp.dao.base.inter.IBaseDao;
import com.ctp.dao.config.DaoName;
import com.ctp.dao.inter.IUserDao;
import com.ctp.model.po.TUser;
import com.ctp.model.vo.PageParam;

/**
 *  用户，包括对账户，地址，认证、商店的操作的dao
 *	@auther zyy
 *	@date 2016年10月24日下午10:03:37
 */
@Repository(DaoName.USER)
public class UserDaoImpl implements IUserDao {

	@Resource(name=DaoName.BASE)
	private IBaseDao baseDao;

	public TUser getUserByName(String fname) {
		return (TUser) baseDao.get("SELECT u FROM TUser u WHERE u.fname = ? ", fname);
	}

	@Override
	public ListPage queryByPage(PageParam page) {
		return baseDao.queryByHql(page.getPageNo(), page.getPageSize(), page.getCount(), page.getQuery(),page.getParams());
	}

	@Override
	public void save(TUser user) {
		baseDao.save(user);
	}

	@Override
	public void update(TUser user) {
		baseDao.update(user);
	}

	@Override
	public void deleteUser(String delQuery, String userId) {
		baseDao.deleteByHql(delQuery, userId);
	}

	@Override
	public TUser getUser(String userId) {
		return baseDao.get(TUser.class, userId);
	}
	
}
