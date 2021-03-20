/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

import java.io.IOException;
import java.io.PrintWriter;
import javax.jms.Session;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author DELL
 */
@WebServlet(urlPatterns = {"/Update"})
public class Update extends HttpServlet {

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
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        try (PrintWriter out = response.getWriter()) {
            /* TODO output your page here. You may use following sample code. */
            out.println("<!DOCTYPE html>");
            out.println("<html>");
            out.println("<head>");
            out.println(" <style>/*\n" +
"\n" +
"/*\n" +
"=====\n" +
"=====\n" +
"*/\n" +
"\n" +
".field{\n" +
"  --uiFieldPlaceholderColor: var(--fieldPlaceholderColor, #767676);\n" +
"}\n" +
"\n" +
".field__input{ \n" +
"  background-color: transparent;\n" +
"  border-radius: 0;\n" +
"  border: none;\n" +
"\n" +
"  -webkit-appearance: none;\n" +
"  -moz-appearance: none;\n" +
"\n" +
"  font-family: inherit;\n" +
"  font-size: 1em;\n" +
"}\n" +
"\n" +
".field__input:focus::-webkit-input-placeholder{\n" +
"  color: var(--uiFieldPlaceholderColor);\n" +
"}\n" +
"\n" +
".field__input:focus::-moz-placeholder{\n" +
"  color: var(--uiFieldPlaceholderColor);\n" +
"  opacity: 1;\n" +
"}\n" +
"\n" +
"/*\n" +
"=====\n"  +
"=====\n" +
"*/\n" +
"\n" +
".a-field{\n" +
"  display: inline-block;\n" +
"}\n" +
"\n" +
".a-field__input{ \n" +
"  display: block;\n" +
"  box-sizing: border-box;\n" +
"  width: 100%;\n" +
"}\n" +
"\n" +
".a-field__input:focus{\n" +
"  outline: none;\n" +
"}\n" +
"\n" +
"/*\n" +
"=====\n" +
"LEVEL 3. PRESENTATION STYLES\n" +
"=====\n" +
"*/\n" +
"\n" +
"/* a-field */\n" +
"\n" +
".a-field{\n" +
"  --uiFieldHeight: var(--fieldHeight, 40px);  \n" +
"  --uiFieldBorderWidth: var(--fieldBorderWidth, 2px);\n" +
"  --uiFieldBorderColor: var(--fieldBorderColor);\n" +
"\n" +
"  --uiFieldFontSize: var(--fieldFontSize, 1em);\n" +
"  --uiFieldHintFontSize: var(--fieldHintFontSize, 1em);\n" +
"\n" +
"  --uiFieldPaddingRight: var(--fieldPaddingRight, 15px);\n" +
"  --uiFieldPaddingBottom: var(--fieldPaddingBottom, 15px);\n" +
"  --uiFieldPaddingLeft: var(--fieldPaddingLeft, 15px);   \n" +
"\n" +
"  position: relative;\n" +
"  box-sizing: border-box;\n" +
"  font-size: var(--uiFieldFontSize);\n" +
"  padding-top: 1em;  \n" +
"}\n" +
"\n" +
".a-field .a-field__input{\n" +
"  height: var(--uiFieldHeight);\n" +
"  padding: 0 var(--uiFieldPaddingRight) 0 var(--uiFieldPaddingLeft);\n" +
"  border-bottom: var(--uiFieldBorderWidth) solid var(--uiFieldBorderColor);  \n" +
"}\n" +
"\n" +
".a-field .a-field__input::-webkit-input-placeholder{\n" +
"  opacity: 0;\n" +
"  transition: opacity .2s ease-out;\n" +
"}\n" +
"\n" +
".a-field .a-field__input::-moz-placeholder{\n" +
"  opacity: 0;\n" +
"  transition: opacity .2s ease-out;\n" +
"}\n" +
"\n" +
".a-field .a-field__input:not(:placeholder-shown) ~ .a-field__label-wrap .a-field__label{\n" +
"  opacity: 0;\n" +
"  bottom: var(--uiFieldPaddingBottom);\n" +
"}\n" +
"\n" +
".a-field .a-field__input:focus::-webkit-input-placeholder{\n" +
"  opacity: 1;\n" +
"  transition-delay: .2s;\n" +
"}\n" +
"\n" +
".a-field .a-field__input:focus::-moz-placeholder{\n" +
"  opacity: 1;\n" +
"  transition-delay: .2s;\n" +
"}\n" +
"\n" +
".a-field .a-field__label-wrap{\n" +
"  box-sizing: border-box;\n" +
"  width: 100%;\n" +
"  height: var(--uiFieldHeight);	\n" +
"\n" +
"  pointer-events: none;\n" +
"  cursor: text;\n" +
"\n" +
"  position: absolute;\n" +
"  bottom: 0;\n" +
"  left: 0;\n" +
"}\n" +
"\n" +
".a-field .a-field__label{\n" +
"  position: absolute;\n" +
"  left: var(--uiFieldPaddingLeft);\n" +
"  bottom: calc(50% - .5em);\n" +
"\n" +
"  line-height: 1;\n" +
"  font-size: var(--uiFieldHintFontSize);\n" +
"\n" +
"  pointer-events: none;\n" +
"  transition: bottom .2s cubic-bezier(0.9,-0.15, 0.1, 1.15), opacity .2s ease-out;\n" +
"  will-change: bottom, opacity;\n" +
"}\n" +
"\n" +
".a-field .a-field__input:focus ~ .a-field__label-wrap .a-field__label{\n" +
"  opacity: 1;\n" +
"  bottom: var(--uiFieldHeight);\n" +
"}\n" +
"\n" +
"/* a-field_a1 */\n" +
"\n" +
".a-field_a1 .a-field__input{\n" +
"  transition: border-color .2s ease-out;\n" +
"  will-change: border-color;\n" +
"}\n" +
"\n" +
".a-field_a1 .a-field__input:focus{\n" +
"  border-color: var(--fieldBorderColorActive);\n" +
"}\n" +
"\n" +
"/* a-field_a2 */\n" +
"\n" +
".a-field_a2 .a-field__label-wrap:after{\n" +
"  content: \"\";\n" +
"  box-sizing: border-box;\n" +
"  width: 0;\n" +
"  height: var(--uiFieldBorderWidth);\n" +
"  background-color: var(--fieldBorderColorActive);\n" +
"\n" +
"  position: absolute;\n" +
"  bottom: 0;\n" +
"  left: 0;  \n" +
"\n" +
"  will-change: width;\n" +
"  transition: width .285s ease-out;\n" +
"}\n" +
"\n" +
".a-field_a2 .a-field__input:focus ~ .a-field__label-wrap:after{\n" +
"  width: 100%;\n" +
"}\n" +
"\n" +
"/* a-field_a3 */\n" +
"\n" +
".a-field_a3{\n" +
"  padding-top: 1.5em;\n" +
"}\n" +
"\n" +
".a-field_a3 .a-field__label-wrap:after{\n" +
"  content: \"\";\n" +
"  box-sizing: border-box;\n" +
"  width: 100%;\n" +
"  height: 0;\n" +
"\n" +
"  opacity: 0;\n" +
"  border: var(--uiFieldBorderWidth) solid var(--fieldBorderColorActive);\n" +
"\n" +
"  position: absolute;\n" +
"  bottom: 0;\n" +
"  left: 0;\n" +
"\n" +
"  will-change: opacity, height;\n" +
"  transition: height .2s ease-out, opacity .2s ease-out;\n" +
"}\n" +
"\n" +
".a-field_a3 .a-field__input:focus ~ .a-field__label-wrap:after{\n" +
"  height: 100%;\n" +
"  opacity: 1;\n" +
"}\n" +
"\n" +
".a-field_a3 .a-field__input:focus ~ .a-field__label-wrap .a-field__label{\n" +
"  bottom: calc(var(--uiFieldHeight) + .5em);\n" +
"} \n" +
".field{\n" +
"  --fieldBorderColor: #D1C4E9;\n" +
"  --fieldBorderColorActive: #673AB7;\n" +
"}</style>");
            out.println("<title>Servlet Update</title>");            
            out.println("</head>");
            out.println("<body><form method='POST' action='http://localhost:8080/RoomBookingApplication/ChangeDate'>");
            out.println("<div class=\"page\">\n" +
"  <div class=\"page__demo\">\n" +
"    <label class=\"field a-field a-field_a1 page__field\">\n" +
"      <input name='indt'class=\"field__input a-field__input\" placeholder=\"dd/mm/yyyy\" required>\n" +
"      <span class=\"a-field__label-wrap\">\n" +
"        <span class=\"a-field__label\">CheckIn Date</span>\n" +
"      </span>\n" +
"    </label>\n" +"<br>"+
"    <label class=\"field a-field a-field_a2 page__field\">\n" +
"      <input name='outdt' class=\"field__input a-field__input\" placeholder=\"dd/mm/yyyy\" required>\n" +
"      <span class=\"a-field__label-wrap\">\n" +
"        <span class=\"a-field__label\">CheckOut Date</span>\n" +
"      </span>\n" +
"    </label>    \n" +
"    </div>\n" +
"</div>");
            int id=Integer.parseInt(request.getParameter("bid"));
            out.println("<input type='hidden' name='bid' value="+id+">");
            out.println("<button type='submit'>Update</button>");
            out.println("</form></body>");
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
