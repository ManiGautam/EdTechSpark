package com.manijee.edtechspark.model;

import java.util.ArrayList;
import java.util.Date;

public class CartRequestmodel {

        public String id;
        public int userId;
        public Date createdDate;
        public boolean isActive;
        public ArrayList<CartItem> cartItems;

    public CartRequestmodel(String id, int userId, Date createdDate, boolean isActive, ArrayList<CartItem> cartItems) {
        this.id = id;
        this.userId = userId;
        this.createdDate = createdDate;
        this.isActive = isActive;
        this.cartItems = cartItems;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public int getUserId() {
        return userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }

    public Date getCreatedDate() {
        return createdDate;
    }

    public void setCreatedDate(Date createdDate) {
        this.createdDate = createdDate;
    }

    public boolean isActive() {
        return isActive;
    }

    public void setActive(boolean active) {
        isActive = active;
    }

    public ArrayList<CartItem> getCartItems() {
        return cartItems;
    }

    public void setCartItems(ArrayList<CartItem> cartItems) {
        this.cartItems = cartItems;
    }
}
 class CartItem{
    public int id;
    public int itemId;
    public int unitPrice;
    public int quantity;
    public int total;
    public String cartId;
    public String cart;

     public CartItem(int id, int itemId, int unitPrice, int quantity, int total, String cartId, String cart) {
         this.id = id;
         this.itemId = itemId;
         this.unitPrice = unitPrice;
         this.quantity = quantity;
         this.total = total;
         this.cartId = cartId;
         this.cart = cart;
     }

     public int getId() {
         return id;
     }

     public void setId(int id) {
         this.id = id;
     }

     public int getItemId() {
         return itemId;
     }

     public void setItemId(int itemId) {
         this.itemId = itemId;
     }

     public int getUnitPrice() {
         return unitPrice;
     }

     public void setUnitPrice(int unitPrice) {
         this.unitPrice = unitPrice;
     }

     public int getQuantity() {
         return quantity;
     }

     public void setQuantity(int quantity) {
         this.quantity = quantity;
     }

     public int getTotal() {
         return total;
     }

     public void setTotal(int total) {
         this.total = total;
     }

     public String getCartId() {
         return cartId;
     }

     public void setCartId(String cartId) {
         this.cartId = cartId;
     }

     public String getCart() {
         return cart;
     }

     public void setCart(String cart) {
         this.cart = cart;
     }
 }
