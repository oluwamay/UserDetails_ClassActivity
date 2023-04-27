package com.securitydemo.services;

import com.securitydemo.dtos.StudentRequest;
import com.securitydemo.dtos.StudentResponse;
import com.securitydemo.entities.Student;
import org.springframework.http.ResponseEntity;

public interface StudentService {
    ResponseEntity<StudentResponse> findStudent(Long studentId);

    String addStudent(StudentRequest request);
}
