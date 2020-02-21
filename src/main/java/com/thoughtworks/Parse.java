package com.thoughtworks;

import com.thoughtworks.data.Dish;
import com.thoughtworks.order.OrderItem;

import java.util.ArrayList;
import java.util.List;

public class Parse {
    public static List<OrderItem> parseOrder(String str, List<Dish> dishes) {
        List<OrderItem> list = new ArrayList<>();
        String[] arrSelect = str.split(",");
        for (int i = 0; i < arrSelect.length; i++) {
            String regex = " x ";
            String[] itemIdAndCount = arrSelect[i].split(regex);
            String id = itemIdAndCount[0];
            int count = Integer.parseInt(itemIdAndCount[1]);
            Dish dish = getItemDish(id, dishes);
            OrderItem orderItem = new OrderItem(dish, count);
            list.add(orderItem);
        }
        return list;
    }

    public static Dish getItemDish(String itemId, List<Dish> dishes) {
        Dish res = new Dish();
        for (Dish dish : dishes) {
            if (dish.getId().equals(itemId)) {
                res = dish;
                break;
            }
        }
        return res;
    }
}
