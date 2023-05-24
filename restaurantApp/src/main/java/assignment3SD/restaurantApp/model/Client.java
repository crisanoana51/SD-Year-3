package assignment3SD.restaurantApp.model;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;

import java.io.Serializable;


@Entity
public class Client implements Serializable {

    @Id
    private int id;
    private String name;
    private String contactInfo;
    private float loyaltyPoints;

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

    public String getContactInfo() {
        return contactInfo;
    }

    public void setContactInfo(String contactInfo) {
        this.contactInfo = contactInfo;
    }

    public float getLoyaltyPoints() {
        return loyaltyPoints;
    }

    public void setLoyaltyPoints(float loyaltyPoints) {
        this.loyaltyPoints = loyaltyPoints;
    }
}
