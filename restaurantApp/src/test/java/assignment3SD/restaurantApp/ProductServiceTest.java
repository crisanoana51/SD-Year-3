package assignment3SD.restaurantApp;


import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.*;

import assignment3SD.restaurantApp.businessService.ProductService;
import assignment3SD.restaurantApp.model.Product;
import assignment3SD.restaurantApp.persistanceLayer.ProductRepo;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.springframework.boot.test.context.SpringBootTest;
import java.util.Optional;


@SpringBootTest
public class ProductServiceTest {
    @InjectMocks
    private ProductService productService;
    @Mock
    private ProductRepo productRepo;
    @Test
    public void testCreateProduct(){
        Product product = new Product(1,"mamaliga",23,"cu branza");
        when(productRepo.save(product)).thenReturn(product);
        Product savedProduct = productService.addProduct(product);
        assertEquals(product,savedProduct);

    }
}
