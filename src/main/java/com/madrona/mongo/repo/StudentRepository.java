package com.madrona.mongo.repo;

import com.madrona.mongo.model.Gender;
import com.madrona.mongo.model.Student;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface StudentRepository extends CrudRepository<Student, Long> {

    Student findByName(String name);

    Student findByAddressHomeNumber(String addressHomeNumber);

    List<Student> findByGender(Gender gender);
}