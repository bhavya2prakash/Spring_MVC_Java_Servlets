/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.bhavya_prakash_hw3.part6;

import java.sql.Connection;
import java.util.List;
import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.ResultSetHandler;
import org.apache.commons.dbutils.handlers.BeanListHandler;

/**
 *
 * @author BHAVYA PRAKASH
 */
public class MovieDAO {
    public List<Movie> getMovies(String type, String keyword) {
        Connection connection = null;
        List<Movie> result = null;
        try {
            DAO dbdao = new DAO();
            connection = dbdao.getConnection();
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
//            else{
//                 query = "select * from movies";
//            }
            result = queryRunner.query(connection, query, handler, keyword);
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
        return result;
    }
    
    public int addMovie(String title, String actor, String actress, String genre, int year) {
        Connection connection = null;
        int result = 0;
        try {
            DAO dbdao = new DAO();
            connection = dbdao.getConnection();
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
