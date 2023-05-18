package com.mongo.crud;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.mongodb.repository.config.EnableMongoRepositories;

@SpringBootApplication
public class CrudMongoApplication {

	public static void main(String[] args) {
		SpringApplication.run(CrudMongoApplication.class, args);
	}

}
