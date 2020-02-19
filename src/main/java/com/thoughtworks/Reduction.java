package com.thoughtworks;

import java.util.List;

public interface Reduction {
    public abstract int getReduction(List<String> items, List<Integer> counts, int price);

    public abstract String printReduction(List<String> items, int reductionPrice);
}
