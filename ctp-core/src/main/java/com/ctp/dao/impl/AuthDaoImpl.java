package com.ctp.dao.impl;

import java.util.List;

import javax.annotation.Resource;
import javax.sql.rowset.BaseRowSet;

import org.springframework.stereotype.Repository;

import com.ctp.dao.base.impl.ListPage;
import com.ctp.dao.base.inter.IBaseDao;
import com.ctp.dao.config.DaoName;
import com.ctp.dao.inter.IAuthDao;
import com.ctp.model.po.TAuth;
import com.ctp.model.po.TRole;
import com.ctp.model.po.TRoleAuth;
import com.ctp.model.vo.PageParam;

/**
 *  角色、权限信息、权限明细的dao
 *	@auther zyy
 *	@date 2016年10月24日下午9:48:15
 */
@Repository(DaoName.AUTH)
public class AuthDaoImpl implements IAuthDao {

	@Resource(name=DaoName.BASE)
	private IBaseDao baseDao;

	public List<TAuth> queryAuthsByUserRoleId(String userRoleId) {
		return baseDao.query("SELECT ta FROM TAuth ta , TRoleAuth tra WHERE ta.fid = tra.fauthID AND tra.froleID = ? order by ta.forderby asc", userRoleId);
	}

	public void save(TAuth auth) {
		baseDao.save(auth);
	}

	public void save(TRole role) {
		baseDao.save(role);
	}

	public void save(List<TRoleAuth> roleAuths) {
		baseDao.save(roleAuths);
	}

	@Override
	public ListPage queryByPage(PageParam page) {
		return baseDao.queryByHql(page.getPageNo(), page.getPageSize(), page.getCount(), page.getQuery(),page.getParams());
	}

	@Override
	public List<Object[]> queryRole2Auth(String query) {
		return baseDao.queryBySql(query);
	}

	@Override
	public void deleteAuthByRoleId(String delQuery,String roleId) {
		baseDao.deleteByHql(delQuery, roleId);
	}

	@Override
	public void deleteRole(String delQuery,String roleId) {
		baseDao.deleteByHql(delQuery,roleId);
	}

	@Override
	public void deleteAuth(String delQuery, String authId) {
		baseDao.deleteByHql(delQuery, authId);
	}

	@Override
	public List<TRoleAuth> queryRoleAuthsByAuthId(String query,String authId) {
		return baseDao.queryLimit(query, 0, 1, authId);
	}

	@Override
	public TAuth getAuth(String authId) {
		return baseDao.get(TAuth.class, authId);
	}

	@Override
	public void update(TAuth auth) {
		baseDao.update(auth);
	}

	@Override
	public TRole getRole(String roleId) {
		return baseDao.get(TRole.class, roleId);
	}

	@Override
	public void update(TRole role) {
		baseDao.update(role);
	}
	
}
