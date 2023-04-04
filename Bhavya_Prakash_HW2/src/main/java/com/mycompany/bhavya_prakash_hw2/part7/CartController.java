/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */
package com.mycompany.bhavya_prakash_hw2.part7;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Enumeration;
import javax.annotation.security.DeclareRoles;
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
@WebServlet(name = "CartController", urlPatterns = {"/CartController"})

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
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        HttpSession session = request.getSession();
	Cart cart = (Cart)session.getAttribute("cart");
        response.setContentType("text/html;charset=UTF-8");
        try ( PrintWriter out = response.getWriter()) {
            /* TODO output your page here. You may use following sample code. */
            out.println("<!DOCTYPE html>");
            out.println("<html>");
            out.println("<head>");
            out.println("<title>Servlet CartController</title>");            
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>Your Cart</h1>");
            out.println("<form action='CartController' method='get'>");
            out.println("<table border=1>");
            out.println("<th>Items<th>Quantity");
            
            for (Item item : cart.getCart()){
                out.println("<tr><td>"+item.getName()+"<td><input  name='"+item.getName()+"' value="+item.getCount()+" type=\"text\">");
            }
            out.println("</table>");
            if (request.isUserInRole("part7_user")){
            out.println("<input type=\"submit\" name=\"Submit\" value=\"Modify Cart\">");
           }
            out.println("</form>");
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
            System.out.println(name);
            int count = Integer.parseInt(amount);
            if (count == 0) {
                cart.deleteItem(name);
            } else {
                cart.modifyItemCount(name, count);
            }
        }
        session.setAttribute("cart", cart);
        
       processRequest( request,  response);
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
//        if (authorization == null) {
//        response.setStatus(response.SC_UNAUTHORIZED);
//        response.setHeader("WWW-Authenticate", "BASIC realm=file");
//        System.out.println(request.getUserPrincipal());
//        }
//        else {
//          if (!request.isUserInRole("part7_user")) {
//              response.setStatus(response.SC_UNAUTHORIZED);
//              response.setHeader("WWW-Authenticate", "BASIC realm=file");
//              System.out.println(request.getUserPrincipal());
//            }
//          else {
//              System.out.println(request.getUserPrincipal());
//              String[] items = request.getParameterValues("books");
//	if (items == null)
//            items = request.getParameterValues("music");
//	if (items == null)
//            items = request.getParameterValues("computers");
//        
//        HttpSession session = request.getSession();
//	Cart cart = (Cart)session.getAttribute("cart");
//	if (cart == null) {
//            cart = new Cart();
//	}
//        
//        if (items == null) {
//            session.setAttribute("items", items);
//            session.setAttribute("cart", cart);
//            processRequest( request,  response);
//            return;
//        }
//        
//	for (String name : items) {
//            Item item = cart.findItem(name);
//            if (item != null) {
//                int amount = item.getCount();
//                cart.modifyItemCount(name, ++amount);
//            } else {
//                cart.addItem(new Item(name, 1));
//            }
//        }
//        session.setAttribute("items", items);
//        session.setAttribute("cart", cart);
//        processRequest( request,  response);
//        }
//            
//        }
//          }
        if (request.authenticate(response)){
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
            processRequest( request,  response);
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
        processRequest( request,  response);
        }
        else{
        //processRequest( request,  response);
        System.out.print("not");
            
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
