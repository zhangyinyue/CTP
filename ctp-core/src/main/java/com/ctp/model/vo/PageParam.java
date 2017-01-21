package com.ctp.model.vo;

import java.util.Map;

/**
 *  用于传分页参数
 *	@auther zyy
 *	@date 2016年12月3日下午3:13:37
 */
public class PageParam {

	private int pageNo;
	private int pageSize;
	private String query;
	private String count;
	private Map<String,Object> params;
	
	public int getPageNo() {
		return pageNo;
	}
	public void setPageNo(int pageNo) {
		this.pageNo = pageNo;
	}
	public int getPageSize() {
		return pageSize;
	}
	public void setPageSize(int pageSize) {
		this.pageSize = pageSize;
	}
	public String getQuery() {
		return query;
	}
	public void setQuery(String query) {
		this.query = query;
	}
	public String getCount() {
		return count;
	}
	public void setCount(String count) {
		this.count = count;
	}
	public Map<String, Object> getParams() {
		return params;
	}
	public void setParams(Map<String, Object> params) {
		this.params = params;
	}
}
