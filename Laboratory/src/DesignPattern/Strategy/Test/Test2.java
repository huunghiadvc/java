package DesignPattern.Strategy.Test;

import DesignPattern.Strategy.Test.entity.Customer;
import DesignPattern.Strategy.Test.impl.CustomerRepo;

public class Test2 {
    public static void test2(){
        Customer a = new Customer(1,"A", "A", "A");
//        CustomerRepo.getCusList().put(a.getName(), a);
        CustomerRepo customerRepo = new CustomerRepo();
        customerRepo.getAll().put(a.getName(), a);
    }
}
