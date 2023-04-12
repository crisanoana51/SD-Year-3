package labactivity.businessService;

import labactivity.model.Assignment;
import labactivity.persistanceLayer.AssignmentRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.expression.spel.ast.Assign;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AssignmentService {

    private final AssignmentRepo assignmentRepo;


    @Autowired
    public AssignmentService(AssignmentRepo assignmentRepo){
        this.assignmentRepo = assignmentRepo;
    }

    public Assignment addAssignment(Assignment assignment){
        return assignmentRepo.save(assignment);
    }
    public List<Assignment> findAllAssignments(){
        return assignmentRepo.findAll();
    }

    public Assignment updateAssignment(Assignment assignment){
        return assignmentRepo.save(assignment);
    }

    public void deleteAssignment(int nr){
        assignmentRepo.deleteById(nr);
    }
}
