package com.ctp.dao.base.impl;


import java.util.ArrayList;
import java.util.List;

/**
 * 
 * @author Administrator
 *
 */
public class ListPage {
	
	public static final ListPage createEmpty(int currentPageNo){
		ListPage lp = new ListPage(){
			@Override
			public boolean isEmpty(){
				return true;
			}
			@Override
			public int getTotalPageCount(){
				return 0;
			}
		};
		lp.setCurrentPageNo(currentPageNo);
		return lp;
	};
	
	private int currentPageNo;//当前页
	private int currentPageSize;//当前分页大小
	
	private int totalPageCount;//总页数
	private int totalCount;//总数量
	
	private List dataList;
	
	/**
	 * 判断是否为空
	 * @return
	 */
	public boolean isEmpty(){
		return dataList == null || dataList.size() < 1;
	}
	
	public boolean hasNextPage(){
		return currentPageNo < totalPageCount;
	}
	
	public int getCurrentPageNo() {
		return currentPageNo;
	}

	public void setCurrentPageNo(int currentPageNo) {
		this.currentPageNo = currentPageNo;
	}

	public int getCurrentPageSize() {
		return currentPageSize;
	}

	public void setCurrentPageSize(int currentPageSize) {
		this.currentPageSize = currentPageSize;
	}

	public int getTotalPageCount() {
		return totalPageCount;
	}

	public void setTotalPageCount(int totalPageCount) {
		this.totalPageCount = totalPageCount;
	}

	public int getTotalCount() {
		return totalCount;
	}

	public void setTotalCount(int totalCount) {
		this.totalCount = totalCount;
	}

	public List getDataList() {
		return dataList == null ? new ArrayList() : dataList;
	}
	public void resetTotalCount(int totalCount){
		this.totalCount = totalCount;
		this.totalPageCount = (int)((totalCount -1)/this.currentPageSize + 1);
	}
	public void setDataList(List dataList) {
		this.dataList = dataList;
	}
	
}
