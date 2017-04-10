<%@ page language="java" contentType="text/html; charset=utf-8" pageEncoding="utf-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!-- BEGIN SIDEBAR -->
<div class="page-sidebar nav-collapse collapse">
	<!-- BEGIN SIDEBAR MENU -->        
	<ul class="page-sidebar-menu">
		<li>
			<!-- BEGIN SIDEBAR TOGGLER BUTTON -->
			<div class="sidebar-toggler hidden-phone"></div>
			<!-- BEGIN SIDEBAR TOGGLER BUTTON -->
		</li>
		<li>
			<!-- BEGIN RESPONSIVE QUICK SEARCH FORM -->
			<form class="sidebar-search">
				<div class="input-box">
					<a href="javascript:;" class="remove"></a>
				</div>
			</form>
			<!-- END RESPONSIVE QUICK SEARCH FORM -->
		</li>
		<%--<li class="${ empty pid && empty cid  ? 'active' : ''  }">
			<a href="${basePath }admin/index/toIndex">
			<i class="icon-home"></i> 
			<span class="title">首页</span>
			</a>
		</li>--%>
		<c:forEach items="${sessionScope.authTree.tree}" var="auth" varStatus="i">
			 <c:choose>
			 <%--父节点 --%>
				<c:when test="${empty auth.fparentID }">
					<%--第一个节点不用这两个标签 --%>
					<c:if test="${i.index  != 0 }">
						</ul>
						</li>
					</c:if>
					<%--父节点为当前节点，设置为选中 --%>
					<li class="${ auth.fid == pid ? 'active' : ''  }">
						<a href="${basePath }${auth.furl}">
						<i class="${auth.ficon}"></i> 
						<span class="title">${auth.fname}</span>
						<span class="arrow "></span><%--加上open 的class，则父菜单<变成向下 --%>
						</a>
						<ul class="sub-menu">
				</c:when>
				<%--子节点 --%>
				<c:otherwise>
				<%--子节点为当前节点，设置为选中 --%>
						<li class="${ auth.fid == cid ? 'active' : ''  }">
							<a href="${basePath }${auth.furl}?pid=${auth.fparentID}&cid=${auth.fid}">
							<i class="${auth.ficon}"></i> 
							<span class="title">${auth.fname}</span>
							</a>
						</li >
				</c:otherwise>
			</c:choose>
		</c:forEach>
		<%--为最后一个节点增加配对的标签 --%>
			</ul>
			</li>
	</ul>
	<!-- END SIDEBAR MENU -->
</div>
<!-- END SIDEBAR -->