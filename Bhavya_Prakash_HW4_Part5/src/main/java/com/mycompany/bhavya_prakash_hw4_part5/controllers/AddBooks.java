/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/SpringFramework/AbstractController.java to edit this template
 */
package com.mycompany.bhavya_prakash_hw4_part5.controllers;

import com.mycompany.bhavya_prakash_hw4_part5.model.Books;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import javax.sql.DataSource;
import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.ResultSetHandler;
import org.apache.commons.dbutils.handlers.BeanHandler;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.AbstractController;

/**
 *
 * @author BHAVYA PRAKASH
 */
public class AddBooks extends AbstractController {
    
    public AddBooks() {
    }
    Connection conn = null;
    ResultSet rs = null;
    Statement stmt = null;

    public void connectDatabase() {
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");

            String url = "jdbc:mysql://localhost/homework3";
            conn = DriverManager.getConnection(url, "root", "bhavya1234");
            stmt = conn.createStatement();
        } catch (ClassNotFoundException | SQLException ex) {
            System.out.println(ex.getMessage());
        }
    }
    
    protected ModelAndView handleRequestInternal(
            HttpServletRequest request,
            HttpServletResponse response) throws Exception {
        //throw new UnsupportedOperationException("Not yet implemented");
        if (conn == null) {
            connectDatabase();
        }
        ModelAndView mv = null;
        String page = request.getParameter("page") == null ? "" : request.getParameter("page");
        switch (page) {
            case "index":
                request.setAttribute("count", request.getParameter("count"));
                mv = new ModelAndView("addbooks");
                break;
            case "addbooks": 
                    int result=0;
                    try {
                        int count = Integer.parseInt(request.getParameter("count"));
                        String sql = "INSERT INTO books values(?,?,?,?)";
                        PreparedStatement prepStmt = conn.prepareStatement(sql);

                        for (int i = 1; i <= count; i++) {
                            String isbn = request.getParameter("isbn" + i).replaceAll("<|>|@|;|,|=|}|$|&", "");
                            String title = request.getParameter("title" + i).replaceAll("<|>|@|;|,|=|}|$|&", "");
                            String authors = request.getParameter("author" + i).replaceAll("<|>|@|;|,|=|}|$|&", "");
                            Float price = Float.valueOf(request.getParameter("price" + i));
                            prepStmt.setString(1, isbn);
                            prepStmt.setString(2, title);
                            prepStmt.setString(3, authors);
                            prepStmt.setFloat(4, price);
                            result = prepStmt.executeUpdate();
                        }
                        request.setAttribute("count", request.getParameter("count"));
                        
                    }
        
                    catch(Exception ex){
                                System.out.println("Details Not Added In DB!! " + ex.getMessage());
                    }
                    if(result>0){
                        mv = new ModelAndView("success");
                    }else{
                        mv = new ModelAndView("error");
                    }
        
                break;
            default:
                mv = new ModelAndView("index");
                break;    
    }
    return mv;    
    
}
}
