package com.proj.ticketsellingsystem.modelData;


import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

import java.io.Serializable;
@Entity
public class Concert implements Serializable {
    @Id
    private int id;
    private String name;
    private String description;

    private int maxNrTickets;

    private int availableTickets;


    public Concert(int id, String name, String description, int maxNrTickets, int availableTickets) {
        this.id = id;
        this.name = name;
        this.description = description;
        this.maxNrTickets = maxNrTickets;
        this.availableTickets = availableTickets;
    }

    public Concert() {

    }

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

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public int getMaxNrTickets() {
        return maxNrTickets;
    }

    public void setMaxNrTickets(int maxNrTickets) {
        this.maxNrTickets = maxNrTickets;
    }

    public int getAvailableTickets() {
        return availableTickets;
    }

    public void setAvailableTickets(int availableTickets) {
        this.availableTickets = availableTickets;
    }
}
