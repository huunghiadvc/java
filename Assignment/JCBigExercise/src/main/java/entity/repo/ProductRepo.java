package entity.repo;

import entity.Product;

import java.util.ArrayList;
import java.util.List;

public class ProductRepo {
    private static List<Product> productList;

    private ProductRepo() {
    }
    public static List<Product> getProductList(){
        if (productList == null){
            productList = new ArrayList<>();
        }
        return productList;
    }
}
