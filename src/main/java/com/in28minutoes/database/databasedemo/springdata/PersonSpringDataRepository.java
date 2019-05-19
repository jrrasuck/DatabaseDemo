package com.in28minutoes.database.databasedemo.springdata;

import org.springframework.data.jpa.repository.JpaRepository;

import com.in28minutoes.database.databasedemo.entity.Person;

public interface PersonSpringDataRepository extends JpaRepository<Person, Integer>{

}
