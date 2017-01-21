<%@page import="com.ctp.utils.URequest"%>
<%@ page language="java" contentType="text/html; charset=utf-8" pageEncoding="utf-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@taglib prefix="fns" uri="/WEB-INF/fns.tld" %>
<%
	String basePath = URequest.getBasePath(request);
	request.setAttribute("basePath", basePath);
	
%>
<!DOCTYPE html>
<!-- 
Template Name: Metronic - Responsive Admin Dashboard Template build with Twitter Bootstrap 2.3.2
Version: 1.4
Author: KeenThemes
Website: http://www.keenthemes.com/preview/?theme=metronic
Purchase: http://themeforest.net/item/metronic-responsive-admin-dashboard-template/4021469
-->
<!--[if IE 8]> <html lang="en" class="ie8 no-js"> <![endif]-->
<!--[if IE 9]> <html lang="en" class="ie9 no-js"> <![endif]-->
<!--[if !IE]><!--> <html lang="en" class="no-js"> <!--<![endif]-->
<!-- BEGIN HEAD -->
<head>
	<meta charset="utf-8" />
	<title>校园交易平台后台管理系统</title>
	<meta content="width=device-width, initial-scale=1.0" name="viewport" />
	<meta content="" name="description" />
	<meta content="" name="author" />
	<!-- BEGIN GLOBAL MANDATORY STYLES -->        
	<link href="${basePath}assets/plugins/bootstrap/css/bootstrap.min.css" rel="stylesheet" type="text/css"/>
	<link href="${basePath}assets/plugins/bootstrap/css/bootstrap-responsive.min.css" rel="stylesheet" type="text/css"/>
	<link href="${basePath}assets/plugins/font-awesome/css/font-awesome.min.css" rel="stylesheet" type="text/css"/>
	<link href="${basePath}assets/css/style-metro.css" rel="stylesheet" type="text/css"/>
	<link href="${basePath}assets/css/style.css" rel="stylesheet" type="text/css"/>
	<link href="${basePath}assets/css/style-responsive.css" rel="stylesheet" type="text/css"/>
	<link href="${basePath}assets/css/themes/default.css" rel="stylesheet" type="text/css" id="style_color"/>
	<link href="${basePath}assets/plugins/uniform/css/uniform.default.css" rel="stylesheet" type="text/css"/>
	<!-- END GLOBAL MANDATORY STYLES -->
	<!-- BEGIN PAGE LEVEL PLUGIN STYLES --> 
	<link href="${basePath}assets/plugins/gritter/css/jquery.gritter.css" rel="stylesheet" type="text/css"/>
	<link href="${basePath}assets/plugins/bootstrap-daterangepicker/daterangepicker.css" rel="stylesheet" type="text/css" />
	<link href="${basePath}assets/plugins/fullcalendar/fullcalendar/fullcalendar.css" rel="stylesheet" type="text/css"/>
	<link href="${basePath}assets/plugins/jqvmap/jqvmap/jqvmap.css" rel="stylesheet" type="text/css" media="screen"/>
	<link href="${basePath}assets/plugins/jquery-easy-pie-chart/jquery.easy-pie-chart.css" rel="stylesheet" type="text/css" media="screen"/>
	<!-- END PAGE LEVEL PLUGIN STYLES -->
	<!-- BEGIN PAGE LEVEL STYLES --> 
	<link href="${basePath}assets/css/pages/tasks.css" rel="stylesheet" type="text/css" media="screen"/>
	<!-- END PAGE LEVEL STYLES -->
	<link href="${basePath}assets/plugins/sweetalert/sweetalert.css" rel="stylesheet" type="text/css" media="screen"/>
	<link href="${basePath}assets/css/inputDate.css" rel="stylesheet" type="text/css" media="screen"/>
	<!-- <link rel="shortcut icon" href="favicon.ico" /> -->
	 
	<script src="${basePath }assets/plugins/jquery-1.10.1.min.js" type="text/javascript"></script>
	<script src="${basePath }assets/plugins/jquery-migrate-1.2.1.min.js" type="text/javascript"></script>
	<script src="${basePath }assets/plugins/uniform/jquery.uniform.min.js" type="text/javascript" ></script>
	<script src="${basePath }assets/plugins/jquery-ui/jquery-ui-1.10.1.custom.min.js" type="text/javascript"></script>      
	<script src="${basePath }assets/plugins/jquery.blockui.min.js" type="text/javascript"></script>
	
	<script src="${basePath }assets/plugins/jquery-slimscroll/jquery.slimscroll.min.js" type="text/javascript"></script>
	<script src="${basePath }assets/plugins/bootstrap/js/bootstrap.min.js" type="text/javascript"></script>
	<script src="${basePath }assets/plugins/bootstrap-hover-dropdown/twitter-bootstrap-hover-dropdown.min.js" type="text/javascript" ></script>
	<script src="${basePath }assets/plugins/sweetalert/sweetalert.min.js" type="text/javascript" ></script>
	<script type="text/javascript" src="${basePath }assets/plugins/gritter/js/jquery.gritter.js"></script>
	
	<script src="${basePath }assets/scripts/app.js" type="text/javascript"></script>
	
	<script type="text/javascript">
		$basePath = "${basePath }";
		$(document).ajaxStart($.blockUI).ajaxStop($.unblockUI);
	</script>
</head>
<!-- END HEAD -->
