
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
               "<td class="+"\"first w4 c\""+">"+value.username+"</td>"
               +"<td class="+"\"w1 c\""+">"+value.realname+"</td>"
               +"<td class="+"\"w2 c\""+">"+value.sex+"</td>"
               +"<td>"+value.email+"</td>"
               +"<td class="+"\"w4 c\""+">"+value.phone+"</td>"
               +"<td class="+"\"w1 c\""+">"+"<a href="+"\"../serInfoServlet?id="+value.id+"\""+">修改</a> <a class="+"manageDel"+" "+"onclick="+"\"return window.confirm('这条记录将被删除且不可恢复，确认删除吗？')\""+
               " "+"href="+"\"../deleteUserServlet?id="+value.id+"\""+">删除</a>"+"</td>"
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
               "<tr> <td class="+"\"first w4 c\""+"align="+"\"center\""+">"+value.id+"</td>"
                   +"<td><b>"+value.name+"</b></td>"
                   +"<td class="+"\"w1 c\""+">"+"<a href="+"productClass-modify.jsp?name="+value.name+"&id="+value.id+
                   ">修改</a> <a class="+"manageDel"+" "+"onclick="+"\"return window.confirm('这条记录将被删除且不可恢复，确认删除吗？')\""+
                   " "+"href="+"\"../deleteProcudctClassServlet?id="+value.id+"&isPar=true"+"\""+">删除</a>"+"</td>"
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
                            "<tr> <td class="+"\"first w4 c\""+"align="+"\"center\""+">"+value1.id+"</td>"
                            +"<td class="+"childClass"+">"+value1.name+"</td>"
                            +"<td class="+"\"w1 c\""+">"+"<a href="+"productClass-modify.jsp?name="+value1.name+"&id="+value1.id+
                            ">修改</a> <a class="+"manageDel"+" "+"onclick="+"\"return window.confirm('这条记录将被删除且不可恢复，确认删除吗？')\""
                            +" "+"href="+"" +
                            "\"../deleteProcudctClassServlet?id="+value1.id+"&isPar=false"+"\""+">删除</a>"+"</td>"
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
function showParentId_productClass_modify() {
    $(function () {
        $.ajax({
            url:"/easybuy/perTypeServlet",
            type:"post",
            dataType:"json",
            success:function (result) {
                $.each(result,function (index,value) {
                    $("#parentId_productClass_modify").append("<option value="+value.id+">"+value.name+"</option>");
                });
            }
        });
    });
}