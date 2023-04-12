package labactivity.businessService;

import labactivity.model.Teacher;
import labactivity.persistanceLayer.TeacherRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class TeacherService {

    private final TeacherRepo teacherRepo;

    @Autowired
    public TeacherService (TeacherRepo teacherRepo){
        this.teacherRepo=teacherRepo;

    }
    public Teacher addTeacher(Teacher teacher){
        return teacherRepo.save(teacher);

    }
    public boolean verifyIdentity(String username, String password){
        Teacher foundTeacher = findByUsername(username);
        Teacher newTeacher = new Teacher();
        newTeacher.setPassword(password);
        if (foundTeacher != null && foundTeacher.verifyPassword(newTeacher.getPassword())) {
            foundTeacher.setRole("teacher");
            String role = foundTeacher.getRole();
            System.out.println("Role: " + role); // Debugging line
            return true;
        }
        System.out.println(foundTeacher.getPassword());
        System.out.println(password);
        return false;
    }
    public Teacher findByUsername(String username){
        return teacherRepo.findTeacherByUsername(username);
    }

}
