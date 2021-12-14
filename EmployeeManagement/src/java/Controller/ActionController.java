/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controller;

import Models.Tblemployee;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
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
public class ActionController extends HttpServlet {

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        RequestDispatcher dispatcher = getServletContext().getRequestDispatcher("/employee/action.jsp");
        dispatcher.forward(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String employeeNo = request.getParameter("employeeNo");
       
        EntityManager em = Persistence.createEntityManagerFactory("EmployeeManagementPU").createEntityManager();

        List<Tblemployee> list = em.createNamedQuery("Tblemployee.findByEmployeeNo", Tblemployee.class).setParameter("employeeNo", employeeNo).getResultList();

        Map<String, String> errors = new HashMap<String, String>();
        if (list.size() > 0) {
            errors.put("Name", "This employee is existed, please try other!!");
            request.setAttribute("errors", errors);
            request.getRequestDispatcher("/employee/action.jsp").forward(request, response);
        } else {
            Tblemployee employee = new Tblemployee();
            employee.setEmployeeNo(employeeNo);
            employee.setEmployeeName(request.getParameter("name").toString());
            employee.setPlaceOfWork(request.getParameter("place").toString());
            employee.setPhoneNo(request.getParameter("phone").toString());

            em.getTransaction().begin();
            em.persist(employee);
            em.getTransaction().commit();
            
            response.sendRedirect("/EmployeeManagement/employee-list");
        }

        
    }
//    public static boolean validateName(String no, String name, String place, String phone )
//    {
//       
//        return ;
//    }

    /**
     * Returns a short description of the servlet.
     *
     * @return a String containing servlet description
     */
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
