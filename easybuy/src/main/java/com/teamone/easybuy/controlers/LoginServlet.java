package com.teamone.easybuy.controlers;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

@WebServlet("/loginServlet")
public class LoginServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
    request.setCharacterEncoding("utf-8");
    response.setContentType("text/html;charset=utf-8");
    HttpSession session = request.getSession();
    String code=(String)session.getAttribute("rand");
    String myCode=request.getParameter("myCode");
    String name=request.getParameter("name");
    String password=request.getParameter("pwd");
        System.out.println("code"+code);
        System.out.println("mycode"+myCode);
    if(code.equals(myCode)){
        response.getWriter().println("welcome   "+name+" "+password);
    }else{
        response.getWriter().println("error");
    }
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
    doPost(request,response);
    }
}
