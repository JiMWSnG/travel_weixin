<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<!DOCTYPE html>
<html lang="en">

<head>
    <meta charset="UTF-8">
    <title>用户信息设置</title>
    <meta charset="UTF-8">
    <meta name="keywords" content=""/>
    <meta name="description" content=""/>
    <meta name="author" content=""/>
    <meta name="viewport" content="width=device-width, initial-scale=1.0, maximum-scale=1.0, user-scalable=0"/>
    <meta name="apple-mobile-web-app-capable" content="yes">
    <!--允许iphone设备全屏浏览-->
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <!-- <link rel="apple-touch-icon-precomposed" href="apple-touch-icon.png"> -->
    <!--允许用户将网页创建快捷方式到桌面-->
    <title>用户信息设置</title>
    <link rel="stylesheet" type="text/css" href="css/jquery-ui.css">
    <link rel="stylesheet" rev="stylesheet" href="css/jock-citypicker-2.0.css" type="text/css"/>
    <link rel="stylesheet" type="text/css" href="css/index.css">
    <link rel="stylesheet" type="text/css" href="css/style.css">
    <link rel="stylesheet" type="text/css" href="css/altinf.css">
    <script type="text/javascript" src="js/Adaptive.js"></script>
    <script type="text/javascript" src="js/jquery-1.12.4.min.js"></script>
    <script type="text/javascript" src="js/jquery-ui.min.js"></script>
    <script type="text/javascript" src="js/picker.js"></script>
    <script type="text/javascript" src="js/jock-citypicker-2.0.min.js"></script>
    <script type="text/javascript" src="js/citypick.js"></script>
    <script type="text/javascript" src="js/main.js"></script>
</head>

<body>
<header>
    <div class="luxian_header">
        <!--<a href="#" onClick="javascript :history.back(-1);">-->
        <a onClick="javascript :history.back(-1);">
            <div class="back"></div>
        </a>
        <div class="main_title">
            用户基本信息
        </div>
        <div class="account"></div>
    </div>
</header>

<div class="clear"></div>
<!--     <div id="mid">-->
<br>
<!--                        <p class="group name">
                            <label>姓名</label>-->
<div id="feeinfo">
    <form name="altUserInfo" method="post" action="http://localhost:8080/Changyou/AlterUserInfo" onsubmit="return check();">
        <div class="info_describe">

            <div class="include">
                <p class="includetitle">姓名</p>
                <input type="text" id="name" class="formsize" name="name" placeholder="必填">
                <hr class="divide">
            </div>

            <div class="include">
                <p class="includetitle">手机</p>
                <input type="text" id="phonenum" class="phonenum formsize" name="phonenum" placeholder="请输入11位手机号">
                <hr class="divide">
                <p class="danger">号码位数不正确，请重新输入！</p>
            </div>

            <div class="include">
                <p class="includetitle">身份证</p>
                <input type="text" id="idnum" class="formsize idnum" name="idnum" placeholder="请输入18位身份证号">
                <hr class="divide idnumber">
                <p class="danger">身份证号码位数不正确，请重新输入！</p>
            </div>

            <div class="warnings">
                <label id="warning" name="warning"></label>
            </div>

        </div>

        <input type="submit" class="btn1 btn-primary" value="提&nbsp;&nbsp;交">
    </form>


        <!--        <form id="submitform">
                    <p class="group">
                        <div class="users_info">
                                <p class="group name">
                                    <label>姓名</label>
                                    <input type="text" id="name" class="formsize name1" name="name" placeholder="必填">
                                   <br>
                                </p>
                                <hr class="divide">
                                <p class="group">
                                    <label>手机</label>
                                    <input type="text" class="phonenum formsize" name="phonenum" placeholder="请输入11位手机号">
                                   <br>
                                </p>
                                <hr class="divide">
                                <p class="danger">号码位数不正确，请重新输入！</p>
                                <p class="group">
                                    <label>身份证</label>
                                    <input type="text" class="formsize idnum" name="idnum" placeholder="请输入18位身份证号">
                                    <br>
                                </p>
                                <p class="danger">身份证号码位数不正确，请重新输入！</p>
                            </div>
                    </p>

                </form>
        -->

</div>
<br>

<!--<a href="chkinf.html">-->
    <!--<button class="btn1 btn-primary" type="button">提&nbsp;&nbsp;交</button>-->
<!--</a>-->

<div id="mengban"></div>
<div id="mengban2"></div>
<div id="mengban3"></div>
</body>

<script type="application/javascript">
    function check() {
        var name = document.getElementById("name").value;
        var phonenum = document.getElementById("phonenum").value;
        var idnum = document.getElementById("idnum").value;
        var phoneRegExp = /^1[34578]\d{9}$/;
        var idRegExp = /^\d{17}[0-9x]$/i

        if (name == "") {
            $("#warning")[0].innerHTML = "请输入正确的用户名";
            return false;
        } else if (!phoneRegExp.test(phonenum)) {
            $("#warning")[0].innerHTML = "请输入正确的手机号码";
            return false;
        } else if (!idRegExp.test(idnum)) {
            $("#warning")[0].innerHTML = "请输入正确的身份证号码";
            return false;
        } else {
            return true;
        }
    }
</script>

</html>
