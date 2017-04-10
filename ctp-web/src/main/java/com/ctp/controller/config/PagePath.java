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
	LOGIN("admin/login"),
	/**
	 * 登陆界面
	 */
	HOME("admin/user/home"),
	/**
	 * 用户列表界面
	 */
	USER_LIST("admin/user/userList"),
	/**
	 * 用户编辑界面
	 */
	USER_EDIT("admin/user/userEdit"),
	/**
	 * 角色列表界面
	 */
	ROLE_LIST("admin/role/roleList"),
	USER_ROLE_LIST("admin/user/roleList"),
	/**
	 * 角色权限编辑界面
	 */
	ROLE_AUTH_EDIT("admin/role/roleEdit"),
	/**
	 * 权限项列表界面
	 */
	AUTH_LISE("admin/auth/authList"),
	/**
	 * 父权限项列表界面
	 */
	AUTH_PARENT_LISE("admin/auth/authParentList"),
	/**
	 * 权限项编辑界面
	 */
	AUTH_EDIT("admin/auth/authEdit"),
	/**
	 * 书籍列表
	 */
    BOOK_LIST("admin/book/bookList"),
    /**
     * 书籍编辑界面
     */
    BOOK_EDIT("admin/book/bookEdit"),

	APP_BOOK_LIST("app/home"),
    APP_MYY_BOOKS("app/mybooks"),
    APP_SUBPAGE("app/subpage"),
	APP_LOGIN("app/login"),
	APP_ACCOUNT("app/myaccount"),
	APP_REGISTER("app/register"),
	APP_VIEWER("app/viewer"),
	APP_BOOKS("app/books"),
	APP_NEW_BOOKS("app/newbooks"),
	APP_MY_BOOKS("app/mybooks"),
	APP_MY_FRIENDS("app/myfriends"),
	APP_BOOK_DETAIL("app/subpage"),
	APP_BOOK_MYFACTORY("app/myfactory")
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
