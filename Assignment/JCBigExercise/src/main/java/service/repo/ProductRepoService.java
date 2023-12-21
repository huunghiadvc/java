package service.repo;

import entity.Product;
import entity.repo.ProductRepo;

public class ProductRepoService {
    public Product findById(long id){
        if (ProductRepo.getProductList().isEmpty()){
            System.err.println("PRODUCT LIST IS EMPTY");
            return null;
        }
        for (Product product : ProductRepo.getProductList()){
            if (product.getId() == id){
                return product;
            }
        }
        return null;
    }
}
