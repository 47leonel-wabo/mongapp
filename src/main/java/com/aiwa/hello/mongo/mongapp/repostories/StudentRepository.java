package com.aiwa.hello.mongo.mongapp.repostories;

import com.aiwa.hello.mongo.mongapp.domain.Student;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface StudentRepository extends MongoRepository<Student, String> {
}
