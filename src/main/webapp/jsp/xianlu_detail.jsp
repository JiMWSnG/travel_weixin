<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%><!-- jsp文件保存的编码方式 --><!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>线路详情</title>
    <meta name="keywords" content=""/>
    <meta name="description" content=""/>
    <meta name="author" content=""/>
    <meta name="viewport" content="width=device-width, initial-scale=1.0, maximum-scale=1.0, user-scalable=0"/>
    <meta name="apple-mobile-web-app-capable" content="yes"> <!--允许iphone设备全屏浏览-->
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <!-- <link rel="apple-touch-icon-precomposed" href="apple-touch-icon.png"> --> <!--允许用户将网页创建快捷方式到桌面-->
    <link rel="stylesheet" type="text/css" href="../css/style.css">
    <link rel="stylesheet" type="text/css" href="../css/detail.css">
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
            线路详情
        </div>
        <div class="account"></div>
    </div>
</header>
<div class="clear"></div>
<div id="_contain">
 <!--轮播窗 -->
    <div class="main_visual">
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
        <div class="xianlu_title">
            <div id="position">[北京周边]</div>
            <div id="xianlu_name">十渡</div>
            <div id="sale">已售</div>
            <div id="sales">123</div>
        </div>
    </div>
    <!--路线信息-->
    <div class="book">
        <div class="xianlu_detail">
            <p id="xianlu_detail">孤山寨+漂流+竹筏+烧烤3日2晚跟团游仅需345元</p>
        </div>
        <div class="xianlu_price">
            <p>&yen;</p><p id="xianlu_price">345</p><p>元 / 人</p>
        </div>
        <div class="booknote">
            <div class="bookimgdiv"><i class="bookimg"></i></div>
            <div class="booknotep"><p id="booknote">提前3天预订</p></div>
        </div>
    </div>
     <!--费用说明 -->
    <div class="info">
    	<div class="info_detail">
        	<div class="infoimgdiv"><i class="infoimg"></i></div>
        	<div class="info_title"><p>费用说明</p></div>
            <div class="btn-down"></div>            
        </div>
		<div id="feeinfo">
        	<hr/>
            <div class="info_describe">
                <div class="include"><p class="includetitle">费用包括:</p><p class="includedetail">1.车费；2.烧烤，漂流，竹筏；3.住宿费（农家院）</p></div>
                <hr color="#000000" style="border:0; height:1px"/>
                <div class="notinclude_list"><p class="notincludetitle">费用不包括:</p><p class="notincludedetail">1.保险；2.滑梯；</p></div>
            </div>
    	</div>
 	 </div>
    <!--交通信息 -->
    <div class="info">
    	<div class="info_detail">
        	<div class="infoimgdiv"><i class="infoimg"></i></div>
        	<div class="info_title"><p>交通信息</p></div>
            <div class="btn-down"></div>            
        </div>
		<div id="transportinfo">
        	<hr/>
            <div class="info_describe">
                <div class="infodescribe"><p>在西门集合，坐大巴车去火车站，乘坐火车到达十渡，下车后有车专门接送。</p></div>
            </div>
    	</div>
 	 </div>
    <!--酒店信息 -->
    <div class="info">
    	<div class="info_detail">
        	<div class="infoimgdiv"><i class="infoimg"></i></div>
        	<div class="info_title"><p>酒店信息</p></div>
            <div class="btn-down"></div>            
        </div>
		<div id="hotelinfo">
        	<hr/>
            <div class="info_describe">
                <div class="infodescribe"><p>景区内农家院，有免费wifi，提供24小时热水，棋牌室，台球桌免费提供</p></div>
            </div>
    	</div>
 	 </div>
      <!--预定流程 -->
    <div class="info">
    	<div class="info_detail">
        	<div class="infoimgdiv"><i class="infoimg"></i></div>
        	<div class="info_title"><p>预定流程</p></div>
            <div class="btn-down"></div>            
        </div>
		<div id="bookinfo">
        	<hr/>
            <div class="info_describe">
                <div class="infodescribe"><p>点击购买产品，填写出行日期，出游人数、身份信息及联系方式，填写完成确认无误后，支付购买</p></div>
            </div>
    	</div>
 	 </div>
      <!--退款说明 -->
    <div class="info">
    	<div class="info_detail">
        	<div class="infoimgdiv"><i class="infoimg"></i></div>
        	<div class="info_title"><p>退款说明</p></div>
            <div class="btn-down"></div>            
        </div>
		<div id="refundinfo">
        	<hr/>
            <div class="info_describe">
                <div class="infodescribe"><p>支持出行前48小时无条件退款，48小时至24小时退还95%，24小时内退还90%</p></div>
            </div>
    	</div>
 	 </div>
     <!--出行提示 -->
    <div class="info">
    	<div class="info_detail">
        	<div class="infoimgdiv"><i class="infoimg"></i></div>
        	<div class="info_title"><p>出行提示</p></div>
            <div class="btn-down"></div>            
        </div>
		<div id="outtip">
        	<hr/>
            <div class="info_describe">
                <div class="infodescribe"><p>夜间山间较冷，请注意携带衣物保暖。</p></div>
            </div>
    	</div>
 	 </div>
     <!--点击购买 -->
     <button class="buybtn btn-primary" type="button">点击购买产品</button>
</div>




</body>
</html>