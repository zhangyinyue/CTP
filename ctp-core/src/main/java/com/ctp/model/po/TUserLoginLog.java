package com.ctp.model.po;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

import org.hibernate.annotations.GenericGenerator;

/**
 *  用户登陆日志
 *	@auther zyy
 *	@date 2016年10月23日上午9:55:41
 */
@Entity
@Table(name="t_user_login_log")
public class TUserLoginLog {

	@Id
	@GeneratedValue(generator = "uuid")
    @GenericGenerator(name = "uuid", strategy = "uuid")
	private String fid;
	@Column(name="fuser_id")
	private String fuserID;
	@Column(name="flogin_token")
	private String floginToken;
	@Column(name="flogin_time")
	private long floginTime;	//登陆时间
	@Column(name="flogout_time")
	private long flogoutTime;	//登出时间
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
	public String getFloginToken() {
		return floginToken;
	}
	public void setFloginToken(String floginToken) {
		this.floginToken = floginToken;
	}
	public long getFloginTime() {
		return floginTime;
	}
	public void setFloginTime(long floginTime) {
		this.floginTime = floginTime;
	}
	public long getFlogoutTime() {
		return flogoutTime;
	}
	public void setFlogoutTime(long flogoutTime) {
		this.flogoutTime = flogoutTime;
	}
	
	
}
