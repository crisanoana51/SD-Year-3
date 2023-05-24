package assignment3SD.restaurantApp.model;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;

import java.io.Serializable;
import java.util.Base64;


@Entity
public class Employee implements Serializable {


    @Id
    private int id;
    private String name;
    private String role;
    private String contactInfo;

    private String username;
    private String password;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getRole() {
        return role;
    }

    public void setRole(String role) {
        this.role = role;
    }

    public String getContactInfo() {
        return contactInfo;
    }

    public void setContactInfo(String contactInfo) {
        this.contactInfo = contactInfo;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        String hashedPassword = Base64.getEncoder().encodeToString(password.getBytes());
        this.password = hashedPassword;
    }

    public boolean verifyPassword(String password) {
        String hashedPassword = Base64.getEncoder().encodeToString(password.getBytes());
        return this.password.equals(hashedPassword);
    }

    public void notifyOrderReady(OrderFood order) {
        if(order.getOrderReady().equals("ready")) {
            System.out.println("Order is ready for waiter: " + order.getWaiterId());
        }
    }
}
