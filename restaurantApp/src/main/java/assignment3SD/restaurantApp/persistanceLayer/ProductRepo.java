package assignment3SD.restaurantApp.persistanceLayer;

import org.springframework.data.jpa.repository.JpaRepository;
import assignment3SD.restaurantApp.model.Product;

public interface ProductRepo extends JpaRepository<Product, Integer> {
}
