/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author 007
 */
@WebServlet(urlPatterns = {"/Home"})
public class Home extends HttpServlet {
    
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        try (PrintWriter out = response.getWriter()) {
            /* TODO output your page here. You may use following sample code. */
            out.println("<!DOCTYPE html>");
            out.println("<html>");
            out.println("<head>");
            out.println("<style>"
                    +"a:link,a:visited{"
                    +"background-color: #0099ff;"
                    + "color:white;"
                    + "padding:14px 25px;"
                    + "text-align:center;"
                    + "text-decoration:none;"
                    + "display:inline-block;"
                    + "}"
                    + "a:hover,a:active{background-color: #005c99;}"
                    + "spam{font-size:70px;color:darkblue;}"
                    + "</style>");
            out.println("<title>Home page</title>");            
            out.println("</head>");
            out.println("<body style='background-color:#e6f5ff'>");
            out.println("<center>");
            out.println("<spam><b><i>HOTEL UNIVERSE</i></b></spam>");
            out.println("<br>");
            out.println("<marquee style='color:blue;font-size:30px'><h2>Welcome to our hotel.....</h2></marquee>");            
            out.println("<br>");
            out.println("<h2><a href='http://localhost:8080/RoomBookingApplication/Form?t="+ 1 +"'>Single Rooms Rs. 1200 per day </a></h2>");
            out.println("<h2><a href='http://localhost:8080/RoomBookingApplication/Form?t="+ 2 +"'>Double Rooms Rs. 1700 per day </a></h2>");
            out.println("<h2><a href='http://localhost:8080/RoomBookingApplication/Form?t="+ 3 +"'>Family Rooms Rs. 3300 per day </a></h2>");
            out.println("<h2><a href='http://localhost:8080/RoomBookingApplication/Form?t="+ 4 +"'>Delux Rooms Rs. 5000 per day </a></h2>");
            out.println("</center>");
            
            out.println("</body>");
            out.println("</html>");
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
        processRequest(request, response);
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
        processRequest(request, response);
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
