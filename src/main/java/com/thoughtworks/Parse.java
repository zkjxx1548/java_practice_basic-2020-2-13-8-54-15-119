package com.thoughtworks;

import java.util.ArrayList;
import java.util.List;

public class Parse {
    private List<String> selectIds;
    private List<Integer> selectCounts;

    public Parse() {
    }

    public List<String> getSelectIds() {
        return selectIds;
    }

    public void setSelectIds(List<String> selectIds) {
        this.selectIds = selectIds;
    }

    public List<Integer> getSelectCounts() {
        return selectCounts;
    }

    public void setSelectCounts(List<Integer> selectCount) {
        this.selectCounts = selectCount;
    }

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

    public void setIdsAndCounts(String str) {
        String[] arrSelect = str.split(",");
        List<String> listId = new ArrayList<>();
        List<Integer> listCount = new ArrayList<>();
        for (int i = 0; i < arrSelect.length; i++) {
            String regex = " x ";
            String[] itemIdAndCount = arrSelect[i].split(regex);
            listId.add(itemIdAndCount[0]);
            listCount.add(Integer.parseInt(itemIdAndCount[1]));
        }
        setSelectIds(listId);
        setSelectCounts(listCount);
    }
}
