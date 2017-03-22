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
				<form action="${basePath }adminBook/book/listPage" method="post" id="queryForm">
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
							<div class="caption"><i class="icon-reorder"></i>书籍编辑</div>
						</div>
						<div class="portlet-body form">
							<!-- BEGIN FORM-->
							<form action="${basePath }adminBook/book/safety" id="form_sample_1" class="form-horizontal" enctype=”multipart/form-data” novalidate="novalidate" method="post">
								<div class="alert alert-error hide">
									<button class="close" data-dismiss="alert"></button>
									字段输入有误，请检查重新输入！
								</div>
								<div class="alert alert-success hide">
									<button class="close" data-dismiss="alert"></button>
									数据提交中....
								</div>
								<div class="control-group">
									<input type="hidden" name="fid" value="${ book.fid }" />
									<label class="control-label">书名<span class="required">*</span></label>
									<div class="controls">
										<input type="text" name="fname" value="${book.fname }" data-required="1" class="span6 m-wrap">
									</div>
								</div>
                                <div class="control-group">
                                    <label class="control-label">书籍封面<span class="required">*</span></label>
                                    <img src="${basePath }adminBook/book/image?bookId=${book.fid}" style="width:120px; height:200px"/>
                                    <div class="controls">
                                        <input type="file"   name="imagefile" data-required="1" class="span6 m-wrap">
                                    </div>
                                </div>
                                <div class="control-group">
                                    <label class="control-label">书籍文件<span class="required">*</span></label>
                                    <div class="controls">
                                        <input type="file"   name="file" data-required="1" class="span6 m-wrap">
                                    </div>
                                </div>
								<div class="control-group">
									<label class="control-label">作者<span class="required">*</span></label>
									<div class="controls">
										<input type="text" name="fauthor" value="${book.fauthor }" data-required="1" class="span6 m-wrap">
									</div>
								</div>
								<div class="control-group">
									<label class="control-label">出版社<span class="required">*</span></label>
									<div class="controls">
										<input type="text" name="fpublish" value="${book.fpublish }" data-required="1" class="span6 m-wrap">
									</div>
								</div>
								<div class="control-group">
									<label class="control-label">出版时间<span class="required">*</span></label>
									<div class="controls">
										<input type="date"   name="fpublishyearstr" value="${book.fpublishyearstr}"  data-required="1" class="span6 m-wrap">
									</div>
								</div>
								<div class="control-group">
									<label class="control-label">出版时间<span class="required">*</span></label>
									<div class="controls">
										<textarea cols="160" rows="10" name="fdesc" >${book.fdesc}</textarea>
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
	<script src="${basePath }assets/scripts/book.js" type="text/javascript"></script>
	<script> 
		jQuery(document).ready(function() {  
		   App.init(); // initlayout and core plugins
		   Book.initOperation();
		});
	</script> 
</body> 
<!-- END BODY -->
</html>