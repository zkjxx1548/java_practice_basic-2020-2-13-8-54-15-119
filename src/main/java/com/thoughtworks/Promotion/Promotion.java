package com.thoughtworks.Promotion;

import com.thoughtworks.order.Order;

public interface Promotion {
    int getReduction(Order order);

    String printReduction(Order order);
}
