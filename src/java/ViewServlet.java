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
import java.util.List;
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
@WebServlet(urlPatterns = {"/ViewServlet"})
public class ViewServlet extends HttpServlet {

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
            out.println("<title>View Data</title>\n" +
"	<meta charset=\"utf-8\">\n" +
"	    <meta name=\"viewport\" content=\"width=device-width, initial-scale=1\">\n" +
"		<link rel=\"stylesheet\" href=\"https://maxcdn.bootstrapcdn.com/bootstrap/4.4.1/css/bootstrap.min.css\">\n" +
"		<script src=\"https://ajax.googleapis.com/ajax/libs/jquery/3.4.1/jquery.min.js\"></script>\n" +
"        <script>\n" +
"		$(\"document\").ready(function(){\n" +
"			$(\".btn-danger\").click(function(){\n" +
"				if(confirm('Do you really want yo delete it?'))\n" +
"				{\n" +
"					var deleteuser=$(this).attr('href');\n" +
"					$.ajax(\n" +
"					{\n" +
"                                           url:deleteuser,\n" +
"                                           method:\"GET\",\n" +
"                                           success:function(res)\n" +
"                                           {\n" +
    "                                           if(res!=1)\n" +
    "                                           {\n" +
    "                                               alert(\"Record is deleted succesfully\");\n" +
    "                                           }\n" +
    "                                           else\n" +
    "                                           {\n" +
    "                                               alert(\"Record is not deleted\");\n" +
    "                                           }\n" +
"                                           }\n" +
"					});\n" +
"					$(this).parents('tr').fadeOut(500,function()\n" +
"					{\n" +
"                                           $(this).remove();	\n" +
"                                       });\n" +
"				}\n" +
"                           return false;"+
"			});\n" +
"		});\n" +
"	\n" +
"	</script>");
            
            out.print("<div class=\" container\">");
            out.println("<h1 class=\"row justify-content-center text-secondary\">Employees List</h1>");  
            out.println("<a href='index.html'>Add New Employee</a>");  
            List<Users> list=UsersDAO.getAllUsers();  

            out.print("<table class=\"table table-striped table-hover table-dark\" border='1'");  
            out.print("<tr>"
                        + "<th>Id</th>"
                        + "<th>Name</th>"
                        + "<th>Address</th>"
                        + "<th>Age</th>"
                        + "<th>Gender</th>"
                        + "<th>Action</th>"
                    + "</tr>");  
            for(Users e:list){  
             out.print("<tr>"
                     + "<td>"+e.getID()+"</td>"
                     + "<td>"+e.getUser()+"</td>"
                     + "<td>"+e.getAddress()+"</td>"
                     + "<td>"+e.getAge()+"</td>"
                     + "<td>"+e.getGender()+"</td>"
                     + "<td><a href='EditServlet?id="+e.getID()+"'><button class=\"btn btn-primary\" style=\"margin-right: 5px\">Edit</button></a>"
                     + "<a href='DeleteServlet?id="+e.getID()+"'><button class=\"btn btn-danger\" type=\"submit\">Delete</button></a></td></tr>");  
            }  
            out.print("</table>");  
            out.print("</div>");
            out.close();  
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
            Logger.getLogger(ViewServlet.class.getName()).log(Level.SEVERE, null, ex);
        } catch (SQLException ex) {
            Logger.getLogger(ViewServlet.class.getName()).log(Level.SEVERE, null, ex);
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
            Logger.getLogger(ViewServlet.class.getName()).log(Level.SEVERE, null, ex);
        } catch (SQLException ex) {
            Logger.getLogger(ViewServlet.class.getName()).log(Level.SEVERE, null, ex);
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
