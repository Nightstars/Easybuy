$(document).ready(function () {
   $.ajax({
      url:"typeServlet",
      type:"post",
      dataType:"json",
      success:function (result) {
         //var arr=JSON.parse(result);

      }
   });
});

