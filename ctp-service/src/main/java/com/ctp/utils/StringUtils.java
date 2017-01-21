package com.ctp.utils;
/**
 *  字符串工具类
 *	@auther zyy
 *	@date 2016年11月7日下午9:14:55
 */
public class StringUtils {

	/**
	 * 判断字符串是否为空
	 * @param str
	 * @return 空为true
	 */
	public static boolean isEmpty(String str){
		return str == null || "".equals(str.trim());
	}
}
