package com.ctp.model.po;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

import org.hibernate.annotations.GenericGenerator;

/**
 *  商品
 *	@auther zyy
 *	@date 2016年10月23日上午9:55:41
 */
@Entity
@Table(name="t_goods")
public class TGoods {

	@Id
	@GeneratedValue(generator = "uuid")
    @GenericGenerator(name = "uuid", strategy = "uuid")
	private String fid;
	private String fname;
	private Integer fprice;
	@Column(name="fstore_id'")
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
	public Integer getFprice() {
		return fprice;
	}
	public void setFprice(Integer fprice) {
		this.fprice = fprice;
	}
	public String getFstoreID() {
		return fstoreID;
	}
	public void setFstoreID(String fstoreID) {
		this.fstoreID = fstoreID;
	}
	
	
	
}
