<%@ page language="java" contentType="text/html; charset=utf-8" pageEncoding="utf-8"%>
<%@include file="../common/header.jsp" %>
<!-- BEGIN BODY -->
<body class="page-header-fixed">
	<%@include file="../common/top.jsp" %>
	<!-- BEGIN CONTAINER -->
	<div class="page-container">
		<%@include file="../common/sidebar.jsp" %>
		<div class="page-content">
			<%@include file="../common/pageHeader.jsp" %>
			<!-- 内容开始 -->
			<div class="row-fluid">
				<div class="span12">
					<!-- BEGIN EXAMPLE TABLE PORTLET-->
					<div class="portlet box blue">
						<div class="portlet-title">
							<div class="caption"><i class="icon-globe"></i>用户列表</div>
							<div class="actions">
								<a href="javascript:User.dataOperation('');" class="btn red"><i class="icon-pencil"></i>新增<i class="icon-plus"></i></a>
								<button id="del" class="btn red">删除<i class="icon-minus"></i></button>
							</div>
						</div>
						<div class="portlet-body">
							<div id="sample_1_wrapper" class="dataTables_wrapper form-inline" role="grid">
								<div class="row-fluid">
									<form action="${basePath }adminUser/user/listPage" method="post" id="queryForm">
										<input type="hidden" name="pageNo" id="pageNo" value="${user.pageNo }" />
										<input type="hidden" name="pageSize" id="pageSize" value="${user.pageSize }" />
										<div class="span3">
											<div class="dataTables_filter" id="sample_1_filter">
												<label>名称: <input type="text" name="name" value="${user.name }" aria-controls="sample_1" class="m-wrap small"></label>
											</div>
										</div>
										<div class="span3">
											<button id="sample_editable_1_new" class="btn" type="submit">
												查询 <i class="icon-search"></i>
											</button>
										</div>
									</form>
								</div>
								<table class="table table-striped table-hover dataTable" id="sample_1" aria-describedby="sample_1_info">
									<thead>
									<tr>
										<th>
											<input type="checkbox" class="group-checkable" data-set="#sample_1 .checkboxes">
										</th>
										<th>用户id</th>
										<th>用户名称</th>
										<th>用户姓别</th>
										<th>操作</th>
									</tr>
									</thead>

									<tbody role="alert" aria-live="polite" aria-relevant="all">
									<c:choose>
										<c:when test="${empty listPage.dataList}">
											<tr class="gradeX odd">
												<td colspan="4" style="text-align: center;">暂无数据</td>
											</tr>
										</c:when>
										<c:otherwise>
											<c:forEach items="${listPage.dataList }" var="d">
												<tr class="gradeX odd">
													<td class=" sorting_1">
														<input type="checkbox" class="checkboxes" value="${d.fid }">
													</td>
													<td>${d.fid }</td>
													<td>${d.fname }</td>
													<td>${d.fsex == 1 ? "男" : "女" }</td>
													<td>
														<a href="javascript:User.dataOperation('${d.fid}');" class="btn mini purple">
															<i class="icon-edit"></i>编辑
														</a>
													</td>
												</tr>
											</c:forEach>
										</c:otherwise>
									</c:choose>
									</tbody>
								</table>
								${fns:paging(listPage) }
							</div>
						</div>
					</div>
					<!-- END EXAMPLE TABLE PORTLET-->
				</div>
			</div>
			<!-- 内容结束 --> 		 
		</div> 
	</div> 
	<!-- END CONTAINER -->
	<%@include file="../common/footer.jsp" %>
	<!-- 引入模块JS -->
	<script src="${basePath }assets/scripts/user.js" type="text/javascript"></script>
	<script>    
		jQuery(document).ready(function() {
		    App.init();
            User.init();
		});
		
	</script>
</body>
<!-- END BODY -->
</html>