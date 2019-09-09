package com.teamone.easybuy.controlers;

import com.google.gson.Gson;
import com.teamone.easybuy.entities.Cart_Goods;
import com.teamone.easybuy.services.CartService;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.SQLException;
import java.util.List;

@WebServlet("/cartInfoServlet")
public class CartInfoServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("utf-8");
        response.setContentType("text/html;charset=utf-8");
        int id=Integer.parseInt(request.getParameter("userId"));
        CartService cartService=new CartService();
        try {
            List<Cart_Goods> cart_goods=cartService.CartGoodsInfo(id);
            Gson gson=new Gson();
            response.getWriter().println(gson.toJson(cart_goods));
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doPost(request,response);
    }
}
