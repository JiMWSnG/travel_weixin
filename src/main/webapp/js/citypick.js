   $(function() {
       function fn2(city) {
           $("#destination").val(city);
       }

       $("#destination").click(function() {
           $('#mengban2').css('display', 'block');
           citypicker.show({
               selected: fn2
           });
       });
       
       $("#mengban2").click(function() {
           $("#div_select_city_sub_menu").hide();
           $("#ui-datepicker-div").hide();
           $("#mengban2").css("display", "none");
       });
   });
