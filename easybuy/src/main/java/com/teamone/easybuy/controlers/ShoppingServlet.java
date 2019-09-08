package com.teamone.easybuy.controlers;

import com.teamone.easybuy.entities.OrderDetail;
import com.teamone.easybuy.entities.OrderList;
import com.teamone.easybuy.services.OrderService;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.util.Date;

@WebServlet("/shoppingServlet")
public class ShoppingServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doGet(request,response);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("utf-8");
        response.setContentType("text/html;charset=utf-8");
        String id=request.getParameter("id");
        String price=request.getParameter("price");
        String userId=request.getParameter("userId");
        OrderService orderService=new OrderService();
        OrderList orderList=new OrderList(0,new SimpleDateFormat("yyyyMMddHHmmss").format(new Date())+System.currentTimeMillis(),Integer.parseInt(userId),new Date());
        OrderDetail orderDetail=new OrderDetail(0,Integer.parseInt(id),1,Double.parseDouble(price),0);
        try {
            if(orderService.createOrder(orderList,orderDetail)){
                response.sendRedirect("shopping-result.jsp");
            }else{
                response.sendRedirect("index.jsp");
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
