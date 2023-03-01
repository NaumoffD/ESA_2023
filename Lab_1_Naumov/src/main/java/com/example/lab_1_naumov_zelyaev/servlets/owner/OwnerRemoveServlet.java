package com.example.lab_1_naumov_zelyaev.servlets.owner;

import com.example.lab_1_naumov_zelyaev.bean.OwnerBean;
import jakarta.servlet.ServletContext;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import jakarta.ejb.EJB;
import java.io.IOException;



@WebServlet(name = "OwnerRemoveServlet", value = "/OwnerRemove")
public class OwnerRemoveServlet extends HttpServlet {

    @EJB
    private OwnerBean ownerBean;

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("text/html");
        request.setCharacterEncoding("UTF-8");



        if(request.getParameter("ownerId") != null){
            request.setAttribute("namePage", "Удаление");
            long animalOwnerId = Long.valueOf(request.getParameter("ownerId"));
            ownerBean.delete(animalOwnerId);
        }
        else
            request.setAttribute("namePage", "Error 404");
        ServletContext servletContext = getServletContext();
        //RequestDispatcher requestDispatcher = servletContext.getRequestDispatcher("/index");
        response.sendRedirect(request.getContextPath() + "/index");
        //requestDispatcher.forward(request,response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
}
