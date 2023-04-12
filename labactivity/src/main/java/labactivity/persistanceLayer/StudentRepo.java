package labactivity.persistanceLayer;

import labactivity.model.Student;
import org.springframework.data.jpa.repository.JpaRepository;

public interface StudentRepo extends JpaRepository<Student, Integer> {
    Student findStudentByEmailAddress(String username);
}
