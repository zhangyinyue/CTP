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
            <li><a href="${basePath}appBook/book/myfactory" >猜你喜欢</a></li>
            <li><a href="${basePath}appBook/book/myFriends">我的好友</a></li>
            <li><a href="${basePath}appBook/book/myBooks">我的书架</a></li>
            <li><a href="${basePath}appBook/book/login">登陆</a></li>
            <li><a href="${basePath}appBook/book/register" class="current">注册</a></li>
        </ul>
    </div>

    <!--公告及新书上架-->
    <div id="templatemo_header">
        <div id="templatemo_notice">
            <p>
                <span>《漂亮朋友》</span> 强势登陆
                敬请期待！
            </p>
        </div>


        <div id="templatemo_new_books">
            <ul>
                <li>《巨人的陨落》</li>
                <li>《乖，摸摸头》</li>
                <li>《丝绸之路》</li>
            </ul>
            <a href="${basePath}appBook/book/newBooks" style="margin-left: 50px;">更多...</a>
        </div>
    </div> <!-- end of header -->

    <div id="templatemo_content" class="templatemo_login_content">
        <div class="contact_form">
            <div class="form_subtitle">注册</div>
            <form class="templatemo_login_form" name="login" action="${basePath}appUser/user/add">
                <div class="form_row">
                    <label class="contact"><strong>用户名:</strong></label>
                    <input type="text" class="contact_input" name="fname">
                </div>
                <div class="form_row">
                    <label class="contact"><strong>密码:</strong></label>
                    <input type="password" class="contact_input" name="fpwd">
                </div>
                <div class="form_row">
                    <label class="contact"><strong>姓别:</strong></label>
                    <select name="fsex">
                        <option value="1" >男</option>
                        <option value="0" >女</option>
                    </select>
                </div>
                <div class="form_row">
                    <label class="contact"><strong>年龄:</strong></label>
                    <input type="text" class="contact_input" name="fage">
                </div>
                <div class="form_row">
                    <input type="submit" class="login" value="注册">
                </div>
            </form>
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
