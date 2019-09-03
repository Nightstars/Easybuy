package com.teamone.easybuy.controlers;

import com.teamone.easybuy.entities.User;
import com.teamone.easybuy.services.EasybuyServices;

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

@WebServlet("/registServlet")
public class RegistServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
    request.setCharacterEncoding("utf-8");
    response.setContentType("text/html;charset=utf-8");
    String userId=request.getParameter("userId");
    String userName=request.getParameter("userName");
    String password=request.getParameter("password");
    String confirmPassword=request.getParameter("confirmPassword");
    String sex=request.getParameter("sex");
    String birthday=request.getParameter("birthday");
    String identityCode=request.getParameter("identityCode");
    String email=request.getParameter("email");
    String mobile=request.getParameter("mobile");
    String address=request.getParameter("address");
    SimpleDateFormat simpleDateFormat=new SimpleDateFormat("yyyy-MM-dd");
    Date Ubirthday=null;
        try {
            Ubirthday=simpleDateFormat.parse(simpleDateFormat.format(simpleDateFormat.parse(birthday)));
        } catch (ParseException e) {
            e.printStackTrace();
        }
        User user=new User(userId,userName,password,sex,Ubirthday,identityCode,email,mobile,address);
        EasybuyServices easybuyServices=new EasybuyServices();
        try {
            if(easybuyServices.regist(user)){
                response.sendRedirect("reg-result.jsp");
            }else {
                response.sendRedirect("register.jsp");
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
    doPost(request,response);
    }
}
