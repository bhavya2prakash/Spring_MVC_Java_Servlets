/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.bhavya_prakash_hw4_part6.model;

import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author BHAVYA PRAKASH
 */
public class Cart {
    private List<Item> cart;
    
    public Cart() {
        cart = new ArrayList<>();
    }
    
    public List<Item> getCart() {
        return cart;
    }

    public void setCart(List<Item> cart) {
        this.cart = cart;
    }
    
    public Item findItem(String name) {
        for (Item item : cart) {
            if (name.equals(item.getName())) {
                return item;
            }
        }
        return null;
    }
    
    public void addItem(Item item) {
        cart.add(item);
    }
    
    public void deleteItem(Item item) {
        cart.remove(item);
    }
    
    public void deleteItem(String name) {
        Item item = findItem(name);
        if (item != null)
            deleteItem(item);
    }
    
    public void modifyItemCount(String name, int count) {
        for (Item tmp : cart) {
            if (name.equals(tmp.getName())) {
                tmp.setCount(count);
            }
        }
    }
}
