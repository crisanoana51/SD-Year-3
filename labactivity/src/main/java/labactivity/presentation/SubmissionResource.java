package labactivity.presentation;


import jakarta.servlet.http.HttpServletRequest;
import labactivity.businessService.SubmissionService;
import labactivity.businessService.TeacherService;
import labactivity.model.Submission;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/submission")
public class SubmissionResource {

    private final SubmissionService submissionService;

    private final TeacherService teacherService;

    public SubmissionResource(SubmissionService submissionService, TeacherService teacherService) {
        this.submissionService = submissionService;
        this.teacherService = teacherService;
    }

    @PostMapping("/add")
    public ResponseEntity<Submission> addSubmission(@RequestBody Submission submission) throws Exception {
        Submission newSubmission = submissionService.addSubmission(submission);
        return new ResponseEntity<>(newSubmission, HttpStatus.CREATED);
    }

    @PutMapping("/grade/{id}/{grade}")
    public ResponseEntity<Submission> updateSubmission(@PathVariable("id") int id, @PathVariable("grade") double grade, @RequestParam String username, String password) {
        if (teacherService.verifyIdentity(username,password)) {
            Submission gradedSubmission = submissionService.gradeSubmission(id, grade);
            return new ResponseEntity<>(gradedSubmission, HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.FORBIDDEN);
        }
    }

}
