package service;

import dao.impl.JpaRepoImpl;
import entity.Product;
import entity.ProductRepo;
import utils.InputUtils;
import utils.validate.ValidateUtils;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class ProductService extends JpaRepoImpl<Product> {
    public ProductService() {
        super(Product.class);
    }

    @Override
    protected List<Product> rowMapper(ResultSet rs) {
        List<Product> studentList = new ArrayList<>();
        try {
            while (rs.next()){
                studentList.add(
                        Product.builder()
                                .id(rs.getInt("id"))
                                .name(rs.getString("name"))
                                .producer(rs.getString("producer"))
                                .line(rs.getString("line"))
                                .price(rs.getDouble("price"))
                                .build()
                );
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return studentList;
    }

    public Product addNewProduct(){
        String name, producer, productLine, price;

        while (true){
            System.out.println("Please enter product name: ");
            name = InputUtils.getString();
            if (ValidateUtils.stringValid(name)){
                break;
            }
            System.err.println("Invalid customer name, please try again!");
        }

        while (true){
            System.out.println("Please enter product producer: ");
            producer = InputUtils.getString();
            if (ValidateUtils.stringValid(producer)){
                break;
            }
            System.out.println("Invalid producer format!");
        }

        while (true){
            System.out.println("Please enter product line: ");
            productLine = InputUtils.getString();
            if (ValidateUtils.productLineValid(productLine)){
                break;
            }
            System.err.println("Invalid product line!");
        }

        while (true){
            System.out.println("Please enter product line: ");
            price = InputUtils.getString();
            if (ValidateUtils.priceValid(price)){
                break;
            }
            System.err.println("Invalid product price!");
        }

        try {
            Product product = new Product(name, producer, productLine, Double.parseDouble(price));
            ProductRepo.getProductList().add(product);
            return product;
        } catch (Exception e){
            return null;
        }
    }
}
