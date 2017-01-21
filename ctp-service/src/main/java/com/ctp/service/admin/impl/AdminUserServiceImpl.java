package com.ctp.service.admin.impl;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Service;

import com.alibaba.fastjson.JSON;
import com.ctp.dao.base.impl.ListPage;
import com.ctp.dao.config.DaoName;
import com.ctp.dao.inter.IAuthDao;
import com.ctp.dao.inter.IUserDao;
import com.ctp.jedis.cache.RedisCacheStorage;
import com.ctp.jedis.client.RedisName;
import com.ctp.model.po.TAuth;
import com.ctp.model.po.TUser;
import com.ctp.model.vo.AuthTreeVO;
import com.ctp.model.vo.PageParam;
import com.ctp.model.vo.UserVO;
import com.ctp.service.admin.inter.IAdminUserService;
import com.ctp.service.config.LoginEnum;
import com.ctp.service.config.ReturnMsg;
import com.ctp.service.config.ServiceName;
import com.ctp.service.config.SessionEnum;
import com.ctp.utils.ContextUtils;
import com.ctp.utils.StringUtils;
import com.ctp.utils.URequest;
import com.ctp.utils.UResponse;

/**
 *  用户服务类
 *	@auther zyy
 *	@date 2016年10月31日下午9:23:02
 */
@Service(ServiceName.ADMIN_USER)
public class AdminUserServiceImpl implements IAdminUserService {

	@Resource(name=DaoName.AUTH)
	private IAuthDao authDao;
	
	@Resource(name=DaoName.USER)
	private IUserDao userDao;
	
	@Resource(name=RedisName.REDIS_CACHE)
	private RedisCacheStorage<String,String> redisCache;
	
	public AuthTreeVO getAuthTreeByUser(TUser user) {
		HttpServletRequest request = ContextUtils.getRequest();
		List<TAuth> auths = authDao.queryAuthsByUserRoleId(user.getFroleID());
		LinkedHashMap<String, List<TAuth>> tempMap = new LinkedHashMap<String, List<TAuth>>();
		for(int i = 0; i < auths.size(); i++){
			TAuth auth = auths.get(i);
			//以父节点id做为key
			String key = auth.getFparentID() == null ? auth.getFid().toString() : auth.getFparentID();
			List<TAuth> tree = tempMap.get(key);
			if(tree == null){
				tree = new ArrayList<TAuth>();
				tree.add(auth);
				tempMap.put(key, tree);
			}else{
				tree.add(auth);
			}
			redisCache.set(auth.getFid(),auth.getFname());
		}
		AuthTreeVO authTreeVo = new AuthTreeVO();
		for(String key:tempMap.keySet()){
			authTreeVo.addAllNode(tempMap.get(key));
		}
		if(URequest.getSession(request, SessionEnum.AUTH_TREE.toString()) == null){
			URequest.setSession(request, SessionEnum.AUTH_TREE.toString(), authTreeVo);
		}
		return authTreeVo;
	}

	public String login(TUser user) {
		
		String result = checkEmpty(user);
		/*用户名密码非空*/
		if(result == null){
			TUser tuser = userDao.getUserByName(user.getFname());
			if(tuser == null){
				result =  LoginEnum.ACCOUNT_NO_EXISTS.getStrVal();
			}else if(user.getFpwd().equals(tuser.getFpwd())){
				result = LoginEnum.LOGIN_SUCCESS.getStrVal();
				HttpServletRequest request = ContextUtils.getRequest();
				HttpServletResponse response = ContextUtils.getResponse();
				URequest.setSession(request, SessionEnum.USER.toString(), tuser);
				if(LoginEnum.REMEMBER.getIntVal()==user.getRemember()){//保存cookie
					UResponse.setCookie(response, SessionEnum.COOKE_USER_NAME.toString(), tuser.getFname());
					UResponse.setCookie(response, SessionEnum.COOKE_USER_PWD.toString(), tuser.getFpwd());
				}else{
					UResponse.removeCookie(response, SessionEnum.COOKE_USER_NAME.toString());
					UResponse.removeCookie(response, SessionEnum.COOKE_USER_PWD.toString());
				}
			}else{
				result = LoginEnum.PASSWORD_ERROR.getStrVal();
			}
		}
		return result;
	}

	/**
	 * 检查用户名密码是否为空
	 * @param user
	 * @return LoginInfo的信息
	 */
	private String checkEmpty(TUser user) {
		if(StringUtils.isEmpty(user.getFname())){
			return LoginEnum.ACCOUNT_EMPTY.getStrVal();
		}else if (StringUtils.isEmpty(user.getFpwd())){
			return LoginEnum.PASSWORD_EMPTY.getStrVal();
		}
		return null;
	}

	@Override
	public TUser toLogin() {
		TUser user = null;
		Cookie pwdCookie = URequest.getCookie(ContextUtils.getRequest(), SessionEnum.COOKE_USER_PWD.toString());
		Cookie nameCookie = URequest.getCookie(ContextUtils.getRequest(), SessionEnum.COOKE_USER_NAME.toString());
		if(pwdCookie != null){
			user = new TUser();
			user.setFpwd(pwdCookie.getValue());
			user.setFname(nameCookie.getValue());
			user.setRemember(1);
		}
		return user;
	}

	@Override
	public ListPage queryUserByPage(UserVO user) {
		PageParam page = new PageParam();
		StringBuilder query = new StringBuilder();
		StringBuilder count = new StringBuilder();
		Map<String, Object> params = new HashMap<>();
		
		query.append("SELECT u FROM TUser u WHERE 1=1");
		count.append("SELECT COUNT(u.fid) FROM TUser u WHERE 1=1");
		
		if(!StringUtils.isEmpty(user.getName())){
			String filter = " AND u.fname LIKE :name ";
			query.append(filter);
			count.append(filter);
			params.put("name", "%" + user.getName() + "%");
		}
		
		page.setPageNo(user.getPageNo());
		page.setPageSize(user.getPageSize());
		page.setQuery(query.toString());
		page.setCount(count.toString());
		page.setParams(params);
		
		return userDao.queryByPage(page);
	}

	@Override
	public void saveUser(TUser user) {
		if(StringUtils.isEmpty(user.getFid())){
			userDao.save(user);
		}else{
			userDao.update(user);
		}
	}

	@Override
	public String deleteUser(UserVO user) {
		String delUser = " DELETE TUser u where u.fid in ( "+ user.getIdsStr()+" )";
		userDao.deleteUser(delUser, null);
		return ReturnMsg.DEL_SUCCESS.toString();
	}

	@Override
	public TUser getUser(String userId) {
		return userDao.getUser(userId);
	}

	
	
}
