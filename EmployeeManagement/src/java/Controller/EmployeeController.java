package Controller;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

import Models.Tblemployee;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.Persistence;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author Loki Kun
 */
public class EmployeeController extends HttpServlet {
 
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
            EntityManager em = Persistence.createEntityManagerFactory("EmployeeManagementPU").createEntityManager();
            
            List<Tblemployee> list = em.createNamedQuery("Tblemployee.findAll", Tblemployee.class).getResultList();
            
            request.setAttribute("EmployeeList", list);
            
            request.getRequestDispatcher("/employee/display.jsp").forward(request, response);
    }
   
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        
    }

  
    @Override
    public String getServletInfo() {
        return "Short description";
    }

}
