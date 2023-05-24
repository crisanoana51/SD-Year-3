package assignment3SD.restaurantApp.businessService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import assignment3SD.restaurantApp.model.Product;
import assignment3SD.restaurantApp.persistanceLayer.ProductRepo;

import java.util.List;


@Service
public class ProductService {

    @Autowired
    private final ProductRepo productRepo;

    public ProductService(ProductRepo productRepo) {
        this.productRepo = productRepo;
    }

    public Product addProduct(Product product){
        return productRepo.save(product);
    }

    public List<Product> findAllProducts(){
        return productRepo.findAll();
    }

    public Product updateProduct(Product product){
        return productRepo.save(product);
    }

    public void deleteProduct(int id){
        productRepo.deleteById(id);
    }

    public Product findProductById(int id) {
        return productRepo.getReferenceById(id);
    }
}
