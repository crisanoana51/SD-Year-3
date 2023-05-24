package assignment3SD.restaurantApp.persistanceLayer;

import org.springframework.data.jpa.repository.JpaRepository;
import assignment3SD.restaurantApp.model.OrderFood;

public interface OrderRepo extends JpaRepository<OrderFood, Integer> {
}
