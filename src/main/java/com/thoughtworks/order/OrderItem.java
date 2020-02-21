package com.thoughtworks.order;

import com.thoughtworks.data.Dish;

public class OrderItem {
    private final Dish dish;
    private final int count;
    private final double subtotal;

    public OrderItem(Dish dish, int count) {
        this.dish = dish;
        this.count = count;
        this.subtotal = dish.getPrice() * this.count;
    }

    public Dish getDish() {
        return dish;
    }

    public int getCount() {
        return count;
    }

    public double getSubtotal() {
        return subtotal;
    }
}
