package com.ctp.dao.inter;

import java.util.List;

import com.ctp.dao.base.impl.ListPage;
import com.ctp.model.po.TAuth;
import com.ctp.model.po.TRole;
import com.ctp.model.po.TRoleAuth;
import com.ctp.model.vo.PageParam;

/**
 * 	角色、权限信息、权限明细的dao
 *	@auther zyy
 *	@date 2016年10月24日下午9:42:15
 */
public interface IAuthDao {

	/**
	 * 通过用户角色id获取权限集合
	 * @param userId
	 * @return
	 */
	List<TAuth> queryAuthsByUserRoleId(String userRoleId);
	
	/**
	 * 保存角色
	 * @param role
	 */
	void save(TRole role);
	
	/**
	 * 保存角色权限关系
	 * @param roleAuth
	 */
	void save(List<TRoleAuth> roleAuths);
	/**
	 * 分页查询
	 * @param page
	 * @return
	 */
	ListPage queryByPage(PageParam page);
	/**
	 * 查询角色权限项填到所有权限项中
	 * @param query
	 * @return
	 */
	List<Object[]> queryRole2Auth(String query);
	/**
	 * 通过角色id删除所有对应的权限项
	 * @param roleId
	 */
	void deleteAuthByRoleId(String delQuery,String roleId);
	/**
	 * 删除角色
	 * @param roleId
	 */
	void deleteRole(String delQuery,String roleId);
	
	/**
	 * 保存权限项
	 * @param auth
	 */
	void save(TAuth auth);
	/**
	 * 更新权限项
	 * @param auth
	 */
	void update(TAuth auth);
	
	/**
	 * 更新角色
	 * @param role
	 */
	void update(TRole role);
	
	/**
	 * 删除权限项
	 * @param delQuery
	 * @param authId
	 */
	void deleteAuth(String delQuery,String authId);
	
	/**
	 * 权限项获取角色关系
	 * @param authId
	 * @return
	 */
	List<TRoleAuth> queryRoleAuthsByAuthId(String query,String authId);
	
	/**
	 * 获取权限项
	 * @param authId
	 * @return
	 */
	TAuth getAuth(String authId);
	/**
	 * 获取角色
	 * @param roleId
	 * @return
	 */
	TRole getRole(String roleId);
}
