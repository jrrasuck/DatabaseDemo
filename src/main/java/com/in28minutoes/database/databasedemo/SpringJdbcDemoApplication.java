package com.in28minutoes.database.databasedemo;

import java.util.Date;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;

import com.in28minutoes.database.databasedemo.entity.Person;
import com.in28minutoes.database.databasedemo.jdbc.PersonJdbcDao;

//@SpringBootApplication
public class SpringJdbcDemoApplication implements CommandLineRunner {
	
	private Logger logger = LoggerFactory.getLogger(this.getClass());
	
	@Autowired
	PersonJdbcDao dao;

	public static void main(String[] args) {
		SpringApplication.run(SpringJdbcDemoApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		
		logger.info("findAll -> {} persons", dao.findAll());
		
		logger.info("find by id -> {}", dao.findById(10001));
		
		logger.info("{} records deleted", dao.deleteById(10003));
		
		logger.info("{} records inserted", dao.insert(
				new Person(10004, "Zidane", "Paris", new Date())));
		
		logger.info("{} records updated", dao.update(
				new Person(10003, "Ronaldo", "São Paulo", new Date())));
		
	}

}
