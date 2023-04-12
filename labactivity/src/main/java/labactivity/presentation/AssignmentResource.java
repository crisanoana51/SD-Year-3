package labactivity.presentation;


import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import labactivity.businessService.AssignmentService;
import labactivity.businessService.TeacherService;
import labactivity.model.Assignment;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/assignment")
public class AssignmentResource {

    private final AssignmentService assignmentService;

    private final TeacherService teacherService;
    public AssignmentResource(AssignmentService assignmentService, TeacherService teacherService){
        this.assignmentService = assignmentService;
        this.teacherService = teacherService;
    }
    @GetMapping("/all")
    public ResponseEntity<List<Assignment>> getAllAssignments(){
        List<Assignment> assignments = assignmentService.findAllAssignments();
        return new ResponseEntity<>(assignments, HttpStatus.OK);
    }

    @PostMapping("/add")
    public ResponseEntity<Assignment> addAssignment(@RequestBody Assignment assignment, @RequestParam String username, @RequestParam String password){

        if (teacherService.verifyIdentity(username,password)){
            Assignment newAssignment = assignmentService.addAssignment(assignment);
            return new ResponseEntity<>(newAssignment, HttpStatus.CREATED);
        } else {
            return new ResponseEntity<>(HttpStatus.FORBIDDEN);
        }
    }



    @PutMapping("/update")
    public ResponseEntity<Assignment> updateAssignment(@RequestBody Assignment assignment, @RequestParam String username, @RequestParam String password){
        if (teacherService.verifyIdentity(username, password)){
            Assignment updatedAssignment = assignmentService.updateAssignment(assignment);
            return new ResponseEntity<>(updatedAssignment, HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.FORBIDDEN);
        }
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<?> deleteAssignment(@PathVariable("id") int id, @RequestParam String username, String password){
        if (teacherService.verifyIdentity(username, password)){
            assignmentService.deleteAssignment(id);
            return new ResponseEntity<>(HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.FORBIDDEN);
        }
    }

}
