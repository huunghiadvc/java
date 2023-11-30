package DesignPattern.Strategy.Strategy.impl;

import DesignPattern.Strategy.Strategy.Discount;

public class NoDiscount implements Discount {
    @Override
    public double NoDiscount(double price) {
        return 0;
    }
}
