package com.teamone.easybuy.controlers;

import com.teamone.easybuy.entities.Address;
import com.teamone.easybuy.services.AddressService;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.SQLException;

@WebServlet("/addAddressServlet")
public class AddAddressServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("utf-8");
        response.setContentType("text/html;charset=utf-8");
        String name=request.getParameter("name");
        String id=request.getParameter("id");
        AddressService addressService=new AddressService();
        try {
            if(addressService.addAddress(new Address(0,name,Integer.parseInt(id)))){
                response.getWriter().println("ok");
            }else{
                response.getWriter().println("error");
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doPost(request,response);
    }
}
