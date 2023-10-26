import entity.Product;

import javax.swing.plaf.synth.SynthOptionPaneUI;
import java.time.LocalDateTime;
import java.time.Month;
import java.util.ArrayList;
import java.util.Arrays;

public class Main {
    public static void main(String[] args) {
        ArrayList<Product> productsList = new ArrayList<>();
        Product tomato = new Product(1, "F523", "Tomoto", "Food", 1.5, 589);
        Product zaraShirt = new Product(2, "A763", "Zara shirt", "Appearance", 12.0, 90);
        Product kitchenTable = new Product(3, "H320", "Kitchen table", "Household", 299.0, 13);
        Product iPhone = new Product(4, "E092", "IPhone", "Electronic", 1000.0, 4);
        Product football = new Product(5, "S108", "Football", "Sport", 19.9, 2);
        productsList.add(tomato);
        productsList.add(zaraShirt);
        productsList.add(kitchenTable);
        productsList.add(iPhone);
        productsList.add(football);

        Order order1 = new Order();
        order1.setCustomerName("Mike Tyson");
        LocalDateTime timeOrder = LocalDateTime.of(2023, Month.AUGUST, 8, 11, 30, 0);
        order1.setTransactionTime(timeOrder);

        LineItem[] lineItemsMikeTyson = {
                new LineItem(tomato, 5),
                new LineItem(iPhone, 2),
                new LineItem(football, 4)
        };
        for (LineItem item: lineItemsMikeTyson) {
            if (order1.addProduct(item.getProduct(), item.getQuantity())) {
                System.out.println(order1.getCustomerName() + " order " + item.getQuantity() + " " + item.getProduct().getName() + " successfully\n");
            } else {
                System.out.println(order1.getCustomerName() + " order " + item.getQuantity() + " " + item.getProduct().getName() + " failed");
            }
        }

        System.out.println(order1);

        Order order2 = new Order();
        order2.setCustomerName("Chris Evans");
        order2.setAddress("123 Cau Giay");
        LocalDateTime timeDelivery = LocalDateTime.of(2023, Month.AUGUST, 9, 13, 14, 0);
        order2.setTransactionTime(timeDelivery);

        LineItem[] lineItemsChrisEvan = {
                new LineItem(zaraShirt, 3),
                new LineItem(iPhone, 3)
        };
        for (LineItem item: lineItemsChrisEvan) {
            if (order2.addProduct(item.getProduct(), item.getQuantity())) {
                System.out.println(order2.getCustomerName() + " order " + item.getQuantity() + " " + item.getProduct().getName() + " successfully\n");
            } else {
                System.out.println(order2.getCustomerName() + " order " + item.getQuantity() + " " + item.getProduct().getName() + " failed");
            }
        }

        System.out.println(order2);



    }
}
