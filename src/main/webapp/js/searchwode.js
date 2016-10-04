$(function() {
    //打开搜索页面,隐藏主页面
    $('#sch').on('click', function(event){
        event.preventDefault();
        $("#main_page").removeClass("is_visible");
        $("#main_page").addClass("not_visible");
        $("#search_page").removeClass("not_visible");
        $("#search_page").addClass("is_visible");
    });

    //隐藏搜索页面,打开主页面
    $('#button_cancel').on('click', function(event){
        event.preventDefault();
        $("#search_page").removeClass("is_visible");
        $("#search_page").addClass("not_visible");
        $("#main_page").removeClass("not_visible")
        $("#main_page").addClass("is_visible");
    });

    //打开我的页面,隐藏主页面
    $('#account').on('click', function (event) {
        event.preventDefault();
        $("#account_page").removeClass("not_display");
        $("#account_page").addClass("is_display");
//        document.getElementById("account_page").style.display = "block";
        document.getElementById("account_page").style.left = "0";

        //添加listener
    });

    $('#account_blank').on('click',function (event) {
        event.preventDefault();
        document.getElementById("account_page").style.left = "100%";
//        $("#account_page").removeClass("is_display");
//        $("#account_page").addClass("not_display");
    });


});
