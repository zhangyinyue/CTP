package com.ctp.model.po;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

import org.hibernate.annotations.GenericGenerator;

/**
 *  购物车信息
 *	@auther zyy
 *	@date 2016年10月23日上午9:55:41
 */
@Entity
@Table(name="t_shopping_car")
public class TShoppingCar {

	@Id
	@GeneratedValue(generator = "uuid")
    @GenericGenerator(name = "uuid", strategy = "uuid")
	private String fid;
	@Column(name="fuser_id")
	private String fuserID;
	@Column(name="fgoods_id")
	private String fgoodsID;
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
	public String getFgoodsID() {
		return fgoodsID;
	}
	public void setFgoodsID(String fgoodsID) {
		this.fgoodsID = fgoodsID;
	}
	
	
}
