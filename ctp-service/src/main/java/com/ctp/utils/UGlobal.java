package com.ctp.utils;

import java.text.SimpleDateFormat;
import java.util.Date;

import com.ctp.dao.base.impl.ListPage;



public class UGlobal{

	private static final ThreadLocal<SimpleDateFormat> tl = new ThreadLocal<>();
	
	public static String dateFormat(Long time){
		if(time == null) time = 0L;
		long t = time * 1000;
		SimpleDateFormat sdf = tl.get();
		if(sdf == null){
			sdf = new SimpleDateFormat("yyyy-MM-dd");
			tl.set(sdf);
		}
		return sdf.format(new Date(t));
	}
	
	
	
	/*<div class="row-fluid" style="display: block;height:30px;line-height: 30px;">
	<span>第1页/共5页</span>
	<span>&nbsp;&nbsp;&nbsp;&nbsp;共1000条记录</span> 
	<span style="float:right">
		<select style="height:30px;line-height: 20px;width:60px;margin-top:-3px;margin-left:10px;">
			<option selected="selected">1</option>
		</select>
	</span>
	<span style="float: right;" style="width:100px;">
		<div class="dataTables_paginate paging_bootstrap pagination" style="margin:0;">
		<ul>
			<li class="prev disabled"><a href="#">← <span class="hidden-480">上一页</span></a></li>
			<li class="next"><a href="#"><span class="hidden-480">下一页</span> → </a></li>
		</ul>
		</div>
	</span>  
</div>*/
	public static String paging(ListPage listPage){
		StringBuilder paging = new StringBuilder("<div class=\"row-fluid\" style=\"display: block;height:30px;line-height: 30px;\">");
		paging.append("<span>第").append(listPage.getCurrentPageNo()).append("页")
				.append("/共").append(listPage.getTotalPageCount()).append("页</span>")
				.append("<span>&nbsp;&nbsp;&nbsp;&nbsp;").append(listPage.getTotalCount()).append("条记录</span>")

				.append("<span>每页显示<input type=\"text\" name=\"pageSize\" value=\"").append(listPage.getCurrentPageSize()).append("\" style=\"height:20px;line-height: 20px;width:60px;\" onkeyup=\"changePageSize(this.value)\"/>条</span>")

				.append("<span style=\"float:right\">")
				.append("<select style=\"height:30px;line-height: 20px;width:60px;margin-top:-3px;margin-left:10px;\" onchange=\"paging(this.value)\">");
		for(int i=1,s=listPage.getTotalPageCount();i<=s;i++){
			paging.append("<option value=\"").append(i).append("\"");
			if(i == listPage.getCurrentPageNo())
				paging.append(" selected");
			paging.append(">").append(i).append("</option>");
		}
		paging.append("</select></span>");


		paging.append("<span style=\"float: right;\" style=\"width:100px;\">")
				.append("<div class=\"dataTables_paginate paging_bootstrap pagination\" style=\"margin:0;\">")
				.append("<ul>")
				//上一页
				.append("<li class=\"prev");
		if(listPage.getCurrentPageNo() <= 1){
			paging.append(" disabled");
		}
		int prev = listPage.getCurrentPageNo() - 1;
		paging.append("\"><a href=\"javascript:paging(").append(prev < 0 ? 0 : prev).append(");\">");
		paging.append("← <span class=\"hidden-480\">上一页</span></a></li>");

		//下一页
		paging.append("<li class=\"next");
		if(listPage.getCurrentPageNo() >= listPage.getTotalPageCount())
			paging.append(" disabled");
		int next = listPage.getCurrentPageNo() + 1;
		paging.append("\"><a href=\"javascript:paging(").append(next > listPage.getTotalPageCount() ? listPage.getTotalPageCount() : next).append(");\"><span class=\"hidden-480\">下一页</span> → </a></li>");

		paging.append("</ul>")
				.append("</div>")
				.append("</span>")
				.append("</div>");

		return paging.toString();
	}
	public static String appPaging(ListPage listPage){
		StringBuilder paging = new StringBuilder("<div class=\"row-fluid\" style=\"display: block;height:30px;line-height: 30px;color:white\">");
		paging.append("<span>第").append(listPage.getCurrentPageNo()).append("页")
				.append("/共").append(listPage.getTotalPageCount()).append("页</span>")
				.append("<span>&nbsp;&nbsp;&nbsp;&nbsp;").append(listPage.getTotalCount()).append("条记录</span>")

				.append("<span>每页显示<input type=\"text\" name=\"pageSize\" value=\"").append(listPage.getCurrentPageSize()).append("\" style=\"height:20px;line-height: 20px;width:60px;\" onkeyup=\"changePageSize(this.value)\"/>条</span>")

				.append("<span style=\"float:right\">")
				.append("<select style=\"height:30px;line-height: 20px;width:60px;margin-top:-3px;margin-left:10px;\" onchange=\"paging(this.value)\">");
		for(int i=1,s=listPage.getTotalPageCount();i<=s;i++){
			paging.append("<option value=\"").append(i).append("\"");
			if(i == listPage.getCurrentPageNo())
				paging.append(" selected");
			paging.append(">").append(i).append("</option>");
		}
		paging.append("</select></span>");


		paging.append("<span style=\"float: right;\" style=\"width:100px;\">")
				.append("<div class=\"dataTables_paginate paging_bootstrap pagination\" style=\"margin:0;\">")
				.append("<ul>")
				//上一页
				.append("<li class=\"prev");
		if(listPage.getCurrentPageNo() <= 1){
			paging.append(" disabled");
		}
		int prev = listPage.getCurrentPageNo() - 1;
		paging.append("\"><a href=\"javascript:paging(").append(prev < 0 ? 0 : prev).append(");\">");
		paging.append("← <span class=\"hidden-480\">上一页</span></a></li>");

		//下一页
		paging.append("<li class=\"next");
		if(listPage.getCurrentPageNo() >= listPage.getTotalPageCount())
			paging.append(" disabled");
		int next = listPage.getCurrentPageNo() + 1;
		paging.append("\"><a href=\"javascript:paging(").append(next > listPage.getTotalPageCount() ? listPage.getTotalPageCount() : next).append(");\"><span class=\"hidden-480\">下一页</span> → </a></li>");

		paging.append("</ul>")
				.append("</div>")
				.append("</span>")
				.append("</div>");

		return paging.toString();
	}
}
