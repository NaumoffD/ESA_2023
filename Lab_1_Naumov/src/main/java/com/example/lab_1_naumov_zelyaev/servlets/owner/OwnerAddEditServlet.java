package com.example.lab_1_naumov_zelyaev.servlets.owner;

import com.example.lab_1_naumov_zelyaev.bean.OwnerBean;
import com.example.lab_1_naumov_zelyaev.bean.AnimalBean;
import com.example.lab_1_naumov_zelyaev.entity.Owner;
import jakarta.servlet.ServletContext;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import jakarta.ejb.EJB;
import java.io.IOException;

@WebServlet(name = "AddAndEditServlet", value = "/OwnerEdit")
public class OwnerAddEditServlet extends HttpServlet {


    @EJB
    private AnimalBean animalBean;
    @EJB
    private OwnerBean ownerBean;
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("text/html");
        request.setCharacterEncoding("UTF-8");



        if(request.getParameter("ownerId") != null){
            request.setAttribute("namePage", "Редактирование");
            long animalOwnerId = Long.valueOf(request.getParameter("ownerId"));
            Owner owner = ownerBean.get(animalOwnerId);

            request.setAttribute("owner", owner);
        }
        else
            request.setAttribute("namePage", "Добавление");
        request.getRequestDispatcher("/ownerEdit.jsp").forward(request,response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("text/html");
        request.setCharacterEncoding("UTF-8");

        String firstName = request.getParameter("firstName");
        String surname = request.getParameter("surname");
        String patronymic = request.getParameter("patronymic");
        String phoneNumber = request.getParameter("phoneNumber");
        String address = request.getParameter("address");



        if (!request.getParameter("ownerId").equals("")){

            long animalOwnerId = Long.valueOf(request.getParameter("ownerId"));
            Owner owner = ownerBean.get(animalOwnerId);
            owner.setFirstName(firstName);
            owner.setSurname(surname);
            owner.setPatronymic(patronymic);
            owner.setPhoneNumber(phoneNumber);
            owner.setAddress(address);


            ownerBean.update(owner);
        }else{
            ownerBean.add(new Owner(firstName,surname,patronymic,phoneNumber,address));
        }
        ServletContext servletContext = getServletContext();
        response.sendRedirect(request.getContextPath() + "/index");
    }
}
