import config.dao.JpaRepo;
import entity.Product;
import entity.repo.ProductRepo;
import service.product.ProductService;
import utils.Controller;
import utils.MenuUtils;

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
