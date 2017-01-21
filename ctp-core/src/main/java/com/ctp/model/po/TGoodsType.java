package com.ctp.model.po;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

import org.hibernate.annotations.GenericGenerator;

/**
 *  商品规格
 *	@auther zyy
 *	@date 2016年10月23日上午9:55:41
 */
@Entity
@Table(name="t_goods_type")
public class TGoodsType {

	@Id
	@GeneratedValue(generator = "uuid")
    @GenericGenerator(name = "uuid", strategy = "uuid")
	private String fid;
	private Integer fprice;
	private byte[] fpicture;
	@Column(name="fgoods_id")
	private String fgoodsID;
	public String getFid() {
		return fid;
	}
	public void setFid(String fid) {
		this.fid = fid;
	}
	public Integer getFprice() {
		return fprice;
	}
	public void setFprice(Integer fprice) {
		this.fprice = fprice;
	}
	public byte[] getFpicture() {
		return fpicture;
	}
	public void setFpicture(byte[] fpicture) {
		this.fpicture = fpicture;
	}
	public String getFgoodsID() {
		return fgoodsID;
	}
	public void setFgoodsID(String fgoodsID) {
		this.fgoodsID = fgoodsID;
	}
	
	
	
}
