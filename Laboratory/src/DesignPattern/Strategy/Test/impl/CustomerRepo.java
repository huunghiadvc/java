package DesignPattern.Strategy.Test.impl;

import DesignPattern.Strategy.Test.Factory.JpaRepoCloneImpl;
import DesignPattern.Strategy.Test.entity.Customer;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class CustomerRepo extends JpaRepoCloneImpl<String, Customer> {

    public CustomerRepo() {
        super(Customer.class);
    }

    @Override
    protected Map<String, Customer> rowMapper(ResultSet rs) {
        Map<String, Customer> customerMap = new HashMap<>();
        try {
            while (rs.next()){
                customerMap.put(
                        rs.getString("name"),
                        Customer.builder()
                                .id(rs.getInt("id"))
                                .name(rs.getString("name"))
                                .email(rs.getString("date_of_birth"))
                                .tel(rs.getString("address"))
                                .build());
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return customerMap;
    }
}
