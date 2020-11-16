package com.aiwa.hello.mongo.mongapp.domain;

import org.springframework.data.annotation.Id;
import org.springframework.data.annotation.PersistenceConstructor;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.Field;

import java.util.ArrayList;
import java.util.List;

@Document(collection = "student")
public class Student {

    @Id // this will automatically match to '_id' of mongodb
    private String id;

    @Field(name = "name")
    private String name;

    @Field(name = "email")
    private String email;

    @Field(name = "department")
    private Department department;

    @Field(name = "subjects")
    private List<Subject> subjects = new ArrayList<>();

    public Student() {
    }

    @PersistenceConstructor // Because we have more than one constructor
    public Student(String name, String email, Department department, List<Subject> subjects) {
        this.name = name;
        this.email = email;
        this.department = department;
        this.subjects = subjects;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public Department getDepartment() {
        return department;
    }

    public void setDepartment(Department department) {
        this.department = department;
    }

    public List<Subject> getSubjects() {
        return subjects;
    }

    public void setSubjects(List<Subject> subjects) {
        this.subjects = subjects;
    }

    @Override
    public String toString() {
        return "Student{" +
                "id='" + id + '\'' +
                ", name='" + name + '\'' +
                ", email='" + email + '\'' +
                ", department=" + department +
                ", subjects=" + subjects +
                '}';
    }
}
