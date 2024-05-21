package com.example.checpoint5.exerciseSubmissions.services;

import com.example.checpoint5.exerciseSubmissions.models.ExerciseSubmission;
import com.example.checpoint5.exerciseSubmissions.repositories.ExerciseSubmissionRepository;
import com.example.checpoint5.students.repositories.StudentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Collection;

@Service
public class ExerciseSubmissionService {

    @Autowired
    private ExerciseSubmissionRepository exerciseSubmissionRepository;
    @Autowired
    private StudentRepository studentRepository;



    public ExerciseSubmission create (ExerciseSubmission exerciseSubmission) {
        checkValidSubmission(exerciseSubmission);
        return exerciseSubmissionRepository.save(exerciseSubmission);
    }

    private void checkValidSubmission(ExerciseSubmission exerciseSubmission) {
        if(exerciseSubmission.getMarks() > 5 || exerciseSubmission.getMarks() < 1) {
            throw new IllegalArgumentException();
        }
    }

    public Collection<ExerciseSubmission> getALl() {
        return exerciseSubmissionRepository.findAll();
    }

    public void updateMark(long id, byte mark) {
        ExerciseSubmission exerciseSubmission = exerciseSubmissionRepository.getReferenceById(id);
        exerciseSubmission.setMarks(mark);
        checkValidSubmission(exerciseSubmission);
        exerciseSubmissionRepository.save(exerciseSubmission);
    }

    public int countByStudentId(long studentId) {
        return exerciseSubmissionRepository.countByStudentId(studentId);
    }
}
