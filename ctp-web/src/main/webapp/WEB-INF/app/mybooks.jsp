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
    <link rel="stylesheet" href="${basePath}assets/css/sti_style.css" type="text/css" media="screen">
    <link rel="stylesheet" href="${basePath}assets/css/mediaelementplayer.css">

    <script src="${basePath}assets/plugins/js/jquery-1.7.min.js"></script>
    <script src="${basePath}assets/plugins/js/jquery.touchSwipe.min.js"></script>
    <script src="${basePath}assets/plugins/js/jquery.versatileTouchSlider.min.js"></script>
    <script src="${basePath}assets/plugins/js/mediaelement-and-player.min.js"></script>

    <script>
        jQuery(document).ready(function() {
            $.versatileTouchSlider('#ex_shelf_full', {
                    slideWidth: 650, // some number. ex: 960 or '100%'
                    slideHeight: 'auto', // some number. ex: 220 or 'auto'
                    showPreviousNext: true,
                    currentSlide: 0,
                    scrollSpeed: 600,
                    autoSlide: false,
                    autoSlideDelay: 3000,
                   /* showPlayPause: true,
                    showPagination: true,*/
                    alignPagination: 'left',
                    alignMenu: 'left',
                    swipeDrag: true,
                    sliderType: 'image_shelf', // image_shelf, image_banner, image_text, image_gallery
                    pageStyle: 'numbers', // numbers, bullets, thumbnails
                    orientation: 'horizontal', // horizontal, vertical (if vertical, the "slideHeight" option must be a number, not 'auto')
                    onScrollEvent: function() {},
                    ajaxEvent: function() {}
                }
            );

        });
    </script>
