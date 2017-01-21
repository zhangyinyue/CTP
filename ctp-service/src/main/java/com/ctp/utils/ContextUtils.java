package com.ctp.utils;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *  web上下文工具类
 *	@auther zyy
 *	@date 2016年12月5日下午9:48:59
 */
public class ContextUtils {

	private static HttpServletRequest request;
	private static HttpServletResponse response;
	
	public static HttpServletRequest getRequest() {
		return request;
	}
	public static void setRequest(HttpServletRequest request) {
		ContextUtils.request = request;
	}
	public static HttpServletResponse getResponse() {
		return response;
	}
	public static void setResponse(HttpServletResponse response) {
		ContextUtils.response = response;
	}
	
	
}
