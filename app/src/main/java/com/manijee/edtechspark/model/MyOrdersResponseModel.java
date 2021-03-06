package com.manijee.edtechspark.model;

import java.util.ArrayList;
import java.util.Date;

public class MyOrdersResponseModel {

    private int id;
    private int itemId;
    private int unitPrice;
    private int quantity;
    private int total;
    private String orderId;
    private String order;
    private String paymentId;
    private Date createdDate;
    public MyOrdersResponseModel(int id, String paymentId, Date createdDate,int itemId, int unitPrice, int quantity, int total, String orderId, String order) {
        this.id = id;
        this.paymentId = paymentId;
        this.createdDate = createdDate;
        this.itemId = itemId;
        this.unitPrice = unitPrice;
        this.quantity = quantity;
        this.total = total;
        this.orderId = orderId;
        this.order = order;
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
    public String getPaymentId() {
        return paymentId;
    }

    public void setPaymentId(String paymentId) {
        this.paymentId = paymentId;
    }

    public Date getCreatedDate() {
        return createdDate;
    }

    public void setCreatedDate(Date createdDate) {
        this.createdDate = createdDate;
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

    public String getOrderId() {
        return orderId;
    }

    public void setOrderId(String orderId) {
        this.orderId = orderId;
    }

    public String getOrder() {
        return order;
    }

    public void setOrder(String order) {
        this.order = order;
    }
}
    class UserDetails{
        private String id;
        private int userId;
        private String paymentId;
        private Date createdDate;
        private ArrayList<MyOrdersResponseModel> orderItems;
        public UserDetails(String id, int userId,  ArrayList<MyOrdersResponseModel> orderItems) {
            this.id = id;
            this.userId = userId;

            this.orderItems = orderItems;
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


        public ArrayList<MyOrdersResponseModel> getOrderItems() {
            return orderItems;
        }

        public void setOrderItems(ArrayList<MyOrdersResponseModel> orderItems) {
            this.orderItems = orderItems;
        }
    }
