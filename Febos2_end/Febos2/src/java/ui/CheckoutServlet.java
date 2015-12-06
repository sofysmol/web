/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ui;

import dao.shop.Shop;
import dao.shop.ShopService;
import java.io.IOException;
import java.io.PrintWriter;
import java.net.URLEncoder;
import java.util.List;
import javax.servlet.ServletException;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

/**
 *
 * @author SofySmo
 */
public class CheckoutServlet extends HttpServlet {

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
        String cookieName="shopsid";
            Cookie cookies [] = request.getCookies ();
            Cookie myCookie = null;
            if (cookies != null) {
                for (int i = 0; i < cookies.length; i++) {
                    if (cookies[i].getName().equals (cookieName)) {
                        myCookie = cookies[i]; break;
                    }
                }
            }
        if(myCookie==null)
        {
                
                Cookie cookie=new Cookie("shops", URLEncoder.encode(ShopsToCookie(), "UTF-8"));
                response.addCookie(cookie);
                logger.info("added information about shops from DB in cookie");
        }
        request.getRequestDispatcher("/Checkout.jsp").forward(request, response);
    }
     private String ShopsToCookie()
    {
        ShopService service=new ShopService();
        String cookie="";
        List<Shop> list=service.findAll(); 
        
        for (Shop list1 : list) {
            cookie += list1.getName() + "&" + list1.getX() + "&" + list1.getY() + "&" + list1.getShopId() + "&" + "%";
        }
        return cookie;
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
