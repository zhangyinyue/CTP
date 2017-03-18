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
    <link href="${basePath}assets/css/book_detail.css" rel="stylesheet" type="text/css" />
    <script src="${basePath}assets/plugins/js/jquery-1.7.min.js"></script>

</head>
<body>
<div id="templatemo_container">
    <!--菜单-->
    <div id="templatemo_menu">
        <ul>
            <li><a href="${basePath}appBook/book/list" class="current">首页</a></li>
            <li><a href="${basePath}appBook/book/books">书籍列表</a></li>
            <li><a href="${basePath}appBook/book/newBooks">新书上架</a></li>
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
            <a href="subpage.html" style="margin-left: 50px;">更多...</a>
        </div>


        <div id="templatemo_new_books">
            <ul>
                <li>《巨人的陨落》</li>
                <li>《乖，摸摸头》</li>
                <li>《丝绸之路》</li>
            </ul>
            <a href="subpage.html" style="margin-left: 50px;">更多...</a>
        </div>
    </div> <!-- end of header -->

    <div id="templatemo_content">

        <div id="templatemo_content_left">
            <div class="templatemo_content_left_section">
                <h1>猜你喜欢</h1>
                <ul>
                    <li><a href="subpage.html">《巨人的陨落》</a></li>
                    <li><a href="subpage.html">《乖，摸摸头》</a></li>

                </ul>
            </div>
            <div class="templatemo_content_left_section">
                <h1>我的好友</h1>
                <ul>
                    <li><a href="#">张银约</a></li>
                    <li><a href="#">唐唐唐</a></li>

                </ul>
            </div>
        </div> <!-- end of content left -->

        <!--内容-->
        <div class="templatemo_content_right">
            <h1>Book Title <span>(by author name)</span></h1>
            <div class="image_panel"><img src="images/templatemo_image_02.jpg" alt="CSS Template" width="100"
                                          height="150"/></div>
            <h2>Read the lessons - Watch the videos - Do the exercises</h2>
            <ul>
                <li>By Deke <a href="#">McClelland</a></li>
                <li>January 2024</li>
                <li>Pages: 498</li>
                <li>ISBN 10: 0-496-91612-0 | ISBN 13: 9780492518154</li>
            </ul>

            <p>Lorem ipsum dolor sit amet, consectetur adipiscing elit. Vivamus nec dui. Donec nec neque ut quam sodales
                feugiat. Nam sodales, pede vel dapibus lobortis, ipsum diam molestie risus, a vulputate risus nisl
                pulvinar lacus.</p>

            <p>Donec at arcu. Nunc aliquam, dolor vitae sollicitudin lacinia, nibh orci sagittis diam, dignissim sodales
                dui erat nec eros. Fusce quis enim. Aenean eleifend, neque hendrerit elementum sodales, odio erat
                sagittis quam, sed tempor orci magna vitae tellus. Proin dui mauris, tempor eget, pulvinar sed, pretium
                sit amet, dui. Proin vulputate justo et quam.</p>

            <p>In fermentum, eros ac tincidunt aliquam, elit velit semper nunc, a tincidunt orci lectus a arcu. Nullam
                commodo, arcu non facilisis imperdiet, felis lectus tempus felis, vitae volutpat augue ante quis leo.
                Aliquam tristique dolor ac odio. Sed consectetur, lacus et dictum tristique, odio neque elementum ante,
                nec eleifend leo dolor vel tortor.</p>

            <div class="cleaner_with_height">&nbsp;</div>

            <!--评论-->
            <div id="demo" class="demolayout">
                <ul id="demo-nav" class="demolayout">
                    <li class="active" ><a href="#tab1">短评</a></li>
                    <li><a href="#tab2">猜你喜欢</a></li>
                </ul>
                <div class="tabs-container">
                    <div style="display: block;" class="tab" id="tab1">
                        <div class="tab-item">
                            <p class="item-userinfo">
                                <span class="name">黑眼圈小姐</span> <span>2017-03-08</span>
                            </p>
                            <p class="item-content">老师太可爱了，神经大条却观察力敏锐，故事轻松有趣，确实不同于东野的其他书。ps，老师快和新藤在一起吧，超般配啊！</p>
                        </div>
                        <div class="tab-item">
                            <p class="item-userinfo">
                                <span class="name">黑眼圈小姐</span> <span>2017-03-08</span>
                            </p>
                            <p class="item-content">老师太可爱了，神经大条却观察力敏锐，故事轻松有趣，确实不同于东野的其他书。ps，老师快和新藤在一起吧，超般配啊！</p>
                        </div>

                    </div>
                    <div style="display: none;" class="tab" id="tab2">
                        就是喜欢李
                        <div class="clear"></div>
                    </div>
                </div>
            </div>



        </div> <!-- end of content right -->

        <div class="cleaner_with_height">&nbsp;</div>
    </div> <!-- end of content -->

    <div id="templatemo_footer">

        <a href="${basePath}appBook/book/list">首页</a> | <a href="${basePath}appBook/book/books">书籍列表</a> | <a href="${basePath}appBook/book/newBooks">新书上架</a> | <a href="#">我的好友</a> | <a href="${basePath}appBook/book/myBooks">我的书架</a> | <a href="#">个人信息</a><br />
        Copyright © 2017 <a href="${basePath}appBook/book/list"><strong>读友会</strong></a>
        <!-- Credit: www.templatemo.com -->	</div>
    <!-- end of footer -->
    <!--  Free CSS Template www.templatemo.com -->
</div> <!-- end of container -->

<script type="text/javascript">
    (function () {
        $("#demo-nav li").click(function (e) {
            var i = $(this).index();
            $(this).addClass('active').siblings().removeClass('active');
            $(".tabs-container .tab").eq(i).show().siblings().hide();
        })
    })();
</script>
</body>
</html>
