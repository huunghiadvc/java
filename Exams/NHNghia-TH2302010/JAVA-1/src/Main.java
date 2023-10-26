import entity.Product;

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

        LineItem[] lineItemsMikeTyson = {
                new LineItem(tomato, 5),
                new LineItem(iPhone, 2),
                new LineItem(football, 4)
        };

        ArrayList<LineItem> mikeTysonOrder = new ArrayList<>();
        while (true){
            try {
                mikeTysonOrder = new ArrayList<>(Arrays.asList(lineItemsMikeTyson));
                System.out.println("ADD DATA SUCCESSFULLY!");
                break;
            } catch (Exception e) {
                System.err.println("Add data failed!");
            }
        }

        Order order1 = new Order();
        order1.setCustomerName("Mike Tyson");
        LocalDateTime timeOrder = LocalDateTime.of(2023, Month.AUGUST, 8, 11, 30, 0);
        order1.setTransactionTime(timeOrder);
        order1.setLineItem(mikeTysonOrder);

        System.out.println(order1);

        LineItem[] lineItemsChrisEvan = {
                new LineItem(zaraShirt, 3),
                new LineItem(iPhone, 3)
        };
        ArrayList<LineItem> deliceryChrisEvan;
        while (true){
            try {
                deliceryChrisEvan = new ArrayList<>(Arrays.asList(lineItemsChrisEvan));
                System.out.println("ADD DELIVERY OF CHRIS EVAN SUCCESSFULLY!");
                break;
            } catch (Exception e) {
                System.err.println("Add data failed!");
            }
        }
        Order order2 = new Order();
        order2.setCustomerName("Chris Evans");
        order2.setAddress("123 Cau Giay");
        LocalDateTime timeDelivery = LocalDateTime.of(2023, Month.AUGUST, 9, 13, 14, 0);
        order2.setTransactionTime(timeDelivery);
        order2.setLineItem(deliceryChrisEvan);

        System.out.println(order2);



    }
}
