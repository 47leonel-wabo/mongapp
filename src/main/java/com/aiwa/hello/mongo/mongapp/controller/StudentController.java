package com.aiwa.hello.mongo.mongapp.controller;

import com.aiwa.hello.mongo.mongapp.domain.Student;
import com.aiwa.hello.mongo.mongapp.services.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.lang.Nullable;
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
    public ResponseEntity<?> allStudents(@RequestParam("studentId") @Nullable String studentId) {
        if (studentId != null) {
            return new ResponseEntity<>(studentService.fetchStudentById(studentId), HttpStatus.OK);
        }
        return new ResponseEntity<>(studentService.fetchStudents(), HttpStatus.OK);
    }

    /*
        Let's try using pagination
        @Param pageNumber
        @Param pageSize
        TODO: Remember pages are zero-based indexed!
     */
    @GetMapping("/page")
    public ResponseEntity<?> allStudentsUsingPagination(@RequestParam("pageNo") Integer pageNo,
                                                        @RequestParam("pageSize") Integer pageSize) {
        var pg = PageRequest.of(pageNo, pageSize);

        /*
            Return values into a content array with extra features added for description
            TODO: To get ride of this array and extra properties add: ".getContent()" to return a list instead
         */
        return new ResponseEntity<>(studentService.fetchStudents(pg), HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity<?> addStudent(@RequestBody Student student) {
        return new ResponseEntity<>(studentService.addStudent(student), HttpStatus.CREATED);
    }

    @PatchMapping
    public ResponseEntity<?> updateStudent(@RequestBody Student student) {
        return new ResponseEntity<>(studentService.addStudent(student), HttpStatus.OK);
    }

    @DeleteMapping("/{studentId}")
    public ResponseEntity<?> removeStudent(@PathVariable String studentId) {
        if (studentId == null || studentId.isBlank() || studentId.isEmpty()) {
            return new ResponseEntity<>("Student ID required", HttpStatus.BAD_REQUEST);
        }
        studentService.removeStudentById(studentId);
        return new ResponseEntity<>("Student with id " + studentId + " removed", HttpStatus.OK);
    }
}
