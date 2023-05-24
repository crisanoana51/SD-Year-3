package assignment3SD.restaurantApp.businessService;

import assignment3SD.restaurantApp.model.Product;
import assignment3SD.restaurantApp.persistanceLayer.ProductRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import assignment3SD.restaurantApp.model.OrderedProduct;
import assignment3SD.restaurantApp.persistanceLayer.OrderedProductRepo;

import java.util.List;


@Service
public class OrderedProductService {

    @Autowired
    private final OrderedProductRepo orderedProductRepo;


    @Autowired
    private final ProductRepo productRepo;

    public OrderedProductService(OrderedProductRepo orderedProductRepo, ProductRepo productRepo) {
        this.orderedProductRepo = orderedProductRepo;
        this.productRepo = productRepo;
    }

    public OrderedProduct addOrderedProduct(OrderedProduct orderedProduct){
        int id = orderedProduct.getProduct().getId();
        Product p = productRepo.getReferenceById(id);
        System.out.println(p.getName() + ' ' + p.getId() );
        System.out.println(p.getPrice()*orderedProduct.getQuantity());
        orderedProduct.setTotalPrice(p.getPrice()*orderedProduct.getQuantity());
        return orderedProductRepo.save(orderedProduct);
    }

    public List<OrderedProduct> findAllOrderedProducts(){
        return orderedProductRepo.findAll();
    }

    public OrderedProduct updateOrderedProduct(OrderedProduct orderedProduct){
        return orderedProductRepo.save(orderedProduct);
    }

    public void deleteOrderedProduct(int id){
        orderedProductRepo.deleteById(id);
    }

    public OrderedProduct findOrderedProductById(int id) {
        return orderedProductRepo.getReferenceById(id);
    }
}
