package com.aiwa.hello.mongo.mongapp.services;

import com.aiwa.hello.mongo.mongapp.domain.Student;
import com.aiwa.hello.mongo.mongapp.repostories.StudentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.NoSuchElementException;

@Service
public class StudentService {

    private final StudentRepository studentRepository;

    @Autowired
    public StudentService(StudentRepository studentRepository) {
        this.studentRepository = studentRepository;
    }

    public Student addStudent(Student student) {
        return studentRepository.save(student);
    }

    public List<Student> fetchStudents() {
        return studentRepository.findAll();
    }

    public Student fetchStudentById(String studentId) {
        return studentRepository.findById(studentId).orElseThrow(() -> new NoSuchElementException("Student with Id: " + studentId + " doesn't exist"));
    }

    public Student updateStudent(Student student) {
        return addStudent(student);
    }
}
