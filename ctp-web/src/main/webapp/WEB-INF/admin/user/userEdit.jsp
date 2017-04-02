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
				<form action="${basePath }adminUser/user/listPage" method="post" id="queryForm">
					<%--  <input type="hidden" name="pageNo" value="${auth.pageNo }" />
					<input type="hidden" name="pageSize" value="${auth.pageSize }" />
					<input type="hidden" name="name" value="${auth.fname }" /> --%>
				</form>
			</div>
			<div class="row-fluid">
				<div class="span12">
					<!-- BEGIN VALIDATION STATES-->
					<div class="portlet box purple">
						<div class="portlet-title">
							<div class="caption"><i class="icon-reorder"></i>用户编辑</div>
						</div>
						<div class="portlet-body form">
							<!-- BEGIN FORM-->
							<form action="${basePath }adminUser/user/safety" id="form_sample_1" class="form-horizontal" novalidate="novalidate" method="post">
								<div class="alert alert-error hide">
									<button class="close" data-dismiss="alert"></button>
									字段输入有误，请检查重新输入！
								</div>
								<div class="alert alert-success hide">
									<button class="close" data-dismiss="alert"></button>
									数据提交中....
								</div>
								<div class="control-group">
									<input type="hidden" name="fid" value="${ user.fid }" />
									<label class="control-label">用户名称<span class="required">*</span></label>
									<div class="controls">
										<input type="text" name="fname" value="${user.fname }" data-required="1" class="span6 m-wrap">
									</div>
								</div>
								<div class="control-group">
									<label class="control-label">用户密码<span class="required">*</span></label>
									<div class="controls">
										<input type="text" name="fpwd" value="${user.fpwd }" data-required="1" class="span6 m-wrap">
									</div>
								</div>
								<div class="control-group">
									<label class="control-label">性别</label>
									<div class="controls">
										<select name="fsex">
											<option value="1" ${user.fsex == 1 ? "selected":""}>男</option>
											<option value="0"  ${user.fsex == 0 ? "selected":""}>女</option>
										</select>
									</div>
								</div>
								<div class="control-group">
									<label class="control-label">年龄<span class="required">*</span></label>
									<div class="controls">
										<input type="number" value="${user.fage }" name="fage"  data-required="1" class="span6 m-wrap tooltips">
									</div>
								</div>
								<div class="control-group">
									<label class="control-label">角色</label>
									<div class="controls">
										<input type="hidden" id="selectParentId" value="${user.froleID }" name="froleID"   >
										<input type="text" id="selectParent" value="${user.roleName }"  readonly="readonly" name="roleName"  class="span6 m-wrap " >
										<input id="btntext" type="button" value="浏览..." class="btn blue" />
									</div>
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
	<script src="${basePath }assets/plugins/layer/layer.js" type="text/javascript"></script>
	<script src="${basePath }assets/scripts/user.js" type="text/javascript"></script>
	<script> 
		jQuery(document).ready(function() {  
		   App.init(); // initlayout and core plugins
		   User.initOperation();
		});
	</script> 
</body> 
<!-- END BODY -->
</html>