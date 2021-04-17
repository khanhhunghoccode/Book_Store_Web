/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package hungkd.dtos;

import java.io.Serializable;

/**
 *
 * @author PC
 */
public class BookDTO implements Serializable{
    private String productID, productName, status;
    private float price;
    private int quantity;

    public BookDTO() {
    }

    public BookDTO(String productID, String productName, String status, float price, int quantity) {
        this.productID = productID;
        this.productName = productName;
        this.status = status;
        this.price = price;
        this.quantity = quantity;
    }

    public String getProductID() {
        return productID;
    }

    public void setProductID(String productID) {
        this.productID = productID;
    }

    public String getProductName() {
        return productName;
    }

    public void setProductName(String productName) {
        this.productName = productName;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public float getPrice() {
        return price;
    }

    public void setPrice(float price) {
        this.price = price;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }
    
}
