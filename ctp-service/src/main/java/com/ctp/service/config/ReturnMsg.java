package com.ctp.service.config;
/**
 *  
 *	@auther zyy
 *	@date 2016年12月13日下午10:31:11
 */
public enum ReturnMsg {
	/**
	 * 删除权限项失败，该权限项已被引用！
	 */
	DEL_AUTH_FAIL("删除权限项失败，该权限项已被引用！"),
	/**
	 * 删除成功！
	 */
	DEL_SUCCESS("删除成功！");
	
	private String name;
	ReturnMsg(String name){
		this.name = name;
	}
	@Override
	public String toString() {
		return this.name;
	}
}
