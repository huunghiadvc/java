package utils;

import dao.JpaRepo;
import entity.Product;
import entity.ProductRepo;
import service.ProductService;

import java.util.List;

public class MenuUtils {
    public static void show(){
        System.out.println("SELECT OPTION BELOW:");
        System.out.println("    1. Display products.");
        System.out.println("    2. Find product.");
        System.out.println("    3. Add new product.");
        System.out.println("    4. Update product by id.");
        System.out.println("    5. Delete product by id.");
        System.out.println("    6. Exit.");
        System.out.println("Please input option: ");
    }

    public static void controller(){
        String userChoose;
        ProductService service = new ProductService();

        while (true){
            userChoose = InputUtils.getString();
            if (!userChoose.matches(".*[0-9].*")){
                System.err.println("Please input integer");
                continue;
            }
            break;
        }

        switch (Integer.parseInt(userChoose)){
            case 1:
                List<Product> productList = ProductRepo.getProductList();
                System.out.println(productList);
                break;

            case 2:
                System.out.println("Wait for update!");
                break;

            case 3:
                Product product = service.addNewProduct();
                service.insert(product);
                break;

            case 4:

                // TODO: 11/12/2023 : update product by id

                break;

            case 5:
                // TODO: 11/12/2023 : delete product by id
                break;

            case 6:
                do {
                    System.out.println("Input Y to confirm exist or N to cancel!");
                    userChoose = InputUtils.getString();
                    if (userChoose.equalsIgnoreCase("Y")) {
                        System.exit(0);
                    }
                } while (!userChoose.equalsIgnoreCase("N"));
                break;

            default:
                System.err.println("Please select option 1-4!");
        }
    }
}
