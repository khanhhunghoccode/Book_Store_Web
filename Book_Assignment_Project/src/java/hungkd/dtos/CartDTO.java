/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package hungkd.dtos;

import java.io.Serializable;
import java.util.HashMap;
import java.util.Map;

/**
 *
 * @author PC
 */
public class CartDTO implements Serializable {

    private String customer;
    private Map<String, BookDTO> cart;

    public CartDTO() {
    }

    public CartDTO(String customer, Map<String, BookDTO> cart) {
        this.customer = customer;
        this.cart = cart;
    }

    public String getCustomer() {
        return customer;
    }

    public void setCustomer(String customer) {
        this.customer = customer;
    }

    public Map<String, BookDTO> getCart() {
        return cart;
    }

    public void setCart(Map<String, BookDTO> cart) {
        this.cart = cart;
    }

    public void add(BookDTO book) {
        if (cart == null) {
            cart = new HashMap<>();
        }
        if (cart.containsKey(book.getProductID())) {
            int quantity = this.cart.get(book.getProductID()).getQuantity();
            book.setQuantity(quantity + book.getQuantity());
        }
        cart.put(book.getProductID(), book);
    }

    public void delete(String id) {
        if (cart == null) {
            return;
        }
        if (this.cart.containsKey(id)) {
            this.cart.remove(id);
        }
    }

    public void update(BookDTO book) {
        if (this.cart != null) {
            if (this.cart.containsKey(book.getProductID())) {
                cart.replace(book.getProductID(), book);
            }
        }
    }
}
