package com.thoughtworks;

import java.util.List;

public class Parse {
    public static Dish getItemDish(String itemId) {
        List<Dish> list = DataProvider.getDishes();
        Dish res = new Dish();
        for (Dish dish : list) {
            if (dish.getId().equals(itemId)) {
                res = dish;
                break;
            }
        }
        return res;
    }
}
