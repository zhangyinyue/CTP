package com.ctp.utils;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletResponse;

import com.alibaba.fastjson.JSONObject;

public final class UResponse {
	
	private static final String ENCODE = "utf-8";
	private static final String CONTENT_TYPE_HTML = "text/html;charset=utf-8";
	private static final String CONTENT_TYPE_JSON = "application/json;charset=utf-8";
	
	public static void write(HttpServletResponse response,String data){
		response.setCharacterEncoding(ENCODE);
		response.setContentType(CONTENT_TYPE_HTML);
		try(PrintWriter pw = response.getWriter()){
			pw.write(data);
		}catch(Exception e){
			e.printStackTrace();
		}
	}
	/**
	 * 返回结果
	 * @param response
	 * @param data
	 * @param success 是否成功
	 */
	public static void writeJSON(HttpServletResponse response,Object data,boolean success){
		response.setCharacterEncoding(ENCODE);
		response.setContentType(CONTENT_TYPE_JSON);
		try(PrintWriter pw = response.getWriter()){
			JSONObject obj = new JSONObject();
			obj.put("success", success);
			obj.put("data", data);
			pw.write(obj.toString());
			pw.flush();
		}catch(Exception e){
			e.printStackTrace();
		}
	}
	/**
	 * 返回成功
	 * @param response
	 * @param data
	 */
	public static void writeSuccess(HttpServletResponse response,Object data){
		writeJSON(response, data, true);
	}
	/**
	 * 失败
	 * @param response
	 * @param data
	 */
	public static void writeFail(HttpServletResponse response,Object data){
		writeJSON(response, data, false);
	}
	
	/**
	 * 设置Cookie
	 * @param response
	 * @param name
	 * @param values
	 */
	public static void setCookie(HttpServletResponse response,String name,String... values){
		if(response == null)return;
		StringBuffer buf = new StringBuffer();
		for (String value : values) {
			buf.append(value+",");
		}
		Cookie cookie = new Cookie(name,  buf.substring(0, buf.length()-1));
		cookie.setMaxAge(7*24*60*60);//如果为负则为浏览器进程，浏览器关闭则失效，0则删除，以秒计
		cookie.setPath("/");
		response.addCookie(cookie); 
	}
	/**
	 * 删除Cookie
	 * @param response
	 * @param name
	 */
	public static void removeCookie(HttpServletResponse response,String name){
		if(response == null)return;
		Cookie cookie = new Cookie(name, null);
		cookie.setMaxAge(0);
		cookie.setPath("/");
		response.addCookie(cookie);
	}
	/**
	 * 保存cookie
	 * @param response
	 * @param name
	 * @param value
	 * @param age
	 */
	public static void setCookie(HttpServletResponse response,String name,String value,int age){
		Cookie cookie = new Cookie(name,  value);
		cookie.setMaxAge(age);//如果为负则为浏览器进程，浏览器关闭则失效，0则删除，以秒计
		cookie.setPath("/");
		response.addCookie(cookie); 
	}
	/**
	 * Response跳转
	 * @param url
	 * @param response
	 * 会产生二次请求
	 * 即跳到URL 然后 URL再请求
	 * reques和response都是独立的，即数据不共享 
	 */
	public static void redirect(String url,HttpServletResponse response){
		try {
			response.sendRedirect(url);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	
}
