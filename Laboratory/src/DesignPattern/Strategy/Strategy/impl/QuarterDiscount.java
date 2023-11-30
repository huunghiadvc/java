package DesignPattern.Strategy.Strategy.impl;

import DesignPattern.Strategy.Strategy.Discount;

public class QuarterDiscount implements Discount {
    @Override
    public double DoDiscount(double price) {
        return price * 0.75;
    }
}
