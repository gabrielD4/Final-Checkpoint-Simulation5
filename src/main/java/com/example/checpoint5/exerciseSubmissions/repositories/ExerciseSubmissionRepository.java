package com.example.checpoint5.exerciseSubmissions.repositories;

import com.example.checpoint5.exerciseSubmissions.models.ExerciseSubmission;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ExerciseSubmissionRepository extends JpaRepository<ExerciseSubmission, Long> {

    int countByStudentId(long studentId);
}
