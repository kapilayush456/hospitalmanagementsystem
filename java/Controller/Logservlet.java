package Controller;

import DAO.*;
import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
public class Logservlet extends HttpServlet {

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        boolean flag = false;
        boolean flag1 = false;
        response.setContentType("text/html;charset=UTF-8");
        try (PrintWriter out = response.getWriter()) {

            String uname = request.getParameter("username");
            String pass = request.getParameter("password");
            String type = request.getParameter("selects");
            HttpSession session=request.getSession();
            
            UserDAO ud = new UserDAO();
            System.out.println(uname + " " + pass + " " + type);
            if (type.equals("PATIENT")) {
                flag = ud.checkStu(uname, pass);
                
                System.out.println(flag);
                if (flag) {
                    session.setAttribute("uname",uname);
                    response.sendRedirect("home.html");
                }
            } else if (type.equals("DOCTOR")) {
                flag = ud.checkAdmin(uname, pass);
                if (flag) {
                    session.setAttribute("uname",uname);
                    response.sendRedirect("home1.jsp");
                }
            }
            else{
                response.sendRedirect("index.html");
            }
        } catch (Exception ee) {
            ee.printStackTrace();
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
