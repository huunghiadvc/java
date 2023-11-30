package DesignPattern.Strategy.Test.entity;

import java.util.HashMap;
import java.util.Map;

public class CusRepo {
    private static Map<String, Customer> CusRepo;

    private CusRepo(Map<String, Customer> cusRepo) {
        CusRepo = cusRepo;
    }

    public static Map<String, Customer> getCusRepo() {
        if (CusRepo == null){
            CusRepo = new HashMap<>();
        }
        return CusRepo;
    }
}