</head>
<body>
<div id="templatemo_container">
    <!--菜单-->
    <div id="templatemo_menu">
        <ul>
            <li><a href="${basePath}appBook/book/list" >首页</a></li>
            <li><a href="${basePath}appBook/book/books">书籍列表</a></li>
            <li><a href="${basePath}appBook/book/newBooks">新书上架</a></li>
            <li><a href="${basePath}appBook/book/myBooks">我的好友</a></li>
            <li><a href="${basePath}appBook/book/myBooks" class="current">我的书架</a></li>
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
                <h1>我的好友</h1>
                <ul>
                    <li><a href="#">张银约</a></li>
                    <li><a href="#">唐唐唐</a></li>
                    <li><a href="#">张银约</a></li>
                    <li><a href="#">唐唐唐</a></li>
                    <li><a href="#">张银约</a></li>
                    <li><a href="#">唐唐唐</a></li>
                    <li><a href="#">张银约</a></li>
                    <li><a href="#">唐唐唐</a></li>
                    <li><a href="#">张银约</a></li>
                    <li><a href="#">唐唐唐</a></li>
                    <li><a href="#">张银约</a></li>
                    <li><a href="#">唐唐唐</a></li>
                </ul>
            </div>
        </div> <!-- end of content left -->

        <!--内容-->
        <div class="templatemo_content_right">
            <div class="title"><span class="title_icon"><img src="${basePath}assets/images/books_1.png" alt="" title=""></span>
                我的书架</div>
            <!-- 书架-->
            <div class="sti_container" id="ex_shelf_full" style="margin-top:50px;">
                <div class="sti_slider">
                    <div class="sti_items">

                        <!-- SLIDE GROUP 1 -->

                        <div class="sti_slide">
                            <div class="sti_shelf_divider"></div>

                            <div class="sti_prod">
                                <img src="${basePath}assets/images/banner_full_1_thumb.jpg" alt="" width="110" height="150">
                                <a href="" class="link video sti_lightbox" data-type="video-vimeo" data-size="700x394" title="Lamborghini Aventador"></a>
                            </div>
                            <div class="sti_prod">
                                <img src="${basePath}assets/images/banner_full_2_thumb.jpg" alt="" width="110" height="150">
                                <a href="" class="link video sti_lightbox" data-type="video-youtube" data-size="700x420" title="Youtube Video (For The Birds / PIXAR)"></a>
                                <a href="#" class="ribbon ribbon_green" title="Ribbon"></a>
                            </div>
                            <div class="sti_prod">
                                <img src="${basePath}assets/images/banner_full_3_thumb.jpg" alt="" width="110" height="150">
                                <a href="" class="link video sti_lightbox" data-type="video-vimeo" data-size="700x394" title="Vimeo Video"></a>
                                <a href="#" class="ribbon ribbon_red" title="Ribbon"></a>
                            </div>
                            <div class="sti_prod">
                                <img src="image/banner_full_4_thumb.jpg" alt="" width="110" height="150">
                                <a href="" class="link audio sti_lightbox"  data-type="audio" data-size="450x50" title="Audio Example. HTML5 Support / Flash Fallback"></a>
                                <a href="#" class="ribbon ribbon_green" title="Ribbon"></a>
                            </div>
                            <div class="sti_prod">
                                <img src="${basePath}assets/images/banner_full_5_thumb.jpg" alt="" width="110" height="150">
                                <a href="" class="link video sti_lightbox" data-type="video" data-size="540x303" title="MP4 Video. HTML5 Support / Flash Fallback"></a>
                                <a href="#" class="ribbon ribbon_orange" title="Ribbon"></a>
                            </div>
                            <div class="sti_prod">
                                <img src="${basePath}assets/images/banner_full_1_thumb.jpg" alt="" width="110" height="150">
                                <a href="" class="link zoom sti_lightbox" data-type="image" title="Lightbox image example"></a>
                                <a href="#" class="ribbon ribbon_blue" title="Ribbon"></a>
                            </div>
                            <div class="sti_prod">
                                <img src="${basePath}assets/images/banner_full_2_thumb.jpg" alt="" width="110" height="150">
                                <a href="" class="link audio sti_lightbox"  data-type="audio" data-size="450x50" title="Audio Example 2. HTML5 Support / Flash Fallback"></a>
                            </div>

                            <div class="sti_shelf_divider_bottom"></div>
                        </div>

                        <!-- SLIDE GROUP 2 -->

                        <div class="sti_slide">
                            <div class="sti_shelf_divider"></div>

                            <div class="sti_prod">
                                <img src="${basePath}assets/images/banner_full_1_thumb.jpg" alt="" width="110" height="150">
                                <a href="#" class="link more" title="Title"></a>
                            </div>
                            <div class="sti_prod">
                                <img src="${basePath}assets/images/banner_full_2_thumb.jpg" alt="" width="110" height="150">
                                <a href="content/audio/AirReview-Landmarks-02-ChasingCorporate.mp3" class="link audio sti_lightbox"  data-type="audio" data-size="450x50" title="Audio Example. HTML5 Support / Flash Fallback"></a>
                                <a href="#" class="ribbon ribbon_green" title="Ribbon"></a>
                            </div>
                            <div class="sti_prod">
                                <img src="${basePath}assets/images/banner_full_3_thumb.jpg" alt="" width="110" height="150">
                                <a href="#" class="link more" title="Title"></a>
                            </div>
                            <div class="sti_prod">
                                <img src="${basePath}assets/images/banner_full_4_thumb.jpg" alt="" width="110" height="150">
                                <a href="" class="link video sti_lightbox" data-type="video-vimeo" data-size="700x394" title="Vimeo Video"></a>
                            </div>
                            <div class="sti_prod">
                                <img src="${basePath}assets/images/banner_full_5_thumb.jpg" alt="" width="110" height="150">
                                <a href="content/html/html_content.html" class="link content sti_lightbox"  data-type="html-content" data-size="550x450" title="HTML Content"></a>
                            </div>
                            <div class="sti_prod">
                                <img src="${basePath}assets/images/banner_full_1_thumb.jpg" alt="" width="110" height="150">
                                <a href="#" class="link more" title="Title"></a>
                                <a href="#" class="ribbon ribbon_red" title="Ribbon"></a>
                            </div>
                            <div class="sti_prod">
                                <img src="${basePath}assets/images/banner_full_2_thumb.jpg" alt="" width="110" height="150">
                                <a href="#" class="link more" title="Title"></a>
                            </div>

                            <div class="sti_shelf_divider_bottom"></div>
                        </div>

                        <!-- SLIDE GROUP 3 -->
                    </div><!-- sti_items -->
                </div><!-- sti_slider -->

                <%--<div class="sti_paginate">
                    <div class="sti_page"></div>

                    <div class="sti_control">
                        <a href="#" class="sti_btn sti_play"><img src="${basePath}assets/img/play.png" alt=""></a>
                        <a href="#" class="sti_btn sti_pause"><img src="${basePath}assets/img/pause.png" alt=""></a>
                    </div>
                </div>--%>

            </div><!-- sti_container -->

        </div> <!-- end of content right -->
    </div>
    <!-- end of content -->

    <div id="templatemo_footer">

        <a href="${basePath}appBook/book/list">首页</a> | <a href="${basePath}appBook/book/books">书籍列表</a> | <a href="${basePath}appBook/book/newBooks">新书上架</a> | <a href="#">我的好友</a> | <a href="${basePath}appBook/book/myBooks">我的书架</a> | <a href="#">个人信息</a><br />
        Copyright © 2017 <a href="${basePath}appBook/book/list"><strong>读友会</strong></a>
        <!-- Credit: www.templatemo.com -->	</div>
    <!-- end of footer -->
    <!--  Free CSS Template www.templatemo.com -->
</div> <!-- end of container -->
</body>
</html>
