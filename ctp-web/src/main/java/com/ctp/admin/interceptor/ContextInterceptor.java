package com.ctp.admin.interceptor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

import com.ctp.utils.ContextUtils;

/**
 *  上下文拦截器
 *	@auther zyy
 *	@date 2016年12月5日下午9:41:10
 */
public class ContextInterceptor extends HandlerInterceptorAdapter{

	@Override
	public boolean preHandle(HttpServletRequest request,
			HttpServletResponse response, Object handler) throws Exception {
		ContextUtils.setRequest(request);
		ContextUtils.setResponse(response);
		return super.preHandle(request, response, handler);
	}
}
