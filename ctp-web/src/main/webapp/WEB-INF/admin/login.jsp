<%@page import="com.ctp.utils.URequest"%>
<%@ page language="java" contentType="text/html; charset=utf-8" pageEncoding="utf-8"%>
<%
	String basePath = URequest.getBasePath(request);
	request.setAttribute("basePath", basePath);
%>
<!DOCTYPE html>
<!--[if IE 8]> <html lang="en" class="ie8"> <![endif]-->
<!--[if IE 9]> <html lang="en" class="ie9"> <![endif]-->
<!--[if !IE]><!--> <html lang="en"> <!--<![endif]-->
<!-- BEGIN HEAD -->
<head>
	<meta charset="utf-8" />
	<title>系统登录</title>
	<meta content="width=device-width, initial-scale=1.0" name="viewport" />
	<meta content="" name="description" />
	<meta content="" name="author" />
	<!-- BEGIN GLOBAL MANDATORY STYLES -->
	<link href="${basePath }assets/plugins/bootstrap/css/bootstrap.min.css" rel="stylesheet" type="text/css"/>
	<link href="${basePath }assets/plugins/bootstrap/css/bootstrap-responsive.min.css" rel="stylesheet" type="text/css"/>
	<link href="${basePath }assets/plugins/font-awesome/css/font-awesome.min.css" rel="stylesheet" type="text/css"/>
	<link href="${basePath }assets/css/style-metro.css" rel="stylesheet" type="text/css"/>
	<link href="${basePath }assets/css/style.css" rel="stylesheet" type="text/css"/>
	<link href="${basePath }assets/css/style-responsive.css" rel="stylesheet" type="text/css"/>
	<link href="${basePath }assets/css/themes/default.css" rel="stylesheet" type="text/css" id="style_color"/>
	<link href="${basePath }assets/plugins/gritter/css/jquery.gritter.css" rel="stylesheet" type="text/css"/>
	<link href="${basePath }assets/plugins/uniform/css/uniform.default.css" rel="stylesheet" type="text/css"/>
	<link rel="stylesheet" type="text/css" href="${basePath }assets/plugins/select2/select2_metro.css" />
	<!-- END GLOBAL MANDATORY STYLES -->
	<!-- BEGIN PAGE LEVEL STYLES -->
	<link href="${basePath }assets/css/pages/login-soft.css" rel="stylesheet" type="text/css"/>
	<!-- END PAGE LEVEL STYLES -->
	<!-- <link rel="shortcut icon" href="favicon.ico" /> -->
</head>
<!-- END HEAD -->
<!-- BEGIN BODY -->
<body class="login">
	<!-- BEGIN LOGO -->
	<div class="logo">
 	</div>
	<!-- END LOGO -->
	<!-- BEGIN LOGIN -->
	<div class="content">
		<!-- BEGIN LOGIN FORM -->
		<form class="form-vertical login-form" id="loginForm" action="${basePath }adminUser/login" method="post">
			<h3 class="form-title">系统登录</h3>
			<div class="control-group">
				<!--ie8, ie9 does not support html5 placeholder, so we just show field title for that-->
				<label class="control-label visible-ie8 visible-ie9">帐号</label>
				<div class="controls">
					<div class="input-icon left">
						<i class="icon-user"></i>
						<input value="${requestScope.user.fname }" class="m-wrap placeholder-no-fix" type="text" autocomplete="off" placeholder="帐号" name="fname"/>
					</div>
				</div>
			</div>
			<div class="control-group"> 
				<label class="control-label visible-ie8 visible-ie9">密码</label>
				<div class="controls">
					<div class="input-icon left"> 
						<i class="icon-lock"></i>
						<input value="${requestScope.user.fpwd }" class="m-wrap placeholder-no-fix" type="password" autocomplete="off" placeholder="密码" name="fpwd"/>
					</div>
				</div>
			</div>
			<label style="color:red" id="error"></label>
			<div class="form-actions">
				<label class="checkbox">
				<input type="checkbox" name="remember" value="1" ${user == null ? "":(user.remember==1 ? "checked" : "" )}/>记住密码
				</label> 
				
				<button id = "btnAjaxSubmit" type="submit" class="btn blue pull-right">
				登录 <i class="m-icon-swapright m-icon-white"></i>
				</button>            
			</div>
		</form>
		<!-- END LOGIN FORM -->        
	</div>
	<!-- END LOGIN -->
	<!-- BEGIN JAVASCRIPTS(Load javascripts at bottom, this will reduce page load time) -->
	<!-- BEGIN CORE PLUGINS -->   <script src="${basePath }assets/plugins/jquery-1.10.1.min.js" type="text/javascript"></script>
	<!-- BEGIN CORE PLUGINS -->   <script src="${basePath }assets/plugins/jquery.form.js" type="text/javascript"></script>
	<script src="${basePath }assets/plugins/jquery-migrate-1.2.1.min.js" type="text/javascript"></script>
	<!-- IMPORTANT! Load jquery-ui-1.10.1.custom.min.js before bootstrap.min.js to fix bootstrap tooltip conflict with jquery ui tooltip -->
	<script src="${basePath }assets/plugins/jquery-ui/jquery-ui-1.10.1.custom.min.js" type="text/javascript"></script>      
	<script src="${basePath }assets/plugins/bootstrap/js/bootstrap.min.js" type="text/javascript"></script>
	<script src="${basePath }assets/plugins/bootstrap-hover-dropdown/twitter-bootstrap-hover-dropdown.min.js" type="text/javascript" ></script>
	<!--[if lt IE 9]>
	<script src="${basePath }assets/plugins/excanvas.min.js"></script>
	<script src="${basePath }assets/plugins/respond.min.js"></script>  
	<![endif]-->   
	<script src="${basePath }assets/plugins/jquery-slimscroll/jquery.slimscroll.min.js" type="text/javascript"></script>
	<script src="${basePath }assets/plugins/jquery.blockui.min.js" type="text/javascript"></script>  
	<script src="${basePath }assets/plugins/jquery.cookie.min.js" type="text/javascript"></script>
	<script src="${basePath }assets/plugins/uniform/jquery.uniform.min.js" type="text/javascript" ></script>
	<!-- END CORE PLUGINS -->
	<!-- BEGIN PAGE LEVEL PLUGINS -->
	<script src="${basePath }assets/plugins/jquery-validation/dist/jquery.validate.js" type="text/javascript"></script>
	<script src="${basePath }assets/plugins/backstretch/jquery.backstretch.min.js" type="text/javascript"></script>
	<script type="text/javascript" src="${basePath }assets/plugins/select2/select2.min.js"></script>
	<script type="text/javascript" src="${basePath }assets/plugins/gritter/js/jquery.gritter.js"></script>
	<!-- END PAGE LEVEL PLUGINS -->
	<!-- BEGIN PAGE LEVEL SCRIPTS -->
	<script src="${basePath }assets/scripts/app.js" type="text/javascript"></script>
	 <script src="${basePath }assets/scripts/login-soft.js" type="text/javascript"></script>      
	<!-- END PAGE LEVEL SCRIPTS --> 
	<script>
		var basePath = "${basePath }";
		jQuery(document).ready(function() {     
		  App.init();
		  Login.init();
		});
	</script>
	<!-- END JAVASCRIPTS -->
</body>
<!-- END BODY -->
</html>