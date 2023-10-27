package controller;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Enumeration;
import java.util.List;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import model.Calculator;
import model.Product3;

/**
 *
 * @author ItipatSongsampansakul
 */
public class AddToShoppingCart extends HttpServlet {

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
        String[] checkbArray = request.getParameterValues("CBDVDName");
        List<Product3> pdList = CallProductTable.findAllProduct();
        int unit, unitPrice = 0, totalPrice = 0;
        for(String MVname : checkbArray){  // call all Movie name    
            for(Product3 pd : pdList){ 
                // getParameterValues return MVname[escape cha]  
                if(MVname.trim().equals(pd.getMovie()) && !request.getParameter(MVname.trim()).equals("")){ 
                    unit = Integer.parseInt(request.getParameter(MVname.trim())); // Call unit from Text Input
                    request.setAttribute(MVname.trim() + "_quantity", unit);
                    //unitPrice = unit *  pd.getPrice(); // Price per Unit
                    unitPrice = Calculator.unitCalculator( pd.getPrice(), unit);
                    totalPrice = Calculator.totalCalculator(totalPrice, unitPrice); // Total price
                    
                    request.setAttribute(MVname.trim() + "_unitPrice", unitPrice);
                }
            }
        }
        request.setAttribute("totalPrice", totalPrice);
        HttpSession session = request.getSession();
        
        //remove old session Attr
        Enumeration<String> SessionAttrList = session.getAttributeNames();
        while(SessionAttrList.hasMoreElements()){
            String singleAttr = SessionAttrList.nextElement();
            if(!singleAttr.contains("WELD_S_HASH")){
                session.removeAttribute(singleAttr);
            }
        }
        
        Enumeration<String> AttrList = request.getAttributeNames();
        while(AttrList.hasMoreElements()){
            String singleAttr = AttrList.nextElement();
            if(singleAttr.contains("_quantity")){
                session.setAttribute(singleAttr.replace("_quantity",""), request.getAttribute(singleAttr));
            }
        }
//        try (PrintWriter out = response.getWriter()) {
//            /* TODO output your page here. You may use following sample code. */
//            out.println("<!DOCTYPE html>");
//            out.println("<html>");
//            out.println("<head>");
//            out.println("<title>Servlet test</title>");            
//            out.println("</head>");
//            out.println("<body>");
//            SessionAttrList = session.getAttributeNames();
//            while(SessionAttrList.hasMoreElements()){
//                String singleAttr = SessionAttrList.nextElement();
//                out.println("<h1> name : " + singleAttr + " value : " +  session.getAttribute(singleAttr) + "</h1>");
//            }
//            out.println("</body>");
//            out.println("</html>");
//        }
        request.getRequestDispatcher("cart.jsp").forward(request, response);
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
