package DesignPattern.Strategy;

import DesignPattern.Strategy.Strategy.impl.HalfDiscount;
import DesignPattern.Strategy.Strategy.impl.NoDiscount;
import DesignPattern.Strategy.Strategy.impl.QuarterDiscount;
import DesignPattern.Strategy.Strategy.impl.TenPercentDiscount;
import DesignPattern.Strategy.entity.Ticket;

import java.util.Random;

public class Main {
    public static void main(String[] args) {
        System.out.println("abc");
        Random random = new Random();
        for (int i = 1; i <= 10; i++) {

            Ticket ticket = new Ticket();

            int index = random.nextInt(0, 4);

            ticket.setPrice(50*i);

            switch (index){
                case 0:
                    ticket.set_promoteStrategy(new NoDiscount());
                    break;

                case 1:
                    ticket.set_promoteStrategy(new TenPercentDiscount());
                    break;

                case 2:
                    ticket.set_promoteStrategy(new QuarterDiscount());
                    break;

                case 3:
                    ticket.set_promoteStrategy(new HalfDiscount());
                    break;

                default:
                    System.out.println("Error");
                    break;
            }

            double discountPrice = ticket.GetDiscountPrice();

            System.out.println("Ticket " + i + " have price is " +
                    discountPrice + " because discount " +
                    ticket.get_promoteStrategy().getClass().getSimpleName());

        }
    }
}
