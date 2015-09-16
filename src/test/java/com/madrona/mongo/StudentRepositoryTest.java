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

        System.out.println("Student details inserted " + savedStudent.getId());
    }


    @Test
    public void testFindByName() throws Exception {
        Student mayooran = studentRepository.findByName("mayooran");
        System.out.println(mayooran.getId());
    }

    @Test
    public void testDeleteAll() throws Exception {
        studentRepository.deleteAll();
        System.out.println("Deleted all records");
    }
}