package com.ctp.service.admin.impl;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.ctp.dao.base.impl.ListPage;
import com.ctp.dao.config.DaoName;
import com.ctp.dao.inter.IAuthDao;
import com.ctp.model.po.TAuth;
import com.ctp.model.po.TRole;
import com.ctp.model.po.TRoleAuth;
import com.ctp.model.vo.AuthTreeVO;
import com.ctp.model.vo.AuthVO;
import com.ctp.model.vo.PageParam;
import com.ctp.model.vo.RoleVO;
import com.ctp.service.admin.inter.IAdminAuthService;
import com.ctp.service.config.ReturnMsg;
import com.ctp.service.config.ServiceName;
import com.ctp.utils.StringUtils;

/**
 *  角色、权限信息、权限明细
 *	@auther zyy
 *	@date 2016年10月31日下午9:28:23
 */
@Service(ServiceName.ADMIN_AUTH)
public class AdminAuthServiceImpl implements IAdminAuthService {

	@Resource(name=DaoName.AUTH)
	private IAuthDao authDao;
	
	@Override
	public ListPage queryRoleByPage(RoleVO role) {
		PageParam page = new PageParam();
		StringBuilder query = new StringBuilder();
		StringBuilder count = new StringBuilder();
		Map<String, Object> params = new HashMap<>();
		
		query.append("SELECT r FROM TRole r WHERE 1=1");
		count.append("SELECT COUNT(r.fid) FROM TRole r WHERE 1=1");
		
		if(!StringUtils.isEmpty(role.getName())){
			String filter = " AND r.fname LIKE :name ";
			query.append(filter);
			count.append(filter);
			params.put("name", "%" + role.getName() + "%");
		}
		
		page.setPageNo(role.getPageNo());
		page.setPageSize(role.getPageSize());
		page.setQuery(query.toString());
		page.setCount(count.toString());
		page.setParams(params);
		
		return authDao.queryByPage(page);
	}

	@Override
	public AuthTreeVO queryRole2Auth(RoleVO role) {
		
		AuthTreeVO authTree = new AuthTreeVO();
		StringBuilder sql = new StringBuilder();
		sql.append(" SELECT a.fid,a.fparent_id,a.fname,t1.val ")
		.append(" FROM t_auth a ")
		.append(" LEFT JOIN (select au.fid id, 1 val ")
		.append(" FROM t_auth au , t_role_auth ra, t_role ro ")
		.append(" WHERE au.fid = ra.fauth_id AND ra.frole_id = ro.fid ");
		if(!StringUtils.isEmpty(role.getId())){//id为空就不拼接
			sql.append(" AND ra.frole_id = '").append(role.getId()).append("'");
		}else{
			sql.append(" AND 1 = 2");
		}
		sql.append(" ) t1")
		.append(" ON a.fid = t1.id")
		.append(" ORDER BY a.forderby");
		List<Object[]> auths = (List<Object[]>) authDao.queryRole2Auth(sql.toString());
		for(Object[] objs:auths){
			TAuth auth = new TAuth();
			auth.setFid(objs[0].toString());
			auth.setFparentID(objs[1] == null ? "" :objs[1].toString());
			auth.setFname(String.valueOf(objs[2]));
			auth.setBelongRole(objs[3] == null ? "" :objs[3].toString());
			authTree.addNode(auth);
		}
		
		return authTree;
	}

	@Override
	public void saveRoleAndAuths(RoleVO role) {

		TRole trole = new TRole();
		if(StringUtils.isEmpty(role.getId())){
			trole.setFname(role.getName());
			authDao.save(trole);
		}else{
			trole.setFid(role.getId());
			trole.setFname(role.getName());
			authDao.update(trole);
			String delQuery = " DELETE TRoleAuth ra where ra.froleID = ?";
			authDao.deleteAuthByRoleId(delQuery, trole.getFid());
		}
		List<TRoleAuth> roleAuths = new ArrayList<TRoleAuth>();
		for(int i = 0; i < role.getIds().length; i++){
			TRoleAuth roleAuth = new TRoleAuth();
			roleAuth.setFauthID(role.getIds()[i]);
			roleAuth.setFroleID(trole.getFid());
			roleAuths.add(roleAuth);
		}
		authDao.save(roleAuths);
		
	}

