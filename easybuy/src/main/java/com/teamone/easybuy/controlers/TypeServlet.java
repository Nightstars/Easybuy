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

@WebServlet("/typeServlet")
public class TypeServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
    doGet(request,response);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("utf-8");
        response.setContentType("text/html;charset=utf-8");
        TypeService typeService=new TypeService();
        List<Type> parTypeList = null;
        List<Type> childTypeList = null;
        try {
            parTypeList=typeService.parTypeList();
        } catch (SQLException e) {
            e.printStackTrace();
        };
        String[] parList=new String[parTypeList.size()];
        //String[] childList=new String[childTypeList.size()];
        for(int i=0;i<parTypeList.size();i++){
            parList[i]= parTypeList.get(i).getName();
            //response.getWriter().println(parList[i]);
        }
        Gson gson = new Gson();
        String jsonParList=gson.toJson(parList);
        response.getWriter().println(jsonParList);
//        for(int j=0;j<childTypeList.size();j++){
//            childList[j]= childTypeList.get(j).getName();
//            response.getWriter().println(childList[j]);
//        }
    }
}
