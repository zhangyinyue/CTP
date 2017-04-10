package com.ctp.controller.config;
/**
 *  控制器路径名称
 *	@auther zyy
 *	@date 2016年11月14日下午9:26:15
 */
public interface ControllerName {
	/*用户控制器*/
	 String ADMIN_USER = "adminUser";		//用户控制器
	 String ADMIN_TOLOGIN = "/loginPage";		//跳转到登陆界面
	 String ADMIN_LOGIN = "/login";			//登陆操作
	 String ADMIN_LOGOUT = "/logout";			//登出操作
	 String ADMIN_HOME = "/homePage";			//跳转到首页界面
	
	/*权限控制器*/
	 String ADMIN_AUTH = "adminAuth";				//权限控制器
	 String ADMIN_ROLE_LIST = "/role/listPage";		//角色列表界面
	 String ADMIN_ROLE_EDIT	= "/role/editPage";	//角色编辑界面
	 String ADMIN_ROLE_SAVE = "/role/safety";		//角色保存操作
	 String ADMIN_ROLE_DEL = "/role/deletion";		//角色删除操作
	 String ADMIN_AUTH_LIST = "/auth/listPage";		//权限项列表
	 String ADMIN_AUTH_PARENT_LIST = "/auth/listParentPage";		//父权限项列表
	 String ADMIN_AUTH_EDIT = "/auth/editPage";	//权限项编辑界面
	 String ADMIN_AUTH_SAVE = "/auth/safety";		//权限项保存
	 String ADMIN_AUTH_DEL = "/auth/deletion";		//权限项删除
	
	 String ADMIN_USER_LIST = "/user/listPage";		//用户列表界面
	 String ADMIN_USER_EDIT	= "/user/editPage";	//用户编辑界面
	 String ADMIN_USER_SAVE = "/user/safety";		//用户保存操作
	 String ADMIN_USER_DEL = "/user/deletion";		//用户删除操作

	String ADMIN_BOOK = "adminBook";				//书籍控制器
	String ADMIN_BOOK_LIST = "/book/listPage";	//书籍列表界面
	String ADMIN_BOOK_EDIT = "/book/editPage";	//书籍编辑界面
	String ADMIN_BOOK_SAVE = "/book/safety";	//书籍保存操作
	String ADMIN_BOOK_DEL = "/book/deletion";	//书籍删除操作
	String ADMIN_BOOK_VIEW_IMAGE = "/book/image";
	String ADMIN_BOOK_VIEW_FILE = "/book/file";


	String APP_BOOK = "appBook";
	String APP_BOOK_LIST = "/book/list";
	String APP_BOOK_MYFACTORY = "/book/myfactory";
	String APP_LOGIN = "book/login";
	String APP_ACCOUNT = "book/myAccount";
	String APP_REGISTER = "book/register";
	String APP_VIEWER = "book/viewer";
	String APP_BOOKS = "book/books";
	String APP_NEW_BOOKS = "book/newBooks";
	String APP_MY_BOOKS = "book/myBooks";
	String APP_MY_FRIENDS = "book/myFriends";
	String APP_BOOK_DETAIL = "book/subpage";
	String APP_ADD_MYBOOK = "book/addmyboos";
	String APP_ADD_BOOKREVIEW = "book/addbookreview";

	String APP_USER = "appUser";
	String APP_USER_LIST = "user/list";
	String APP_USER_ADD = "user/add";
	String APP_USER_DEL = "user/del";
	String APP_USER_LOGIN = "user/login";
	String APP_USER_LOGOUT = "user/logout";			//登出操作
	String APP_FRIEND_ADD = "user/addfriend";
	String APP_FRIEND_DEL = "user/delfriend";
}
