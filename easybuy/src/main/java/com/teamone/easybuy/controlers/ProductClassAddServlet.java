package com.teamone.easybuy.controlers;

import com.teamone.easybuy.entities.Type;
import com.teamone.easybuy.services.ProductTypeServices;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.SQLException;

@WebServlet("/productClassAddServlet")
public class ProductClassAddServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
    doGet(request,response);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("utf-8");
        response.setContentType("text/html;charset=utf-8");
        String parentId=request.getParameter("parentId");
        String name=request.getParameter("className");
        ProductTypeServices productTypeServices=new ProductTypeServices();
        Type type=new Type(name,Integer.parseInt(parentId));
        if("0".equals(parentId)){
            try {
                if(productTypeServices.addParProductName(type)){
                    response.sendRedirect("/easybuy//manage/manage-result.jsp");
                }else {
                    response.sendRedirect("/easybuy//manage/productClass-add.jsp");
                }
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }else {
            try {
                if(productTypeServices.addChildProductName(type)){
                    response.sendRedirect("/easybuy//manage/manage-result.jsp");
                }else {
                    response.sendRedirect("/easybuy//manage/productClass-add.jsp");
                }
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }
}
