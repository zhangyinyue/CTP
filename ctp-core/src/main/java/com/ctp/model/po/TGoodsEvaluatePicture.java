package com.ctp.model.po;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

import org.hibernate.annotations.GenericGenerator;

/**
 *  商品评价图片
 *	@auther zyy
 *	@date 2016年10月23日上午9:55:41
 */
@Entity
@Table(name="t_goods_evaluate_picture")
public class TGoodsEvaluatePicture {

	@Id
	@GeneratedValue(generator = "uuid")
    @GenericGenerator(name = "uuid", strategy = "uuid")
	private String fid;
	@Column(name="fgood_evaluate_id")
	private String fgEvaluateID;
	private byte[] fpicture;
	public String getFid() {
		return fid;
	}
	public void setFid(String fid) {
		this.fid = fid;
	}
	public String getFgEvaluateID() {
		return fgEvaluateID;
	}
	public void setFgEvaluateID(String fgEvaluateID) {
		this.fgEvaluateID = fgEvaluateID;
	}
	public byte[] getFpicture() {
		return fpicture;
	}
	public void setFpicture(byte[] fpicture) {
		this.fpicture = fpicture;
	}
	
}
