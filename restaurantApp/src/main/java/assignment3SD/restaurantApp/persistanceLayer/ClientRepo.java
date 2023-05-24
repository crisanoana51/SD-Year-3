package assignment3SD.restaurantApp.persistanceLayer;

import org.springframework.data.jpa.repository.JpaRepository;
import assignment3SD.restaurantApp.model.Client;

public interface ClientRepo extends JpaRepository<Client, Integer> {
}
