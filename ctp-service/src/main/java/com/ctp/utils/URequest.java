package com.ctp.utils;


import java.io.IOException;
import java.io.UnsupportedEncodingException;

import javax.servlet.ServletException;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.log4j.Logger;

public final class URequest {

	private static final Logger log = Logger.getLogger(URequest.class);
	
	/**
	 * 取得字符串
	 * @param request
	 * @param param
	 * @return 如果为空则返回空字符 null 
	 */
	public static String getString(HttpServletRequest request,String param){
		String value = request.getParameter(param);
		if(value == null || value.length() == 0){
			return null;//返回空字符
		}
		return value;
	}
	
	public static String getStringCharset(HttpServletRequest request,String param,String charset){
		String value = request.getParameter(param);
		if(value == null || value.length() == 0){
			return null;//返回空字符
		}
		try {
			return new String(value.getBytes("iso-8859-1"), charset);
		} catch (UnsupportedEncodingException e) {
			log.error("字符串转码错误", e);
		}
		return null;
	}
	
	/**
	 * 取得字符串数组
	 * @param request
	 * @param param
	 * @return 如果为空返回null
	 */
	public static String[] getStrings(HttpServletRequest request,String param){
		String[] values = request.getParameterValues(param);
		if(values == null || values.length == 0){
			return null;
		}
		return values;
	}
	
	/**
	 * 取得字符串
	 * @param request
	 * @param param
	 * @return 如果为空则返回空字符 null 
	 */
	public static String getStringTrim(HttpServletRequest request,String param){
		String str = getString(request, param);
		return str == null ? null : str.trim();
	}
	
	/**
	 * 取得整数
	 * @param request
	 * @param param
	 * @param defaultValue 如果不存在或数据转化错误的返回值 
	 * @return
	 */
	public static int getInt(HttpServletRequest request,String param,int defaultValue){
		String value = getString(request, param);
		if(value == null){
			return defaultValue;
		}
		try {
			return Integer.parseInt(value);
		} catch (NumberFormatException e) {
			log.error("字符串转整型错误", e);
			return defaultValue;
		}
	}
	
	/**
	 * 取得整数数组
	 * @param request
	 * @param param
	 * @param defaultValue 数组中的值如果为空或者转化失败的默认值
	 * @return
	 */
	public static int[] getInts(HttpServletRequest request,String param,int defaultValue){
		String[] values = getStrings(request, param);
		if(values == null)
			return new int[]{defaultValue};
		int len = values.length;
		int[] array = new int[len];
		for(int i=0;i<len;i++){
			int value = defaultValue;
			try {
				if(values[i] == null || values[i].length() == 0)
					value = defaultValue;
				else
					value = Integer.parseInt(values[i]);
			} catch (NumberFormatException e) {
				log.error("字符串转整型错误", e);
				value = defaultValue;
			} 
			array[i] = value;
		}
		return array;
	}
	
	
	public static Integer[] getIntegers(HttpServletRequest request,String param,int defaultValue){
		String[] values = getStrings(request, param);
		if(values == null)
			return new Integer[]{defaultValue};
		int len = values.length;
		Integer[] array = new Integer[len];
		for(int i=0;i<len;i++){
			int value = defaultValue;
			try {
				if(values[i] == null || values[i].length() == 0)
					value = defaultValue;
				else
					value = Integer.parseInt(values[i]);
			} catch (NumberFormatException e) {
				log.error("字符串转整型错误", e);
				value = defaultValue;
			} 
			array[i] = value;
		}
		return array;
	}
	
	/**
	 * 取得长整型
	 * @param request
	 * @param param
	 * @param defaultValue 如果不存在或数据转化错误的返回值 
	 * @return
	 */
	public static long getLong(HttpServletRequest request,String param,int defaultValue){
		String value = getString(request, param);
		if(value == null){
			return defaultValue;
		}
		try {
			return Long.parseLong(value);
		} catch (NumberFormatException e) {
			log.error("字符串转整型错误", e);
			return defaultValue;
		}
	}
	/**
	 * 取得长整型数组
	 * @param request
	 * @param param
	 * @param defaultValue 如果不存在或数据转化错误的返回值 
	 * @return
	 */
	public static long[] getLongs(HttpServletRequest request,String param,int defaultValue){
		String[] values = getStrings(request, param);
		if(values == null)
			return new long[]{defaultValue};
		int len = values.length;
		long[] array = new long[len];
		for(int i=0;i<len;i++){
			long value = defaultValue;
			try {
				if(values[i] == null || values[i].length() == 0)
					value = defaultValue;
				else
					value = Long.parseLong(values[i]);
			} catch (NumberFormatException e) {
				log.error("字符串转整型错误", e);
				value = defaultValue;
			} 
			array[i] = value;
		}
		return array;
	}
	
	/**
	 * 取得保存在session中的值
	 * @param request
	 * @param name
	 * @return
	 */
	public static Object getSession(HttpServletRequest request,String name){
		return  request == null ? null :request.getSession().getAttribute(name);
	}
	
	/**
	 * 保存session
	 * @param request
	 * @param name
	 * @param value
	 */
	public static void setSession(HttpServletRequest request,String name,Object value){
		if(request == null ) return;
		request.getSession().setAttribute(name, value);
	}
	/**
	 * 删除session
	 * @param request
	 * @param name
	 */
	public static void removeSession(HttpServletRequest request,String name){
		request.getSession().removeAttribute(name);
	}
	public static void removeSession(HttpServletRequest request,String... name){
		for(int i=0,len=name.length;i<len;i++)
			request.getSession().removeAttribute(name[i]);
	}
	/**
	 * 取得cookie
	 * @param request
	 * @param name
	 * @return
	 */
	public static Cookie getCookie(HttpServletRequest request,String name) {
		Cookie[] cookies = request.getCookies();
		if(cookies == null) return null;
		for(int i=0,s=cookies.length;i<s;i++){
			Cookie cookie = cookies[i];
			if(cookie.getName().equals(name)){
				return cookie;
			}
		}
		return null;
	}
	
	public static String getBasePath(HttpServletRequest request){
		return new StringBuilder(request.getScheme()).append("://").append(request.getServerName())
					.append(":").append(request.getServerPort()).append(request.getContextPath()).append("/")
					.toString();
	}
	
	/**
	 * 用于将请求在服务器端重定向至另一个页面,
	 * 它会保留request里面的参数、状态等,而且客户端并不知道请求被重定向。
	 * @param url
	 * @param request
	 * @param response
	 */
	public static void forward(String url,HttpServletRequest request,HttpServletResponse response){
		try {
			request.getRequestDispatcher(url).forward(request, response);
		} catch (ServletException | IOException e) {
			e.printStackTrace();
		}
	}
	
}
