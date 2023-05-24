package assignment3SD.restaurantApp.model;

import assignment3SD.restaurantApp.persistanceLayer.Observer;


public class EmployeeObserver implements Observer {

    private Employee employee;

    @Override
    public void update(OrderFood order) {
        employee.notifyOrderReady(order);
    }
}
