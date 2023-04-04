/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */
package com.mycompany.bhavya_prakash_hw3.part7;

import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import javax.servlet.RequestDispatcher;
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
@WebServlet(name = "AddBooksController", urlPatterns = {"/AddBooks"})
public class AddBooksController extends HttpServlet {
    private static final String JDBC_DRIVER = "com.mysql.cj.jdbc.Driver";
    private static final String DB_URL = "jdbc:mysql://localhost/homework3";
    private static final String user = "root";
    private static final String password = "bhavya1234";

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
            if(request.getParameter("count").equals("")){
                RequestDispatcher rd  = request.getRequestDispatcher("Part7/amount.jsp");
                rd.forward(request, response);
                return;
            }
            
            int count  = Integer.parseInt(request.getParameter("count"));
            
            HttpSession session = request.getSession();
            session.setAttribute("count", count);
            
            if(count>0){
                
                RequestDispatcher rd  = request.getRequestDispatcher("Part7/books.jsp");
                rd.forward(request, response);
            }
            else{
                
                
                RequestDispatcher rd  = request.getRequestDispatcher("Part7/amount.jsp");
                rd.forward(request, response);
                
            }
           
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
            HttpSession session  =  request.getSession();
            int count  = (Integer)session.getAttribute("count");
            
            for(int i = 1; i<= count ; i++){
                
                String isbnField = "isbn"+i;
                String titleField="title"+i;
                String authorField="author"+i;
                String priceField="price"+i;
                
                System.out.println(isbnField);
                
                String isbn = request.getParameter(isbnField).replaceAll("<|>|@|;|,|=|}|$|&", "");
                String title = request.getParameter(titleField).replaceAll("<|>|@|;|,|=|}|$|&", "");
                String author = request.getParameter(authorField).replaceAll("<|>|@|;|,|=|}|$|&", "");
                float price = Float.parseFloat(request.getParameter(priceField).replaceAll("<|>|@|;|,|=|}|$|&", ""));

                try {
                    
                    Class.forName("com.mysql.cj.jdbc.Driver");
                    Connection connection = DriverManager.getConnection("jdbc:mysql://localhost/homework3", "root", "bhavya1234");
                    
                    
                    String query = "INSERT INTO books"
                            + "(isbn, title, authors, price) VALUES"
                            + "(?,?,?,?)";
                    PreparedStatement preparedStatement;
                    preparedStatement = connection.prepareStatement(query);
                    
                    preparedStatement.setString(1, isbn);
                    preparedStatement.setString(2, title);
                    preparedStatement.setString(3, author);
                    preparedStatement.setFloat(4, price);
                    
                    int result = preparedStatement.executeUpdate();
                    
                    
           
                    
                    
                    if (result > 0) {
                    RequestDispatcher rd = request.getRequestDispatcher("Part7/success.jsp");
                    rd.forward(request, response);
                    }
     
                } catch (ClassNotFoundException ex) {
                System.out.println("ClassNotFoundException" + ex.getMessage());
                } catch (SQLException ex) {
                System.out.println("SQLException" + ex.getMessage());
                }
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
