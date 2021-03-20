

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
@WebServlet(urlPatterns = {"/ViewBooking"})
public class ViewBooking extends HttpServlet {

    @WebServiceRef(wsdlLocation = "WEB-INF/wsdl/localhost_8000/Service1.wsdl")
    private Service1 service;
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        try (PrintWriter out = response.getWriter()) {
            /* TODO output your page here. You may use following sample code. */
            out.println("<!DOCTYPE html>");
            
            out.println("<html>");
            out.println("<head>");
            out.println("<title>Servlet Sev1</title>    <!-- Compiled and minified CSS -->\n" +
"    <link rel=\"stylesheet\" href=\"https://cdnjs.cloudflare.com/ajax/libs/materialize/1.0.0/css/materialize.min.css\">\n" +
"\n" +
"    <!-- Compiled and minified JavaScript -->\n" +
"    <script src=\"https://cdnjs.cloudflare.com/ajax/libs/materialize/1.0.0/js/materialize.min.js\"></script>\n" +
"      ");            
            out.println("</head>");
            out.println("<body class='#c5cae9 indigo lighten-4'>");
            out.println("<h1 class='center-align'>Your Booking Details </h1><div class='container'><br/><br/><br/>");
            out.println("<table class='striped'><tr>");
            out.print("<th colspan='5'>Room No</th>");
            out.print("<th colspan='5'>Check in date</th>");
            out.print("<th colspan='5'>Check out date</th>");
            out.print("<th colspan='5'>Bill amount</th>");
            out.print("<th colspan='5'>Stay in days</th><th></th></tr>");
            Service1 s = new Service1();
            IService1 client = s.getBasicHttpBindingIService1();
            String nm =request.getParameter("name");
            String ph=request.getParameter("phone");
            String em=request.getParameter("email");
            ArrayOfBooked b = client.getBookingInfo(client.getCustomerId(nm, ph, em));          
			for (Booked b1 : b.getBooked())
            {
				out.print("<td colspan='5'>"+b1.getRoomNos()+"</td>");
                out.print("<td colspan='5'>"+b1.getCheckInDate().getValue()+"</td>");
                out.print("<td colspan='5'>"+b1.getCheckOutDate().getValue()+"</td>");
                out.print("<td colspan='5'>"+b1.getTotalAmount()+"</td>");
                out.print("<td colspan='5'>"+b1.getTotalDays()+"</td>");
                out.println("<td><a href='http://localhost:8080/RoomBookingApplication/Delete?bid="+b1.getBID()+"'>Delete</a></td>");
                out.println("<td><a href='http://localhost:8080/RoomBookingApplication/Update?bid="+b1.getBID()+"'>Update</a></td></tr>");               
            }
            out.println("</table></div>");
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
