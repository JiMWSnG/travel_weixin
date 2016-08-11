<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%><!-- jsp文件保存的编码方式 -->
<!doctype html>
<html>
<head>
    <meta charset="utf-8">
    <title>畅游</title>
    <meta name="keywords" content=""/>
    <meta name="description" content=""/>
    <meta name="author" content=""/>
    <meta name="viewport" content="width=device-width, initial-scale=1.0, maximum-scale=1.0, user-scalable=0"/>
    <meta name="apple-mobile-web-app-capable" content="yes"> <!--允许iphone设备全屏浏览-->
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <!-- <link rel="apple-touch-icon-precomposed" href="apple-touch-icon.png"> --> <!--允许用户将网页创建快捷方式到桌面-->
    <link rel="stylesheet" type="text/css" href="../css/style.css">
    <link rel="stylesheet" type="text/css" href="../css/index.css">
    <script type="text/javascript" src="../js/jquery-1.12.4.min.js"></script>
    <!--<script type="text/javascript" src="js/jquery.event.drag-1.5.min.js"></script>-->
    <script type="text/javascript" src="../js/jquery.touchSlider.js"></script>
    <script type="text/javascript" src="../js/mainSlider.js"></script>
    <script type="text/javascript" src="../js/Adaptive.js"></script>
</head>

<body>

