package com.ctp.model.vo;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.Column;

import com.ctp.model.po.TAuth;


/**
 *  权限树
 *	@auther zyy
 *	@date 2016年10月31日下午10:32:14
 */
public class AuthTreeVO {

	private List<Node> tree = new ArrayList<Node>();
	
	public List<?> getTree(){
		return tree;
	}
	
	public void addNode(TAuth auth){
		tree.add(new Node(auth));
	}
	
	public void addAllNode(List<TAuth> tree){
		for(int i = 0; i < tree.size(); i++){
			this.tree.add(new Node(tree.get(i)));
		}
	}
	
	public Node getNode(int i){
		return tree.get(i);
	}
	
	public int size(){
		return tree.size();
	}
	
	public  class Node{
		private String fid;
		private String fparentID;	//父节点
		private String fname;
		private String furl;		//权限路径
		private String forderBy;	//排序
		private String ficon;	
		private String belongRole;
		
		public Node(TAuth auth) {
			this.fid = auth.getFid();
			this.fparentID = auth.getFparentID();
			this.fname = auth.getFname();
			this.furl = auth.getFurl();
			this.forderBy = auth.getForderby();
			this.ficon = auth.getFicon();
			this.belongRole = auth.getBelongRole();
		}

		public String getBelongRole() {
			return belongRole;
		}

		public void setBelongRole(String belongRole) {
			this.belongRole = belongRole;
		}

		public String getFid() {
			return fid;
		}

		public void setFid(String fid) {
			this.fid = fid;
		}

		public String getFparentID() {
			return fparentID;
		}

		public void setFparentID(String fparentID) {
			this.fparentID = fparentID;
		}

		public String getFname() {
			return fname;
		}

		public void setFname(String fname) {
			this.fname = fname;
		}

		public String getFurl() {
			return furl;
		}

		public void setFurl(String furl) {
			this.furl = furl;
		}

		public String getForderBy() {
			return forderBy;
		}

		public void setForderBy(String forderBy) {
			this.forderBy = forderBy;
		}

		public String getFicon() {
			return ficon;
		}

		public void setFicon(String ficon) {
			this.ficon = ficon;
		}
		
		@Override
		public String toString() {
			return this.fid+","+this.fname+","+this.forderBy+","+this.fparentID+","+
					this.furl+","+this.ficon;
		}
	}
}
