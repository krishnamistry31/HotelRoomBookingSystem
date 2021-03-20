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
@WebServlet(urlPatterns = {"/Confirm"})
public class Confirm extends HttpServlet {

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        try (PrintWriter out = response.getWriter()) {
            /* TODO output your page here. You may use following sample code. */
        
            String name = request.getParameter("name");
            String phone = request.getParameter("phone");
            String email = request.getParameter("email");
            int rno = Integer.parseInt(request.getParameter("room"));
            String chkin = request.getParameter("indate");
            String chout = request.getParameter("outdate");
            HotelClient.Service1 s1 = new HotelClient.Service1();
            HotelClient.IService1 client = s1.getBasicHttpBindingIService1();
            Integer i = client.bookRoom(name, phone, email, rno, chkin, chout);
               out.println("<!DOCTYPE html>");
            out.println("<html>");
            out.println("<head>");
            out.println("<style>"
                    + "spam{font-size:70px;color:darkblue;}"
                    + "pre{font-size:40px;color:30px}"
                    + "h1{font-size:50px;color:red}"
                    + "</style>");
            out.println("<title>Confirmation Page</title>");            
            out.println("</head>");
            out.println("<body style='background-color:#e6f5ff;color:blue'>");
            out.println("<center>" );
            out.println("<spam><b><i>HOTEL UNIVERSE</i></b></spam>");
            out.println("<br><br>");
            out.println("<h1>Booking Confirmed.</h1>");
            out.println("<pre><h5>Your name registered is:       "+name+"</h5></pre>");
            out.println("<pre><h5>Your Room Booked is:       "+rno+"</h5></pre>");
            out.println("<pre><h5>Your Checkin Date is:      "+chkin+"</h5></pre>");
            out.println("<pre><h5>Your total amount to be paid is:       "+ i +"</h5></pre>");
            out.println("<h1>Thank you!!!!!</h1>");
            out.println("<a href='http://localhost:8080/RoomBookingApplication/Cancel'>Manage your bookings</a>");
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
