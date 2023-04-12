package labactivity.model;


import jakarta.persistence.Entity;
import jakarta.persistence.Id;

import java.io.Serializable;

@Entity
public class Assignment implements Serializable {

    @Id
    private int number;
    private String title;

    private String deadline;

    private String description;

    public Assignment(){

    }

    public Assignment(int number, String title, String deadline, String description) {
        this.number = number;
        this.title = title;
        this.deadline = deadline;
        this.description = description;

    }

    public int getNumber() {
        return number;
    }

    public void setNumber(int number) {
        this.number = number;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDeadline() {
        return deadline;
    }

    public void setDeadline(String deadline) {
        this.deadline = deadline;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

}
