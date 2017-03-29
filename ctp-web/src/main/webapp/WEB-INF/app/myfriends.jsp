<%--
  Created by IntelliJ IDEA.
  User: Administrator
  Date: 2017/3/13 0013
  Time: 19:52
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@page import="com.ctp.utils.URequest"%>
<%@taglib prefix="fns" uri="/WEB-INF/fns.tld" %>
<%
    String basePath = URequest.getBasePath(request);
    request.setAttribute("basePath", basePath);

%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
    <title>图书推荐系统</title>
    <meta name="keywords" content="" />
    <meta name="description" content="" />
    <link href="${basePath}assets/css/templatemo_style.css" rel="stylesheet" type="text/css" />
</head>
<body>
<div id="templatemo_container">
    <!--菜单-->
    <div id="templatemo_menu">
        <ul>
            <li><a href="${basePath}appBook/book/list" >首页</a></li>
            <li><a href="${basePath}appBook/book/books">书籍列表</a></li>
            <li><a href="${basePath}appBook/book/newBooks">新书上架</a></li>
            <li><a href="${basePath}appBook/book/myFriends" class="current">我的好友</a></li>
            <li><a href="${basePath}appBook/book/myBooks">我的书架</a></li>
            <c:if test="${empty sessionScope.appUser}">
                <li><a href="${basePath}appBook/book/login">登陆</a></li>
                <li><a href="${basePath}appBook/book/register">注册</a></li>
            </c:if>
            <c:if test="${ not empty sessionScope.appUser}">
                <li><a href="${basePath}appBook/book/myAccount">个人信息</a></li>
                <li><a href="${basePath}appUser/user/logout">退出登陆</a></li>
            </c:if>
        </ul>
    </div>

    <!--图片-->
    <div class="templatemo_header">
        <img src="${basePath}assets/images/adds.jpg" alt="" class="head-img">
    </div>

    <!--好友列表-->
    <div id="templatemo_content" class="templatemo_friend_list_content">
        <ul class="table-header">
            <li class="name"><img class="table-header-logo" src="${basePath}assets/images/friend.png" alt="好友信息">好友信息</li>
            <li class="read"><img class="table-header-logo" src="${basePath}assets/images/book.png" alt="最近阅读">最近阅读</li>
            <li class="potions"><img class="table-header-logo" src="${basePath}assets/images/option.png" alt="管理">管理</li>
        </ul>
        <div class="table-body">
            <%--<ul class="table-item">
                <li class="name">喵了个咪</li>
                <li class="read">《我摸到一条鲸鱼》</li>
                <li class="potions">
                    <a>取消关注</a>
                </li>
            </ul>--%>
            <c:forEach items="${friendPage.dataList }" var="d">
                <ul class="table-item">
                    <li class="name">${d.fname}</li>
                    <li class="potions">
                        <a href="${basePath}appBook/book/myBooks?id=${d.fid}">查看书架</a>
                    </li>
                    <li class="potions">
                    <a href="${basePath}appUser/user/delfriend?ffriendID=${d.fid}">取消关注</a>
                </li>
                </ul>
            </c:forEach>
        </div>
    </div> <!-- end of content -->
    <div id="templatemo_footer">

        <a href="${basePath}appBook/book/list">首页</a> | <a href="${basePath}appBook/book/books">书籍列表</a> | <a href="${basePath}appBook/book/newBooks">新书上架</a> | <a href="#">我的好友</a> | <a href="${basePath}appBook/book/myBooks">我的书架</a> | <a href="#">个人信息</a><br />
        Copyright © 2017 <a href="${basePath}appBook/book/list"><strong>读友会</strong></a>
        <!-- Credit: www.templatemo.com -->	</div>
    <!-- end of footer -->
    <!--  Free CSS Template www.templatemo.com -->
</div> <!-- end of container -->
</body>
</html>
