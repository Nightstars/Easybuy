
function show(){
   $(function () {
      $.ajax({
         url:"perTypeServlet",
         type:"post",
         dataType:"json",
         success:function (result) {
            $.each(result,function (index,value) {
               $("#tpyeLisit").append("<dt>"+value.name+"</dt>");
               $.ajax({
                  async:false,
                  url:"childTypeServlet",
                  type:"post",
                  data:"id="+value.id,
                  dataType:"json",
                  success:function (result1) {
                     $.each(result1,function (index1,value1) {
                        $("#tpyeLisit").append("<dd>"+"<a href="+"product-list.jsp"+">"+value1.name+"</a>"+"</dd>");
                     });
                  }
               });
            });
         }
      });
   });
}
function showUser() {
   $(function () {
     $.ajax({
        url:"/easybuy/userServlet",
        type:"post",
        dataType:"json",
        success:function (result) {
           $.each(result,function (index,value) {
           $("#user-userList").append(
               "<tr>" +
               "<td class="+"first w4 c"+">"+value.username+"</td>"
               +"<td class="+"w1 c"+">"+value.realname+"</td>"
               +"<td class="+"w2 c"+">"+value.sex+"</td>"
               +"<td>"+value.email+"</td>"
               +"<td class="+"w4 c"+">"+value.phone+"</td>"
               +"<td class="+"w1 c"+">"+"<a href="+"user-modify.jsp"+">修改</a> <a class="+"manageDel"+" href="+"javascript:void(0)"+">删除</a>"+"</td>"
               + "</tr>"
           );
        });
        }
     });
   });
}
function showGoodsType(){
   $(function () {
      $.ajax({
         url:"/easybuy/perTypeServlet",
         type:"post",
         dataType:"json",
         success:function (result) {
            $.each(result,function (index,value) {
               $("#goodsType").append(
               "<tr> <td class="+"first w4 c"+"align="+"\""+"center"+"\""+">"+value.id+"</td>"
                   +"<td>"+value.name+"</td>"
                   +"<td class="+"w1 c"+"><a href="+"productClass-modify.jsp"+">修改</a> <a class="+"manageDel"+ "href="+"javascript:void(0)"+">删除</a></td>"
               +"</tr>"
                   );
               $.ajax({
                  async:false,
                  url:"/easybuy/childTypeServlet",
                  type:"post",
                  data:"id="+value.id,
                  dataType:"json",
                  success:function (result1) {
                     $.each(result1,function (index1,value1) {
                        //$("#tpyeLisit").append("<dd>"+value1.name+"</dd>");
                        $("#goodsType").append(
                            "<tr> <td class="+"first w4 c"+">"+value1.id+"</td>"
                            +"<td class="+"childClass"+">"+value1.name+"</td>"
                            +"<td class="+"w1 c"+"><a href="+"productClass-modify.jsp?name="+value1.name+">修改</a> <a class="+"manageDel"+ "href="+"javascript:void(0)"+">删除</a></td>"
                            +"</tr>"
                     );
                     });
                  }
               });
            });
         }
      });
   });
}
function showParentId() {
    $(function () {
        $.ajax({
            url:"/easybuy/perTypeServlet",
            type:"post",
            dataType:"json",
            success:function (result) {
                $.each(result,function (index,value) {
                    $("#parentId").append("<option value="+value.id+">"+value.name+"</option>");
                });
            }
        });
    });
}