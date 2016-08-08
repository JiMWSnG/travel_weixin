$(function() {
    $(".sp1").click(function() {
        var $val = $(this).next("input").val();
        if ($val <= 1) {
            $(this).next("input").val(1);
        } else {
            $(this).next("input").val($val - 1);
            $(".rprice").val(+$(".rnum").val() * 200);
        }
    });

    $(".sp2:eq(0)").click(function() {
        var $val = $(this).prev("input").val();
        if ($val >= 50) {
            $(this).prev("input").val(50);
        } else {
            $(this).prev("input").val(+$val + 1);
        }
    });

    $(".sp2:eq(1)").click(function() {
        var $val = $(this).prev("input").val();
        if ($val >= 10) {
            $(this).prev("input").val(10);
        } else {
            $(this).prev("input").val(+$val + 1);
            $(".rprice").val($(this).prev("input").val() * 200);
        }
    });

    $("#insur_icon").click(function() {
        if ($("#insurance").css("display") == "none") {
            $("#insurance").slideDown(500);
            $("#insur_icon").text("-");
        } else {
            $("#insurance").slideUp(500);
            $("#insur_icon").text("+");
            $(".insurance_info:gt(0)").css("display", "none");
            $(".insurman_icon:gt(0)").text("+");
        }
    });


    $("#mid").on("change",".phonenum",function() {
        if ($(this).val().length != 11&&$(this).val().length != 0) {
            $(this).parent().nextAll("p:eq(0)").css("display", "block");
        } else {
            $(this).parent().nextAll("p:eq(0)").css("display", "none");
        }
    });

    $("#insurance").on("change",".idnum",function() {
        if ($(this).val().length != 18&&$(this).val().length != 0) {
            $(this).parent().nextAll("p:eq(0)").css("display", "block");
        } else {
            $(this).parent().nextAll("p:eq(0)").css("display", "none");
        }
    });


    $("#add").click(function() {
        $("#add").before("<li class='applicant'></li>");
        var $li=$("#add").prevAll("li:eq(0)");
        $li.append('<p class="message message2">投保人'+'<span class="insurman_icon">-</span></p>');
        $li.append('<div class="insurance_info"></div>');
        var $div=$li.find("div");
        $div.append('<p class="group name"><label>姓名</label>'+'<input type="text" id="name" class="formsize name1" name="name" placeholder="必填"><br></p>');
        $div.append('<hr class="divide"><p class="group"><label>手机号</label><input type="text" class="phonenum formsize" name="phonenum" placeholder="请输入11位手机号"><br></p>');
        $div.append('<hr class="divide"><p class="danger">号码位数不正确，请重新输入！</p><p class="group"><label>身份证号</label><input type="text" class="formsize idnum" name="idnum" placeholder="请输入18位身份证号"><br></p>');
        $div.append('<hr class="divide idnumber"><p class="danger">身份证号码位数不正确，请重新输入！</p></div>');
    });

 	$("#insurance").on("click",".insurman_icon",function() {
        var $div = $(this).parent().next("div");
        if ($div.css("display") == "none") {
            $div.slideDown(500);
            $(this).text("-");
        } else {
            $div.slideUp(500);
            $(this).text("+");
        }
    });
     
});
