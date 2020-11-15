package com.aiwa.hello.mongo.mongapp;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.mongodb.repository.config.EnableMongoRepositories;

@SpringBootApplication
@EnableMongoRepositories("com.aiwa.hello.mongo.mongapp.repostories")
public class MongappApplication {

	public static void main(String[] args) {
		SpringApplication.run(MongappApplication.class, args);
	}

}
