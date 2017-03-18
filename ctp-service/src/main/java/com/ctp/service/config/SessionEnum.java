package com.ctp.service.config;
/**
 *  放到session中的key值的枚举
 *	@auther zyy
 *	@date 2016年11月23日下午7:42:15
 */
public enum SessionEnum  {
	/*用户*/
	USER("user"),
	APPUSER("appUser"),
	/*权限树*/
	AUTH_TREE("authTree"),
	
	/*cookie中存放的用户名密码*/
	COOKE_USER_PWD("cookeUserPwd"),
	COOKE_USER_NAME("cookeUserName");
	
	private String value;
	private SessionEnum(String value){
		this.value = value;	
	}
	@Override
	public String toString() {
		return this.value;
	}
}
