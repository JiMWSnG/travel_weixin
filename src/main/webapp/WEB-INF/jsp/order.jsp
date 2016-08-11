<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%><!-- jsp文件保存的编码方式 -->
<!DOCTYPE html>
<html lang="en">

<head>
    <meta charset="UTF-8">
    <title>畅游——定制页面</title>
    <meta charset="UTF-8">
    <meta name="keywords" content="" />
    <meta name="description" content="" />
    <meta name="author" content="" />
    <meta name="viewport" content="width=device-width, initial-scale=1.0, maximum-scale=1.0, user-scalable=0" />
    <meta name="apple-mobile-web-app-capable" content="yes">
    <!--允许iphone设备全屏浏览-->
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <!-- <link rel="apple-touch-icon-precomposed" href="apple-touch-icon.png"> -->
    <!--允许用户将网页创建快捷方式到桌面-->
    <title>酒店定制</title>
    <link rel="stylesheet" type="text/css" href="../css/jquery-ui.css">
    <link rel="stylesheet" rev="stylesheet" href="../css/jock-citypicker-2.0.css" type="text/css" />
    <link rel="stylesheet" type="text/css" href="../css/dingzhi_style.css">
    <script type="text/javascript" src="../js/Adaptive.js"></script>
    <script type="text/javascript" src="../js/jquery-1.12.4.min.js"></script>
    <script type="text/javascript" src="../js/jquery-ui.min.js"></script>
    <script type="text/javascript" src="../js/picker.js"></script>
    <script type="text/javascript" src="../js/jock-citypicker-2.0.min.js"></script>
    <script type="text/javascript" src="../js/citypick.js"></script>
    <script type="text/javascript" src="../js/main.js"></script>
</head>

<body>
    <header>
        <div class="header">
            <ul class="ul1">
                <li class="goback"><a href="" class="revert"><i class="icon icon-left"></i></a></li>
                <li class="title">
                    <p>定制订单填写</p>
                </li>
                <li class="logo"><a href="" class="account"><i class="icon icon-right"></i></a></li>
                </li>
            </ul>
        </div>
    </header>
    <div class="clear"></div>
    <div id="mid">
        <form id="submitform">
            <p class="group">
                <label>出游类型</label>
                <input type="text" id="typeplay" class="formsize" name="typeplay" placeholder="请填写您的出游类型">
                <br>
            </p>
            <hr class="divide">
            <p class="group">
                <label>出游时间</label>
                <input type="text" id="datepicker1" class="formsize" name="datepicker1" placeholder="请核实您的入住时间" readonly="readonly">
                <br>
            </p>
            <hr class="divide">
            <p class="group">
                <label>离开时间</label>
                <input type="text" id="datepicker2" class="formsize" name="datepicker2" placeholder="请核实您的离开时间" readonly="readonly">
                <br>
            </p>
            <hr class="divide">
            <p class="group">
                <label>出发地点</label>
                <input type="text" id="destination1" class="formsize destination" name="destination1" placeholder="请选择您的出发地点" readonly="readonly">
                <br>
            </p>
            <hr class="divide">
            <p class="group">
                <label>目的地</label>
                <input type="text" id="destination2" class="formsize destination" name="destination2" placeholder="请选择您的目的地" readonly="readonly">
                <br>
            </p>
            <hr class="divide">
            <div class="group group2">
                <label>出游人数</label>
                <p class="childgroup">
                    <span class="sp sp1">-</span>
                    <input type="text" id="personnumber" class="pnum" name="pnum" value="1" readonly="readonly">
                    <span class="sp sp2">+</span>
                </p>
                <br>
            </div>
            <div class="group group2">
                <label>房间数量</label>
                <p class="childgroup">
                    <span class="sp sp1">-</span>
                    <input type="text" id="roomnumber" class="rnum" name="rnum" value="1" readonly="readonly">
                    <span class="sp sp2">+</span>
                </p>
                <br>
            </div>
            <div class="group group2">
                <label>总价</label>
                <p class="childgroup">
                    <input type="text" class="rprice" name="rprice" value="200" readonly="readonly">
                </p>
                <br>
            </div>
            <p class="message">预定人信息</p>
            <p class="group name">
                <label>姓名</label>
                <input type="text" id="name" class="formsize name1" name="reserve_name" placeholder="必填">
                <br>
            </p>
            <hr class="divide">
            <p class="group">
                <label>手机号</label>
                <input type="text" class="phonenum formsize" name="phonenum" placeholder="请输入11位手机号">
                <br>
            </p>
            <hr class="divide">
            <p class="danger">号码位数不正确，请重新输入！</p>
            <p class="message">投保人信息<span id="insur_icon">+</span></p>
            <ul id="insurance">
                <li class="applicant">
                    <p class="message message2">投保人<span class="insurman_icon">-</span></p>
                    <div class="insurance_info">
                        <p class="group name">
                            <label>姓名</label>
                            <input type="text" id="name" class="formsize name1" name="name" placeholder="必填">
                            <br>
                        </p>
                        <hr class="divide">
                        <p class="group">
                            <label>手机号</label>
                            <input type="text" class="phonenum formsize" name="phonenum" placeholder="请输入11位手机号">
                            <br>
                        </p>
                        <hr class="divide">
                        <p class="danger">号码位数不正确，请重新输入！</p>
                        <p class="group">
                            <label>身份证号</label>
                            <input type="text" class="formsize idnum" name="idnum" placeholder="请输入18位身份证号">
                            <br>
                        </p>
                        <hr class="divide idnumber">
                        <p class="danger">身份证号码位数不正确，请重新输入！</p>
                    </div>
                </li>
                <div id="add">+</div>
            </ul>

        </form>
        <button class="btn1 btn-primary" type="button">提&nbsp;&nbsp;交</button>
    </div>
    <div id="mengban"></div>
    <div id="mengban2"></div>
    <div id="mengban3"></div>
</body>

</html>
