$(function() {
    /*酒店级别*/
    $("#level").click(function() {
        $('#mengban').css('display', 'block');
        $('#myprice').slideDown(300);
    });

    $("#price_btn").click(function() {
        var $result = "";
        var num = 0;
        $('#mengban').css('display', 'none');
        $('#myprice').slideUp(300);
        $(".active").each(function(index, val) {
            $result = $result + $(this).text() + ",";
        });
        $("#level").val($result);
    });

    $(".myli").click(function() {
        $(".myli").removeClass('active');
        $(this).addClass('active');
    });

    $(".myli2").click(function() {
        if ($(this).index() === 0) {
            $(".myli2").removeClass('active');
            $(this).addClass('active');
        } else {
            $(".myli2:eq(0)").removeClass('active');
            if ($(this).hasClass('active')) {
                $(this).removeClass('active');
                if ($(".myli2").hasClass("active") != true) {
                    $(".myli2:eq(0)").addClass('active');
                }
            } else {
                $(this).addClass('active');
            }
        }
    });
});
