package com.example.checpoint5.students.repositories;

import com.example.checpoint5.students.models.Student;
import org.springframework.data.jpa.repository.JpaRepository;

public interface StudentRepository extends JpaRepository<Student, Long> {
}
