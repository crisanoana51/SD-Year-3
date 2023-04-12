package labactivity.model;


import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

import java.io.Serializable;
import java.util.Base64;

@Entity
public class Student implements Serializable {

    @Id
    private int id;
    private String fullName;
    private int groupNr;
    private String emailAddress;
    private String hobby;
    private String password;

    private String tokenPassword;

    private String role;


    public Student(){

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

    public String getFullName() {
        return fullName;
    }

    public void setFullName(String fullName) {
        this.fullName = fullName;
    }

    public int getGroupNr() {
        return groupNr;
    }

    public void setGroupNr(int group) {
        this.groupNr = group;
    }

    public String getEmailAddress() {
        return emailAddress;
    }

    public void setEmailAddress(String emailAddress) {
        this.emailAddress = emailAddress;
    }

    public String getHobby() {
        return hobby;
    }

    public void setHobby(String hobby) {
        this.hobby = hobby;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        String hashedPassword = Base64.getEncoder().encodeToString(password.getBytes());
        this.password = hashedPassword;
    }

    public String getTokenPassword() {
        return tokenPassword;
    }

    public void setTokenPassword(String tokenPassword) {
        this.tokenPassword = tokenPassword;
    }

    public void updatePassword(String password){
        this.password = password;
        this.tokenPassword = null;
    }
    public boolean verifyPassword(String password) {
        String hashedPassword = Base64.getEncoder().encodeToString(password.getBytes());
        return this.password.equals(hashedPassword);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Student student = (Student) o;
        return id == student.id;
    }

}
