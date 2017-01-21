package com.ctp.controller.config;
/**
 *  控制器返回字串
 *	@auther zyy
 *	@date 2016年12月11日下午7:27:24
 */
public enum ControllerReturnMsg {

	/**
	 * 异常错误
	 */
	EXCEPTION_ERROR("异常错误"),
	/**
	 * 操作成功
	 */
	OPERATOR_SUCCESS("操作成功"),
	/**
	 * 删除成功
	 */
	DELETE_SUCCESS("删除成功"),
	/**
	 * 名称不能为空
	 */
	NAME_NOT_NULL("名称不能为空"),
	;
	private String name;
	
	ControllerReturnMsg(String name){
		this.name = name;
	}
	@Override
	public String toString() {
		return this.name;
	}
}
