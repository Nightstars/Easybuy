$(document).ready(function () {
   $.ajax({
      url:"typeServlet",
      type:"post",
      success:function (result) {
         alert(result);
      }
   });
});

