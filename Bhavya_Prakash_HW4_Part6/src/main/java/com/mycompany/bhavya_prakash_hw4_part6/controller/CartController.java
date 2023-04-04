/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/SpringFramework/AbstractController.java to edit this template
 */
package com.mycompany.bhavya_prakash_hw4_part6.controller;

import com.mycompany.bhavya_prakash_hw4_part6.model.Cart;
import com.mycompany.bhavya_prakash_hw4_part6.model.Item;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;


/**
 *
 * @author BHAVYA PRAKASH
 */
@Controller
public class CartController {
    
    public CartController() {
    }
    
    @RequestMapping(value="/addcart.htm" , method = RequestMethod.POST)
    protected ModelAndView handleRequestInternal(
            HttpServletRequest request,
            HttpServletResponse response) throws Exception {
       // throw new UnsupportedOperationException("Not yet implemented");
        //String authorization = request.getHeader("Authorization");
        //if (authorization!=null &&request.isUserInRole("cart")){
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
            
            return new ModelAndView("ViewCart");
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
        return new ModelAndView("ViewCart");
    
   
   // } 
 // return null;
}
    @RequestMapping(value="/remove.htm" , method = RequestMethod.POST)
    protected ModelAndView handleRequestInternal2(
            HttpServletRequest request,
            HttpServletResponse response) throws Exception {
       // throw new UnsupportedOperationException("Not yet implemented");
        HttpSession session = request.getSession();
	Cart cart = (Cart)session.getAttribute("cart");
	if (cart == null) {
            cart = new Cart();
        }
        String removeItem= request.getParameter("remove");
        cart.deleteItem(removeItem);
            
        session.setAttribute("cart", cart);
        return new ModelAndView("ViewCart");
  
       
}
}
