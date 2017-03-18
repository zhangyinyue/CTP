package com.ctp.service.admin.inter;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.ctp.dao.base.impl.ListPage;
import com.ctp.model.po.TAuth;
import com.ctp.model.po.TUser;
import com.ctp.model.vo.AuthTreeVO;
import com.ctp.model.vo.AuthVO;
import com.ctp.model.vo.RoleVO;
import com.ctp.model.vo.UserVO;

/**
 *  
 *	@auther zyy
 *	@date 2016年10月31日下午9:22:46
 */
public interface IAdminUserService {

	/**
	 * 通用用户id获取二层树形结构的权限树，并保存在到session中
	 * @param user
	 * @return
	 */
	AuthTreeVO getAuthTreeByUser(TUser user);
	/**
	 * 用户登陆服务类，并把用户对象保存到session中
	 * @param user
	 * @return LoginInfo的信息
	 */
	String login(TUser user);

	/**
	 * 服务端登陆
	 * @param user
	 * @return
	 */
	String appLogin(TUser user);
	/**
	 * 跳转到登陆界面
	 * @return
	 */
	TUser toLogin();
	
	/**
	 * 分页按条件获取用户
	 * @param user
	 * @return
	 */
	ListPage queryUserByPage(UserVO user);
	
	/**
	 * 保存用户
	 * @param user
	 */
	void saveUser(TUser user);
	
	/**
	 * 删除用户
	 * @param user
	 * @return 
	 */
	String deleteUser(UserVO user);
	
	/**
	 * 获取用户
	 * @param userId
	 * @return
	 */
	TUser getUser(String userId);
}
