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
            <li><a href="${basePath}appBook/book/list" class="current">首页</a></li>
            <li><a href="${basePath}appBook/book/books">书籍列表</a></li>
            <li><a href="${basePath}appBook/book/newBooks">新书上架</a></li>
            <li><a href="${basePath}appBook/book/myfactory" >猜你喜欢</a></li>
            <li><a href="${basePath}appBook/book/myFriends">我的好友</a></li>
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

    <div id="templatemo_content">

        <div id="templatemo_content_left">
            <div class="templatemo_content_left_section">
                <h1>猜你喜欢</h1>
                <ul>
                    <c:choose>
                        <c:when test="${empty sessionScope.appUser}">
                            <a href="${basePath}appBook/book/login" >请先登陆</a>
                        </c:when>
                        <c:when test="${empty reviewBooks}">
                            欢迎来到读友会，请您多多享受查阅书籍的乐趣~
                        </c:when>
                        <c:otherwise>
                            <c:forEach items="${reviewBooks}" var="d">
                                <li><a href="${basePath}appBook/book/subpage?id=${d.fid}">${d.fname}</a></li>
                            </c:forEach>
                        </c:otherwise>
                    </c:choose>
                </ul>
            </div>
            <div class="templatemo_content_left_section">
                <h1>我的好友</h1>
                <ul>
                    <c:choose>
                        <c:when test="${empty sessionScope.appUser}">
                            <a href="${basePath}appBook/book/login" >请先登陆</a>
                        </c:when>
                        <c:otherwise>
                            <c:forEach items="${userPage.dataList }" var="d">
                                <li><a href="${basePath}appBook/book/myFriends">${d.fname}</a></li>
                            </c:forEach>
                        </c:otherwise>
                    </c:choose>

                </ul>
            </div>
        </div> <!-- end of content left -->

        <!--内容-->
        <div class="templatemo_content_right">
            <div class="title"><span class="title_icon"><img src="${basePath}assets/images/books_1.png" alt="" title=""></span>
                新书上架</div>

            <c:forEach items="${newBooks.dataList }" var="d" varStatus="idx">
                <div class="templatemo_product_box" style="height: 300px;">
                    <h1>${d.fname }  <span>(作者 ${d.fauthor})</span></h1>
                    <div style="position: relative;width: 100px;">
                        <img src="${basePath}assets/img/ribbon_red.png" alt="image" style="position: absolute;top: 0px;right: -20px;"/>
                        <img src="${basePath }appBook/book/image?bookId=${d.fid}" style="width:100px; height:150px"/>
                    </div>
                    <div class="product_info">
                    <p>${d.fdesc}</p>
                        <p>出版社：${d.fpublish}</p>
                        <p>出版时间：${fns:dateFormat(d.fpublishyear) }</p>
                        <div class="buy_now_button" style="margin-left: -20px;"><a href="${basePath}appBook/book/addmyboos?fbookID=${d.fid}">加入书架</a></div>
                        <div class="detail_button" style="margin-top: -36px;margin-left: 85px;"><a href="${basePath}appBook/book/subpage?id=${d.fid}">详情</a></div>
                    </div>
                    <div class="cleaner">&nbsp;</div>
                </div>
                <c:choose>
                <c:when test="${idx.index != 0 && idx.index % 2 != 0}">
                    <div class="cleaner_with_height">&nbsp;</div>
                </c:when>
                <c:otherwise>
                    <div class="cleaner_with_width">&nbsp;</div>
                </c:otherwise>
                </c:choose>
            </c:forEach>
            <a href="${basePath}appBook/book/newBooks" style="margin-left: 600px;">更多...</a>
        </div> <!-- end of content right -->

        <div class="templatemo_content_right">
            <div class="title">
                <span class="title_icon"><img src="${basePath}assets/images/books_1.png" alt="" title=""></span>
                书籍列表</div>
            <c:forEach items="${listPage.dataList }" var="d" varStatus="idx">
                <div class="templatemo_product_box" style="height: 300px;">
                    <h1>${d.fname }  <span>(作者 ${d.fauthor})</span></h1>
                    <img src="${basePath }appBook/book/image?bookId=${d.fid}" style="width:100px; height:150px"/>
                    <div class="product_info">
                        <p>${d.fdesc}</p>
                        <p>出版社：${d.fpublish}</p>
                        <p>出版时间：${fns:dateFormat(d.fpublishyear) }</p>
                        <div class="buy_now_button" style="margin-left: -20px;"><a href="${basePath}appBook/book/addmyboos?fbookID=${d.fid}">加入书架</a></div>
                        <div class="detail_button" style="margin-top: -36px;margin-left: 85px;"><a href="${basePath}appBook/book/subpage?id=${d.fid}">详情</a></div>
                    </div>
                    <div class="cleaner">&nbsp;</div>
                </div>
                <c:choose>
                    <c:when test="${idx.index != 0 && idx.index % 2 != 0}">
                        <div class="cleaner_with_height">&nbsp;</div>
                    </c:when>
                    <c:otherwise>
                        <div class="cleaner_with_width">&nbsp;</div>
                    </c:otherwise>
                </c:choose>
            </c:forEach>
            <a href="${basePath}appBook/book/books" style="margin-left: 600px;">更多...</a>
        </div>
        <div class="cleaner_with_height">&nbsp;</div>
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
