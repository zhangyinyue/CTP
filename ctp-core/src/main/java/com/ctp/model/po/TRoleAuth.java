package com.ctp.model.po;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

import org.hibernate.annotations.GenericGenerator;

/**
 *  角色权限明细
 *	@auther zyy
 *	@date 2016年10月23日上午9:55:41
 */
@Entity
@Table(name="t_role_auth")
public class TRoleAuth {

	@Id
	@GeneratedValue(generator = "uuid")
    @GenericGenerator(name = "uuid", strategy = "uuid")
	private String fid;
	@Column(name="frole_id")
	private String froleID;
	@Column(name="fauth_id")
	private String fauthID;
	public String getFid() {
		return fid;
	}
	public void setFid(String fid) {
		this.fid = fid;
	}
	public String getFroleID() {
		return froleID;
	}
	public void setFroleID(String froleID) {
		this.froleID = froleID;
	}
	public String getFauthID() {
		return fauthID;
	}
	public void setFauthID(String fauthID) {
		this.fauthID = fauthID;
	}
	
	
}
