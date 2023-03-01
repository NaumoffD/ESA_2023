package com.example.lab_1_naumov_zelyaev.servlets.animals;

import com.example.lab_1_naumov_zelyaev.bean.OwnerBean;
import com.example.lab_1_naumov_zelyaev.bean.AnimalBean;
import com.example.lab_1_naumov_zelyaev.entity.Animal;
import com.example.lab_1_naumov_zelyaev.entity.Owner;
import jakarta.ejb.EJB;
import jakarta.servlet.*;
import jakarta.servlet.http.*;
import jakarta.servlet.annotation.*;

import java.io.IOException;
import java.util.List;

@WebServlet(name = "AnimalAddEditServlet", value = "/AnimalEdit")
public class AnimalAddEditServlet extends HttpServlet {

    @EJB
    private AnimalBean animalBean;

    @EJB
    private OwnerBean ownerBean;
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("text/html");
        request.setCharacterEncoding("UTF-8");

        List<Owner> allInfo = ownerBean.getAll();

        request.setAttribute("owners", allInfo);

        if(request.getParameter("chipId") != null){
            request.setAttribute("namePage", "Редактирование");
            Long chipId = Long.valueOf(request.getParameter("chipId"));
            Animal animal = animalBean.get(chipId);

            request.setAttribute("animal", animal);
        }
        else
            request.setAttribute("namePage", "Добавление");
        request.getRequestDispatcher("/animalEdit.jsp").forward(request,response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("text/html");
        request.setCharacterEncoding("UTF-8");

        String name = request.getParameter("name");
        String sex = request.getParameter("sex");
        String color = request.getParameter("color");
        String breed = request.getParameter("breed");
        Owner owner;
        if (request.getParameter("owner").equals("null"))
            owner = null;
        else
            owner = ownerBean.get(Long.parseLong(request.getParameter("owner")));

        if (!request.getParameter("chipId").equals("")){

            long animalId = Long.valueOf(request.getParameter("chipId"));
            Animal animal = animalBean.get(animalId);
            animal.setName(name);
            animal.setSex(sex);
            animal.setColor(color);
            animal.setBreed(breed);
            if (owner != null){
                owner.addAnimal(animal);
                ownerBean.update(owner);
            }
            else{
                Owner oldOwner = animal.getOwner();
                if (oldOwner != null){
                    oldOwner.removeAnimal(animal);
                    ownerBean.update(oldOwner);
                }
            }
            animalBean.update(animal);
        }
        else{
            animalBean.add(new Animal(name,sex,color,breed, owner));
        }
        ServletContext servletContext = getServletContext();
        response.sendRedirect(request.getContextPath() + "/index");
    }
}