<!-------------------- 主界面 -------------------->
<div id="main_page" class="main_page is_visible">
    <header>
        <div class="_header">
            <div class="logo">
                <a href="#"><img src="../images/icon/logo.png" alt="Logo" class="logo_image"></a>
            </div>
            <div id="sch" class="sch">
                <p><img src="../images/icon/sch.png">搜索目的地、帖子、景点</p>
            </div>
            <div class="account">
                <a href="#">
                    <img alt="account" src="../images/icon/account2.png" class="account_image">
                </a>
            </div>
        </div>
    </header>
    <div class="clear"></div>

    <div id="_contain">

        <div class="main_visual">
            <div class="flicking_con">
                <a href="#"></a>
                <a href="#"></a>
                <a href="#"></a>
                <a href="#"></a>
                <a href="#"></a>
            </div>
            <div class="main_image">
                <ul>
                    <li><span class="img_1"><a href="#"></a></span></li>
                    <li><span class="img_2"><a href="#"></a></span></li>
                    <li><span class="img_3"><a href="#"></a></span></li>
                    <li><span class="img_4"><a href="#"></a></span></li>
                    <li><span class="img_5"><a href="#"></a></span></li>
                </ul>
                <a href="javascript:;" id="btn_prev"></a>
                <a href="javascript:;" id="btn_next"></a>
            </div>

            <!--<img src="images/index/banner.png">-->

            <!--<div class="logo-dbs">
                <div class="dbs-img">
                    <img src="images/icon/logo.png">
                </div>
                <p>全球低价游，满足你世界梦！</p>
            </div>-->
        </div>

        <div class="menu">
            <div class="nav">
                <a href="xianlu.jsp">
                    <img src="../images/menu/icon_luxian.png">
                    <p>线路</p>
                </a>
            </div>
            <div class="nav">
                <a href="jiudian.jsp">
                    <img src="../images/menu/icon_jiudian.png">
                    <p>酒店</p>
                </a>
            </div>
            <div class="nav">
                <a href="menpiao">
                    <img src="../images/menu/icon_menpiao.png">
                    <p>门票</p>
                </a>
            </div>
        </div>

        <!------------------- 路线推荐部分 ------------------->
        <hr class="divide">

        <div class="name">
            <a href="xianlu.jsp">
                <div class="name_title">线路推荐</div>
                <div class="name_more">
                    <img class="icon_more" alt="more" src="../images/index/more.png">
                </div>
            </a>
        </div>

        <div class="contain">
            <div class="ad">
                <div class="ad-picture">
                    <div class="ad-legend">
                        <div class="ad-price">
                            <p>&yen;200<span class="qi">起</span></p>
                        </div>
                        <div class="ad-surplus">
                            <p>余量充足</p>
                        </div>
                    </div>
                </div>
                <div class="ad-title">
                    &lt;香格里拉-昆大丽双飞6日游&gt;跑男同款,秘境香巴拉,双廊骑行,庭院酒店
                </div>
                <div class="ad-description">
                    <p>一日三餐全含 &nbsp; 免费娱乐活动</p>
                </div>
            </div>

            <div class="ad">
                <div class="ad-picture">
                    <div class="ad-legend">
                        <div class="ad-price">
                            <p>&yen;200<span class="qi">起</span></p>
                        </div>
                        <div class="ad-surplus">
                            <p>余量充足</p>
                        </div>
                    </div>
                </div>
                <div class="ad-title">
                    &lt;香格里拉-昆大丽双飞6日游&gt;跑男同款,秘境香巴拉,双廊骑行,庭院酒店
                </div>
                <div class="ad-description">
                    <p>一日三餐全含 &nbsp; 免费娱乐活动</p>
                </div>
            </div>

            <div class="ad">
                <div class="ad-picture">
                    <div class="ad-legend">
                        <div class="ad-price">
                            <p>&yen;200<span class="qi">起</span></p>
                        </div>
                        <div class="ad-surplus">
                            <p>余量充足</p>
                        </div>
                    </div>
                </div>
                <div class="ad-title">
                    &lt;香格里拉-昆大丽双飞6日游&gt;跑男同款,秘境香巴拉,双廊骑行,庭院酒店
                </div>
                <div class="ad-description">
                    <p>一日三餐全含 &nbsp; 免费娱乐活动</p>
                </div>
            </div>

            <div class="more">
                <p>查看更多<img src="../images/icon/arr-right.png"></p>
            </div>

        </div>

        <!------------------- 酒店推荐部分 ------------------->
        <hr class="divide">

        <div class="name">
            <a href="jiudian.jsp">
                <div class="name_title">酒店推荐</div>
                <div class="name_more">
                    <img class="icon_more" alt="more" src="../images/index/more.png">
                </div>
            </a>
        </div>

        <div class="contain">
            <div class="ad-hotel">
                <div class="ad-hotel-picture">
                    <img src="../images/index/hotel_1.jpg" alt="hotel picture" class="hotel-picture">
                </div>
                <div class="ad-hotel-description">
                    <div class="ad-hotel-title">
                        <p>北京速8酒店(东四店)</p>
                    </div>
                    <div class="ad-hotel-notes">
                        <p>经济型|wifi</p>
                    </div>
                    <div class="ad-hotel-price">
                        <p>
                            <span class="ad-hotel-discount">8.5折&nbsp;&nbsp;</span>
                            <span class="ad-hotel-cost">&yen;180</span>
                            <span class="ad-hotel-qi">起</span>
                        </p>
                    </div>
                </div>
            </div>

            <hr class="divide">

            <div class="ad-hotel">
                <div class="ad-hotel-picture">
                    <img src="../images/index/hotel_1.jpg" alt="hotel picture" class="hotel-picture">
                </div>
                <div class="ad-hotel-description">
                    <div class="ad-hotel-title">
                        <p>北京速8酒店(东四店)</p>
                    </div>
                    <div class="ad-hotel-notes">
                        <p>经济型|wifi</p>
                    </div>
                    <div class="ad-hotel-price">
                        <p>
                            <span class="ad-hotel-discount">8.5折&nbsp;&nbsp;</span>
                            <span class="ad-hotel-cost">&yen;180</span>
                            <span class="ad-hotel-qi">起</span>
                        </p>
                    </div>
                </div>
            </div>

            <hr class="divide">

            <div class="ad-hotel">
                <div class="ad-hotel-picture">
                    <img src="../images/index/hotel_1.jpg" alt="hotel picture" class="hotel-picture">
                </div>
                <div class="ad-hotel-description">
                    <div class="ad-hotel-title">
                        <p>北京速8酒店(东四店)</p>
                    </div>
                    <div class="ad-hotel-notes">
                        <p>经济型|wifi</p>
                    </div>
                    <div class="ad-hotel-price">
                        <p>
                            <span class="ad-hotel-discount">8.5折&nbsp;&nbsp;</span>
                            <span class="ad-hotel-cost">&yen;180</span>
                            <span class="ad-hotel-qi">起</span>
                        </p>
                    </div>
                </div>
            </div>

            <div class="more">
                <p>查看更多<img src="../images/icon/arr-right.png"></p>
            </div>

        </div>

        <!------------------- 门票推荐部分 ------------------->
        <hr class="divide">

        <div class="name">
            <a href="menpiao.html">
                <div class="name_title">门票推荐</div>
                <div class="name_more">
                    <img class="icon_more" alt="more" src="../images/index/more.png">
                </div>
            </a>
        </div>

        <div class="contain">
            <div class="ad-ticket">
                <div class="ad-picture"></div>
                <div class="ad-ticket-title">
                    北京海洋馆
                </div>
                <div class="ad-ticket-price">
                    <p>
                        <span>&yen;160</span>
                        <span class="ad-ticket-qi">起</span>
                    </p>
                </div>
            </div>

            <div class="ad-ticket">
                <div class="ad-picture"></div>
                <div class="ad-ticket-title">
                    北京海洋馆
                </div>
                <div class="ad-ticket-price">
                    <p>
                        <span>&yen;160</span>
                        <span class="ad-ticket-qi">起</span>
                    </p>
                </div>
            </div>

            <div class="ad-ticket">
                <div class="ad-picture"></div>
                <div class="ad-ticket-title">
                    北京海洋馆
                </div>
                <div class="ad-ticket-price">
                    <p>
                        <span>&yen;160</span>
                        <span class="ad-ticket-qi">起</span>
                    </p>
                </div>
            </div>

            <div class="more">
                <p>查看更多<img src="../images/icon/arr-right.png"></p>
            </div>

        </div>

    </div>

