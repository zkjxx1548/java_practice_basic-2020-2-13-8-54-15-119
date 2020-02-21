package com.thoughtworks.Promotion;

import com.thoughtworks.order.Order;

public class FullReduction implements Promotion {
    private static final int Basic = 30;
    private static final int FULL_PRICE = 6;

    @Override
    public int getReduction(Order order) {
        return order.getAllPrice() >= Basic ? FULL_PRICE : 0;
    }

    @Override
    public String printReduction(Order order) {
        return String.format("满%d减%d元，省%d元\n", Basic, FULL_PRICE, FULL_PRICE);
    }
}
