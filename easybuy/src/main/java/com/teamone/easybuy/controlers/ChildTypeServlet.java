package com.teamone.easybuy.controlers;

import com.google.gson.Gson;
import com.teamone.easybuy.entities.Type;
import com.teamone.easybuy.services.TypeService;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.SQLException;
import java.util.List;

@WebServlet("/childTypeServlet")
public class ChildTypeServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
    doGet(request,response);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("utf-8");
        response.setContentType("text/html;charset=utf-8");
        TypeService typeService=new TypeService();
        int id=Integer.parseInt(request.getParameter("id"));
        try {
            List<Type> childTypeList =typeService.childTypeList(id);
            Gson gson=new Gson();
            String jsonArray=gson.toJson(childTypeList);
            response.getWriter().println(jsonArray);
        } catch (SQLException e) {
            e.printStackTrace();
        };
    }
}
