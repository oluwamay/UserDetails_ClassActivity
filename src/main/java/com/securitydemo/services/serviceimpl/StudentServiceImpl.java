package com.securitydemo.services.serviceimpl;

import com.securitydemo.dtos.StudentRequest;
import com.securitydemo.dtos.StudentResponse;
import com.securitydemo.entities.Student;
import com.securitydemo.repositories.StudentRepository;
import com.securitydemo.services.StudentService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.BeanUtils;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class StudentServiceImpl implements StudentService {

    private final StudentRepository studentRepository;
    @Override
    public ResponseEntity<StudentResponse> findStudent(Long studentId) {
      Student student = studentRepository.findById(studentId).orElseThrow(IllegalArgumentException::new);
      return new ResponseEntity<>(StudentResponse.builder().name(student.getName()).build(), HttpStatus.OK);
    }

    @Override
    public String addStudent(StudentRequest request) {
        Student student = new Student();
        BeanUtils.copyProperties(request, student);
        return studentRepository.save(student).getName();
    }

}
