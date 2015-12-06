/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ui;

import dao.Users.Users;
import dao.history.HistoryService;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import dao.comment.*;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
/**
 *
 * @author SofySmo
 */
@WebServlet(name = "PersonalServlet", urlPatterns = {"/PersonalServlet"})
public class PersonalServlet extends HttpServlet {
    private static final Logger logger = LogManager.getLogger("shopLog");
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
        Users user=(Users)request.getSession().getAttribute("user");
        if(user==null)
        {
           logger.error("user not found");
        }
        {
            List<List<String>> history=historyUser(user.getId());
            request.getSession().setAttribute("historyUser", history); 
            logger.info("requested information about  purchases of user with user id="+user.getId());
            List<Comment> comments=commentUser(user.getId());
            request.getSession().setAttribute("comments", comments);
            logger.info("requested information about comments of user with user id="+user.getId());
        request.getRequestDispatcher("/Profile.jsp").forward(request, response);
        }
    }
    private List<List<String>> historyUser(int id)
    {
        HistoryService ser=new HistoryService();
        return ser.findAllOrderByUserId(id);
    }
    private List<Comment> commentUser(int id)
    {
        CommentService ser=new CommentService();
        return ser.findCommentByUserId(id);
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
