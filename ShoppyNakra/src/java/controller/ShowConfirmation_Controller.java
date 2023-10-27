/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */
package controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Enumeration;
import java.util.HashMap;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import model.Product3;
import model.Shoppingcart3;

/**
 *
 * @author ItipatSongsampansakul
 */
public class ShowConfirmation_Controller extends HttpServlet {

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
        HttpSession session = request.getSession();
        Enumeration<String> sessionAttrList = session.getAttributeNames();
        HashMap<String, Integer> sessionMap = new HashMap<>();
        while(sessionAttrList.hasMoreElements()){
                String singleAttr = sessionAttrList.nextElement();
                if(!singleAttr.contains("WELD_S_HASH")){
                    sessionMap.put(singleAttr,(Integer)session.getAttribute(singleAttr));
                }
        }   
        session.invalidate();
        
        //Harry Potter 15
        synchronized(getServletContext()){
            int LastestCartID = CallProductTable.findLastestCartID();
            getServletContext().setAttribute("LastestCartID",LastestCartID + 1);
                for(String Movie: sessionMap.keySet()){
                    Product3 Product = CallProductTable.findProductByMovie(Movie);
                    Shoppingcart3 ShoppingCart = new Shoppingcart3((int) getServletContext().getAttribute("LastestCartID"), Product.getId());
                    ShoppingCart.setQuantity(sessionMap.get(Movie));
                    CallProductTable.insertShoppingCart(ShoppingCart);
                }
            }
        request.setAttribute("totalPrice", request.getParameter("totalPrice"));
        request.getRequestDispatcher("ShowConfirmation.jsp").forward(request, response);
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
