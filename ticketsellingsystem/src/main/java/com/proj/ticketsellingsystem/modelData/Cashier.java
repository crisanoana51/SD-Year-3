package com.proj.ticketsellingsystem.modelData;

import jakarta.persistence.*;
import org.mindrot.jbcrypt.BCrypt;
import java.io.Serializable;
import java.util.Base64;

@Entity
public class Cashier implements Serializable {
    @Id
    private int id;
    private String username;

    @Column(name = "password", nullable = false)
    private String passwordHash;

    public Cashier(String username, String password) {
        this.username = username;
        this.passwordHash = password;
    }

    public Cashier() {

    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return passwordHash;
    }

    public void setPassword(String password) {
        String hashedPassword = Base64.getEncoder().encodeToString(password.getBytes());
        this.passwordHash = hashedPassword;
    }

    public boolean verifyPassword(String password) {
        String hashedPassword = Base64.getEncoder().encodeToString(password.getBytes());
        return this.passwordHash.equals(hashedPassword);
    }


}
