package com.db.springjpa.controller;

import com.db.springjpa.entity.Person;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Arrays;
import java.util.Date;
import java.util.List;

@RestController
public class PersonController {

    private Logger logger = LoggerFactory.getLogger(this.getClass());

    @GetMapping("/persons")
    public List<Person> getAllPersons(){
//        logger.info("User id 10001 -> {}", repository.findById(10001));
        return Arrays.asList(new Person("shashi", "hyderabad", new Date()));
    }
}
