package labactivity.model;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToMany;

import java.util.List;


@Entity
public class LabClass {


    @Id
    private int number;

    private String date;
    private String title;

    private String curricula;

    private String labText;

    @ManyToMany
    private List<Student> attendance;

    public int getNumber() {
        return number;
    }

    public void setNumber(int number) {
        this.number = number;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getCurricula() {
        return curricula;
    }

    public void setCurricula(String curricula) {
        this.curricula = curricula;
    }

    public String getLabText() {
        return labText;
    }

    public void setLabText(String labText) {
        this.labText = labText;
    }

    public List<Student> getAttendance() {
        return attendance;
    }

    public void setAttendance(List<Student> attendance) {
        this.attendance = attendance;
    }
}
