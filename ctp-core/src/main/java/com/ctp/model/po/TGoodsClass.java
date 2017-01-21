package com.ctp.model.po;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

import org.hibernate.annotations.GenericGenerator;

/**
 *  商品类别明细
 *	@auther zyy
 *	@date 2016年10月23日上午9:55:41
 */
@Entity
@Table(name="t_goods_class")
public class TGoodsClass {

	@Id
	@GeneratedValue(generator = "uuid")
    @GenericGenerator(name = "uuid", strategy = "uuid")
	private String fid;
	@Column(name="fgoods_id")
	private String fgoodsID;
	@Column(name="fsmall_class_id")
	private String fsmallClassID;
	public String getFid() {
		return fid;
	}
	public void setFid(String fid) {
		this.fid = fid;
	}
	public String getFgoodsID() {
		return fgoodsID;
	}
	public void setFgoodsID(String fgoodsID) {
		this.fgoodsID = fgoodsID;
	}
	public String getFsmallClassID() {
		return fsmallClassID;
	}
	public void setFsmallClassID(String fsmallClassID) {
		this.fsmallClassID = fsmallClassID;
	}
	
	
	
}
