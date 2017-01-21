package com.ctp.model.po;

import javax.annotation.Generated;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

import org.hibernate.annotations.GenericGenerator;


/**
 *  账户信息
 *	@auther zyy
 *	@date 2016年10月23日上午9:55:41
 */
@Entity
@Table(name="t_account")
public class TAccount {

	@Id
	@GeneratedValue(generator = "uuid")
    @GenericGenerator(name = "uuid", strategy = "uuid")
	private String fid;
	private String faccount;
	private Integer ftype;		//1支付宝 2微信
	@Column(name="fuser_id")
	private String fuserID;
	public String getFid() {
		return fid;
	}
	public void setFid(String fid) {
		this.fid = fid;
	}
	public String getFaccount() {
		return faccount;
	}
	public void setFaccount(String faccount) {
		this.faccount = faccount;
	}
	public Integer getFtype() {
		return ftype;
	}
	public void setFtype(Integer ftype) {
		this.ftype = ftype;
	}
	public String getFuserID() {
		return fuserID;
	}
	public void setFuserID(String fuserID) {
		this.fuserID = fuserID;
	}
	
	
}
