package com.ctp.model.vo;
/**
 *  用户vo
 *	@auther zyy
 *	@date 2016年12月21日下午9:12:31
 */
public class UserVO extends PageVO{

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

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}
	
}
