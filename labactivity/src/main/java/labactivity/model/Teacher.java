package labactivity.model;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;

import java.io.Serializable;
import java.util.Base64;


@Entity
public class Teacher implements Serializable {


    @Id
    private int id;
    private String username;
    private String password;

    private String role;

    public Teacher(){

    }

    public String getRole() {
        return role;
    }

    public void setRole(String role) {
        this.role = role;
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
}
