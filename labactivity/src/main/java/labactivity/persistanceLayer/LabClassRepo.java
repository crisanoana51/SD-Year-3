package labactivity.persistanceLayer;

import labactivity.model.LabClass;
import org.springframework.data.jpa.repository.JpaRepository;

public interface LabClassRepo extends JpaRepository<LabClass, Integer> {
}
