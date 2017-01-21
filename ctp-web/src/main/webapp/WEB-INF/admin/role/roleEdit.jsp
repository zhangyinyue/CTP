<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%@include file="../common/header.jsp" %>
<!-- BEGIN BODY -->
<body class="page-header-fixed">
	<%@include file="../common/top.jsp" %>
	<!-- BEGIN CONTAINER -->
	<div class="page-container">
		<%@include file="../common/sidebar.jsp" %>
		<div class="page-content">
			<%@include file="../common/pageHeader.jsp"%>
			<!-- 内容开始 -->
			<!-- 查询表单 -->
			<div style="display: none;">
				<form action="${basePath }adminAuth/role/listPage" method="post" id="queryForm">
					<input type="hidden" name="name" value="${name }" />
				</form>
			</div>
			<div class="row-fluid">
				<div class="span12">
					<!-- BEGIN VALIDATION STATES-->
					<div class="portlet box purple">
						<div class="portlet-title">
							<div class="caption"><i class="icon-reorder"></i>角色权限修改</div>
						</div>
						<div class="portlet-body form">
							<!-- BEGIN FORM-->
							<form action="${basePath }adminAuth/role/safety" id="form_sample_1" class="form-horizontal" novalidate="novalidate" method="post">
								<div class="alert alert-error hide">
									<button class="close" data-dismiss="alert"></button>
									输入的数据有误，请检查
								</div>
								<div class="alert alert-success hide">
									<button class="close" data-dismiss="alert"></button>
									数据提交中....
								</div>
								<div class="control-group">
									<input type="hidden"  name="id" value="${ role.id }" />
									<label class="control-label">角色名称<span class="required">*</span></label>
									<div class="controls">
										<input type="text" id="name" name="name" value="${role.name }" data-required="1" class="span6 m-wrap">
									</div>
									
									
									<!-- 权限列表开始 -->
									<table class="table table-striped table-hover dataTable" id="sample_1" aria-describedby="sample_1_info" style="width:70%; margin-left: 90px" >
										<thead>
											<tr>
											<th>
												<input type="checkbox" class="group-checkable" data-set="#sample_1 .checkboxes">权限设置(全选)
											</th>
											</tr>
										</thead>
										<tbody role="alert" aria-live="polite" aria-relevant="all">
											
											<c:forEach items="${authTree.tree}" var="d" varStatus="i">
												 <c:choose>
												 <%--父节点 --%>
													<c:when test="${empty d.fparentID }">
														<%--第一个节点不用这两个标签 --%>
														<c:if test="${i.index  != 0 }">
															</tr> 
														</c:if>
														<%--父节点为当前节点 --%>
														<tr class="gradeX odd">
										    			<td  class=" sorting_1" style="font-weight: bold;">
														<input type="checkbox" ${d.belongRole == 1 ? "checked":""} name="ids" class="checkboxes" value="${d.fid }">
															${d.fname }
														</td>
														
														
													</c:when>
													<%--子节点 --%>
													<c:otherwise>
													<%--子节点为当前节点 --%>
														<td class=" sorting_1">
															<input type="checkbox" ${d.belongRole == 1 ? "checked":""} name="ids" class="checkboxes" value="${d.fid }">
															${d.fname }
														</td>
													</c:otherwise>
												</c:choose>
											</c:forEach>
											
											
											<%-- <c:forEach items="${authTree.tree }" var="d">
										    	<tr class="gradeX odd">
										    	<td  class=" sorting_1" style="font-weight: bold;">
													<input type="checkbox" ${d.value.checkFlag == 1 ? "checked":""} class="checkboxes" value="${d.value.id }">
													${d.value.name }
												</td>
												
										    	<c:forEach items="${d.value.leaf }" var="dLeaf">
												<td class=" sorting_1">
													<input type="checkbox" ${dLeaf.checkFlag == 1 ? "checked":""} class="checkboxes" value="${dLeaf.id }">
													${dLeaf.name }
												</td>
												</c:forEach>
												
											 </tr> 
											 </c:forEach> --%>
										</tbody>
									</table>
									<!-- 权限列表结束 -->
								</div>
								
								<div class="form-actions">
									<button type="submit" class="btn purple">提交</button>
									<button type="button" id="cancel" class="btn">取消</button>
								</div>
							</form>
							<!-- END FORM-->
						</div>
					</div>
					<!-- END VALIDATION STATES-->
				</div>
			</div>
			<!-- 内容结束 -->
			</div>
							 
	</div> 
	<!-- END CONTAINER -->
	<%@include file="../common/footer.jsp" %>
	<!-- 引入模块JS -->
	<script src="${basePath }assets/plugins/jquery.form.js" type="text/javascript"></script>
	<script src="${basePath }assets/plugins/jquery-validation/dist/jquery.validate.min.js" type="text/javascript"></script>
	<script src="${basePath }assets/scripts/role.js" type="text/javascript"></script>
	<script> 
		jQuery(document).ready(function() {  
		   App.init(); // initlayout and core plugins
		   Role.initOperation();
		   Role.init();
		});
	</script> 
</body> 
<!-- END BODY -->
</html>