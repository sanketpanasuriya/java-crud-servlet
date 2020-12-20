/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

import DAO.UsersDAO;
import Pojo.Users;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author shani
 */
@WebServlet(urlPatterns = {"/NewUserServlet"})
public class NewUserServlet extends HttpServlet {

    /**
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code>
     * methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
     protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException, ClassNotFoundException, SQLException {
        response.setContentType("text/html;charset=UTF-8");
        try (PrintWriter out = response.getWriter()) {
           String sid=request.getParameter("id"); 
           int id=Integer.parseInt(sid);  
           if(id == 0){
                //step-1fetching value
                String user = request.getParameter("user");
                String address = request.getParameter("address");
                String SAge = request.getParameter("age");
                String gender = request.getParameter("gender");
                int age=Integer.parseInt(SAge); 
                //out.println("Name:"+user+"<br>");
                //out.println("Address:"+address+"<br>");
                //out.println("Age:"+age+"<br>");
                //out.println("Gender:"+gender+"<br>");

                //step-2 Create pojo class object
                Users obj = new Users(user,address,age,gender);
                //insert(user,address,age,gender);

                int status = UsersDAO.insert(obj);
                if(status>0){  
                    out.print("<p>Record saved successfully!</p>");  
                    request.getRequestDispatcher("index.html").include(request, response);  
                }else{  
                    out.println("Sorry! unable to save record");  
                }  
                //step-3 Call DAO Method
                //UsersDAO.insert(obj);
                //UsersDAO.update(obj);
                //UsersDAO.delete(obj);
           }
           else{
                String user = request.getParameter("user");
                String address = request.getParameter("address");
                String SAge = request.getParameter("age");
                String gender = request.getParameter("gender");
                int age=Integer.parseInt(SAge); 
                out.println("Name:"+user+"<br>");
                out.println("Address:"+address+"<br>");
                out.println("Age:"+age+"<br>");
                out.println("Gender:"+gender+"<br>");

                //step-2 Create pojo class object
                Users obj = new Users(id,user,address,age,gender);
                //insert(user,address,age,gender);

                int status = UsersDAO.update(obj);
                if(status>0){  
                    out.print("<p>Record Updated successfully!</p>");  
                    response.sendRedirect("ViewServlet");  
                }else{  
                    out.println("Sorry! unable to save record");  
                }  
                //step-3 Call DAO Method
                //UsersDAO.insert(obj);
                //UsersDAO.update(obj);
                //UsersDAO.delete(obj);
           }
        }
    }
    // <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
    /**
     * Handles the HTTP <code>GET</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        try {
            processRequest(request, response);
        } catch (ClassNotFoundException | SQLException ex) {
            Logger.getLogger(NewUserServlet.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    /**
     * Handles the HTTP <code>POST</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        try {
            processRequest(request, response);
        } catch (ClassNotFoundException | SQLException ex) {
            Logger.getLogger(NewUserServlet.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

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