package com.ctp.admin.interceptor;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.ctp.controller.config.ControllerName;
import com.ctp.model.po.TUser;
import com.ctp.service.config.SessionEnum;
import com.ctp.utils.URequest;
import com.ctp.utils.UResponse;

/**
 *  
 *	@auther zyy
 *	@date 2016年12月12日下午8:58:33
 */
public class LoginFilter implements Filter{

	@Override
	public void init(FilterConfig filterConfig) throws ServletException {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void doFilter(ServletRequest req, ServletResponse res,
			FilterChain chain) throws IOException, ServletException {
		HttpServletRequest request = (HttpServletRequest)req;
		HttpServletResponse response = (HttpServletResponse)res;
		if(request.getRequestURI().contains(ControllerName.ADMIN_USER+ControllerName.ADMIN_TOLOGIN) || 
				request.getRequestURI().contains(ControllerName.ADMIN_USER+ControllerName.ADMIN_LOGIN)){
			chain.doFilter(request, response);
		}
		TUser user = (TUser) URequest.getSession(request, SessionEnum.USER.toString());
		if(user == null){//session中没有用户，则表示还没登陆，返回到登陆界面
			UResponse.redirect(URequest.getBasePath(request)+ControllerName.ADMIN_USER+ControllerName.ADMIN_TOLOGIN, response);
			return ;
		}
		//权限树选中的节点
		String pid = URequest.getString(request, "pid");
		String cid = URequest.getString(request, "cid");
		if(pid != null || cid != null){
			URequest.setSession(request, "pid", pid);
			URequest.setSession(request, "cid", cid);
		}
		
		chain.doFilter(request, response);
	}

	@Override
	public void destroy() {
		// TODO Auto-generated method stub
		
	}

}
