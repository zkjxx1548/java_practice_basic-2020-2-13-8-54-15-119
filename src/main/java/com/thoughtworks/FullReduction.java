package com.thoughtworks;

import java.util.List;

public class FullReduction implements Reduction {

    @Override
    public int getReduction(List<String> items, List<Integer> counts, int price) {
        int basic = 30;
        int reduction = 6;
        return price >= basic ? reduction : 0;
    }

    @Override
    public String printReduction(List<String> items, int price) {
        return String.format("满30减6元，省%d元\n", price);
    }
}
