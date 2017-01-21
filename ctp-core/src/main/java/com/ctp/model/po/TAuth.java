package com.ctp.model.po;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Transient;

import org.hibernate.annotations.GenericGenerator;

/**
 *  权限信息
 *	@auther zyy
 *	@date 2016年10月23日上午9:55:41
 */
@Entity
@Table(name="t_auth")
public class TAuth {

	@Id
	@GeneratedValue(generator = "uuid")
    @GenericGenerator(name = "uuid", strategy = "uuid")
	private String fid;
	@Column(name="fparent_id")
	private String fparentID;	//父节点
	private String fname;
	private String furl;		//权限路径
	private String forderby;	//排序
	private String ficon;		//图标
	
	@Transient
	private String belongRole;
	@Transient
	private int pageNo = 1;
	@Transient
	private int pageSize = 20;
	@Transient
	private String parentName;
	
	public String getParentName() {
		return parentName;
	}
	public void setParentName(String parentName) {
		this.parentName = parentName;
	}
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
	public String getBelongRole() {
		return belongRole;
	}
	public void setBelongRole(String belongRole) {
		this.belongRole = belongRole;
	}
	public String getFid() {
		return fid;
	}
	public void setFid(String fid) {
		this.fid = fid;
	}
	public String getFparentID() {
		return fparentID;
	}
	public void setFparentID(String fparentID) {
		this.fparentID = fparentID;
	}
	public String getFname() {
		return fname;
	}
	public void setFname(String fname) {
		this.fname = fname;
	}
	public String getFurl() {
		return furl;
	}
	public void setFurl(String furl) {
		this.furl = furl;
	}
	public String getForderby() {
		return forderby;
	}
	public void setForderby(String forderby) {
		this.forderby = forderby;
	}
	public String getFicon() {
		return ficon;
	}
	public void setFicon(String ficon) {
		this.ficon = ficon;
	}
	
	
}
