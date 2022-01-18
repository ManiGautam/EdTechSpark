package com.manijee.edtechspark.model;

import java.util.ArrayList;

public class CartSavedErrorResponsemodel {
        public String type;
        public String title;
        public int status;
        public String traceId;
        public Errors errors;
    public CartSavedErrorResponsemodel(String type, String title, int status, String traceId, Errors errors) {
        this.type = type;
        this.title = title;
        this.status = status;
        this.traceId = traceId;
        this.errors = errors;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }

    public String getTraceId() {
        return traceId;
    }

    public void setTraceId(String traceId) {
        this.traceId = traceId;
    }

    public Errors getErrors() {
        return errors;
    }

    public void setErrors(Errors errors) {
        this.errors = errors;
    }
}
 class Errors{
    public ArrayList<String> cart;
    public ArrayList<String> cartItems0Cart;

public ArrayList<Cart> errors;

     public Errors(ArrayList<String> cart, ArrayList<String> cartItems0Cart, ArrayList<Cart> errors) {
         this.cart = cart;
         this.cartItems0Cart = cartItems0Cart;
         this.errors = errors;
     }

     public ArrayList<String> getCart() {
         return cart;
     }

     public void setCart(ArrayList<String> cart) {
         this.cart = cart;
     }

     public ArrayList<String> getCartItems0Cart() {
         return cartItems0Cart;
     }

     public void setCartItems0Cart(ArrayList<String> cartItems0Cart) {
         this.cartItems0Cart = cartItems0Cart;
     }

     public ArrayList<Cart> getErrors() {
         return errors;
     }

     public void setErrors(ArrayList<Cart> errors) {
         this.errors = errors;
     }
 }
class Cart{
    String cart;

    public Cart(String cart) {
        this.cart = cart;
    }

    public String getCart() {
        return cart;
    }

    public void setCart(String cart) {
        this.cart = cart;
    }
}