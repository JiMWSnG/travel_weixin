$(function() {
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
					+'<a href="xianlu_detail.html">'
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
					+'</a>'
                    +'<div class="ad-title">'
                        +'&lt;香格里拉-昆大丽双飞6日游&gt;跑男同款,秘境香巴拉,双廊骑行,庭院酒店'
                    +'</div>'
                    +'<div class="ad-description">'
                        +'<p>一日三餐全含 &nbsp; 免费娱乐活动</p>'
                    +'</div>'
                +'</div>'
            );
        }

});
});

