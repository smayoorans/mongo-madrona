package com.madrona.mongo.bean;

import com.madrona.mongo.repo.StudentRepository;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class RegistrationBean {

	@Autowired
	private StudentRepository repository;

	public RegistrationBean(){
	}

	public StudentRepository getRepository() {
		return repository;
	}

	public void setRepository(StudentRepository repository) {
		this.repository = repository;
	}
}