package com.teamone.easybuy.controlers;

import com.teamone.easybuy.services.UserService;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.SQLException;

@WebServlet("/deleteUserServlet")
public class DeleteUserServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doGet(request,response);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("utf-8");
        response.setContentType("text/html;charset=utf-8");
        int id=Integer.parseInt(request.getParameter("id"));
        UserService userService=new UserService();
        try {
            if(userService.deleteUser(id)){
                response.sendRedirect("manage/manage-result.jsp");
            }else {
                response.sendRedirect("manage/user.jsp");
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
