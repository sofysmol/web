/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ui;

import domain.Order;
import domain.OrderItem;
import java.util.*;
import dao.shop.*;
import dao.history.*;
import dao.Users.*;
import dao.products.*;
import dao.comment.*;
import java.util.Date;
import java.io.IOException;
import java.io.PrintWriter;
import java.net.URLEncoder;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import javax.servlet.http.Cookie;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

/**
 *
 * @author SofySmo
 */
public class DaoWorker extends HttpServlet {
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
        
        String work=request.getParameter("work");
        if(work==null) 
        {
            logger.error("there is no parameter \"work\"");
            response.sendError(401);
            return;
        }
        if(work.compareTo("buy")==0)
        {
                    try{
                         if(request.getParameter("user")==null||request.getParameter("shop")==null)
                        {
                            logger.error("there is no parameter \"user\" or \"shop\"");
                            response.sendError(401);
                            return;
                        }
                        int user=Integer.parseInt(request.getParameter("user"));
                        int shop=Integer.parseInt(request.getParameter("shop"));
                        Order order=(Order)request.getSession().getAttribute("order");
                        buy(user,shop,order);
                        request.getSession().setAttribute("order", null); 
                        logger.info("bought items from the cart");
                        response.sendError(200);
                        return;
                    }
                    catch(NumberFormatException e)
                    {
                        logger.error("incorrectly entered parameter \"count\"");
                        response.sendError(422);
                        return;
                    }
        } 
        else if(work.compareTo("shops")==0)
        {
                Cookie cookie=new Cookie("shops", URLEncoder.encode(ShopsToCookie(), "UTF-8"));
                response.addCookie(cookie);
                response.sendError(200);
                logger.info("added information about shops from DB in cookie");
                return;
        }else if(work.compareTo("auth")==0)
        {
          
            String login=request.getParameter("login");
            if(login==null)
            {
                logger.error("there is no parameter \"login\"");
                response.sendError(401);
                return;
            }
            Users user=auth(login);
            request.getSession().setAttribute("user", user);   
            logger.info("authorized user with login="+login);
            response.sendError(200);
            return;
        }else if(work.compareTo("historyuser")==0)
        {
            /* TODO output your page here. You may use following sample code. */
            String userid=request.getParameter("userid");
            if(userid==null)
            {
                logger.error("there is no parameter \"login\"");
                response.sendError(401);
                return;
            }
            try{
                Integer id=Integer.parseInt(userid);
                List<List<String>> history=historyUser(id);
                request.getSession().setAttribute("historyUser", history); 
                logger.info("requested information on customer purchases userid="+id);
                response.sendError(200);
                return;
            }catch(NumberFormatException e)
                    {
                        logger.error("incorrectly entered parameter \"userid\"");
                        response.sendError(422);
                        return;
                    }
        }else if(work.compareTo("add_com")==0)
        {
            String comment=request.getParameter("comment");
            if(comment!=null)
            {
                Users user=(Users)request.getSession().getAttribute("user");
                logger.info("norm");
                add_com(comment,user);
                
                logger.info("added new comment about shop comment="+comment);
            }else{
                logger.error("there is no parameter \"comment\"");
                response.sendError(401);
                return;
            }
            
        }
         
          response.sendError(200);
    }
    private void add_com(String comment, Users user)
    {
                logger.info("norm");
                CommentService ser=new CommentService();
                Comment com=new Comment();
                com.setContent(comment);
                com.setDatacom(new Date());
                if(user!=null)
                {
                    com.setIduser(user.getId());
                }
                
                ser.persist(com);
    }
    private void buy(int user,int shop,Order order)
    {
        HistoryService serviceHistory=new HistoryService();
        ShopService serviceShop=new ShopService();
        
        if(order!=null)
        {
            List<OrderItem> list=order.getItemList();
            for(int i=0;i<list.size();i++)
            {
                OrderItem product=list.get(i);
                for(int j=0;j<product.getCount();j++)
                {
                    History h=new History();
                    h.setDatabuy(new Date());         
                    h.setShopId((Integer)shop);
                    h.setUserId((Integer)user);
                    h.setProductId((Integer)product.getId());
                    serviceHistory.persist(h);
                    
                }
               
            }
             //list.clear();
        }
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
    private Users auth(String login)
    {
        UserService ser=new UserService();
        Users user=ser.findByLogin(login);
       /* if(user!=null)
            return Integer.toString(user.getId());*/
        return user;
    }
    private List<List<String>> historyUser(int id)
    {
        HistoryService ser=new HistoryService();
        return ser.findAllOrderByUserId(id);
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
