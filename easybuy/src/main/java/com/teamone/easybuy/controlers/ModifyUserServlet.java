package com.teamone.easybuy.controlers;

import com.teamone.easybuy.entities.User;
import com.teamone.easybuy.services.UserService;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.SQLException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

@WebServlet("/modifyUserServlet")
public class ModifyUserServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doGet(request,response);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("utf-8");
        response.setContentType("text/html;charset=utf-8");
        int id=Integer.parseInt(request.getParameter("id"));
        String name=request.getParameter("userName");
        String realname=request.getParameter("name");
        String passWord=request.getParameter("passWord");
        String sex=request.getParameter("sex");
        SimpleDateFormat simpleDateFormat=new SimpleDateFormat("yyyy-MM-dd");
        Date Ubirthday=null;
        try {
            Ubirthday=simpleDateFormat.parse(simpleDateFormat.format(simpleDateFormat.parse(request.getParameter("date"))));
        } catch (ParseException e) {
            e.printStackTrace();
        }
        String phone=request.getParameter("mobile");
        String address=request.getParameter("address");
        UserService userService=new UserService();
        try {
            if(userService.updateUser(new User(id,name,realname,passWord,sex,Ubirthday,phone,address))){
                response.sendRedirect("manage/manage-result.jsp");
            } else {
                request.setAttribute("error","修改失败");
                request.getRequestDispatcher("manage/user-modify.jsp").forward(request,response);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
