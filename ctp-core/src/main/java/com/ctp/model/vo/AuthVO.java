package com.ctp.model.vo;
/**
 *  权限项vo
 *	@auther zyy
 *	@date 2016年11月26日下午10:14:26
 */
public class AuthVO extends PageVO{

	private String id;
	private String name;
	private String[] ids;
	private String idsStr;
	
	
	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String[] getIds() {
		return ids;
	}

	public void setIds(String[] ids) {
		this.ids = ids;
	}

	public String getIdsStr() {
		return idsStr;
	}

	public void setIdsStr(String idsStr) {
		this.idsStr = idsStr;
	}
	
}
