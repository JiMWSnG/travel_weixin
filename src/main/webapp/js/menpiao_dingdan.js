$(function() {
    $(".sp1").click(function() {
        var $val = $(this).next("input").val();
        if ($val <= 1) {
            $(this).next("input").val(1);
        } else {
            $(this).next("input").val($val - 1);
			$(".bookprice").val($(this).next("input").val() * 200);
        }
    });

    $(".sp2").click(function() {
        var $val = $(this).prev("input").val();
        if ($val >= 10000) {
            $(this).prev("input").val(10000);
        } else {
            $(this).prev("input").val(+$val + 1);
            $(".bookprice").val($(this).prev("input").val() * 200);
        }
    });



    $("#mid").on("change",".phonenum",function() {
        if ($(this).val().length != 11&&$(this).val().length != 0) {
            $(this).parent().nextAll("p:eq(0)").css("display", "block");
        } else {
            $(this).parent().nextAll("p:eq(0)").css("display", "none");
        }
    });
     
});
