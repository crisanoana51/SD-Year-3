package assignment3SD.restaurantApp.model;
import assignment3SD.restaurantApp.persistanceLayer.Observer;

import java.util.ArrayList;
import java.util.List;

public class OrderObservable {

    private List<Observer> employees = new ArrayList<>();

    public OrderObservable() {
        this.employees= new ArrayList<>();
    }

    public void addObserver(Observer observer) {
        employees.add(observer);
    }

    public void removeObserver(Observer observer) {
        employees.remove(observer);
    }

    public void notifyObservers(OrderFood order) {

        for (Observer employee : employees) {
            employee.update(order);
        }
    }

}
