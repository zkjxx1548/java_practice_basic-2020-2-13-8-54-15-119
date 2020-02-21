package com.thoughtworks.Promotion;

import com.thoughtworks.order.Order;
import com.thoughtworks.order.OrderItem;
import com.thoughtworks.data.DataProvider;

import java.util.ArrayList;
import java.util.List;

public class HalfReduction implements Promotion {
    private double price;
    private String halfItemNames;

    public HalfReduction() {
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public String getHalfItemNames() {
        return halfItemNames;
    }

    public void setHalfItemNames(String halfItemNames) {
        this.halfItemNames = halfItemNames;
    }

    @Override
    public int getReduction(Order order) {
        double halfPrice = 0;
        String name = "";
        List<String> list = DataProvider.getHalfDishIds();
        List<OrderItem> orderItems = order.getOrderItems();
        List<String> listHalfNames = new ArrayList<>();
        for (OrderItem orderItem : orderItems) {
            if (list.contains(orderItem.getDish().getId())) {
                halfPrice += (orderItem.getSubtotal() / 2);
                listHalfNames.add(orderItem.getDish().getName());
            }
        }
        setPrice(halfPrice);

        for (int i = 0; i < listHalfNames.size() - 1; i++) {
            name += listHalfNames.get(i);
            name += "，";
        }
        if (listHalfNames.size() > 0) {
            name += listHalfNames.get(listHalfNames.size() - 1);
        }
        setHalfItemNames(name);

        return (int) halfPrice;
    }

    @Override
    public String printReduction(Order order) {
        return String.format("指定菜品半价(%s)，省%d元\n", this.halfItemNames, (int) getPrice());
    }
}
