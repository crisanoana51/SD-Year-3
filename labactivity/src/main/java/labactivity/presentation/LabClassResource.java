package labactivity.presentation;


import jakarta.servlet.http.HttpServletRequest;
import labactivity.businessService.LabClassService;
import labactivity.businessService.TeacherService;
import labactivity.model.LabClass;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/lab")
public class LabClassResource {

    private final LabClassService labClassService;
    private final TeacherService teacherService;

    public LabClassResource(LabClassService labClassService, TeacherService teacherService) {
        this.labClassService = labClassService;
        this.teacherService = teacherService;
    }

    @GetMapping("/all")
    public ResponseEntity<List<LabClass>> getAllLabClasses() {
        List<LabClass> labs = labClassService.findAllLabClasses();
        return new ResponseEntity<>(labs, HttpStatus.OK);
    }

    @PostMapping("/add")
    public ResponseEntity<LabClass> addLabClass(@RequestBody LabClass labClass, @RequestParam String username, @RequestParam String password) {

        if (teacherService.verifyIdentity(username, password)) {
            LabClass newLabClass = labClassService.addLabClass(labClass);
            return new ResponseEntity<>(newLabClass, HttpStatus.CREATED);
        } else {
            return new ResponseEntity<>(HttpStatus.FORBIDDEN);
        }
    }

    @PutMapping("/update")
    public ResponseEntity<LabClass> updateLabClass(@RequestBody LabClass labClass, @RequestParam String username, @RequestParam String password) {

        if (teacherService.verifyIdentity(username, password)) {
            LabClass updateLabClass = labClassService.updateLabClass(labClass);
            return new ResponseEntity<>(updateLabClass, HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.FORBIDDEN);
        }
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<?> deleteLabClass(@PathVariable("number") int nr, @RequestParam String username, String password) {
        if (teacherService.verifyIdentity(username, password)) {
            labClassService.deleteLabClass(nr);
            return new ResponseEntity<>(HttpStatus.OK);
        }else {
            return new ResponseEntity<>(HttpStatus.FORBIDDEN);
        }

    }
}
