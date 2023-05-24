package assignment3SD.restaurantApp.persistanceLayer;

import assignment3SD.restaurantApp.model.OrderFood;


public interface Observer {
    void update(OrderFood order);
}
