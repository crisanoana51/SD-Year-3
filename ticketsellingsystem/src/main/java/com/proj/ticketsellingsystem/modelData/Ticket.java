package com.proj.ticketsellingsystem.modelData;

import com.fasterxml.jackson.annotation.JsonAlias;
import com.fasterxml.jackson.annotation.JsonProperty;
import jakarta.persistence.*;

import java.io.Serializable;

@Entity
public class Ticket implements Serializable {
    @Id
    private int id;
    private float price;

    @JoinColumn(name="concert_id")
    private int concertId;


    private int nrPlaces;


    public Ticket() {

    }


    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public float getPrice() {
        return price;
    }

    public void setPrice(float price) {
        this.price = price;
    }

    public int getConcertId() {
        return concertId;
    }

    public void setConcertID(int concertId) {
        this.concertId = concertId;
    }

    public int getNrPlaces() {
        return nrPlaces;
    }

    public void setNrPlaces(int nrPlaces) {
        this.nrPlaces = nrPlaces;
    }

    @Override
    public String toString() {
        return "Ticket{" +
                "id=" + id +
                ", price=" + price +
                ", concert=" + concertId +
                ", nrPlaces=" + nrPlaces +
                '}';
    }
}
