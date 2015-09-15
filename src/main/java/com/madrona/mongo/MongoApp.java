package com.madrona.mongo;

import static org.springframework.data.mongodb.core.query.Criteria.where;


import com.madrona.mongo.model.Person;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.data.mongodb.core.MongoOperations;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Query;

import com.mongodb.Mongo;

public class MongoApp {


  public static void main(String[] args) throws Exception {

    ClassPathXmlApplicationContext ctx = new ClassPathXmlApplicationContext("applicationContext.xml");


    MongoOperations mongoOps = new MongoTemplate(new Mongo(), "testdb");

    mongoOps.insert(new Person("Joe", 34));

    System.out.println(mongoOps.findOne(new Query(where("name").is("Joe")), Person.class));

    mongoOps.dropCollection("person");
  }
}