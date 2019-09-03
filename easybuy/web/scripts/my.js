$(function () {
    $("#submitBtn").click(function () {
        $.ajax({
            url:"loginServlet",
            type:"post",
            data:"name="+$("#userId").val()+"&pwd="+$("#password").val()+"&myCode="+$("#code").val(),
            success:function (result) {
               alert(result);
            }
        });
    });
});