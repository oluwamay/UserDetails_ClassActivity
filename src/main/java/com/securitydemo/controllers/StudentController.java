package com.securitydemo.controllers;

import com.securitydemo.dtos.StudentRequest;
import com.securitydemo.dtos.StudentResponse;
import com.securitydemo.entities.Student;
import com.securitydemo.services.StudentService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Arrays;
import java.util.List;

@RestController
@RequestMapping("api/v1/students")
@RequiredArgsConstructor
public class StudentController {
    private final StudentService studentService;

    @GetMapping(path="/{studentId}")
    public ResponseEntity<StudentResponse> getStudent(@PathVariable Long studentId){
      return studentService.findStudent(studentId);
    }

    @PostMapping()
    public ResponseEntity<String> saveStudent(@RequestBody StudentRequest request){
        return new ResponseEntity<>( studentService.addStudent(request)+" created successfully", HttpStatus.CREATED);
    }
    @DeleteMapping("/{student_id}")
    public ResponseEntity<String> deleteStudent(@PathVariable Long student_id){
       studentService.removeStudent(student_id);
        return new ResponseEntity<>("Deleted successfully", HttpStatus.OK);
    }
}
