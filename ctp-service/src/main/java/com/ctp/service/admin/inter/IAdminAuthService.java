package com.ctp.service.admin.inter;

import java.util.List;

import com.ctp.dao.base.impl.ListPage;
import com.ctp.model.po.TAuth;
import com.ctp.model.po.TRole;
import com.ctp.model.vo.AuthTreeVO;
import com.ctp.model.vo.AuthVO;
import com.ctp.model.vo.RoleVO;

/**
 *  权限服务类
 *	@auther zyy
 *	@date 2016年10月31日下午9:28:06
 */
public interface IAdminAuthService {

	/**
	 * 分页按条件获取角色
	 * @param role
	 * @return
	 */
	ListPage queryRoleByPage(RoleVO role);
	
	/**
	 * 获取角色的权限项
	 * @param role
	 * @return
	 */
	AuthTreeVO queryRole2Auth(RoleVO role);
	/**
	 * 保存角色及角色对应的权限，保存前先删除原有的角色权限项
	 * @param role
	 */
	void saveRoleAndAuths(RoleVO role);
	
	/**
	 * 批量删除角色及角色对应的权限项
	 * @param role
	 */
	void deleteAuthByRoleIds(RoleVO role);
	
	/**
	 * 分页按条件获取权限项
	 * @param auth
	 * @return
	 */
	ListPage queryAuthByPage(AuthVO auth);
	
	/**
	 * 分页按条件获取父权限项
	 * @param auth
	 * @return
	 */
	ListPage queryAuthParentByPage(AuthVO auth);
	/**
	 * 保存权限项
	 * @param auth
	 */
	void saveAuth(TAuth auth);
	/**
	 * 删除权限项，删除前先检查是否有引用，有的话不删除
	 * @param auth
	 * @return “删除成功”、权限项被引用,不能删除
	 */
	String deleteAuth(AuthVO auth);
	/**
	 * 获取权限项
	 * @param authId
	 * @return
	 */
	TAuth getAuth(String authId);
	/**
	 * 获取角色信息
	 * @param roleId
	 * @return
	 */
	TRole getRole(String roleId);
}
