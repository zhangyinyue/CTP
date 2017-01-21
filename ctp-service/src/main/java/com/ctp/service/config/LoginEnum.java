package com.ctp.service.config;
/**
 *  登陆状态的枚举
 *	@auther zyy
 *	@date 2016年11月23日下午8:03:22
 */
public enum LoginEnum {
	/**
	 * 登陆成功
	 */
	LOGIN_SUCCESS("登陆成功"),
	/**
	 * 密码错误
	 */
	PASSWORD_ERROR("密码错误"),
	/**
	 * 账号不存在
	 */
	ACCOUNT_NO_EXISTS("账号不存在"),
	/**
	 * 账号不允许为空
	 */
	ACCOUNT_EMPTY("账号不允许为空"),
	/**
	 * 密码不允许为空
	 */
	PASSWORD_EMPTY("密码不允许为空"),
	/**
	 * 是否记住密码的标志位,数值1
	 */
	REMEMBER(1);
	
	private String strVal;
	private int intVal;
	
	LoginEnum(int value){
		this.intVal = value;	
	}
	
	LoginEnum(String value){
		this.strVal = value;	
	}
	public String getStrVal() {
		return strVal;
	}
	public int getIntVal() {
		return intVal;
	}
	
}
