package DesignPattern.Strategy.Test;

import DesignPattern.Strategy.Test.entity.Customer;
import DesignPattern.Strategy.Test.impl.CustomerRepo;

import java.util.Map;

public class Test {
    public static void main(String[] args) {
        Test2.test2();
//        Customer a = new Customer("A", "A", "A");
        CustomerRepo customerRepo = new CustomerRepo();
        System.out.println(customerRepo.getById(1));

    }
}
