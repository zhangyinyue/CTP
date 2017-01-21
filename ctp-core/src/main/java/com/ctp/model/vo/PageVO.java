package com.ctp.model.vo;

import java.util.Map;

/**
 *  
 *	@auther zyy
 *	@date 2016年12月3日下午3:01:45
 */
public class PageVO {

	private int pageNo = 1;
	private int pageSize = 20;
	
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
	
}
