package labactivity.persistanceLayer;

import labactivity.model.Assignment;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AssignmentRepo extends JpaRepository<Assignment, Integer> {
}
