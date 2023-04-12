package labactivity.presentation;

import jakarta.servlet.http.HttpServletRequest;
import labactivity.businessService.StudentService;
import labactivity.businessService.TeacherService;
import labactivity.model.Student;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("/student")
public class StudentResource {

    private final StudentService studentService;

    private final TeacherService teacherService;

    public StudentResource(StudentService studentService, TeacherService teacherService) {
        this.studentService = studentService;
        this.teacherService = teacherService;
    }

    @GetMapping("/all")
    public ResponseEntity<List<Student>> getAllUsers(){
        List<Student> students = studentService.findAllStudents();
        return new ResponseEntity<>(students, HttpStatus.OK);
    }

    @PostMapping("/login")
    public ResponseEntity<?> login(@RequestBody Student student) {
        Student foundStudent = studentService.findByUsername(student.getEmailAddress());

        if (foundStudent != null) {
            if (foundStudent.getTokenPassword() != null) {
                if (foundStudent.getTokenPassword().equals(student.getTokenPassword())) {
                    foundStudent.updatePassword(student.getPassword());
                    foundStudent.setPassword((foundStudent.getPassword()));
                    studentService.updateStudent(foundStudent);
                    foundStudent.setRole("student");
                    return new ResponseEntity<>(HttpStatus.OK);
                } else {
                    return new ResponseEntity<>(HttpStatus.UNAUTHORIZED);
                }
            } else {
                if (foundStudent.verifyPassword(student.getPassword())) {
                    foundStudent.setRole("student");
                    return new ResponseEntity<>(HttpStatus.OK);
                } else {
                    return new ResponseEntity<>(HttpStatus.UNAUTHORIZED);
                }
            }
        } else {
            return new ResponseEntity<>(HttpStatus.UNAUTHORIZED);
        }
    }


    @PostMapping("/add")
    public ResponseEntity<Student> addUser(@RequestBody Student student, @RequestParam String username, @RequestParam String password){
        if (teacherService.verifyIdentity(username, password)) {
            String token = UUID.randomUUID().toString();
            student.setTokenPassword(token);
            Student newStudent = studentService.addStudent(student);
            return new ResponseEntity<>(newStudent, HttpStatus.CREATED);
        } else {
            return new ResponseEntity<>(HttpStatus.FORBIDDEN);
       }
    }

    @PutMapping("/update")
    public ResponseEntity<Student> updateUser(@RequestBody Student student, @RequestParam String username, @RequestParam String password){
        if (teacherService.verifyIdentity(username, password)) {
            Student updateStudent = studentService.updateStudent(student);
            return new ResponseEntity<>(updateStudent, HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.FORBIDDEN);
        }
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<?> deleteUser(@PathVariable("id") int id, @RequestParam String username, @RequestParam String password){
        if (teacherService.verifyIdentity(username, password)) {
            studentService.deleteStudent(id);
            return new ResponseEntity<>(HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.FORBIDDEN);
        }
    }

}
