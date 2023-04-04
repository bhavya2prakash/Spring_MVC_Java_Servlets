/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/SpringFramework/AbstractController.java to edit this template
 */
package com.mycompany.bhavya_prakash_hw4_part4.controller;


import com.mycompany.bhavya_prakash_hw4_part4.model.Movie;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.List;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.apache.commons.dbutils.DbUtils;
import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.ResultSetHandler;
import org.apache.commons.dbutils.handlers.BeanListHandler;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.AbstractController;

/**
 *
 * @author BHAVYA PRAKASH
 */
public class MovieController extends AbstractController {
    
    public MovieController() {
    }
    private static final String JDBC_DRIVER = "com.mysql.cj.jdbc.Driver";
    private static final String DB_URL = "jdbc:mysql://localhost/homework3";
    private static final String user = "root";
    private static final String password = "bhavya1234";
    private Connection connection;
    public Connection getConnection() throws Exception {
        try {
            Connection connection = null;
            DbUtils.loadDriver(JDBC_DRIVER);
            this.connection = DriverManager.getConnection(DB_URL, user, password);
        } catch (SQLException ex) {
            System.out.println("SQL Exception");
            ex.printStackTrace();
            throw new Exception();
        }
        return this.connection;
    }
    
    protected ModelAndView handleRequestInternal(
            HttpServletRequest request,
            HttpServletResponse response) throws Exception {
       // throw new UnsupportedOperationException("Not yet implemented");
        ModelAndView mv = null;
        String page = request.getParameter("page") == null ? "" : request.getParameter("page");
       if (connection == null) {
            getConnection();
        }
        switch (page) {
            case "home":
                String option = request.getParameter("operation");
                if (option.equals("add")) {
                    mv = new ModelAndView("add");
                } else if (option.equals("browse")) {
                    mv = new ModelAndView("browse");
                }
                break;
            case "add":
                String movieTitle = request.getParameter("Movie Title");
                String leadActor = request.getParameter("Lead Actor");
                String leadActress = request.getParameter("Lead Actress");
                String genre = request.getParameter("Genre");
                String year = request.getParameter("Year");
                int result = addMovie(movieTitle, leadActor, leadActress, genre, Integer.parseInt(year));
                mv = new ModelAndView("addResult");
                mv.addObject("result", result);
                break;
            case "browse":
                String keyword = request.getParameter("keyword");
                String search = request.getParameter("search");
                List<Movie> results = getMovies(search, keyword);
                mv = new ModelAndView("browseResult");
                mv.addObject("keyword", keyword);
                mv.addObject("result", results);
                request.setAttribute("list", results);
                break;
            case "result":
                mv = new ModelAndView("movie");
                break;
            default:
                mv = new ModelAndView("movie");
                break;
        }
        return mv;
    
    }
       public List<Movie> getMovies(String type, String keyword) {
     
        List<Movie> result = null;
        try {
            QueryRunner queryRunner = new QueryRunner();
            ResultSetHandler<List<Movie>> handler = new BeanListHandler<Movie>(Movie.class);
            String query = "";
            if (type.equals("title")) {
                query = "select * from movies where title = ?";
            } else if (type.equals("actor")) {
                query = "select * from movies where actor = ?";
            } else if (type.equals("actress")) {
                query = "select * from movies where actress = ?";
            }
            result = queryRunner.query(connection, query, handler, keyword);
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
        return result;
    }

    public int addMovie(String title, String actor, String actress, String genre, int year) {
        int result = 0;
        try {
            QueryRunner queryRunner = new QueryRunner();
            String query = "insert into movies (title, actor, actress, genre, year) values (?, ?, ?, ?, ?)";
            result = queryRunner.update(connection, query, title, actor, actress, genre, year);
        } catch (Exception e) {
            e.printStackTrace();
            return 0;
        }
        return result;
    }
    
}
