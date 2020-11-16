package com.aiwa.hello.mongo.mongapp.controller;

import com.aiwa.hello.mongo.mongapp.domain.Student;
import com.aiwa.hello.mongo.mongapp.services.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/students")
public class StudentController {

    private final StudentService studentService;

    @Autowired
    public StudentController(StudentService studentService) {
        this.studentService = studentService;
    }

    @GetMapping
    public ResponseEntity<?> allStudents(String studentId) {
        if (studentId != null) {
            return new ResponseEntity<>(studentService.fetchStudentById(studentId), HttpStatus.OK);
        }
        return new ResponseEntity<>(studentService.fetchStudents(), HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity<?> addStudent(@RequestBody Student student) {
        return new ResponseEntity<>(studentService.addStudent(student), HttpStatus.CREATED);
    }

    @PatchMapping
    public ResponseEntity<?> updateStudent(@RequestBody Student student) {
        return new ResponseEntity<>(studentService.addStudent(student), HttpStatus.OK);
    }

    @DeleteMapping
    public ResponseEntity<?> removeStudent(String studentId) {
        if (studentId == null) {
            throw new IllegalArgumentException("Entity Id is needed!");
        }
        studentService.removeStudentById(studentId);
        return new ResponseEntity<>("Student with id " + studentId + " removed", HttpStatus.OK);
    }
}
