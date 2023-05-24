package assignment3SD.restaurantApp.businessService;

import assignment3SD.restaurantApp.model.*;
import assignment3SD.restaurantApp.persistanceLayer.OrderedProductRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import assignment3SD.restaurantApp.persistanceLayer.ClientRepo;
import assignment3SD.restaurantApp.persistanceLayer.OrderRepo;
import org.springframework.web.server.ResponseStatusException;

import java.util.ArrayList;
import java.util.List;


@Service
public class OrderService extends OrderObservable {

    @Autowired
    private final OrderRepo orderRepo;

    @Autowired
    private final OrderedProductRepo orderedProductRepo;
    @Autowired
    private final ClientRepo clientRepo;

    @Autowired
    private final EmployeeService employeeService;



    private final OrderObservable orderObservable = new OrderObservable();

    public OrderService(OrderRepo orderRepo, OrderedProductRepo orderedProductRepo, ClientRepo clientRepo, EmployeeService employeeService) {
        this.orderRepo = orderRepo;
        this.orderedProductRepo = orderedProductRepo;
        this.clientRepo = clientRepo;
        this.employeeService = employeeService;
        addObserver(employeeService);
    }

    public OrderFood addOrder(OrderFood order) throws Exception{

        int id = order.getClientId();
        float bonusLoyalty;
        float initialPrice=0;
        float priceAfterPoints;
        Client client = clientRepo.getReferenceById(id);

        List<OrderedProduct> orderedProducts= new ArrayList<>();
        for(OrderedProduct o : order.getOrderedProducts()){
            OrderedProduct op = orderedProductRepo.getReferenceById(id);
            orderedProducts.add(op);

            initialPrice = initialPrice + op.getTotalPrice();
        }

        order.setPriceOfOrder(initialPrice);
        bonusLoyalty = client.getLoyaltyPoints() + order.getPriceOfOrder()/100;
        priceAfterPoints = order.getPriceOfOrder() - (order.getPriceOfOrder()*bonusLoyalty/100);
        order.setPriceOfOrder(priceAfterPoints);
        order.setOrderReady("in making");
        client.setLoyaltyPoints(bonusLoyalty);
        order.setOrderedProducts(orderedProducts);
        clientRepo.save(client);
        return orderRepo.save(order);

    }

    public List<OrderFood> findAllOrders(){
        return orderRepo.findAll();
    }

    public OrderFood updateOrder(OrderFood order){
        order.setOrderReady("ready");
        return orderRepo.save(order);
    }

    public void deleteOrder(int id){
        orderRepo.deleteById(id);
    }

    public OrderFood findOrderById(int id) {
        return orderRepo.getReferenceById(id);
    }

    public OrderFood markOrderReady(int orderId){
        OrderFood order = orderRepo.findById(orderId)
        .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Order with id " + orderId + " not found"));
        order.setOrderReady("ready");
        notifyObservers(order);
        return orderRepo.save(order);
    }
}
