package assignment3SD.restaurantApp.persistanceLayer;

import org.springframework.data.jpa.repository.JpaRepository;
import assignment3SD.restaurantApp.model.OrderedProduct;

import java.util.List;

public interface OrderedProductRepo extends JpaRepository<OrderedProduct, Integer> {


}
