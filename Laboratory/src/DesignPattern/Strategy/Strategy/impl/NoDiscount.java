package DesignPattern.Strategy.Strategy.impl;

import DesignPattern.Strategy.Strategy.Discount;


public class NoDiscount implements Discount {
    @Override
    public double DoDiscount(double price) {
        return price;
    }
}
