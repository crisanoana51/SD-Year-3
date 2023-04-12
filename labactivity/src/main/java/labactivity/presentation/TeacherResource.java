package labactivity.presentation;


import jakarta.servlet.http.HttpServletResponse;
import labactivity.businessService.TeacherService;
import labactivity.model.Teacher;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/teacher")
public class TeacherResource {

    private final TeacherService teacherService;

    public TeacherResource(TeacherService teacherService) {
        this.teacherService = teacherService;
    }

    @PostMapping("/login")
    public ResponseEntity<?> login(@RequestBody Teacher teacher, HttpServletResponse response) {
        Teacher foundTeacher = teacherService.findByUsername(teacher.getUsername());
        if (foundTeacher != null && foundTeacher.verifyPassword(teacher.getPassword())) {
            foundTeacher.setRole("teacher");
            String role = foundTeacher.getRole();
            System.out.println("Role: " + role); // Debugging line
            response.setHeader("role", role); // Add the "role" attribute to the response header
            return new ResponseEntity<>(HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.UNAUTHORIZED);
        }
    }


    @PostMapping("/add")
    public ResponseEntity<Teacher> addUser(@RequestBody Teacher teacher){
        teacher.setPassword(teacher.getPassword());
        Teacher newTeacher = teacherService.addTeacher(teacher);
        return new ResponseEntity<>(newTeacher, HttpStatus.CREATED);
    }
}
