package com.manijee.edtechspark.model;

import java.util.ArrayList;
import java.util.Date;

public class MyOrdersResponseModel {

        public int id;
        public int itemId;
        public int unitPrice;
        public int quantity;
        public int total;
        public String orderId;
        public String order;

    public MyOrdersResponseModel(int id, int itemId, int unitPrice, int quantity, int total, String orderId, String order) {
        this.id = id;
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
    public String id;
    public int userId;
    public String paymentId;
    public Date createdDate;
    public ArrayList<MyOrdersResponseModel> orderItems;
        public UserDetails(String id, int userId, String paymentId, Date createdDate, ArrayList<MyOrdersResponseModel> orderItems) {
            this.id = id;
            this.userId = userId;
            this.paymentId = paymentId;
            this.createdDate = createdDate;
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

        public ArrayList<MyOrdersResponseModel> getOrderItems() {
            return orderItems;
        }

        public void setOrderItems(ArrayList<MyOrdersResponseModel> orderItems) {
            this.orderItems = orderItems;
        }
    }
