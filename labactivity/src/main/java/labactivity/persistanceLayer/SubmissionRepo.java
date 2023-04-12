package labactivity.persistanceLayer;

import labactivity.model.Submission;
import org.springframework.data.jpa.repository.JpaRepository;

public interface SubmissionRepo extends JpaRepository<Submission, Integer> {
}
