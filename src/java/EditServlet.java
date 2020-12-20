/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

import DAO.UsersDAO;
import Pojo.Users;
import java.io.IOException;
import java.io.PrintWriter;
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
 * @author Dell
 */
@WebServlet(urlPatterns = {"/EditServlet"})
public class EditServlet extends HttpServlet {

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

            Users e=UsersDAO.getUserById(id);  
            out.print("<head>\n" +
    "        <title>Update User</title>\n" +
    "        <meta charset=\"utf-8\">\n" +
    "           <meta name=\"viewport\" content=\"width=device-width, initial-scale=1\">\n" +
    "		<link rel=\"stylesheet\" href=\"https://maxcdn.bootstrapcdn.com/bootstrap/4.4.1/css/bootstrap.min.css\">\n" +
    "		<script src=\"https://ajax.googleapis.com/ajax/libs/jquery/3.4.1/jquery.min.js\"></script>\n" +
    "       </head>");
            out.print("<h1 class=\"row justify-content-center text-secondary\"><b>Update User</b></h1>");  
            out.print("<div class=\"container\">");
            out.print("<form action='NewUserServlet' method='post' class=\"row justify-content-center\">");  
            out.print("<table>");  
            out.print("<tr><td></td><td><input type='hidden' name='id' value='"+e.getID()+"'/></td></tr>");  
            out.print("<tr><td><b>Name:</b></td><td><input type='text' name='user' value='"+e.getUser()+"'/></td></tr>");  
            out.print("<tr><td><b>Address:</b></td><td><input type='text' name='address' value='"+e.getAddress()+"'/></td></tr>");  
            out.print("<tr><td><b>Age:</b></td><td><input type='text' name='age' value='"+e.getAge()+"'/></td></tr>");  
            out.print("<tr><td><b>Gender:</b></td><td><input type='text' name='gender' value='"+e.getGender()+"'/></td></tr>"); 
            
            out.print("</td></tr>");  
            out.print("<tr><td colspan='2'><input type='submit' class=\"btn btn-info btn-block \" value='Edit & Save '/></td></tr>");  
            out.print("</table>");  
            out.print("</form>");  
            out.print("</div>");

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
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(EditServlet.class.getName()).log(Level.SEVERE, null, ex);
        } catch (SQLException ex) {
            Logger.getLogger(EditServlet.class.getName()).log(Level.SEVERE, null, ex);
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
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(EditServlet.class.getName()).log(Level.SEVERE, null, ex);
        } catch (SQLException ex) {
            Logger.getLogger(EditServlet.class.getName()).log(Level.SEVERE, null, ex);
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
