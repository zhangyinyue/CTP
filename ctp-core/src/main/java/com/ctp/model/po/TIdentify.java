package com.ctp.model.po;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

import org.hibernate.annotations.GenericGenerator;

/**
 *  认证信息
 *	@auther zyy
 *	@date 2016年10月23日上午9:55:41
 */
@Entity
@Table(name="t_identify")
public class TIdentify {

	@Id
	@GeneratedValue(generator = "uuid")
    @GenericGenerator(name = "uuid", strategy = "uuid")
	private String fid;
	@Column(name="fuser_id")
	private String fuserID;
	@Column(name="freal_name")
	private String frealName;
	@Column(name="fid_card")
	private String fidCard;			//身份证号
	@Column(name="fid_card_postive")
	private byte[] fidCardPostive;	//身份证正面
	@Column(name="fid_card_negative")
	private byte[] fidCardNegative;	//身份证反面
	@Column(name="fid_card_user")
	private byte[] fidCardUser;		//手持身份证正面照
	@Column(name="fcreate_time")
	private long fcreateTime;		//申请时间
	private Integer fstate;			//0未审核 1通过 2驳回
	private String fremark;			//备注
	@Column(name="foperater_id")
	private String foperaterID;		//审核者
	@Column(name="foperater_time")
	private long foperaterTime;		//审核时间
	public String getFid() {
		return fid;
	}
	public void setFid(String fid) {
		this.fid = fid;
	}
	public String getFuserID() {
		return fuserID;
	}
	public void setFuserID(String fuserID) {
		this.fuserID = fuserID;
	}
	public String getFrealName() {
		return frealName;
	}
	public void setFrealName(String frealName) {
		this.frealName = frealName;
	}
	public String getFidCard() {
		return fidCard;
	}
	public void setFidCard(String fidCard) {
		this.fidCard = fidCard;
	}
	public byte[] getFidCardPostive() {
		return fidCardPostive;
	}
	public void setFidCardPostive(byte[] fidCardPostive) {
		this.fidCardPostive = fidCardPostive;
	}
	public byte[] getFidCardNegative() {
		return fidCardNegative;
	}
	public void setFidCardNegative(byte[] fidCardNegative) {
		this.fidCardNegative = fidCardNegative;
	}
	public byte[] getFidCardUser() {
		return fidCardUser;
	}
	public void setFidCardUser(byte[] fidCardUser) {
		this.fidCardUser = fidCardUser;
	}
	public long getFcreateTime() {
		return fcreateTime;
	}
	public void setFcreateTime(long fcreateTime) {
		this.fcreateTime = fcreateTime;
	}
	public Integer getFstate() {
		return fstate;
	}
	public void setFstate(Integer fstate) {
		this.fstate = fstate;
	}
	public String getFremark() {
		return fremark;
	}
	public void setFremark(String fremark) {
		this.fremark = fremark;
	}
	public String getFoperaterID() {
		return foperaterID;
	}
	public void setFoperaterID(String foperaterID) {
		this.foperaterID = foperaterID;
	}
	public long getFoperaterTime() {
		return foperaterTime;
	}
	public void setFoperaterTime(long foperaterTime) {
		this.foperaterTime = foperaterTime;
	}
	
	
}
