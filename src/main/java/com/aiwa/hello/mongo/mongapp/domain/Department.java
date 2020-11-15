package com.aiwa.hello.mongo.mongapp.domain;

import org.springframework.data.mongodb.core.mapping.Field;

/*
    This is a sub-document, IT'S NOT A SEPARATE COLLECTION! so (- no @Document needed here!!! -)
 */
public class Department {

    @Field(name = "department_name")
    private String departmentName;

    private String location;

    public String getDepartmentName() {
        return departmentName;
    }

    public void setDepartmentName(String departmentName) {
        this.departmentName = departmentName;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }
}
