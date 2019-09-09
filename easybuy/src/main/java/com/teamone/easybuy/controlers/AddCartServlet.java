package com.teamone.easybuy.controlers;

import com.teamone.easybuy.entities.Cart;
import com.teamone.easybuy.services.CartService;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.SQLException;

@WebServlet("/addCartServlet")
public class AddCartServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doGet(request,response);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("utf-8");
        response.setContentType("text/html;charset=utf-8");
        int goodsId=Integer.parseInt(request.getParameter("goodsId"));
        int UserId=Integer.parseInt(request.getParameter("userId"));
        CartService cartService=new CartService();
        Cart cart=new Cart(0,goodsId,1,UserId);
        try {
            if(cartService.addCart(cart)){
                response.sendRedirect("shopping.jsp");
            }else{
                response.sendRedirect("index.jsp");
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
