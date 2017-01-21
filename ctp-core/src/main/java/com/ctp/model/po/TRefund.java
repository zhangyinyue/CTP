package com.ctp.model.po;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

import org.hibernate.annotations.GenericGenerator;

/**
 *  退款信息
 *	@auther zyy
 *	@date 2016年10月23日上午9:55:41
 */
@Entity
@Table(name="t_refund")
public class TRefund {
	
	@Id
	@GeneratedValue(generator = "uuid")
    @GenericGenerator(name = "uuid", strategy = "uuid")
	private String fid;
	private long fmoney;
	@Column(name="fuser_id")
	private String fuserID;
	private int fstate;			//0申请退款1通过2退款成功3驳回
	@Column(name="fapply_time")
	private long fapplyTime;	//申请时间
	@Column(name="ftransfer_time")
	private long ftransferTime;	//退款时间
	@Column(name="foperater_id")
	private String foperaterID;	
	private String freason;
	@Column(name="forder_id")
	private String forderID;
	@Column(name="forder_num")
	private String forderNum;	
	@Column(name="fauth_time")
	private long fauthTime;		//审核时间
	public String getFid() {
		return fid;
	}
	public void setFid(String fid) {
		this.fid = fid;
	}
	public long getFmoney() {
		return fmoney;
	}
	public void setFmoney(long fmoney) {
		this.fmoney = fmoney;
	}
	public String getFuserID() {
		return fuserID;
	}
	public void setFuserID(String fuserID) {
		this.fuserID = fuserID;
	}
	public int getFstate() {
		return fstate;
	}
	public void setFstate(int fstate) {
		this.fstate = fstate;
	}
	public long getFapplyTime() {
		return fapplyTime;
	}
	public void setFapplyTime(long fapplyTime) {
		this.fapplyTime = fapplyTime;
	}
	public long getFtransferTime() {
		return ftransferTime;
	}
	public void setFtransferTime(long ftransferTime) {
		this.ftransferTime = ftransferTime;
	}
	public String getFoperaterID() {
		return foperaterID;
	}
	public void setFoperaterID(String foperaterID) {
		this.foperaterID = foperaterID;
	}
	public String getFreason() {
		return freason;
	}
	public void setFreason(String freason) {
		this.freason = freason;
	}
	public String getForderID() {
		return forderID;
	}
	public void setForderID(String forderID) {
		this.forderID = forderID;
	}
	public String getForderNum() {
		return forderNum;
	}
	public void setForderNum(String forderNum) {
		this.forderNum = forderNum;
	}
	public long getFauthTime() {
		return fauthTime;
	}
	public void setFauthTime(long fauthTime) {
		this.fauthTime = fauthTime;
	}
	
	
}
