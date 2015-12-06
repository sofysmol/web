/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ui;

import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.hibernate.Session;
import org.hibernate.Transaction;
import dao.shop.ShopService;
import dao.shop.Shop;
import dao.products.ProductService;
import dao.products.Products;
import org.hibernate.HibernateException;
import domain.*;
import java.io.File;
import java.util.*;


/**
 *
 * @author SofySmo
 */
public class NewServlet extends HttpServlet {

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
            out.println("<!DOCTYPE html><html><header><title>DB</title></head><body>");
            try{
                
                    /* ProductService ser=new ProductService();
                Products pr=new Products();
                ArrayList<Artwork[]> art=new ArrayList<Artwork[]>();
                    Scanner in = new Scanner(new File("C:\\Users\\SofySmo\\Documents\\NetBeansProjects\\Febos2\\src\\java\\filename.txt"));
                    while (in.hasNextLine())
                    {
                       String filename=in.nextLine();
                       art.add(SerializeArt.deserializeArt("C:\\Users\\SofySmo\\Documents\\NetBeansProjects\\Febos2\\src\\java\\"+filename));
                    }
                     
                for(int i=0; i<art.size();i++)
                {
                    Artwork[] pc=art.get(i);
                    for(int j=0; j<pc.length;j++)
                    {
                       pr.setAuthor(pc[j].getAuthor());
                       pr.setCountry(pc[j].getCountry());
                       pr.setDirection(pc[j].getDirection());
                       pr.setGenre(pc[j].getGenre());
                       pr.setName(pc[j].getName());
                       pr.setPathartwork(pc[j].getPathartwork());
                       pr.setTechnique(pc[j].getTechnique());
                       pr.setSize(pc[j].getSize());
                       pr.setPrice(String.valueOf(pc[j].getPrice()));
                      // pr.setId(i*100+j);
                       ser.persist(pr);
                       
                    }
                }
                out.print("<br>Name:");
                ShopService service=new ShopService();
                Shop shop=service.findById((Integer)1);
                out.print(shop.getName());
               */
            }
       catch(HibernateException e)
            {
                 
            /* if(tx!=null) tx.rollback();
             out.println(e.toString());*/
               // session=newHibernateUtil.getSessionFactory()
            }
            catch(Exception e)
            {
                out.print(e.toString());
            }finally{
                /*if(session!=null)
                    session.close();*/
            }
            out.println("</body></html>");
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
