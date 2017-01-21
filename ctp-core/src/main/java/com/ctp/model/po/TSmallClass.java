package com.ctp.model.po;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

import org.hibernate.annotations.GenericGenerator;

/**
 *  商品小类别
 *	@auther zyy
 *	@date 2016年10月23日上午9:55:41
 */
@Entity
@Table(name="t_small_class")
public class TSmallClass {

	@Id
	@GeneratedValue(generator = "uuid")
    @GenericGenerator(name = "uuid", strategy = "uuid")
	private String fid;
	private String fname;
	@Column(name="fbig_class_id")
	private String fbigClassID;
	@Column(name="fstore_id")
	private String fstoreID;
	public String getFid() {
		return fid;
	}
	public void setFid(String fid) {
		this.fid = fid;
	}
	public String getFname() {
		return fname;
	}
	public void setFname(String fname) {
		this.fname = fname;
	}
	public String getFbigClassID() {
		return fbigClassID;
	}
	public void setFbigClassID(String fbigClassID) {
		this.fbigClassID = fbigClassID;
	}
	public String getFstoreID() {
		return fstoreID;
	}
	public void setFstoreID(String fstoreID) {
		this.fstoreID = fstoreID;
	}
	
	
}
