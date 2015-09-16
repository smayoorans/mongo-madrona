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
import java.util.List;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = "classpath:spring-context.xml")
public class StudentFindRepositoryTest {

    @Autowired
    StudentRepository studentRepository;

    @Test
    public void testFindByName() throws Exception {
        Student mayooran = studentRepository.findByName("mayooran");
        System.out.println(mayooran.getId());
    }

    @Test
    public void testFindByAddressHomeNumber() throws Exception {
        Student mayooran = studentRepository.findByAddressHomeNumber("201");
        System.out.println(mayooran);
    }

    @Test
    public void testFindByGender() throws Exception {
        List<Student> girls = studentRepository.findByGender(Gender.FEMALE);
        System.out.println("-" + girls);
    }
}