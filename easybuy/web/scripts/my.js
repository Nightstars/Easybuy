
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
function showParentId_productAdd() {
    $(function () {
        $.ajax({
            url:"/easybuy/perTypeServlet",
            type:"post",
            dataType:"json",
            success:function (result) {
                $.each(result,function (index,value) {
                    $.ajax({
                        async:false,
                        url:"/easybuy/childTypeServlet",
                        type:"post",
                        data:"id="+value.id,
                        dataType:"json",
                        success:function (result1) {
                            $.each(result1,function (index1,value1) {
                                $("#classNameProductAdd").append("<option value="+"\""+value1.id+"\""+">"+value1.name+"</option>");
                            });
                        }
                    });
                });
            }
        });
    });
}
function showgoods_product() {
    $(function () {
        $.ajax({
            url:"/easybuy/goodsInfoServlet",
            type:"post",
            dataType:"json",
            success:function (result) {
                $.each(result,function (index,value) {
                    $("#goodsList").append(
                        "<tr> <td class="+"\"first w4 c"+"\""+">"+value.id+"" +
                        "</td> <td class="+"\"thumb"+"\""+"><img src="+"\""+value.imgurl+"\""+"width=\"20\""+"><a href="+"\"../product-view.jsp?name="+value.name+"&img="+value.imgurl+"&price="+value.price+"&num="+value.goodsNum+"&desc="+value.detail+"&id="+value.id+"\" "+"target="+"\"_self"+"\""+">"+value.name+"</a></td>"+
                        "<td class="+"\"w1 c"+"\""+"><a href="+"\"product-modify.jsp"+"\""+">修改</a> <a class="+"\"manageDel"+"\" "+" "+"onclick="+"\"return window.confirm('这条记录将被删除且不可恢复，确认删除吗？')\""+
                        " "+"href="+"\"../deleteGoodsServlet?id="+value.id+"\""+">删除</a></td> </tr>"
                    );
                });
            }
        });
    });
}
function showAddress_address() {
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
function showCart_shopping() {
    $(function () {
        $.ajax({
            url:"/easybuy/cartInfoServlet",
            type:"post",
            data:"userId="+$("#userId").val(),
            dataType:"json",
            success:function (result) {
                $.each(result,function (index,value) {
                    $("#showCartInfo").append(
                    "<tr id="+"\"product_id_"+index+"\""+">"+
                        "<td class="+"\"thumb"+"\""+"><img src="+"\""+value.imgurl+"\""+" "+"width=\"55\""+" /><a href="+"\"product-view.jsp\""+">"+value.name+"</a></td>"+
                    "<td class="+"\"price"+"\" "+"id="+"\"price_id_"+index+"\""+">"+
                        "<span>￥"+value.price+"</span>"+
                    "<input type="+"\"hidden\""+" "+"value="+"\"99\""+" />"+
                        "</td>"+
                        "<td class="+"\"number\""+">"+
                        "<span name="+"\"del\""+">-</span>"+
                        "<input id="+"\"number_id_"+index+"\""+" type="+"\"text\""+" "+"name="+"\"number\""+" "+"value="+"\"1\""+" />"+
                        "<span name="+"\"add\""+">+</span>"+
                        "</td>"+
                        "<td class="+"\"delete\""+"><a href="+"\"javascript:void(0)\""+">删除</a></td>"+
                    "</tr>"
                    );
                });
            }
        });
    });
}
function showGoodsIndex() {
    $(function () {
        $.ajax({
            url:"/easybuy/indexShowGoodsServlet",
            type:"post",
            dataType:"json",
            success:function (result) {
                $.each(result,function (index,value) {
                    $("#showGoodsIndex").append(
                    "<li><dl>"+
                    "<dt><a href="+"\"product-view.jsp?name="+value.name+"&img="+value.imgurl+"&price="+value.price+"&num="+value.goodsNum+"&desc="+value.detail+"&id="+value.id+"\" "+"target="+"\"_self\""+"><img src="+value.imgurl+" /></a></dt>"+
                    "<dd class="+"\"title\""+"><a href="+"\"product-view.jsp?name="+value.name+"&img="+value.imgurl+"&price="+value.price+"&num="+value.goodsNum+"&desc="+value.detail+"&id="+value.id+"\" "+" target="+"\"_self\""+">"+value.name+"</a></dd>"+
                    "<dd class="+"\"price\""+">"+"￥"+value.price+"</dd>"+
                    "</dl></li>"
                    );
                });
            }
        });
    });
}
function showGoodsProductList() {
    $(function () {
        $.ajax({
            url:"/easybuy/indexShowGoodsServlet",
            type:"post",
            dataType:"json",
            success:function (result) {
                $.each(result,function (index,value) {
                    $("#showGoodsProductList").append(
                        "<li><dl>"+
                        "<dt><a href="+"\"product-view.jsp?name="+value.name+"&img="+value.imgurl+"&price="+value.price+"&num="+value.goodsNum+"&desc="+value.detail+"&id="+value.id+"\" "+"target="+"\"_self\""+"><img src="+value.imgurl+" /></a></dt>"+
                        "<dd class="+"\"title\""+"><a href="+"\"product-view.jsp?name="+value.name+"&img="+value.imgurl+"&price="+value.price+"&num="+value.goodsNum+"&desc="+value.detail+"&id="+value.id+"\" "+" target="+"\"_self\""+">"+value.name+"</a></dd>"+
                        "<dd class="+"\"price\""+">"+"￥"+value.price+"</dd>"+
                        "</dl></li>"
                    );
                });
            }
        });
    });
}