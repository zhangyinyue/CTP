package com.ctp.controller.config;
/**
 *  页面路径枚举
 *	@auther zyy
 *	@date 2016年11月23日下午8:13:12
 */
public enum PagePath {
	/**
	 * 登陆界面
	 */
	LOGIN("login"),
	/**
	 * 登陆界面
	 */
	HOME("user/home"),
	/**
	 * 用户列表界面
	 */
	USER_LIST("user/userList"),
	/**
	 * 用户列表界面
	 */
	USER_EDIT("user/userEdit"),
	/**
	 * 角色列表界面
	 */
	ROLE_LIST("role/roleList"),
	/**
	 * 角色列表界面
	 */
	ROLE_SELECT_LIST("role/roleSelectList"),
	/**
	 * 角色权限编辑界面
	 */
	ROLE_AUTH_EDIT("role/roleEdit"),
	/**
	 * 权限项列表界面
	 */
	AUTH_LISE("auth/authList"),
	/**
	 * 父权限项列表界面
	 */
	AUTH_PARENT_LISE("auth/authParentList"),
	/**
	 * 权限项编辑界面
	 */
	AUTH_EDIT("auth/authEdit"),
	;
	
	private String strVal;
	
	PagePath(String value){
		this.strVal = value;	
	}
	public String getStrVal() {
		return strVal;
	}
	@Override
	public String toString() {
		return this.strVal;
	}
}
