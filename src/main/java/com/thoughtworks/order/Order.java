package com.thoughtworks.order;

import java.util.List;

public class Order {
    private List<OrderItem> orderItems;
    private int price;

    public Order() {
    }

    public Order(List<OrderItem> orderItems) {
        this.orderItems = orderItems;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    public List<OrderItem> getOrderItems() {
        return orderItems;
    }

    public double getAllPrice() {
        double res = 0.0;
        for (OrderItem orderItem : this.orderItems) {
            res += orderItem.getSubtotal();
        }
        return res;
    }
}
