package com.teamone.easybuy.controlers;

import com.teamone.easybuy.entities.Goods;
import com.teamone.easybuy.services.GoodsService;
import javafx.application.Application;

import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.Part;
import java.io.File;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;
import java.util.UUID;

@WebServlet("/productAddServlet")
@MultipartConfig()
public class ProductAddServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
    doGet(request,response);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("utf-8");
        response.setContentType("text/html;charset=utf-8");
        Part part=request.getPart("photo");
        String name=request.getParameter("productName");
        String productDetail=request.getParameter("productDetail");
        String parentId=request.getParameter("parentId");
        String productPrice=request.getParameter("productPrice");
        String productNumber=request.getParameter("productNumber");
        String uuid=UUID.randomUUID().toString().replaceAll("-","");
        String type=part.getSubmittedFileName().substring(part.getSubmittedFileName().lastIndexOf("."));
        String path="/media/";
        //part.write("d:/myimg/"+uuid+type);
        part.write(path+uuid+type);
        GoodsService goodsService=new GoodsService();
        Goods goods=new Goods(name,productDetail,Double.parseDouble(productPrice),Integer.parseInt(productNumber),"http://45.89.229.247:8080/img/"+uuid+type,Integer.parseInt(parentId));
        try {
            if(goodsService.addGoods(goods)){
                response.sendRedirect("manage/manage-result.jsp");
            }else {
                response.sendRedirect("manage/product-add.jsp");
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
