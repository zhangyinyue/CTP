package com.ctp.controller.config;
/**
 *  控制器路径名称
 *	@auther zyy
 *	@date 2016年11月14日下午9:26:15
 */
public interface ControllerName {
	/*用户控制器*/
	static final String ADMIN_USER = "adminUser";		//用户控制器
	static final String ADMIN_TOLOGIN = "/loginPage";		//跳转到登陆界面
	static final String ADMIN_LOGIN = "/login";			//登陆操作
	static final String ADMIN_LOGOUT = "/logout";			//登出操作
	static final String ADMIN_HOME = "/homePage";			//跳转到首页界面
	
	/*权限控制器*/
	static final String ADMIN_AUTH = "adminAuth";				//权限控制器
	static final String ADMIN_ROLE_LIST = "/role/listPage";		//角色列表界面
	static final String ADMIN_ROLE_EDIT	= "/role/editPage";	//角色编辑界面
	static final String ADMIN_ROLE_SAVE = "/role/safety";		//角色保存操作
	static final String ADMIN_ROLE_DEL = "/role/deletion";		//角色删除操作
	static final String ADMIN_AUTH_LIST = "/auth/listPage";		//权限项列表
	static final String ADMIN_AUTH_PARENT_LIST = "/auth/listParentPage";		//父权限项列表
	static final String ADMIN_AUTH_EDIT = "/auth/editPage";	//权限项编辑界面
	static final String ADMIN_AUTH_SAVE = "/auth/safety";		//权限项保存
	static final String ADMIN_AUTH_DEL = "/auth/deletion";		//权限项删除
	
	static final String ADMIN_USER_LIST = "/user/listPage";		//用户列表界面
	static final String ADMIN_USER_EDIT	= "/user/editPage";	//用户编辑界面
	static final String ADMIN_USER_SAVE = "/user/safety";		//用户保存操作
	static final String ADMIN_USER_DEL = "/user/deletion";		//用户删除操作
	
	
	
}
