<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%><!-- jsp文件保存的编码方式 -->
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>路线</title>
    <meta name="keywords" content=""/>
    <meta name="description" content=""/>
    <meta name="author" content=""/>
    <meta name="viewport" content="width=device-width, initial-scale=1.0, maximum-scale=1.0, user-scalable=0"/>
    <meta name="apple-mobile-web-app-capable" content="yes"> <!--允许iphone设备全屏浏览-->
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <!-- <link rel="apple-touch-icon-precomposed" href="apple-touch-icon.png"> --> <!--允许用户将网页创建快捷方式到桌面-->
    <link rel="stylesheet" type="text/css" href="../css/style.css">
    <link rel="stylesheet" type="text/css" href="../css/xianlu.css">
    <link rel="stylesheet" type="text/css" href="../css/index.css">

    <script type="text/javascript" src="../js/jquery-1.12.4.min.js"></script>
    <!--<script type="text/javascript" src="js/jquery.event.drag-1.5.min.js"></script>-->
    <script type="text/javascript" src="../js/jquery.touchSlider.js"></script>
    <script type="text/javascript" src="../js/mainSlider.js"></script>
    <script type="text/javascript" src="../js/Adaptive.js"></script>
</head>

<body>

<header>
    <div class="luxian_header">
        <div class="back"></div>
        <div class="main_title">
            线路
        </div>
        <div class="search_icon"></div>
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
    </div>

    <div class="show_products" id="show_products">
        <div class="options">
            <ul>
                <li id="category_all" class="active">全部</li>
                <li id="category_pop">人气</li>
                <li id="category_new">新品</li>
            </ul>
        </div>

        <div class="products products_all" id="products_all">
            <div class="contain" id="contain_all">
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

            </div>

            <div class="more">
                <p>查看更多<img src="../images/icon/arr-right.png"></p>
            </div>
        </div>
        <!--end of products_all-->

        <div class="products products_popular" id="products_pop">
            <div class="contain" id="contain_pop">
                <div class="ad">
                    <div class="ad-picture">
                        <div class="ad-legend">
                            <div class="ad-price">
                                <p>&yen;300<span class="qi">起</span></p>
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
                                <p>&yen;300<span class="qi">起</span></p>
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
                                <p>&yen;300<span class="qi">起</span></p>
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

            </div>

            <div class="more">
                <p>查看更多<img src="../images/icon/arr-right.png"></p>
            </div>
        </div>
        <!--end of products_popular-->

        <div class="products products_new" id="products_new">
            <div class="contain" id="contain_new">
                <div class="ad">
                    <div class="ad-picture">
                        <div class="ad-legend">
                            <div class="ad-price">
                                <p>&yen;400<span class="qi">起</span></p>
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
                                <p>&yen;400<span class="qi">起</span></p>
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
                                <p>&yen;400<span class="qi">起</span></p>
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

            </div>

            <div class="more">
                <p>查看更多<img src="../images/icon/arr-right.png"></p>
            </div>
        </div>
        <!--end of products_new-->
    </div>
</div>

<script type="text/javascript">
    window.onload=function()
    {
        var pAll = document.getElementById("products_all");
        var pPop = document.getElementById("products_pop");
        var pNew = document.getElementById("products_new");
        pAll.style.display = "block";
        pPop.style.display = "none";
        pNew.style.display = "none";

        var oTab = document.getElementById("show_products");
        var options = oTab.getElementsByTagName("li");
        var oDiv = oTab.getElementsByClassName("products");
        for(var i=0;i<options.length;i++)
        {
            options[i].index = i;
            options[i].onclick = function()
            {
                for(var i=0;i<options.length;i++)
                {
                    options[i].className = "";
                    oDiv[i].style.display = "none";
                }
                this.className = "active";
                oDiv[this.index].style.display = "block";
            }
        }
    }

    $(".more").click(function(){
        var contain_target;
        var pAll = document.getElementById("products_all");
        var pPop = document.getElementById("products_pop");
        var pNew = document.getElementById("products_new");
        if (pAll.style.display.toString() == "block") {
            contain_target = $("#contain_all");
//            contain_target = document.getElementById("contain_all");
        } else if (pPop.style.display == "block") {
            contain_target = $("#contain_pop");
        } else {
            contain_target = $("#contain_new");
        }
        for(i=0;i<4;i++){
            contain_target.append(
                '<div class="ad">'
                    +'<div class="ad-picture">'
                        +'<div class="ad-legend">'
                            +'<div class="ad-price">'
                                +'<p>&yen;400<span class="qi">起</span></p>'
                            +'</div>'
                            +'<div class="ad-surplus">'
                                +'<p>余量充足</p>'
                            +'</div>'
                        +'</div>'
                    +'</div>'
                    +'<div class="ad-title">'
                        +'&lt;香格里拉-昆大丽双飞6日游&gt;跑男同款,秘境香巴拉,双廊骑行,庭院酒店'
                    +'</div>'
                    +'<div class="ad-description">'
                        +'<p>一日三餐全含 &nbsp; 免费娱乐活动</p>'
                    +'</div>'
                +'</div>'
            );
        }
    })
</script>

<!--<script type="text/javascript">
    var myScroll = null;
    var generatedCount = 0;
    function pullUpAction () {
        var contain, li, i;  //el:contain;  li:ad;
        contain = document.getElementById('contain');
        for (i=0; i<3; i++) {
            $("#contain").append(
                '<div class="ad">'
                    +'<div class="ad-picture">'
                        +'<div class="ad-legend">'
                            +'<div class="ad-price">'
                                +'<p>&yen;400<span class="qi">起</span></p>'
                            +'</div>'
                            +'<div class="ad-surplus">'
                                +'<p>余量充足</p>'
                            +'</div>'
                        +'</div>'
                    +'</div>'
                    +'<div class="ad-title">'
                        +'&lt;香格里拉-昆大丽双飞6日游&gt;跑男同款,秘境香巴拉,双廊骑行,庭院酒店'
                    +'</div>'
                    +'<div class="ad-description">'
                        +'<p>一日三餐全含 &nbsp; 免费娱乐活动</p>'
                    +'</div>'
                +'</div>'
            )
        }
        myScroll.refresh();     // Remember to refresh when contents are loaded (ie: on ajax completion)!
    }

    window.onload = function() {
        myScroll = new IScroll('#_contain', {
            onScrollEnd: function () {
                //如果滑动到底部，则加载更多数据（距离最底部10px高度）
                if ((this.y - this.maxScrollY) > 10) {
                    pullUpAction();
                }
            }
        });
        for (var n=0; n<10; n++) {
            pullUpAction();
        }
    }

    document.addEventListener('touchmove', function (e) { e.preventDefault(); }, false);
</script>-->

</body>
</html>