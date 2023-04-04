/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */
package com.mycompany.bhavya_prakash_hw3.part8;

import java.io.IOException;
import java.util.Enumeration;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 *
 * @author BHAVYA PRAKASH
 */
@WebServlet(name = "CartController", urlPatterns = {"/Cart"})
public class CartController extends HttpServlet {

    /**
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code>
     * methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
  

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
       HttpSession session = request.getSession();
	Cart cart = (Cart)session.getAttribute("cart");
	if (cart == null) {
            cart = new Cart();
        }
        Enumeration<String> items = request.getParameterNames();
        while (items.hasMoreElements()) {
            String name = items.nextElement();
            if (name.equals("Submit")) continue;
            String amount = request.getParameter(name);
            int count = Integer.parseInt(amount);
            if (count == 0) {
                cart.deleteItem(name);
            } else {
                cart.modifyItemCount(name, count);
            }
        }
        session.setAttribute("cart", cart);
        request.getRequestDispatcher("Part8/ViewCart.jsp").forward(request, response);
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
//        String authorization = request.getHeader("Authorization");
//        System.out.print("1");
//        if (authorization == null) {
//            System.out.print("2");
//        response.setStatus(response.SC_UNAUTHORIZED);
//        System.out.print("3");
//        response.setHeader("WWW-Authenticate", "BASIC realm=file");
//        System.out.print("4");
//        System.out.println(request.getUserPrincipal());
//        System.out.print("5");
//        }
//        else {
//            System.out.print("6");
//          if (!request.isUserInRole("part7_user")) {
//              System.out.print("7");
//              response.setStatus(response.SC_UNAUTHORIZED);
//              System.out.print("8");
//              response.setHeader("WWW-Authenticate", "BASIC realm=file");
//              System.out.print("9");
//              System.out.println(request.getUserPrincipal());
//              System.out.print("10");
//            }
//          else {
            
        if (request.authenticate(response)&&request.isUserInRole("cart")){
        String[] items = request.getParameterValues("books");
	if (items == null)
            items = request.getParameterValues("music");
	if (items == null)
            items = request.getParameterValues("computers");
        
        HttpSession session = request.getSession();
	Cart cart = (Cart)session.getAttribute("cart");
	if (cart == null) {
            cart = new Cart();
	}
        
        if (items == null) {
            session.setAttribute("items", items);
            session.setAttribute("cart", cart);
            request.getRequestDispatcher("Part8/ViewCart.jsp").forward(request, response);
            return;
        }
        
	for (String name : items) {
            Item item = cart.findItem(name);
            if (item != null) {
                int amount = item.getCount();
                cart.modifyItemCount(name, ++amount);
            } else {
                cart.addItem(new Item(name, 1));
            }
        }
        session.setAttribute("items", items);
        session.setAttribute("cart", cart);
        request.getRequestDispatcher("Part8/ViewCart.jsp").forward(request, response);
          }
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
