package com.thoughtworks;

import com.thoughtworks.Promotion.FullReduction;
import com.thoughtworks.Promotion.HalfReduction;
import com.thoughtworks.data.Dish;
import com.thoughtworks.order.Order;
import com.thoughtworks.order.OrderItem;

import java.util.List;

public class Restaurant {
  private List<Dish> dishes;
  private List<String> halfIds;

  public Restaurant(List<Dish> dishes, List<String> halfIds) {
    this.dishes = dishes;
    this.halfIds = halfIds;
  }

  public List<Dish> getDishes() {
    return dishes;
  }

  public List<String> getHalfIds() {
    return halfIds;
  }

  public String bestCharge(String selectedItems) {
    //提取点菜信息
    Order order = new Order(Parse.parseOrder(selectedItems, this.dishes));

    //订餐商品展示
    StringBuilder sb = new StringBuilder(printSelectDishes(order));

    //判断优惠类型
    int allPrice = (int) order.getAllPrice();
    FullReduction fullReduction = new FullReduction();
    int fullPrice = fullReduction.getReduction(order);
    HalfReduction halfReduction = new HalfReduction();
    int halfPrice = halfReduction.getReduction(order);
    int price = allPrice;
    if (fullPrice != 0 || halfPrice != 0) {
      String reduction = "";
      if (fullPrice >= halfPrice) {
        reduction = fullReduction.printReduction(order);
        price = price - fullPrice;
      } else {
        reduction = halfReduction.printReduction(order);
        price = price - halfPrice;
      }
      //打印优惠信息
      sb.append(printSelectReduction(reduction));
    }
    order.setPrice(price);

    //打印总计
    sb.append(printEndPrice(order));
    return sb.toString();
  }

  public static String printSelectDishes(Order order) {
    StringBuilder res = new StringBuilder("============= 订餐明细 =============\n");
    List<OrderItem> orderItems = order.getOrderItems();
    for (OrderItem orderItem : orderItems) {
      Dish dish = orderItem.getDish();
      res.append(dish.getName()).append(" x ").append(orderItem.getCount()).append(" = ").append((int) (orderItem.getSubtotal())).append("元\n");
    }
    return res.toString();
  }

  public static String printSelectReduction(String reduction) {
    StringBuilder sb = new StringBuilder("-----------------------------------\n");
    sb.append("使用优惠:\n");
    sb.append(reduction);
    return sb.toString();
  }

  public static String printEndPrice(Order order) {
    StringBuilder sb = new StringBuilder("-----------------------------------\n");
    sb.append(String.format("总计：%d元\n", order.getPrice()));
    sb.append("===================================");
    return sb.toString();
  }
}
