import dao.JpaRepo;
import entity.Product;
import entity.repo.ProductRepo;
import service.product.ProductService;
import utils.Controller;
import utils.MenuUtils;
import utils.SqlBuilder.test.SearchBuilder;

import java.util.Arrays;

public class Main {
    public static void main(String[] args) {
        JpaRepo<Product> jpaRepo = new ProductService();
        ProductRepo.getProductList().addAll(jpaRepo.getAll(null, null));
        while (true){
            MenuUtils.show();
            Controller.appControl();
        }
    }
}
