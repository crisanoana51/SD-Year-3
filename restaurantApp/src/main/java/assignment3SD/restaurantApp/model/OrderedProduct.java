package assignment3SD.restaurantApp.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import jakarta.persistence.*;

import java.io.Serializable;


@Entity
public class OrderedProduct implements Serializable {

    @Id
    private int id;

    private float totalPrice;
    private int quantity;
    @ManyToOne @JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
    private Product product;


    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public float getTotalPrice() {
        return totalPrice;
    }

    public void setTotalPrice(float totalPrice) {
        this.totalPrice = totalPrice;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public Product getProduct() {
        return product;
    }

    public void setProduct(Product product) {
        this.product = product;
    }

    public float calculateTotalPrice(OrderedProduct o){
        float tPrice =  o.getQuantity() * o.getProduct().getPrice();
        return tPrice;
    }
}
