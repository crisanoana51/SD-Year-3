package assignment3SD.restaurantApp.presentation;

import assignment3SD.restaurantApp.businessService.EmployeeService;
import assignment3SD.restaurantApp.model.OrderObservable;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import assignment3SD.restaurantApp.businessService.ClientService;
import assignment3SD.restaurantApp.businessService.OrderService;
import assignment3SD.restaurantApp.model.OrderFood;

import java.util.List;

@RestController
@RequestMapping("/order")
public class OrderResource {

    @Autowired
    private final OrderService orderService;


    private final ClientService clientService;

    private final EmployeeService employeeService;

    public OrderResource(OrderService orderService, ClientService clientService, EmployeeService employeeService) {
        this.orderService = orderService;
        this.employeeService = employeeService;
        this.clientService = clientService;

    }

    @GetMapping("/all")
    public List<OrderFood> getAllOrders() {
        return orderService.findAllOrders();
    }

    @GetMapping("/find/{id}")
    public ResponseEntity<OrderFood> getOrderById(@PathVariable("id") int id) {
        OrderFood order = orderService.findOrderById(id);
        if (order != null) {
            return new ResponseEntity<>(order, HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @PostMapping("/add")
    public OrderFood addOrder(@RequestBody OrderFood order) throws Exception {

        return orderService.addOrder(order);
    }

    @PutMapping("/update/{id}")
    public ResponseEntity<OrderFood> updateOrder(@RequestBody OrderFood order, @RequestParam String username, String password) {
        if(employeeService.verifyIdentity(username,password)){
            OrderFood updatedOrder = orderService.updateOrder(order);
            if (updatedOrder != null) {
                return new ResponseEntity<>(updatedOrder, HttpStatus.OK);
            } else {
                return new ResponseEntity<>(HttpStatus.NOT_FOUND);
            }
        }else return new ResponseEntity<>(HttpStatus.FORBIDDEN);
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<?> deleteOrder(@PathVariable("id") int id) {
        orderService.deleteOrder(id);
        return new ResponseEntity<>(HttpStatus.OK);


    }

    @PutMapping("/notify/{id}")
    public ResponseEntity<OrderFood> updateSubmission(@PathVariable("id") int id, @RequestParam String username, String password) {
        if(employeeService.verifyIdentity(username,password) && employeeService.verifyRole(username,password).equals("kitchen")) {
            OrderFood readyOrder = orderService.markOrderReady(id);
            return new ResponseEntity<>(readyOrder, HttpStatus.OK);
        }else return new ResponseEntity<>(HttpStatus.FORBIDDEN);

    }
}
