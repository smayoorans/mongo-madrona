package com.madrona.mongo;

import com.madrona.mongo.bean.RegistrationBean;
import com.madrona.mongo.model.Address;
import com.madrona.mongo.model.Status;
import com.madrona.mongo.model.Student;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.data.mongodb.core.MongoTemplate;

import java.util.Date;

public class Executable {
	public static ClassPathXmlApplicationContext context;

	static {
		// Acquire Context
		context = new ClassPathXmlApplicationContext("spring-context.xml");
	}

	public static void main(String [] args) throws Exception{
		// Create by MongoTemplate
		createUserThroughMonogoTamplate();
		// Create By Spring Data
		CreateUserThoughMongoRepository();
	}

	public static void createUserThroughMonogoTamplate(){
		MongoTemplate mongoOps = (MongoTemplate)context.getBean("mongoTemplate");
		Student student = new Student();
//		user.setId("200");
		student.setStatus(Status.ACTIVE);
		student.setDateOfBirth(new Date());
		Address address = new Address();
		address.setHomeNumber("200");
		address.setAddressLineOne("UK/London");
		student.setAddress(address);
		mongoOps.insert(student);
	}

	public static void CreateUserThoughMongoRepository(){
		Student student = new Student();
//		user.setId("201");
		student.setStatus(Status.SUSPENDED);
		student.setDateOfBirth(new Date());
		Address address = new Address();
//		address.setHomeNumber("201");
		address.setAddressLineOne("UK/Manchester");
		student.setAddress(address);
		RegistrationBean bean = (RegistrationBean)context.getBean(RegistrationBean.class);
		Student student1 = bean.getRepository().save(student);

		System.out.println(student1.getId());
	}
}