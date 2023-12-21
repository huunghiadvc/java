package service;

import dao.FileService;
import dao.impl.FileServiceImpl;
import entity.Product;
import entity.repo.ProductRepo;
import org.apache.commons.lang3.StringUtils;
import java.util.List;

public class ProductFileService extends FileServiceImpl<Product> {
    public ProductFileService() {
        super(Product.class);
    }

    public static void main(String[] args) {
        Product product = new Product("IPHONE", "Apple", "Pro max", 30000000.0);
        Product product2 = new Product("IPHONE", "Apple", "Pro max", 30000000.0);
        FileService<Product> fileService = new ProductFileService();
        List<Product> repo = ProductRepo.getProductList();
        repo.add(product);
        repo.add(product2);
        fileService.writeToFile(repo);
    }

    @Override
    protected Product rowMapper(String line) {
        if (StringUtils.isEmpty(line)) return null;

        String[] chars = line.split("\\|");

        return Product.builder()
                .id(Long.parseLong(chars[0]))
                .name(String.valueOf(chars[1]))
                .producer(String.valueOf(chars[2]))
                .line(String.valueOf(chars[3]))
                .price(Double.parseDouble(chars[4]))
                .build();
    }
}
