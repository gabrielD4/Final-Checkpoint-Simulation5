package com.example.checpoint5.exerciseSubmissions.controllers;

import com.example.checpoint5.exerciseSubmissions.models.ExerciseSubmission;
import com.example.checpoint5.exerciseSubmissions.services.ExerciseSubmissionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Collection;
import java.util.Optional;

@RestController
@RequestMapping("/v1/exerciseSubmissions")
public class ExerciseSubmissionController {

    @Autowired
    private ExerciseSubmissionService exerciseSubmissionService;

    @PostMapping
    public ResponseEntity<ExerciseSubmission> create(@RequestBody ExerciseSubmission exerciseSubmission) {
        try {
            return ResponseEntity.status(HttpStatus.CREATED).body(exerciseSubmissionService.create(exerciseSubmission));
        } catch (IllegalArgumentException e) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).build();
        }
    }

    @GetMapping
    public Collection<ExerciseSubmission> loadALl() {
        return exerciseSubmissionService.getALl();
    }

    @PutMapping("/{exerciseId}")
    public ResponseEntity<Void> updateSubmission(@PathVariable long exerciseId, @RequestParam byte mark) {
        try {
            exerciseSubmissionService.updateMark(exerciseId, mark);
           return ResponseEntity.status(HttpStatus.ACCEPTED).build();
        } catch (IllegalArgumentException e) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).build();
        }
    }

    @GetMapping("/{studentId}")
    public int getAllByStudentId (@PathVariable long studentId) {
        return exerciseSubmissionService.countByStudentId(studentId);
    }

}
