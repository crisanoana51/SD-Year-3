package labactivity.persistanceLayer;

import labactivity.model.Teacher;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TeacherRepo extends JpaRepository<Teacher, Integer> {
    Teacher findTeacherByUsername(String username);
}