	@Override
	public void deleteAuthByRoleIds(RoleVO role) {
		String delRoleAuth = " DELETE TRoleAuth ra where ra.froleID in ( "+ role.getIdsStr()+" )";
		authDao.deleteAuthByRoleId(delRoleAuth,null);
		String delRole = " DELETE TRole r where r.fid in ( "+role.getIdsStr()+" )";
		authDao.deleteRole(delRole, null);
	}

	@Override
	public ListPage queryAuthByPage(AuthVO auth) {
		PageParam page = new PageParam();
		StringBuilder query = new StringBuilder();
		StringBuilder count = new StringBuilder();
		Map<String, Object> params = new HashMap<>();
		
		query.append("SELECT a FROM TAuth a WHERE 1=1 ");
		count.append("SELECT COUNT(a.id) FROM TAuth a WHERE 1=1");
		
		if(!StringUtils.isEmpty(auth.getName())){
			String filter = " AND a.fname LIKE :name ";
			query.append(filter);
			count.append(filter);
			params.put("name", "%" + auth.getName() + "%");
		}
		
		query.append("ORDER BY a.forderby");
		
		page.setPageNo(auth.getPageNo());
		page.setPageSize(auth.getPageSize());
		page.setQuery(query.toString());
		page.setCount(count.toString());
		page.setParams(params);
		
		return authDao.queryByPage(page);
	}

	@Override
	public void saveAuth(TAuth auth) {
		if(StringUtils.isEmpty(auth.getFid())){
			authDao.save(auth);
		}else{
			authDao.update(auth);
		}
		
	}

	/**
	 * 检查权限项是否被引用
	 * @return true 被引用
	 */
	private boolean checkAuthRealse(String authIds){
		String query = "SELECT 1 FROM TRoleAuth ra where ra.fauthID in (" + authIds +" )";
		List<TRoleAuth> ras = authDao.queryRoleAuthsByAuthId(query, null);
		if(ras.size() > 0){
			return true;
		}
		return false;
	}
	
	@Override
	public String deleteAuth(AuthVO auth) {
		String result = null;
		if(!checkAuthRealse(auth.getIdsStr())){
			try{
				StringBuffer delQuery = new StringBuffer();
				delQuery.append(" DELETE TAuth a where a.fid in ( ").append(auth.getIdsStr()).append(" )");
				authDao.deleteAuth(delQuery.toString(), auth.getId());
			}catch(Exception e){
				e.printStackTrace();
			}finally{
				result = ReturnMsg.DEL_SUCCESS.toString();
			}
		}else{
			result = ReturnMsg.DEL_AUTH_FAIL.toString();
		}
		return result;
	}

	@Override
	public TAuth getAuth(String authId) {
		TAuth child = authDao.getAuth(authId);
		if(child != null && !StringUtils.isEmpty(child.getFparentID())){
			TAuth parent = authDao.getAuth(child.getFparentID());
			child.setParentName(parent.getFname());
		}
		return child;
	}

	@Override
	public TRole getRole(String roleId) {
		return authDao.getRole(roleId);
	}

	@Override
	public ListPage queryAuthParentByPage(AuthVO auth) {
		PageParam page = new PageParam();
		StringBuilder query = new StringBuilder();
		StringBuilder count = new StringBuilder();
		Map<String, Object> params = new HashMap<>();
		
		query.append("SELECT a FROM TAuth a WHERE 1=1 ");
		count.append("SELECT COUNT(a.id) FROM TAuth a WHERE 1=1");
		
		if(!StringUtils.isEmpty(auth.getName())){
			String filter = " AND a.fname LIKE :name ";
			query.append(filter);
			count.append(filter);
			params.put("name", "%" + auth.getName() + "%");
		}
		String filter = " AND (a.fparentID is null OR a.fparentID = '' ) ";
		query.append(filter);
		count.append(filter);
		query.append("ORDER BY a.forderby");
		
		page.setPageNo(auth.getPageNo());
		page.setPageSize(auth.getPageSize());
		page.setQuery(query.toString());
		page.setCount(count.toString());
		page.setParams(params);
		
		return authDao.queryByPage(page);
	}

	
}
