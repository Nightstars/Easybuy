package com.teamone.easybuy.controlers;

import com.google.gson.Gson;
import com.teamone.easybuy.entities.Goods;
import com.teamone.easybuy.services.GoodsService;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.SQLException;
import java.util.List;

@WebServlet("/indexShowGoodsServlet")
public class IndexShowGoodsServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doGet(request,response);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("utf-8");
        response.setContentType("text/html;charset=utf-8");
        GoodsService goodsService=new GoodsService();
        try {
            List<Goods> goodsList=goodsService.selectGoods();
            Gson gson=new Gson();
            response.getWriter().println(gson.toJson(goodsList));
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
