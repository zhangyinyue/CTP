package com.ctp.model.po;

import javax.persistence.*;

import org.hibernate.annotations.GenericGenerator;

/**
 *  用户信息
 *	@auther zyy
 *	@date 2016年10月23日上午9:55:41
 */
@Entity
@Table(name="t_user")
public class TUser {

	@Id
	@GeneratedValue(strategy= GenerationType.IDENTITY)
	private long fid;
	private String fname;
	private byte fsex;
	private int fage;
	@Column(name="frole_id")
	private String froleID;
	private String fpwd;
	
	@Transient
	private int remember;
	@Transient
	private String roleName;

	public String getRoleName() {
		return roleName;
	}

	public void setRoleName(String roleName) {
		this.roleName = roleName;
	}

	public int getRemember() {
		return remember;
	}
	public void setRemember(int remember) {
		this.remember = remember;
	}
	public String getFname() {
		return fname;
	}
	public void setFname(String fname) {
		this.fname = fname;
	}
	public byte getFsex() {
		return fsex;
	}
	public void setFsex(byte fsex) {
		this.fsex = fsex;
	}
	public int getFage() {
		return fage;
	}
	public void setFage(int fage) {
		this.fage = fage;
	}
	public String getFroleID() {
		return froleID;
	}
	public void setFroleID(String froleID) {
		this.froleID = froleID;
	}
	public String getFpwd() {
		return fpwd;
	}
	public void setFpwd(String fpwd) {
		this.fpwd = fpwd;
	}

	public long getFid() {
		return fid;
	}

	public void setFid(long fid) {
		this.fid = fid;
	}
}
