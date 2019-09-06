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

@WebServlet("/modifyServlet")
public class ModifyServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
    doGet(request,response);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("utf-8");
        response.setContentType("text/html;charset=utf-8");
        String id=request.getParameter("id");
        String name=request.getParameter("className");
        String pid=request.getParameter("parentId");
        ProductTypeServices productTypeServices=new ProductTypeServices();
        try {
            if(productTypeServices.updateProductType(new Type(Integer.parseInt(id),name,Integer.parseInt(pid)))){
                response.sendRedirect("manage/manage-result.jsp");
            }else{
                response.sendRedirect("manage/productClass.jsp");
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

    }
}
