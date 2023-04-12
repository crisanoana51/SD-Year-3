package labactivity.businessService;


import labactivity.model.Student;
import labactivity.persistanceLayer.StudentRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class StudentService {

    private final StudentRepo studentRepo;

    @Autowired
    public StudentService(StudentRepo studentRepo) {
        this.studentRepo = studentRepo;
    }

    public Student addStudent(Student student){

        return studentRepo.save(student);
    }

    public List<Student> findAllStudents(){
        return studentRepo.findAll();

    }

    public Student updateStudent(Student student){
        return studentRepo.save(student);
    }

    public void deleteStudent(int id){
        studentRepo.deleteById(id);
    }


    public Student findByUsername(String username) {
        return studentRepo.findStudentByEmailAddress(username);

    }
}
