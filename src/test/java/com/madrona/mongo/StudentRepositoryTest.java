package com.madrona.mongo;

import com.madrona.mongo.model.Address;
import com.madrona.mongo.model.Gender;
import com.madrona.mongo.model.Status;
import com.madrona.mongo.model.Student;
import com.madrona.mongo.repo.StudentRepository;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.util.Date;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = "classpath:spring-context.xml")
public class StudentRepositoryTest {

    @Autowired
    StudentRepository studentRepository;

    @Test
    public void saveStudentTest() {

        studentRepository.deleteAll();

        Student student = new Student();
        student.setName("mayooran");
        student.setGender(Gender.MALE);
        student.setStatus(Status.SUSPENDED);
        student.setDateOfBirth(new Date());

        Address address = new Address();
		address.setHomeNumber("201");
        address.setAddressLineOne("UK/Manchester");

        student.setAddress(address);

        Student savedStudent = studentRepository.save(student);

        System.out.println("Inserted student detail : " + savedStudent.getId());

        Student student1 = new Student();
        student1.setName("Shanya");
        student1.setGender(Gender.FEMALE);
        student1.setStatus(Status.ACTIVE);
        student1.setDateOfBirth(new Date());
        Address address1 = new Address();
        address1.setHomeNumber("200");
        address1.setAddressLineOne("UK/London");
        student1.setAddress(address1);

        Student savedStudent1 = studentRepository.save(student1);

        System.out.println("Inserted student detail : " + savedStudent1.getId());

    }
}