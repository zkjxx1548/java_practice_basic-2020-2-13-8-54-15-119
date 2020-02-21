package com.thoughtworks;

import com.thoughtworks.data.DataProvider;

public class App {
  public static void main(String[] args) {
    Restaurant restaurant = new Restaurant(DataProvider.getDishes(), DataProvider.getHalfDishIds());
    System.out.println(restaurant.bestCharge("ITEM0001 x 1,ITEM0013 x 2,ITEM0022 x 1"));
  }
}
