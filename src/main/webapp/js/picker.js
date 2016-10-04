    $(function() {
        $("#datepicker1,#datepicker2").focus(function() { /*修正BUG采用丢失焦点、获取焦点。*/
            $('#mengban3').css('display', 'block');

        });

        $("#datepicker1,#datepicker2").change(function() {  /*修正BUG，必须改变文本蒙版才消失。*/
                $('#mengban3').css('display', 'none');
            

        });
        $("#mengban3").click(function() {
            $("#ui-datepicker-div").hide();
            $("#mengban3").css("display", "none");
        });


        var currentDate;
        $("#datepicker1").datepicker({
            minDate: new Date(),
            dateFormat: "yy-mm-dd",
            dayNamesMin: ["日", "一", "二", "三", "四", "五", "六"],
            monthNames: ["一月", "二月", "三月", "四月", "五月", "六月", "七月", "八月", "九月", "十月", "十一月", "十二月"],
            showMonthAfterYear: true,
            prevText: "上月",
            nextText: "下月",

        });
        $("#datepicker2").datepicker({
            minDate: CurrentTime(new Date()),
            dateFormat: "yy-mm-dd",
            dayNamesMin: ["日", "一", "二", "三", "四", "五", "六"],
            monthNames: ["一月", "二月", "三月", "四月", "五月", "六月", "七月", "八月", "九月", "十月", "十一月", "十二月"],
            showMonthAfterYear: true,
            prevText: "上月",
            nextText: "下月",
        });
        $("#datepicker2").mouseover(function() {
            var mytime = $("#datepicker1").datepicker("getDate");
            $("#datepicker2").datepicker("option", "minDate", CurrentTime(mytime));
        });
    });

    function CurrentTime(now) {
        var year = now.getFullYear();
        var month = now.getMonth() + 1;
        var lastDay = getDaysInMonth(year, month);
        var day = now.getDate();
        if (day === lastDay) {
            day = 1;
            if (month === 12) {
                month = 1;
                year += 1;
            } else {
                month += 1;
            }
        } else {
            day += 1;
        }
        var hh = now.getHours();
        var mm = now.getMinutes();
        var clock = year + "-";
        if (month < 10)
            clock += "0";
        clock += month + "-";
        if (day < 10)
            clock += "0";
        clock += day + " ";
        if (hh < 10)
            clock += "0";
        clock += hh + ":";
        if (mm < 10) clock += '0';
        clock += mm;
        return clock;
    }

    function getDaysInMonth(year, month) {
        var temp = new Date(year, month, 0);
        return temp.getDate();

    }
