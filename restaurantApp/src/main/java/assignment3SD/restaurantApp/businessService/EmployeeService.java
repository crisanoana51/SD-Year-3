package assignment3SD.restaurantApp.businessService;

import assignment3SD.restaurantApp.model.OrderFood;
import assignment3SD.restaurantApp.persistanceLayer.Observer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import assignment3SD.restaurantApp.model.Employee;
import assignment3SD.restaurantApp.persistanceLayer.EmployeeRepo;

import java.util.List;


@Service
public class EmployeeService implements Observer {

    @Autowired
    private final EmployeeRepo employeeRepo;

    public EmployeeService(EmployeeRepo employeeRepo) {
        this.employeeRepo = employeeRepo;
    }

    public Employee addEmployee(Employee employee){
        return employeeRepo.save(employee);
    }

    public List<Employee> findAllEmployees(){
        return employeeRepo.findAll();
    }

    public Employee updateEmployee(Employee employee){
        return employeeRepo.save(employee);
    }

    public void deleteEmployee(int id){
        employeeRepo.deleteById(id);
    }

    public Employee findEmployeeById(int id) {
        return employeeRepo.getReferenceById(id);
    }

    @Override
    public void update(OrderFood order) {
       System.out.println("MERI DUPA COMANDA");
    }

    public Employee findByUsername(String username){
        return employeeRepo.findEmployeeByUsername(username);
    }

    public boolean verifyIdentity(String username, String password){
       Employee foundEmployee =  findByUsername(username);
       Employee newEmployee = new Employee();
       newEmployee.setPassword(password);
       if(foundEmployee != null && foundEmployee.verifyPassword(newEmployee.getPassword())){
           System.out.println("verificat si ii ok");
           return true;
       }
       return false;
    }

    public String verifyRole(String username, String password){
        Employee foundEmployee =  findByUsername(username);
        Employee newEmployee = new Employee();
        newEmployee.setPassword(password);
        if(foundEmployee != null && foundEmployee.verifyPassword(newEmployee.getPassword())){
            return foundEmployee.getRole();
        }
        return null;
    }
}