</div>

<!------------------- 搜索界面 ------------------->
<div id="search_page" class="search_page not_visible">
    <header>
        <div class="_header">
            <div id="button_cancel" class="cancel"></div>
            <div class="search">
                <div class="div_sch_icon">
                    <i class="sch_icon"></i>
                </div>
                <div class="div_sch_input">
                    <form action="index.jsp" method="get" class="search_form">
                        <input type="text" name="keywords" class="search_input" placeholder="北京" />
                        <input type="submit" name="search" value="搜索" class="button_search"/>
                    </form>
                </div>
            </div>
        </div>
    </header>
    <div class="clear"></div>

    <div class="recommend">
        <div class="rcm_title">
            <p>热门搜索</p>
        </div>
        <hr class="divide">

        <div class="rcm_content">
            <ul>
                <li><a href="index.jsp">北京</a></li>
                <li><a href="index.jsp">上海</a></li>
                <li><a href="index.jsp">广州</a></li>
                <li><a href="index.jsp">日本</a></li>
                <li><a href="index.jsp">泰国</a></li>
                <li><a href="index.jsp">开封</a></li>
                <li><a href="index.jsp">普宁</a></li>
                <li><a href="index.jsp">九寨沟</a></li>
                <li><a href="index.jsp">古北水镇</a></li>
                <li><a href="index.jsp">布达拉宫</a></li>
                <li><a href="index.jsp">厦门</a></li>
                <li><a href="index.jsp">云南</a></li>
                <li><a href="index.jsp">巴厘岛</a></li>
                <li><a href="index.jsp">马尔代夫</a></li>
                <li><a href="index.jsp">泰山</a></li>
                <li><a href="index.jsp">济州岛</a></li>
            </ul>
        </div>
    </div>
</div>

<div id="account_page" class="account_page not_visible"></div>


<!--<div class="footer">
    <hr class="divide">
    <div class="rights">
        Copyright &nbsp; &copy; &nbsp; 2016 Changyou. &nbsp; All rights reserved.
    </div>
</div>-->

<!--<footer>
	<div class="foot act">
    	<img src="images/foot/ft_1_1.png">
        <p>推荐</p>
    </div>
	<div class="foot">
    	<img src="images/foot/ft_2.png">
        <p>目的地</p>
    </div>
	<div class="foot">
    	<img src="images/foot/ft_3.png">
        <p>帖子</p>
    </div>
	<a href="person/person.jsp"><div class="foot">
    	<img src="images/foot/ft_4.png">
        <p>我的</p>
    </div></a>
</footer>-->

<script type="text/javascript" src="../js/jquery-1.7.1.min.js"></script>
<script type="text/javascript">
    //to view more
    $(".more").click(function () {
        for (i = 0; i < 4; i++) {
            $(".favorable").append('<div class="fb">'
                    + '<div class="fb-lt">'
                    + '' + '<img src="../images/scenics/scenic_5.png"/>' + ''
                    + '<p class="fb-name">体验全球最长的过山车15天超爽旅游</p>'
                    + '<p class="price">' + '<span class="discount">2.8折</span>'
                    + '<span class="num"><big>2889</big>元起</span>'
                    + '</p></div></div>');
        }
    });

    //to search
    $('#sch').on('click', function(event){
        event.preventDefault();
        $("#main_page").removeClass("is_visible")
        $("#main_page").addClass("not_visible");
        $("#search_page").removeClass("not_visible");
        $("#search_page").addClass("is_visible");
    });

    $('#button_cancel').on('click', function(event){
        event.preventDefault();
        $("#search_page").removeClass("is_visible");
        $("#search_page").addClass("not_visible");
        $("#main_page").removeClass("not_visible")
        $("#main_page").addClass("is_visible");
    });

</script>

</body>
</html>
