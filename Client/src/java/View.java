

import HotelClient.ArrayOfBooked;
import HotelClient.Booked;
import HotelClient.IService1;
import HotelClient.Room;
import HotelClient.Service1;
import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.List;
import javax.xml.ws.WebServiceRef;
/**
 *
 * @author 007
 */
@WebServlet(urlPatterns = {"/Sev1"})
public class View extends HttpServlet {

    @WebServiceRef(wsdlLocation = "WEB-INF/wsdl/localhost_8000/Service1.wsdl")
    private Service1 service;
    private ArrayOfBooked getBookingInfo(java.lang.Integer id) {
        // Note that the injected javax.xml.ws.Service reference as well as port objects are not thread safe.
        // If the calling of port operations may lead to race condition some synchronization is required.
        HotelClient.IService1 port = service.getBasicHttpBindingIService1();
        return port.getBookingInfo(id);
    }
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        try (PrintWriter out = response.getWriter()) {
            /* TODO output your page here. You may use following sample code. */
            out.println("<!DOCTYPE html>");
            
            out.println("<html>");
            out.println("<head>");
            out.println("<title>Servlet Sev1</title>");            
            out.println("</head>");
            out.println("<body>");
            out.println("<b>Hiii</b>");
            Service1 s = new Service1();
            IService1 client = s.getBasicHttpBindingIService1();
            ArrayOfBooked b = client.getBookingInfo(6);
            out.println("<table border=1>");
            for (Booked b1 : b.getBooked())
            {
                out.print("<tr><td>"+b1.getBID()+"</td>");
                out.print("<td colspan='5'>"+b1.getCID()+"</td>");
                out.print("<td colspan='5'>"+b1.getRoomNos()+"</td>");
                out.print("<td colspan='5'>"+b1.getCheckInDate().getValue()+"</td>");
                out.print("<td colspan='5'>"+b1.getCheckOutDate().getValue()+"</td>");
                out.print("<td colspan='5'>"+b1.getTotalAmount()+"</td>");
                out.print("<td colspan='5'>"+b1.getTotalDays()+"</td>");
                out.println("<td><a href='http://localhost:8080/RoomBookingApplication/Delete?bid="+b1.getBID()+"'>Delete</a></td></tr>");
                
            }
            out.println("</table>");
            /*
            out.println("<h1>List Of Rooms</h1>");
            Iterator<Room> ri = l.iterator(); 
            while(ri.hasNext()){
                out.println("<b> Room </b>" + ri.toString() + "<br>");
            }*/
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
