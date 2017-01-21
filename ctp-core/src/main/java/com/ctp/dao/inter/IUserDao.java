package com.ctp.dao.inter;

import com.ctp.dao.base.impl.ListPage;
import com.ctp.model.po.TAuth;
import com.ctp.model.po.TRole;
import com.ctp.model.po.TUser;
import com.ctp.model.vo.PageParam;

/**
 * 	用户，包括对账户，地址，认证、商店的操作的dao
 *	@auther zyy
 *	@date 2016年10月24日下午9:38:48
 */
public interface IUserDao {
	/**
	 * 通过用户名获取用户信息
	 * @param id
	 * @return
	 */
	TUser getUserByName(String fname);
	
	/**
	 * 分页查询
	 * @param page
	 * @return
	 */
	ListPage queryByPage(PageParam page);
	

	/**
	 * 保存用户
	 * @param user
	 */
	void save(TUser user);
	
	/**
	 * 更新用户
	 * @param user
	 */
	void update(TUser user);
	
	/**
	 * 删除用户
	 * @param userId
	 */
	void deleteUser(String delQuery,String userId);
	
	/**
	 * 获取用户
	 * @param userId
	 * @return
	 */
	TUser getUser(String userId);
}
