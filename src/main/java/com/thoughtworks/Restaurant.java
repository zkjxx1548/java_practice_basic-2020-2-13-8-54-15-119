package com.thoughtworks;

import java.util.ArrayList;
import java.util.List;

public class Restaurant {

  public String bestCharge(String selectedItems) {
    String res = "";
    //提取点菜信息
    Parse parse = new Parse();
    parse.setIdsAndCounts(selectedItems);
    List<String> listId = parse.getSelectIds();
    List<Integer> listCount = parse.getSelectCounts();

    //订餐商品展示
    res += printSelectDishes(listId, listCount);

    //打印优惠
    int allPrice = getAllPrice(listId, listCount);
    FullReduction fullReduction = new FullReduction();
    int fullPrice = fullReduction.getReduction(listId, listCount, allPrice);
    HalfReduction halfReduction = new HalfReduction();
    int halfPrice = halfReduction.getReduction(listId, listCount, allPrice);
    res += printSelectReduction(listId, listCount, fullReduction, halfReduction, allPrice, fullPrice, halfPrice);

    //打印总计
    res += printEndPrice(allPrice, fullPrice, halfPrice);
    return res;
  }

  public static int getAllPrice(List<String> items, List<Integer> counts) {
    double allPrice = 0;
    for (int i = 0; i < items.size(); i++) {
      Dish dish = Parse.getItemDish(items.get(i));
      allPrice += dish.getPrice() * counts.get(i);
    }
    return (int) allPrice;
  }

  public static String printSelectDishes(List<String> items, List<Integer> counts) {
    String res = "============= 订餐明细 =============\n";
    for (int i = 0; i < items.size(); i++) {
      Dish dish = Parse.getItemDish(items.get(i));
      res += dish.getName() + " x " + counts.get(i) + " = " + (int) (counts.get(i) * dish.getPrice()) + "元\n";
    }
    return res;
  }

  public static String printSelectReduction(List<String> items, List<Integer> counts, FullReduction fullReduction, HalfReduction halfReduction, int allPrice, int fullPrice, int halfPrice) {
    String res = "-----------------------------------\n";
    if (fullPrice != 0 || halfPrice != 0) {
      res += "使用优惠:\n";
      if (fullPrice >= halfPrice) {
        res += fullReduction.printReduction(items, fullPrice);
      } else {
        res += halfReduction.printReduction(items, halfPrice);
      }
      return res;
    }
    return "";
  }

  public static String printEndPrice(int allPrice, int fullPrice, int halfPrice) {
    int price = allPrice;
    if (fullPrice != 0 || halfPrice != 0) {
      if (fullPrice >= halfPrice) {
        price = allPrice - fullPrice;
      } else {
        price = allPrice - halfPrice;
      }
    }
    String res = "-----------------------------------\n";
    res += String.format("总计：%d元\n", price);
    res += "===================================";
    return res;
  }
}
