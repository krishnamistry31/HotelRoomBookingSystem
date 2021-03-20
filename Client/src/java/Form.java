/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

import HotelClient.ArrayOfint;
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
@WebServlet(urlPatterns = {"/Form"})
public class Form extends HttpServlet {

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        try (PrintWriter out = response.getWriter()) {
            int roomtype = Integer.parseInt(request.getParameter("t"));
            /* TODO output your page here. You may use following sample code. */
            out.println("<!DOCTYPE html>");
            out.println("<html>");
            out.println("<head>");
            out.println("<style>"
                    + "input,select{width:250px;height:30px;background-color:rgba(255,255,255,0.5);border:none}"
                    + "button{width:150px;font-size:25px;background-color:darkblue;color:white}"
                    + "</style>");
            out.println("<title>Booking Form</title>");            
            out.println("</head>");
            out.println("<body style='background-color:#e6f5ff;font-size:25px;text-align:center;color:blue'>");
            out.println("<h1 style='color:darkblue'>Fill Up Details</h1><form method='POST' action='http://localhost:8080/RoomBookingApplication/Confirm'");
            out.println("<pre>");
            out.println("<h4>Full Name     :      <input type='text' name='name' value='' </h4>");
            out.println("<h4>Contact       :      <input type='phone' name='phone' value='' </h4>");
            out.println("<h4>Email         :      <input type='email' name='email' value='' </h4>");
            out.println("<h4>Room          :      <select name='room'>");
            HotelClient.Service1 s1 = new HotelClient.Service1();
            HotelClient.IService1 client = s1.getBasicHttpBindingIService1();
            ArrayOfint x = client.getRoomNos(roomtype);
            for(int i:x.getInt()){
                if(!client.isRoomBooked(i) && i!=0)
                    out.println("<option value='"+i+"'>"+ i +"</option>");
            }
            out.println("</select></h4>");
            out.println("<h4>Checkin date  :      <input type='text' name='indate' value='' </h4>");
            out.println("<h4>Checkout date :      <input type='text' name='outdate' value='' </h4>");
            out.println("<br>");
            out.println("<button name='book'>Book</button>");
            out.println("<a href='http://localhost:8080/RoomBookingApplication/Cancel'>Cancel ur bookings</a>");
            out.println("</pre>");
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
