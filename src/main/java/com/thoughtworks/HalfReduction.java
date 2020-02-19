package com.thoughtworks;

import java.util.List;

public class HalfReduction implements Reduction {

    @Override
    public int getReduction(List<String> items, List<Integer> counts, int price) {
        double halfPrice = 0;
        List<String> list = DataProvider.getHalfDishIds();
        for (int i = 0; i < items.size(); i++) {
            if (list.contains(items.get(i))) {
                Dish dish = Parse.getItemDish(items.get(i));
                halfPrice += dish.getPrice() * 0.5 * counts.get(i);
            }
        }
        return (int) halfPrice;
    }

    @Override
    public String printReduction(List<String> items, int price) {
        String halfItemNames = "";
        List<String> list = DataProvider.getHalfDishIds();
        List<String> listHalfNames = DataProvider.getHalfDishIds();
        for (int i = 0; i < items.size(); i++) {
            if (list.contains(items.get(i))) {
                Dish dish = Parse.getItemDish(items.get(i));
                listHalfNames.add(dish.getName());
            }
        }
        for (int i = 0; i < listHalfNames.size() - 1; i++) {
            halfItemNames += listHalfNames.get(i);
            halfItemNames += "，";
        }
        halfItemNames += listHalfNames.get(listHalfNames.size() - 1);
        return String.format("指定菜品半价(%s)，省%d元\n", halfItemNames, price);
    }
}
