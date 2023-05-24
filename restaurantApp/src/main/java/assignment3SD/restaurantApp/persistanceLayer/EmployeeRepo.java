package assignment3SD.restaurantApp.persistanceLayer;

import org.springframework.data.jpa.repository.JpaRepository;
import assignment3SD.restaurantApp.model.Employee;

public interface EmployeeRepo extends JpaRepository<Employee, Integer> {
    Employee findEmployeeByUsername(String username);
}
