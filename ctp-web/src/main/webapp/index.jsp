<%@page import="com.ctp.utils.URequest"%>
<%@ page language="java" contentType="text/html; charset=utf-8" pageEncoding="utf-8"%>
<%
	String basePath = URequest.getBasePath(request);
	response.sendRedirect(basePath+"adminUser/loginPage"); 
%>
