package assignment3SD.restaurantApp.presentation;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import assignment3SD.restaurantApp.businessService.OrderedProductService;
import assignment3SD.restaurantApp.model.OrderedProduct;

import java.util.List;

@RestController
@RequestMapping("/orderedProduct")
public class OrderedProductResource {


    @Autowired
    private final OrderedProductService orderedProductService;

    public OrderedProductResource(OrderedProductService orderedProductService) {
        this.orderedProductService = orderedProductService;
    }

    @GetMapping
    public List<OrderedProduct> getAllOrderedProducts() {
        return orderedProductService.findAllOrderedProducts();
    }

    @GetMapping("/{id}")
    public ResponseEntity<OrderedProduct> getOrderedProductById(@PathVariable("id") int id) {
        OrderedProduct orderedProduct = orderedProductService.findOrderedProductById(id);
        if (orderedProduct != null) {
            return new ResponseEntity<>(orderedProduct, HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @PostMapping("/add")
    public OrderedProduct addOrderedProduct(@RequestBody OrderedProduct orderedProduct) {
        return orderedProductService.addOrderedProduct(orderedProduct);
    }

    @PutMapping("/{id}")
    public ResponseEntity<OrderedProduct> updateOrderedProduct(@RequestBody OrderedProduct orderedProduct) {
        OrderedProduct updatedOrderedProduct = orderedProductService.updateOrderedProduct(orderedProduct);
        if (updatedOrderedProduct != null) {
            return new ResponseEntity<>(updatedOrderedProduct, HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> deleteOrderedProduct(@PathVariable("id") int id) {
        orderedProductService.deleteOrderedProduct(id);
        return new ResponseEntity<>(HttpStatus.OK);
    }

}
