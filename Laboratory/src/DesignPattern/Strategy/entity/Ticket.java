package DesignPattern.Strategy.entity;

import DesignPattern.Strategy.Strategy.Discount;
import lombok.Data;

@Data
public class Ticket {
    private String name;
    private double price;
    public Discount _promoteStrategy;

    public Ticket() {
    }

    public double GetDiscountPrice(){
        return _promoteStrategy.DoDiscount(price);
    }

}
