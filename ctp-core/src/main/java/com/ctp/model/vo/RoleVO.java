package com.ctp.model.vo;
/**
 *  角色vo
 *	@auther zyy
 *	@date 2016年12月3日下午3:00:47
 */
public class RoleVO extends PageVO{

	private String id;
	private String name;
	private String[] ids;
	private String idsStr;
	
	public String getIdsStr() {
		return idsStr;
	}

	public void setIdsStr(String idsStr) {
		this.idsStr = idsStr;
	}

	public String[] getIds() {
		return ids;
	}

	public void setIds(String[] ids) {
		this.ids = ids;
	}

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
	
}
