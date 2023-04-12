package labactivity.businessService;


import labactivity.model.Assignment;
import labactivity.model.Submission;
import labactivity.persistanceLayer.AssignmentRepo;
import labactivity.persistanceLayer.SubmissionRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.jetbrains.annotations.NotNull;
import org.springframework.web.server.ResponseStatusException;

import java.util.NoSuchElementException;

@Service
public class SubmissionService {

    @Autowired
    private final SubmissionRepo submissionRepo;


    @Autowired
    public SubmissionService(SubmissionRepo submissionRepo){
        this.submissionRepo=submissionRepo;
    }

    public Submission addSubmission(@NotNull Submission submission) throws Exception{
        return submissionRepo.save(submission);

    }

    public Submission gradeSubmission(int submissionId, double grade) {
        Submission submission = submissionRepo.findById(submissionId)
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Submission with id " + submissionId + " not found"));
        submission.setGrade(grade);
        return submissionRepo.save(submission);
    }



}
