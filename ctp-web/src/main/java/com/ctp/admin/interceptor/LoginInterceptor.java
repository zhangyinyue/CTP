package com.ctp.admin.interceptor;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

import com.ctp.controller.config.ControllerName;
import com.ctp.jedis.cache.RedisCacheStorage;
import com.ctp.jedis.client.RedisName;
import com.ctp.model.po.TUser;
import com.ctp.service.config.SessionEnum;
import com.ctp.utils.URequest;
import com.ctp.utils.UResponse;

/**
 *  用户登陆拦截器
 *	@auther zyy
 *	@date 2016年12月5日下午8:50:28
 */
public class LoginInterceptor extends HandlerInterceptorAdapter{

	@Resource(name=RedisName.REDIS_CACHE)
	private RedisCacheStorage<String,String> redisCache;
	
	@Override
	public boolean preHandle(HttpServletRequest request,
			HttpServletResponse response, Object handler) throws Exception {
		if(request.getRequestURI().contains(ControllerName.ADMIN_USER+ControllerName.ADMIN_TOLOGIN) || 
				request.getRequestURI().contains(ControllerName.ADMIN_USER+ControllerName.ADMIN_LOGIN)){
			return true;
		}
		TUser user = (TUser) URequest.getSession(request, SessionEnum.USER.toString());
		if(user == null){//session中没有用户，则表示还没登陆，返回到登陆界面
			UResponse.redirect(URequest.getBasePath(request)+ControllerName.ADMIN_USER+ControllerName.ADMIN_TOLOGIN, response);
			return false;
		}
		//权限树选中的节点
		String pid = URequest.getString(request, "pid");
		String cid = URequest.getString(request, "cid");
		if(pid != null && cid != null){
			URequest.setSession(request, "pid", pid);
			URequest.setSession(request, "cid", cid);
			URequest.setSession(request, "pname", redisCache.get(pid).toString().replace("\"", ""));
			URequest.setSession(request, "cname", redisCache.get(cid).toString().replace("\"", ""));
		}
		
		
		return super.preHandle(request, response, handler);
	}
}
