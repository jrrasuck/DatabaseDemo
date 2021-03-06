package com.in28minutoes.database.databasedemo;

import java.util.Date;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.in28minutoes.database.databasedemo.entity.Person;
import com.in28minutoes.database.databasedemo.jpa.PersonJpaRepository;

//@SpringBootApplication
public class JpaDemoApplication implements CommandLineRunner {
	
	private Logger logger = LoggerFactory.getLogger(this.getClass());
	
	@Autowired
	PersonJpaRepository repository;

	public static void main(String[] args) {
		SpringApplication.run(JpaDemoApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		
		logger.info("find by id -> {}", repository.findById(10001));
		
		logger.info("{} records inserted", repository.insert(
				new Person(10004, "Zidane", "Paris", new Date())));
		
		logger.info("{} records updated", repository.update(
				new Person(10003, "Ronaldo", "São Paulo", new Date())));
		
		repository.deleteById(10003);
		
		logger.info("findAll -> {} persons", repository.findAll());
		
	}

}
