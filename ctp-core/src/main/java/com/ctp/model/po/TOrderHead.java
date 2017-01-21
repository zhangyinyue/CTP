package com.ctp.model.po;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

import org.hibernate.annotations.GenericGenerator;

/**
 *  订单头
 *	@auther zyy
 *	@date 2016年10月23日上午9:55:41
 */
@Entity
@Table(name="t_order_head")
public class TOrderHead {

	@Id
	@GeneratedValue(generator = "uuid")
    @GenericGenerator(name = "uuid", strategy = "uuid")
	private String fid;
	@Column(name="forder_num")
	private String forderNum;	//订单号
	private String faddress;	
	private String fphone;
	@Column(name="fpost_code")
	private String fpostCode;	//邮编
	@Column(name="fcreate_time")
	private long fcreateTime;	//下订单时间
	private String faccount;	//账号
	@Column(name="faccount_type")
	private int faccountType;	//支付方式 1支付宝2微信
	@Column(name="fbuyer_id")
	private String fbuyerID;
	@Column(name="fseller_id")
	private String fsellerID;
	@Column(name="fstore_id")
	private String fstoreID;
	@Column(name="ftotal_monty")
	private long ftotalMonty;
	public String getFid() {
		return fid;
	}
	public void setFid(String fid) {
		this.fid = fid;
	}
	public String getForderNum() {
		return forderNum;
	}
	public void setForderNum(String forderNum) {
		this.forderNum = forderNum;
	}
	public String getFaddress() {
		return faddress;
	}
	public void setFaddress(String faddress) {
		this.faddress = faddress;
	}
	public String getFphone() {
		return fphone;
	}
	public void setFphone(String fphone) {
		this.fphone = fphone;
	}
	public String getFpostCode() {
		return fpostCode;
	}
	public void setFpostCode(String fpostCode) {
		this.fpostCode = fpostCode;
	}
	public long getFcreateTime() {
		return fcreateTime;
	}
	public void setFcreateTime(long fcreateTime) {
		this.fcreateTime = fcreateTime;
	}
	public String getFaccount() {
		return faccount;
	}
	public void setFaccount(String faccount) {
		this.faccount = faccount;
	}
	public int getFaccountType() {
		return faccountType;
	}
	public void setFaccountType(int faccountType) {
		this.faccountType = faccountType;
	}
	public String getFbuyerID() {
		return fbuyerID;
	}
	public void setFbuyerID(String fbuyerID) {
		this.fbuyerID = fbuyerID;
	}
	public String getFsellerID() {
		return fsellerID;
	}
	public void setFsellerID(String fsellerID) {
		this.fsellerID = fsellerID;
	}
	public String getFstoreID() {
		return fstoreID;
	}
	public void setFstoreID(String fstoreID) {
		this.fstoreID = fstoreID;
	}
	public long getFtotalMonty() {
		return ftotalMonty;
	}
	public void setFtotalMonty(long ftotalMonty) {
		this.ftotalMonty = ftotalMonty;
	}
	
	
}
