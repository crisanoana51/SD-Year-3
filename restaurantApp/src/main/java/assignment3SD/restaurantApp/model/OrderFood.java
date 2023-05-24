package assignment3SD.restaurantApp.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.ManyToOne;

import java.io.Serializable;
import java.util.List;


@Entity
public class OrderFood implements Serializable {
    @Id
    private int idOrder;
    private int tableNumber;
    private int clientId;
    private int waiterId;

    private float priceOfOrder;

    private String orderReady;

    @ManyToMany
    @JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
    private List<OrderedProduct> orderedProducts;

    public int getIdOrder() {
        return idOrder;
    }

    public void setIdOrder(int idOrder) {
        this.idOrder = idOrder;
    }

    public int getTableNumber() {
        return tableNumber;
    }

    public void setTableNumber(int tableNumber) {
        this.tableNumber = tableNumber;
    }

    public int getClientId() {
        return clientId;
    }

    public void setClientId(int clientId) {
        this.clientId = clientId;
    }

    public int getWaiterId() {
        return waiterId;
    }

    public void setWaiterId(int waiterId) {
        this.waiterId = waiterId;
    }

    public List<OrderedProduct> getOrderedProducts() {
        return orderedProducts;
    }

    public void setOrderedProducts(List<OrderedProduct> orderedProducts) {
        this.orderedProducts = orderedProducts;
    }


    public String getOrderReady() {
        return orderReady;
    }

    public void setOrderReady(String orderReady) {
        this.orderReady = orderReady;
    }

    public float getPriceOfOrder() {
        return priceOfOrder;
    }

    public void setPriceOfOrder(float priceOfOrder) {
        this.priceOfOrder = priceOfOrder;
    }
}
