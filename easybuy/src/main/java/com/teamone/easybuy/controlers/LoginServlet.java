package com.teamone.easybuy.controlers;

import com.teamone.easybuy.services.EasybuyServices;
import com.teamone.easybuy.services.UserService;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.sql.SQLException;

@WebServlet("/loginServlet")
public class LoginServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
    request.setCharacterEncoding("utf-8");
    response.setContentType("text/html;charset=utf-8");
    HttpSession session = request.getSession();
    String code=(String)session.getAttribute("rand");
    String myCode=request.getParameter("code");
    String name=request.getParameter("userId");
    String password=request.getParameter("password");
    EasybuyServices easybuyServices=new EasybuyServices();
    UserService userService=new UserService();
    if(code.equals(myCode)){
        try {
            if(easybuyServices.login(name,password)){
                session.setAttribute("name",name);
                session.setAttribute("id",userService.getUserId(name,password));
                request.getRequestDispatcher("index.jsp").forward(request,response);
            }else {
                request.setAttribute("errorinfo","用户名或密码错误");
                request.getRequestDispatcher("login.jsp").forward(request,response);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }else{
        request.setAttribute("errorinfo","验证码错误");
        request.getRequestDispatcher("login.jsp").forward(request,response);
    }
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
    doPost(request,response);
    }
}
