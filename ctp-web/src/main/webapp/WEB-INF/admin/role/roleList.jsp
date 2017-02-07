<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
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
							<div class="caption"><i class="icon-globe"></i>角色test列表</div>
							<div class="actions">
								<a href="javascript:Role.dataOperation('');" class="btn red"><i class="icon-pencil"></i>新增<i class="icon-plus"></i></a>
								<button id="del" class="btn red">删除<i class="icon-minus"></i></button>
							</div>
						</div>
						<div class="portlet-body">
							<div id="sample_1_wrapper" class="dataTables_wrapper form-inline" role="grid">
							<div class="row-fluid">
								<form action="${basePath }adminAuth/role/listPage" method="post" id="queryForm">
									<input type="hidden" name="pageNo" id="pageNo" value="${role.pageNo }" />
									<input type="hidden" name="pageSize" id="pageSize" value="${role.pageSize }" />
									<div class="span3">
										<div class="dataTables_filter" id="sample_1_filter">
											<label>名称: <input type="text" name="name" value="${role.name }" aria-controls="sample_1" class="m-wrap small"></label>
										</div>
									</div>
									<%-- <div class="span3">
										<div id="sample_1_length" class="dataTables_length">
											<label>
												热门：
												<select size="1" name="hot" aria-controls="sample_1" class="m-wrap small">
												<option value="-1">全部</option>
												<option value="1" ${hot == 1 ? "selected" : "" }>是</option>
												<option value="0" ${hot == 0 ? "selected" : "" }>否</option>
												</select>
											</label>
										</div> 
									</div> --%>
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
										<th>角色id</th>
										<th>角色名称</th>
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
										<td>
											<a href="javascript:Role.dataOperation('${d.fid}');" class="btn mini purple">
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
	<script src="${basePath }assets/scripts/role.js" type="text/javascript"></script>
	<script>    
		jQuery(document).ready(function() {  
		   Role.init();
		   App.init(); // initlayout and core plugins
		});
		
		function paging(pageNo){
			$("#pageNo").val(pageNo);
			//表单提交
			$("#queryForm").submit();
		}
		
		function changePageSize(val){
			$("#pageSize").val(val);
		}
	</script>
</body>
<!-- END BODY -->
</html>