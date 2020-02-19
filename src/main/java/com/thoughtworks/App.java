package com.thoughtworks;

public class App {
  public static void main(String[] args) {
    Restaurant restaurant = new Restaurant();
    System.out.println(restaurant.bestCharge("ITEM0001 x 1,ITEM0013 x 2,ITEM0022 x 1"));
  }
}
